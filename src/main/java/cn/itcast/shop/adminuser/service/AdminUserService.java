package cn.itcast.shop.adminuser.service;

import cn.itcast.shop.adminuser.dao.AdminUserDao;
import cn.itcast.shop.adminuser.entity.AdminUser;

/**
 * ��̨��½��ҵ������
 * @author 93449
 *
 */
public class AdminUserService {
	
	//ע��AdminUserDao
	private AdminUserDao adminUserDao;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	/**
	 *  ҵ����õ�½�ķ���
	 * @param adminUser
	 * @return
	 */
	public AdminUser login(AdminUser adminUser) {
		
		
		
		return adminUserDao.login(adminUser);
	}

}
