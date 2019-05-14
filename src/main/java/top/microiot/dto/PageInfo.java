package top.microiot.dto;

public class PageInfo {
	private Integer currentPage;
	private Integer numPerPage;
	
	public PageInfo() {
		super();
		this.currentPage = 0;
		this.numPerPage = 20;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}
}
