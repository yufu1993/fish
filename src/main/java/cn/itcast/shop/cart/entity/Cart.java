package cn.itcast.shop.cart.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * @author 93449
 *
 */
public class Cart {
	
	//���Ｏ��:key ��Ʒid value�������� 	
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	
	public Collection<CartItem> getCartItems(){
		
		return map.values();	
	}
	//�����ܼ�
	private double total;
	
	
	public double getTotal() {
		return total;
	}
	//���ﳵ����
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem){
		/*
		 * �жϹ��ﳵ�Ƿ��Ѵ��ڹ�����
		 * 
		 * 	���ڣ�
		 * 		��������
		 * 		�ܼ�=�ܼ�+������С��
		 * 	�����ڣ�
		 * 		��map����ӹ�����
		 * 		�ܼ�=�ܼ�+������С��
		 * 
		 */
		Integer pid = cartItem.getProduct().getPid();
		//�жϹ��ﳵ���Ƿ���ڹ�����
		if(map.containsKey(pid)){//����
			
			CartItem _cartItem = map.get(pid);//��ù�����ԭ���Ĺ�����
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			
			
		}else{//������
			
			map.put(pid, cartItem);
		}
		//�����ܼǵ�ֵ
		total+=cartItem.getSubtotal();
	}
	//2.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid){
		//���������Ƴ�����
		CartItem cartItem = map.remove(pid);
		//�ܼ�=�ܼ�-�Ƴ��Ĺ�����С��
		total-=cartItem.getSubtotal();
	}
	//3.��չ��ﳵ
	public void clearCart(){
		//�����еĹ�����
		map.clear();
		//�ܼ�����δ0
		total=0;
	}
	
	
	
}	
