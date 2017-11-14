package cn.itcast.shop.cart.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author 93449
 *
 */
public class Cart {
	
	//购物集合:key 商品id value：购物项 	
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
	
	public Collection<CartItem> getCartItems(){
		
		return map.values();	
	}
	//购物总计
	private double total;
	
	
	public double getTotal() {
		return total;
	}
	//购物车功能
	//1.将购物先添加到购物车
	public void addCart(CartItem cartItem){
		/*
		 * 判断购物车是否已存在购物项
		 * 
		 * 	存在：
		 * 		数量增加
		 * 		总计=总计+购物项小计
		 * 	不存在：
		 * 		向map中添加购物项
		 * 		总计=总计+购物项小计
		 * 
		 */
		Integer pid = cartItem.getProduct().getPid();
		//判断购物车中是否存在购物项
		if(map.containsKey(pid)){//存在
			
			CartItem _cartItem = map.get(pid);//获得购物中原来的购物项
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			
			
		}else{//不存在
			
			map.put(pid, cartItem);
		}
		//设置总记的值
		total+=cartItem.getSubtotal();
	}
	//2.从购物车移除购物项
	public void removeCart(Integer pid){
		//将购物项移除购物
		CartItem cartItem = map.remove(pid);
		//总计=总计-移除的购物项小计
		total-=cartItem.getSubtotal();
	}
	//3.清空购物车
	public void clearCart(){
		//将所有的购物项
		map.clear();
		//总计设置未0
		total=0;
	}
	
	
	
}	
