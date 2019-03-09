package com.dj.invoi.pojo;

import java.util.List;

public class PageInfo<T> {
	private int currPageNo;
	private int pageSize;
	private int totalCount;
	private int totalPageNum;
	private List<T> objList;

	public int getCurrPageNo() {
		if(currPageNo >= totalPageNum){
			currPageNo = totalPageNum;
		}
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if(currPageNo <= 1){
			currPageNo = 1;
		}
		this.currPageNo = currPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount <= 0){
			totalPageNum = 1;
		}else{
			if(totalCount % pageSize == 0){
				totalPageNum = totalCount / pageSize;
			}else{
				totalPageNum = totalCount / pageSize + 1;
			}
		}
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public List<T> getObjList() {
		return objList;
	}

	public void setObjList(List<T> objList) {
		this.objList = objList;
	}

}
