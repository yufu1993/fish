package cn.itcast.shop.adminuser.entity;

/**
 * 管理员实体类
 * @author 93449
 *
 */
public class AdminUser {
	//主键id
	private Integer uid;
	//管理员用户名
	private String username;
	//管理员密码
	private String password;
	
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
	
	
	
}
