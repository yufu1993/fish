package cn.itcast.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.adminuser.entity.AdminUser;
import cn.itcast.shop.adminuser.service.AdminUserService;

/**
 * ��̨�û�����Action
 * @author 93449
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	//ģ������ʹ�õĶ���
	private AdminUser adminUser = new AdminUser();
	public AdminUser getModel() {
		return adminUser;
	}
	
	//ע��service
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	/**
	 * ��̨��½�ķ���
	 * @return
	 */
	public String login(){
		
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null ){
			//��½ʧ��
			this.addActionError("�ף������û��������������");
			return "loginFail";
		}else{
			//��½�ɹ�
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			
			return "loginSuccess";
			
		}
		
		
	}

}
