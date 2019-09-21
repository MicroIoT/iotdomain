package top.microiot.domain;

/**
 * 订阅主题类型，主要有三类订阅主题：告警，操作，结果。
 *
 * @author 曹新宇
 */
public enum TopicType {
	Alarm, Operation, Result, GET, SET, ACTION, Unknow;
}
