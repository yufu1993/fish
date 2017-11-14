package cn.itcast.shop.utils;

import java.util.List;

/**
 * ��ҳ��ķ�װ
 * @author 93449
 *
 */
public class PageBean<T> {
	
	//��ǰҳ��
	private int page;
	//�ܼ�¼��
	private int totalCount;
	//��ҳ��
	private int totalpage;
	//ÿҳ��ʾ�ļ�¼��
	private int limit;
	//ÿҳ��ʾ���ݵļ���
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
