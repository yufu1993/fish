package cn.itcast.shop.order.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.order.dao.OrderDao;
import cn.itcast.shop.order.entity.Order;
import cn.itcast.shop.utils.PageBean;

/**
 * ����ģ�飺ҵ������
 * @author 93449
 *
 */
@Transactional
public class OrderService {
	//ע��OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//���涩����ҵ������
	public void save(Order order) {
		
		orderDao.save(order);
		
	}
	
	//�ҵĶ�����ҵ������
	public PageBean<Order> findByPageUid(Integer uid, Integer page) {

		PageBean<Order> pageBean = new PageBean<Order>();	
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��/
		Integer limit=5;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		Integer totalCount=null;
		totalCount=orderDao.findByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		Integer totalPage=null;
		if(totalCount % limit == 0){
			
			totalPage = totalCount / limit;
			
		}else{
			totalPage = totalCount / limit+1;
		}
		pageBean.setTotalpage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		Integer begin = (page-1) * limit ;
		List<Order> list = orderDao.findByPageUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//ҵ��㣺���ݶ���id��ѯ�����ķ���
	public Order findByOid(Integer oid) {
		
		Order order = orderDao.findByOid(oid);	
		
		return order;
	}
	
	//�޸Ķ���
	public void update(Order currOrder) {
		
		orderDao.update(currOrder);
		
	}
	
	
}
