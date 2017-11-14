package cn.itcast.shop.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.cart.entity.Cart;
import cn.itcast.shop.cart.entity.CartItem;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.product.service.ProductService;

/**
 * ���ﳵAction
 * @author 93449
 *
 */
public class CartAction extends ActionSupport{
	
	//������Ʒid
	private Integer pid;
	//��������
	private Integer count;
	//ע����Ʒservice
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



	//����������ӵ����ﳵ
	public String addCart(){
		
		//��װһ��CartItem����
		CartItem cartItem = new CartItem();
		//��������
		cartItem.setCount(count);
		//��ѯ��Ʒ
		Product product = productService.findByPid(pid);
		//������Ʒ
		cartItem.setProduct(product);
		//����������ӵ����ﳵ��
		//���ﳵ��Ӧ�������session��
		Cart cart = getCart();
		cart.addCart(cartItem);
		return "addCart";
	}
	
	//��չ��ﳵ�ķ���
	public String clearCart(){
		//��ù��ﳵ����
		Cart cart = getCart();
		//��չ��ﳵ
		cart.clearCart();
		
		return "clearCart";
		
	}
	
	//�����ﳵ���Ƴ�������ķ���
	public String removeCart(){
		
		getCart().removeCart(pid);
		
		return "removeCart";
	}
	
	public String myCart(){
		
		return "myCart";
	}
	
	
	
	//��ù��ﳵ�ķ�������session��ù��ﳵ
	private Cart getCart() {

		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		if(cart == null){
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}
	
}
