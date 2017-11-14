package cn.itcast.shop.product.adminproductaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.categorysecond.entity.CategorySecond;
import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.product.entity.Product;
import cn.itcast.shop.product.service.ProductService;
import cn.itcast.shop.utils.PageBean;

public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//模型驱动
	private Product product = new Product();
	public Product getModel() {
		return product;
	}
	
	//接收page参数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//文件上传需要的参数
	private File upload;//上传的文件
	private String uploadFileName;//接收文件上传的文件名
	private String uploadContentType;//接收文件上传的文件MIME类型
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//注入商品的service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入二级分类service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//后台查询所有商品 带分页
	public String findAllByPage(){
		//调用service完成查询
		PageBean<Product> pageBean = productService.findByPage(page);
		//将数据传递到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAllSuccess";
	}
	
	//后台添加商品页面跳转的方法
	public String addPage(){
		//查询所有的二级分类集合
		List<CategorySecond> cslist = categorySecondService.findAll();
		//通过值栈进行保存数据
		ActionContext.getContext().getValueStack().set("cslist", cslist);
		//页面跳转
		return "addPageSuccess";
	}
	
	public String save() throws IOException{
		//调用service完成保存的操作
		product.setPdate(new Date());
		
		if(upload != null){
			//获得文件上传的磁盘的绝对路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			System.out.println(realPath);
			//创建一个文件
			File diskFile = new File(realPath+"//"+uploadFileName);
			//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		
		
		return "saveSuccess";
	}
	
	//删除商品的方法
	public String delete(){
		//先查询再删除
		product = productService.findByPid(product.getPid());
		//删除上传的图片
		String path = product.getImage();
		if(path != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
			File file= new File(realPath);
			file.delete();
		}
		//删除商品
		productService.delete(product);
		//页面跳转
		return "deleteSuccess";
		
	}
	
	//编辑商品页面跳转的方法
	public String edit(){
		
		//查询要编辑的商品
		product = productService.findByPid(product.getPid());
		//查询所有的二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		//存到值栈中
		ActionContext.getContext().getValueStack().set("csList", csList);
		
		
		return "editSuccess";
	}
}
