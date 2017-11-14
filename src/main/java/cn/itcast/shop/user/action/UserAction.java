package cn.itcast.shop.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.user.entity.User;
import cn.itcast.shop.user.service.UserService;


/**
 * �û�ģ���Action
 * @author 93449
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ������ʹ�õĶ���
	private User user = new User();
	public User getModel() {
		
		return user;
	}
	
	//������֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//ע��UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * ��ת��ע��ҳ��ִ�еķ���
	 */
	public String registPage(){
		
		return "registPage";
	}
	
	/**
	 * Ajax �����첽У���û�����ִ�з���
	 * @return
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		
		//����Service  ���в�ѯ
		User exitUser = userService.findByUserName(user.getUsername());
		//��ȡresponse������ҳ�����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�ж�
		if(exitUser != null){
			//��ѯ�����û����û��Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		}else{
			//�û������ڣ��û�������ʹ��
			response.getWriter().println("<font color='red'>�û�������ʹ��</font>");
		}
		
		return NONE;
	}
	
	/**
	 * �û�ע��ķ���
	 * @return
	 */
	public String regist(){
		//�ж���֤�룺
		//��session�л����֤������ֵ
		String checkcode1= (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("��֤�����");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ��ˣ���ȥ���伤�");
		return "msg";
	}
	
	/**
	 * �û�����ķ���
	 */
	public String active(){
		//���ݼ������ѯ�û�
		User exitUser = userService.findByCode(user.getCode());
		//�ж�
		if(exitUser== null){
			//���������
			this.addActionMessage("����ʧ�ܣ����������");
			
		}else{
			exitUser.setState(1);
			exitUser.setCode(null);
			this.addActionMessage("����ɹ���");
			//�����޸ĺ���û�
			userService.update(exitUser);
		}
		
		return "msg";
	}
	
	/**
	 * ��ת����½ҳ��
	 * @return
	 */
	public String loginPage(){
		
		return "loginPage";
	}
	
	/**
	 * �û���½�ķ���
	 * @return
	 */
	public String login(){
		
		User existUser = userService.login(user);
		//�ж�
		if(existUser == null){
			//��½ʧ��
			this.addActionError("��½ʧ�ܣ��û����������������û�δ����");
			return LOGIN;
		}else{
			//��½�ɹ�
			//���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//ҳ����ת
			return "loginSuccess";
		}
		
	}
	
	/**
	 * �û��˳��ķ���
	 * @return
	 */
	public String quit(){
		
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
	
		return "logout";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
