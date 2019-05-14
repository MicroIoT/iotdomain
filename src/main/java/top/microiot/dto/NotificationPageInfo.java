package top.microiot.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NotificationPageInfo extends PageInfo{
	private static final String ZONE = "GMT+8";
	public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
	@JsonFormat(pattern=FORMAT,timezone = ZONE)
	@DateTimeFormat(pattern = FORMAT)  
	private Date reportFrom;
	@JsonFormat(pattern=FORMAT,timezone = ZONE)
	@DateTimeFormat(pattern = FORMAT)  
	private Date reportTo;
	@JsonFormat(pattern=FORMAT,timezone = ZONE)
	@DateTimeFormat(pattern = FORMAT)  
	private Date receiveFrom;
	@JsonFormat(pattern=FORMAT,timezone = ZONE)
	@DateTimeFormat(pattern = FORMAT)  
	private Date receiveTo;
	public Date getReportFrom() {
		return reportFrom;
	}
	public void setReportFrom(Date reportFrom) {
		this.reportFrom = reportFrom;
	}
	public Date getReportTo() {
		return reportTo;
	}
	public void setReportTo(Date reportTo) {
		this.reportTo = reportTo;
	}
	public Date getReceiveFrom() {
		return receiveFrom;
	}
	public void setReceiveFrom(Date receiveFrom) {
		this.receiveFrom = receiveFrom;
	}
	public Date getReceiveTo() {
		return receiveTo;
	}
	public void setReceiveTo(Date receiveTo) {
		this.receiveTo = receiveTo;
	}
}
