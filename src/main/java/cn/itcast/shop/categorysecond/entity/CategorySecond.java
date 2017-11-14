package cn.itcast.shop.categorysecond.entity;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.product.entity.Product;

/**
 * 二级分类的实体
 * @author 93449
 *
 */
public class CategorySecond {
	
	//二级分类id
	private Integer csid;
	//二级分类名称
	private String csname;
	
	//所属一级分类 ，存的是一级分类对象
	private Category category;
	//配置商品集合 
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
 