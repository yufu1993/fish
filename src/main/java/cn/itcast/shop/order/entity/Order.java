package cn.itcast.shop.order.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.itcast.shop.user.entity.User;

/**
 * ����ģ��ʵ����
 * @author 93449
 *
 */
public class Order {
	//����id
	private Integer oid;
	//�������
	private Double total;
	//��������ʱ��
	private Date ordertime;
	//����״̬
	private Integer state;// 1:δ����   2:�����Ѿ�����   3:�Ѿ�����   4:��������
	//�ջ���
	private String name;
	//�����绰
	private String phone;
	//�ջ���ַ
	private String addr;
	// �û������:����
	private User user;
	//�����������Ķ��������
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
