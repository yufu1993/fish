package cn.itcast.shop.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.product.dao.ProductDao;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.utils.PageBean;

/**
 * ��Ʒ��ҵ�����
 * @author 93449
 *
 */
@Transactional
public class ProductService {
	
	//ע��ProductDao
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//��ѯ������Ʒ
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	
	//��ѯ������Ʒ
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	
	//������Ʒid��ѯ��Ʒ��
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	
	//����һ������cid���з�ҳ��ѯ��Ʒ 
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		
		PageBean<Product> pageBean =  new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��
		int limit=12;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount % limit); //����ȡ��
		if(totalCount % limit == 0){
			totalPage = totalCount / limit ;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//���Ŀ�ʼ
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//���ݶ�������id��ѯ��Ʒ
	public PageBean<Product> findByCsid(Integer csid, int page) {
		
		PageBean<Product> pageBean =  new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��
		int limit=12;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount = 0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage = 0;
		//Math.ceil(totalCount % limit); //����ȡ��
		if(totalCount % limit == 0){
			totalPage = totalCount / limit ;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//ÿҳ��ʾ�����ݼ���
		//���Ŀ�ʼ
		int begin = (page-1)*limit;
		List<Product> list = productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//ҵ��� ��̨��ѯ��Ʒ����ҳ�ķ���
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean =  new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit=10;
		pageBean.setLimit(limit);
		//�����ܵļ�¼��
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage = totalCount / limit ;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//����ÿҳ��ʾ�����ݼ���
		int begin=(page-1)*limit;
		List<Product> list = productDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//ҵ��㱣����Ʒ�ķ���
	public void save(Product product) {
		productDao.save(product);
	}
	
	//ҵ���ɾ����Ʒ�ķ���
	public void delete(Product product) {
		productDao.delete(product);
	}

	
	
}
