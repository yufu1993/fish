package cn.itcast.shop.user.entity;

/**
 * 用户模块实体类 User
 * @author 93449
 *
 */
public class User {
	//主键id
	private Integer uid;  
	//用户名
	private String username;
	//密码
	private String password;
	//名称
	private String name;
	//邮件
	private String email;
	//电话
	private String phone;
	//地址
	private String addr;
	//状态
	private Integer state;
	//激活码
	private String code;
	// 一个用户对应多个订单:
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
