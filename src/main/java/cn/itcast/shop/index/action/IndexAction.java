package cn.itcast.shop.index.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.product.service.ProductService;

/**
 * ������ҳ��Action
 * @author 93449
 *
 */

public class IndexAction extends ActionSupport{
	//ע��һ������service
	private CategoryService categoryService;
	//ע����Ʒ��service
	private ProductService productService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	/**
	 * ִ�з�����ҳ�ķ���
	 */
	public String execute(){
		//��ѯ����һ������ļ���
		List<Category> cList = categoryService.findAll();
		//��һ��������뵽Session��Χ
		ActionContext.getContext().getSession().put("cList", cList);
		//��ѯ������Ʒ
		List<Product> hList = productService.findHot();
		//���浽ֵջ��
		ActionContext.getContext().getValueStack().set("hList", hList);
		//��ѯ������Ʒ
		List<Product> nList = productService.findNew();
		//���浽ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
		
	}
	
	
}
