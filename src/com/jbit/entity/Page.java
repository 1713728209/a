package com.jbit.entity;
//分页类
public class Page {

	private Integer pageIndex;
	private Integer pageSize=5;
	private Integer pageCount;
	private Integer totalCount;
	
	public void init(){
		if(totalCount!=null){
			pageCount=totalCount%pageSize==0?(totalCount/pageSize):(totalCount/pageSize)+1;
			if(pageIndex==null){
				pageIndex=1;
			}
			if(pageIndex<=0){
				pageIndex=1;
			}
			if(pageIndex>=pageCount){
				pageIndex=pageCount;
			}
		}
	}
	
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Page() {
		super();
	}
}
