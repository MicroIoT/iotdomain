package top.microiot.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserSerializer extends JsonSerializer<User> {
	public UserSerializer() {
	}

	@Override
	public void serialize(User value, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeStartObject();
		if(value.isDevice() && value.isShowPassword())
			gen.writeStringField("password", value.getPassword());
		gen.writeStringField("id", value.getId());
		gen.writeStringField("username", value.getUsername());
		gen.writeObjectField("status", value.getStatus());
		gen.writeStringField("email", value.getEmail());
		gen.writeObjectField("roles", value.getRoles());
		gen.writeBooleanField("isSystem", value.isSystem()); 
		gen.writeBooleanField("isArea", value.isArea()); 
		gen.writeBooleanField("isDevice", value.isDevice()); 
		gen.writeObjectField("area", value.getArea());
		
		gen.writeEndObject();
	}

}
