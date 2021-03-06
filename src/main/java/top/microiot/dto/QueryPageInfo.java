package top.microiot.dto;

/**
 * 查询页信息类。
 *
 * @author 曹新宇
 */
public class QueryPageInfo extends QueryInfo {
	private int pageNumber = 0;
	private int pageSize = 10;
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
