package cn.itcast.shop.utils;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author 93449
 *
 */
public class UUIDUtils {
	
	/**
	 * ��ȡ����ַ���
	 * @return
	 */
	public static String getUUID(){
		
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
