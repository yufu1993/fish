package cn.itcast.shop.category.entity;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.categorysecond.entity.CategorySecond;

/**
 * һ��ʵ����
 * @author 93449
 *
 */
public class Category {
	
	//һ������id
	private Integer cid;
	//һ����������
	private String cname;
	
	//һ�������Ŷ�������ļ���
	private Set<CategorySecond> categorySeconds =new  HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
	
}
