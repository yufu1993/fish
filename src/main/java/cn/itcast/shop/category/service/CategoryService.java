package cn.itcast.shop.category.service;

import java.util.List;

import cn.itcast.shop.category.dao.CategoryDao;
import cn.itcast.shop.category.entity.Category;

/**
 * һ�������ҵ������
 * @author 93449
 *
 */
public class CategoryService {
	
	//ע��һ������dao
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * ҵ����ѯһ������ķ���
	 * @return
	 */
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
	//ҵ��㱣��һ������
	public void save(Category category) {

		categoryDao.save(category);
		
	}
	
	//����cid��ѯһ������ķ���
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}
	//ҵ���ɾ������
	public void delete(Category category) {
		
		categoryDao.delete(category);
	}
	
	//ҵ����޸�һ������ķ���
	public void update(Category category) {
		
		categoryDao.update(category);
		
	}

}
