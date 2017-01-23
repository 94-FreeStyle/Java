package jbw.shop.domain;

import java.util.List;

public class PageBean<T> {
	private int pageCode;
	private List<Clothes> datas;
	private int totleRecord;
	private int pageSize = 8;

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageBean(int pageCode, int totleRecord) {
		this(pageCode, totleRecord, 8);
	}

	public PageBean(int pageCode, int totleRecord, int pageSize) {
		super();
		this.pageCode = pageCode;
		this.totleRecord = totleRecord;
		this.pageSize = pageSize;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public List<Clothes> getDatas() {
		return datas;
	}

	public void setDatas(List<Clothes> datas) {
		this.datas = datas;
	}

	public int getTotleRecord() {
		return totleRecord;
	}

	public void setTotleRecord(int totleRecord) {
		this.totleRecord = totleRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotlePage() {
		int totalPage = this.totleRecord / pageSize;
		return totleRecord % pageSize == 0 ? totalPage : totalPage + 1;
	}

}
