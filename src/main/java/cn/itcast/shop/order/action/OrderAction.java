package cn.itcast.shop.order.action;


import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.cart.entity.Cart;
import cn.itcast.shop.cart.entity.CartItem;
import cn.itcast.shop.order.entity.Order;
import cn.itcast.shop.order.entity.OrderItem;
import cn.itcast.shop.order.service.OrderService;
import cn.itcast.shop.user.entity.User;
import cn.itcast.shop.utils.PageBean;
import cn.itcast.shop.utils.PaymentUtil;

/**
 * ���������Action
 * @author 93449
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	
	//ģ������ʹ�õĶ���
	private  Order order = new Order();
	//ע��OrderService
	private OrderService orderService;
	//����pageҳ��
	private Integer page;
	//����֧��ͨ������
	private String pd_FrpId;
	//���շ��ص�֧�����
	private String r3_Amt;
	//���շ��صĶ�����
	private String r6_Order;
	
	public Order getModel() {
		return order;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	//���ɶ����ķ���
	public String save(){
		//1.�������ݵ����ݿ�
		//�������ݲ�ȫ
		order.setState(1);
		order.setOrdertime(new Date());
		//�ܼƵ������ǹ��ﳵ�е�����
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null ){
			
			this.addActionError("�ף��㻹û�й������ȥ����");
			
			return "msg";
		}
		
		order.setTotal(cart.getTotal());
		//���ö����еĶ�����
		for (CartItem cartItem : cart.getCartItems()) {
			
			OrderItem orderItem = new OrderItem();
			
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			
			order.getOrderItems().add(orderItem);
		}
		//�����������û�
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if(existUser == null){
			
			this.addActionError("�ף�����û�е�½������ȥ��½��");
			
			return "login";
		}
		order.setUser(existUser);
		
		orderService.save(order);
		//��������ʾ��ҳ��
		//ͨ��ֵջ�ķ�ʽ��ʾ����ΪOrder��ʾ�Ķ������ģ��������ʹ�ö���;
		//��չ��ﳵ
		cart.clearCart();
		
		return "saveSuccess";
	}
	
	//�ҵĶ�����ѯ��
	public String findByUid(){
		//�����û�id��ѯ
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		//����service
		PageBean<Order> pageBean = orderService.findByPageUid(existUser.getUid(),page);
		//����ҳ������ʾ��ҳ���� ���浽ֵջ��
		ServletActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByUidSuccess";
	}
	
	//���ݶ���id��ѯ�����ķ���
	public String findByOid(){
		
		order = orderService.findByOid(order.getOid());
		
		return "findByOidSuccess";
		
	}
	
	//��������ķ���
	public String payOrder() throws IOException{
		// 1.�޸�����:
				Order currOrder = orderService.findByOid(order.getOid());
				currOrder.setAddr(order.getAddr());
				currOrder.setName(order.getName());
				currOrder.setPhone(order.getPhone());
				// �޸Ķ���
				orderService.update(currOrder);
				// 2.��ɸ���:
				// ������Ҫ�Ĳ���:
				String p0_Cmd = "Buy"; // ҵ������:
				String p1_MerId = "10001126856";// �̻����:
				String p2_Order = order.getOid().toString();// �������:
				String p3_Amt = "0.01"; // ������:
				String p4_Cur = "CNY"; // ���ױ���:
				String p5_Pid = ""; // ��Ʒ����:
				String p6_Pcat = ""; // ��Ʒ����:
				String p7_Pdesc = ""; // ��Ʒ����:
				String p8_Url = "http://localhost:8080/shop/order_callBack.action"; // �̻�����֧���ɹ����ݵĵ�ַ:
				String p9_SAF = ""; // �ͻ���ַ:
				String pa_MP = ""; // �̻���չ��Ϣ:
				String pd_FrpId = this.pd_FrpId;// ֧��ͨ������:
				String pr_NeedResponse = "1"; // Ӧ�����:
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue); // hmac
				// ���ױ���������:
				StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);
				
				// �ض���:���ױ�����:
				ServletActionContext.getResponse().sendRedirect(sb.toString());
				return NONE;
		
	}
	
	//����ɹ����ת��
	public String callBack(){
		//�޸Ķ���״̬���޸�״̬Ϊ�Ѹ���
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		currOrder.setState(2);
		orderService.update(currOrder);
		//��ҳ����ʾ����ɹ���Ϣ
		this.addActionMessage("��������ɹ�:�������:"+r6_Order+"  ����Ľ��:"+r3_Amt);
		
		return "msg";
		
		
	}
	
	
	
	
	
	
	
}
