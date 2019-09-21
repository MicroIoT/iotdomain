package top.microiot.domain;

/**
 * websocket订阅主题类。
 *
 * @author 曹新宇
 */
public class Topic {
	public static final String TOPIC_ALARM = "/topic/alarm.";
	public static final String TOPIC_RESULT = "/topic/result.";
	public static final String TOPIC_OPERATION = "/topic/operation.";
	public static final String TOPIC_GET = "get";
	public static final String TOPIC_SET = "set";
	public static final String TOPIC_ACTION = "action";
	
	private String topic;
	private TopicType type;
	private String notifyObjectId;
	
	public Topic(String topic) {
		super();
		this.topic = topic;
		this.type = getTopicType(topic);
		this.notifyObjectId = getNotifyObjectId(topic);
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public TopicType getType() {
		return type;
	}

	public void setType(TopicType type) {
		this.type = type;
	}
	
	public String getNotifyObjectId() {
		return notifyObjectId;
	}

	public void setNotifyObjectId(String notifyObjectId) {
		this.notifyObjectId = notifyObjectId;
	}

	private TopicType getTopicType(String topic) {
		if (topic.startsWith(TOPIC_ALARM))
			return TopicType.Alarm;
		else if (topic.startsWith(TOPIC_OPERATION))
			return TopicType.Operation;
		else if (topic.startsWith(TOPIC_RESULT))
			return TopicType.Result;
		else
			return TopicType.Unknow;
	}
	
	public static TopicType getOperationType(String topic) {
		if(topic.startsWith(TOPIC_OPERATION + TOPIC_GET))
			return TopicType.GET;
		else if(topic.startsWith(TOPIC_OPERATION + TOPIC_SET))
			return TopicType.SET;
		else if(topic.startsWith(TOPIC_OPERATION + TOPIC_ACTION))
			return TopicType.ACTION;
		else
			return TopicType.Unknow;
	}
	private String getNotifyObjectId(String topic) {
		String[] topics = topic.split("\\.");
		
		switch(type) {
		case Alarm:
			if(topics.length == 2)
				return topics[1];
			else
				return null;
		case Operation:
			if(topics.length == 3)
				return topics[2];
			else
				return null;
		case Result:
			if(topics.length == 4)
				return topics[2];
			else
				return null;
		default:
				return null;
		}
	}
	
}
