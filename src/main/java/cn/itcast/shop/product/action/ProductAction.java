package cn.itcast.shop.product.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.utils.PageBean;

/**
 * ��Ʒ���Action
 * @author 93449
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//ģ��������װ
	private Product product = new Product();
	//ע��ProductService
	private ProductService productService;
	//����һ������Cid
	private Integer cid;
	//���ն��������id
	private Integer csid;
	//ע��һ�������service
	private CategoryService categoryService;
	//���յ�ǰ��ҳ��
	private int page;
	
	
	public Integer getCid() {
		return cid;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public Product getModel() {
		return product;
	}
	
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	//������Ʒid��ѯ��Ʒ��ִ�з���
	public String findByPid(){
		
		product = productService.findByPid(product.getPid());
		
		return "findByPid";
	}
	
	//����һ�������id��ѯ��Ʒ
	public String findByCid(){
		
		//List<Category> cList = categoryService.findAll();
		//����һ�������ѯ��Ʒ������ҳ��ѯ
		PageBean<Product> pageBean = productService.findByPageCid(cid,page);
		//��pageBean ���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean); 
		return "findByCid";
		
	}
	
	//���ݶ���id��ѯ��Ʒ
	public String findByCsid(){
		//���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean =  productService.findByCsid(csid,page);
		//��pageBean ���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean); 
		return "findByCsid";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

