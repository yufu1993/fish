package cn.itcast.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.user.dao.UserDao;
import cn.itcast.shop.user.entity.User;
import cn.itcast.shop.utils.MailUtils;
import cn.itcast.shop.utils.UUIDUtils;

/**
 * 用户模块业务层代码
 * @author 93449
 *
 */
@Transactional
public class UserService {
	
	//注入UserDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	//按用户名查询用户的方法
	public User findByUserName(String username ){
		
		return userDao.findByUserName(username);
	}

	
	/**
	 * 业务层完成用户注册的方法
	 * @param user
	 */
	public void save(User user) {
		//将数据存入到数据库里面
		user.setState(0);// 0：代表用户未激活 1：代表用户已激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUtils.sendMail(user.getEmail(), code);
		
	}

	
	//业务层根据激活码查询用户
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}


	//更新用户状态
	public void update(User exitUser) {
		
		userDao.update(exitUser);
		
	}

	
	//用户登陆的方法
	public User login(User user) {
		
		return userDao.login(user);
		
	}
	
}
