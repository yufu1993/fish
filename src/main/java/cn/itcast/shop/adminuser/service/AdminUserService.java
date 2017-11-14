package cn.itcast.shop.adminuser.service;

import cn.itcast.shop.adminuser.dao.AdminUserDao;
import cn.itcast.shop.adminuser.entity.AdminUser;

/**
 * 后台登陆的业务层代码
 * @author 93449
 *
 */
public class AdminUserService {
	
	//注入AdminUserDao
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	/**
	 *  业务层用登陆的方法
	 * @param adminUser
	 * @return
	 */
	public AdminUser login(AdminUser adminUser) {
		
		
		
		return adminUserDao.login(adminUser);
	}

}
