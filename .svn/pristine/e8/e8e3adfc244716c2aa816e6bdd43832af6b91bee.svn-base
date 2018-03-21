package com.dsib.common;

import java.io.Serializable;
import java.util.List;

public class Pagination  implements Serializable {
	private static final long serialVersionUID = 1566826618769972857L;
	// 默认的每页记录数
	public static final int DEFAULT_PAGE_SIZE = 10;
	// 每页的记录数
	private int pageSize = DEFAULT_PAGE_SIZE;
	// 当前页
	private int pageNo = 1;
	// 总行数
	private int totalCount;
	// 总页数
	private int pageCount;
	// 每页的记录
	private List<?> resultList;
	// 条件
	private Object queryCondition;

	public Pagination() {
	}

	public Pagination(int pageNo) {
		this.pageNo = pageNo;
	}

	public Pagination(int pageSize, int pageNo) {
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount
				/ pageSize + 1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List getResultList() {
		return resultList;
	}

	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

	public Object getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(Object queryCondition) {
		this.queryCondition = queryCondition;
	}
}
