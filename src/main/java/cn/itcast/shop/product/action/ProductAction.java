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
 * 商品类的Action
 * @author 93449
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//模型驱动封装
	private Product product = new Product();
	//注入ProductService
	private ProductService productService;
	//接收一级分类Cid
	private Integer cid;
	//接收二级分类的id
	private Integer csid;
	//注入一级分类的service
	private CategoryService categoryService;
	//接收当前的页数
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

	//根据商品id查询商品：执行方法
	public String findByPid(){
		
		product = productService.findByPid(product.getPid());
		
		return "findByPid";
	}
	
	//根据一级分类的id查询商品
	public String findByCid(){
		
		//List<Category> cList = categoryService.findAll();
		//根据一级分类查询商品，带分页查询
		PageBean<Product> pageBean = productService.findByPageCid(cid,page);
		//将pageBean 存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean); 
		return "findByCid";
		
	}
	
	//根据二级id查询商品
	public String findByCsid(){
		//根据二级分类查询商品
		PageBean<Product> pageBean =  productService.findByCsid(csid,page);
		//将pageBean 存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean); 
		return "findByCsid";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

