package cn.itcast.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.entity.User;
import cn.itcast.shop.utils.MailUtils;
import cn.itcast.shop.utils.UUIDUtils;

/**
 * �û�ģ��ҵ������
 * @author 93449
 *
 */
@Transactional
public class UserService {
	
	//ע��UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	//���û�����ѯ�û��ķ���
	public User findByUserName(String username ){
		
		return userDao.findByUserName(username);
	}

	
	/**
	 * ҵ�������û�ע��ķ���
	 * @param user
	 */
	public void save(User user) {
		//�����ݴ��뵽���ݿ�����
		user.setState(0);// 0�������û�δ���� 1�������û��Ѽ���
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//���ͼ����ʼ�
		MailUtils.sendMail(user.getEmail(), code);
		
	}

	
	//ҵ�����ݼ������ѯ�û�
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}


	//�����û�״̬
	public void update(User exitUser) {
		
		userDao.update(exitUser);
		
	}

	
	//�û���½�ķ���
	public User login(User user) {
		
		return userDao.login(user);
		
	}
	
}
