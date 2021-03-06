package top.microiot.dto;

/**
 * 查询条件类。
 *
 * @author 曹新宇
 */
public class QueryInfo {
	private String filter;
	private String sort;
	private String collation;
	
	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCollation() {
		return collation;
	}

	public void setCollation(String collation) {
		this.collation = collation;
	}
}
