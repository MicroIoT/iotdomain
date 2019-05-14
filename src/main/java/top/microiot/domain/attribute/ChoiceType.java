package top.microiot.domain.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import top.microiot.exception.ValueException;

public class ChoiceType extends DataType {
private Map<String, AttributeType> attTypes;
	
	public ChoiceType() {
		super(Type.Choice);
		// TODO Auto-generated constructor stub
	}

	public ChoiceType(List<? extends AttTypeInfo> additional) {
		super(Type.Choice);
		if(additional == null)
			throw new ValueException("no choice definition");
		AttributeTypes attributes = new AttributeTypes(additional);
		attTypes = attributes.getAttTypes();
	}

	@Override
	public boolean isValid(AttValueInfo value) {
		if(value.getStructValue() == null)
			return false;
		return true;
	}

	public Map<String, AttributeType> getAttTypes() {
		return attTypes;
	}

	public void setAttTypes(Map<String, AttributeType> attTypes) {
		this.attTypes = attTypes;
	}

	@Override
	public AttValueInfo getAttValue(Object object) {
		Map<String, AttValueInfo> structValue = new HashMap<String, AttValueInfo>();
		
		String name = object.getClass().getSimpleName();
		for (String key : attTypes.keySet()) {
			if(key.equals(name)) {
				AttributeType attType = attTypes.get(key);
				AttValueInfo a =attType.getAttValue(object);
				structValue.put(key, a);
				return new AttValueInfo(structValue);
			}
		}
		throw new ValueException("not supported class " + object.getClass().getName());
	}

	@Override
	public Object getData(DataValue value, Class<?> type) {
		if(value instanceof ChoiceValue) {
			Map<String, DataValue> choiceValue = ((ChoiceValue)value).getValue();
			
			String pkg = type.getPackage().getName();
			Reflections reflections = new Reflections(pkg);
			Set<?> subTypes = reflections.getSubTypesOf(type);
			String key = choiceValue.keySet().iterator().next();
			
			for(Object subType : subTypes) {
				Class<?> t = (Class<?>) subType;
				if(t.getSimpleName().equals(key)) {
					AttributeType attType = attTypes.get(key);
					DataValue v = choiceValue.get(key);
					return attType.getData(v, t);
				}
			}
			
			throw new ValueException(key + " can't convert to " + type.getName());
		} else
			throw new ValueException("expected data value is ChoiceValue, but not " + value.getClass().getName());
	}

	@Override
	public DataValue getAttData(Object object) {
		AttValueInfo a = getAttValue(object);
		
		return new ChoiceValue(a, this);
	}

	@Override
	public Object getValue(AttValueInfo value, Class<?> type) {
		return getData(new ChoiceValue(value, this), type);
	}

}
