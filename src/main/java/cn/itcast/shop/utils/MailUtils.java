package cn.itcast.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * 邮件发送工具类
 * @author 93449
 *
 */
public class MailUtils {
	
	/**
	 * 发送邮件的方法
	 * @param to   	收件人
	 * @param code  激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 获得一个session对象
		 * 创建一个代表邮件对象的message
		 * 发送邮件Transport
		 */
		//1，获得连接对象
		Properties props=new Properties();
		props.setProperty("mail.host", "localhost");
		Session session =Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("service@shop.com", "Quni2020");
			}
			
		});
		 
		//2,创建邮件对象
		Message message = new MimeMessage(session);
		//设置发件人
		try {
			message.setFrom(new InternetAddress("service@shop.com"));
			//设置收件人
			/*
			 * Recipient.CC 抄送 BCC 密送
			 */
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			//设置标题
			message.setSubject("来自购物天堂的官方激活文件");
			//设置内容
			message.setContent("<h1>购物天堂传智商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://192.168.0.105:8080/shop/user_active.action?code="+code+"'>http://192.168.0.105:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			//3.发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		sendMail("18889832911@sina.cn", "123");
	}
}
