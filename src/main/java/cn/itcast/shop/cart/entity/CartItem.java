package cn.itcast.shop.cart.entity;

import cn.itcast.shop.product.entity.Product;

/**
 * ���������
 * @author 93449
 *
 */
public class CartItem {
	//����������Ʒ����Ϣ	
	private Product product;
	//����ĳ����Ʒ����
	private int count;
	//����ĳ����ƷС��
	private double subtotal;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//С���Զ�����
	public double getSubtotal() {
		return count * product.getShop_price() ;
	}
	
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	*/
	
	
}
