package cn.itcast.shop.adminuser.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.adminuser.entity.AdminUser;
import cn.itcast.shop.adminuser.service.AdminUserService;

/**
 * 后台用户管理Action
 * @author 93449
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	//模型驱动使用的对象
	private AdminUser adminUser = new AdminUser();
	public AdminUser getModel() {
		return adminUser;
	}
	
	//注入service
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	/**
	 * 后台登陆的方法
	 * @return
	 */
	public String login(){
		
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if(existAdminUser == null ){
			//登陆失败
			this.addActionError("亲！您的用户名或者密码错误");
			return "loginFail";
		}else{
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			
			return "loginSuccess";
			
		}
		
		
	}

}
