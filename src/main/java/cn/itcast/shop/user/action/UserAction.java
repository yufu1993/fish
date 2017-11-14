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
 * 用户模块的Action
 * @author 93449
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动使用的对象
	private User user = new User();
	public User getModel() {
		
		return user;
	}
	
	//接收验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 跳转到注册页面执行的方法
	 */
	public String registPage(){
		
		return "registPage";
	}
	
	/**
	 * Ajax 进行异步校验用户名的执行方法
	 * @return
	 * @throws IOException 
	 */
	public String findByName() throws IOException{
		
		//调用Service  进行查询
		User exitUser = userService.findByUserName(user.getUsername());
		//获取response对象，向页面输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//判断
		if(exitUser != null){
			//查询到该用户：用户已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		}else{
			//用户不存在：用户名可以使用
			response.getWriter().println("<font color='red'>用户名可以使用</font>");
		}
		
		return NONE;
	}
	
	/**
	 * 用户注册的方法
	 * @return
	 */
	public String regist(){
		//判断验证码：
		//从session中获得验证码的随机值
		String checkcode1= (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			this.addActionError("验证码错误");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功了，请去邮箱激活！");
		return "msg";
	}
	
	/**
	 * 用户激活的方法
	 */
	public String active(){
		//根据激活码查询用户
		User exitUser = userService.findByCode(user.getCode());
		//判断
		if(exitUser== null){
			//激活码错误
			this.addActionMessage("激活失败：激活码错误");
			
		}else{
			exitUser.setState(1);
			exitUser.setCode(null);
			this.addActionMessage("激活成功！");
			//保存修改后的用户
			userService.update(exitUser);
		}
		
		return "msg";
	}
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	public String loginPage(){
		
		return "loginPage";
	}
	
	/**
	 * 用户登陆的方法
	 * @return
	 */
	public String login(){
		
		User existUser = userService.login(user);
		//判断
		if(existUser == null){
			//登陆失败
			this.addActionError("登陆失败：用户名或者密码错误或用户未激活");
			return LOGIN;
		}else{
			//登陆成功
			//将用户的信息存入到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			//页面跳转
			return "loginSuccess";
		}
		
	}
	
	/**
	 * 用户退出的方法
	 * @return
	 */
	public String quit(){
		
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
	
		return "logout";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
