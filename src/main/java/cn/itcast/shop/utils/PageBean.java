package cn.itcast.shop.utils;

import java.util.List;

/**
 * 分页类的封装
 * @author 93449
 *
 */
public class PageBean<T> {
	
	//当前页数
	private int page;
	//总记录数
	private int totalCount;
	//总页数
	private int totalpage;
	//每页显示的记录数
	private int limit;
	//每页显示数据的集合
	private List<T> list;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	
	
}
