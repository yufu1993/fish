package cn.itcast.shop.user.entity;

/**
 * �û�ģ��ʵ���� User
 * @author 93449
 *
 */
public class User {
	//����id
	private Integer uid;  
	//�û���
	private String username;
	//����
	private String password;
	//����
	private String name;
	//�ʼ�
	private String email;
	//�绰
	private String phone;
	//��ַ
	private String addr;
	//״̬
	private Integer state;
	//������
	private String code;
	// һ���û���Ӧ�������:
	
	
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
