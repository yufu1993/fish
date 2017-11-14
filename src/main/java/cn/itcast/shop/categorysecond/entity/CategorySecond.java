package cn.itcast.shop.categorysecond.entity;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.product.entity.Product;

/**
 * ���������ʵ��
 * @author 93449
 *
 */
public class CategorySecond {
	
	//��������id
	private Integer csid;
	//������������
	private String csname;
	
	//����һ������ �������һ���������
	private Category category;
	//������Ʒ���� 
	private Set<Product> products = new HashSet<Product>();
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
 