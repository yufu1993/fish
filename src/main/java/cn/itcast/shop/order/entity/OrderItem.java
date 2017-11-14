package cn.itcast.shop.order.entity;

import cn.itcast.shop.product.entity.Product;

/**
 * 订单模块：订单项
 * @author 93449
 *
 */
public class OrderItem {
	//订单项id
	private Integer itemid;
	//订单数量
	private Integer count;
	//订单小计
	private Double subtotal;
	// 商品外键:对象
	private Product product;
	// 订单外键:对象
	private Order order;
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
