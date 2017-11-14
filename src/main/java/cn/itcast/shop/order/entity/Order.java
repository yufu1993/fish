package cn.itcast.shop.order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.user.entity.User;

/**
 * 订单模块实体类
 * @author 93449
 *
 */
public class Order {
	//订单id
	private Integer oid;
	//订单金额
	private Double total;
	//订单生成时间
	private Date ordertime;
	//订单状态
	private Integer state;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	//收货人
	private String name;
	//订单电话
	private String phone;
	//收货地址
	private String addr;
	// 用户的外键:对象
	private User user;
	//订单中所属的多个订单项
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
	
	
}
