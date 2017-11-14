package cn.itcast.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.cart.entity.Cart;
import cn.itcast.shop.cart.entity.CartItem;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.product.service.ProductService;

/**
 * 购物车Action
 * @author 93449
 *
 */
public class CartAction extends ActionSupport{
	
	//接收商品id
	private Integer pid;
	//接收数量
	private Integer count;
	//注入商品service
	private ProductService productService;
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	//将购物项添加到购物车
	public String addCart(){
		
		//封装一个CartItem对象
		CartItem cartItem = new CartItem();
		//设置数量
		cartItem.setCount(count);
		//查询商品
		Product product = productService.findByPid(pid);
		//设置商品
		cartItem.setProduct(product);
		//将购物项添加到购物车中
		//购物车中应该添加在session中
		Cart cart = getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	
	//清空购物车的方法
	public String clearCart(){
		//获得购物车对象
		Cart cart = getCart();
		//清空购物车
		cart.clearCart();
		
		return "clearCart";
		
	}
	
	//过购物车中移除购物项的方法
	public String removeCart(){
		
		getCart().removeCart(pid);
		
		return "removeCart";
	}
	
	public String myCart(){
		
		return "myCart";
	}
	
	
	
	//获得购物车的方法：从session获得购物车
	private Cart getCart() {

		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}
	
}
