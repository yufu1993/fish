package cn.itcast.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.category.service.CategoryService;

/**
 * 后台管理一级分类Action
 * @author 93449
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	//模型驱动封装的类
	private Category category = new Category();
	public Category getModel() {
		return category;
	}
	
	//注入一级分类service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//查询所有一级分类的方法
	public String findAll(){
		
		List<Category> cList = categoryService.findAll();
		
		//存入到值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//后台保存一级分类的方法
	public String save(){
			
		//调用service保存一级分类
		categoryService.save(category);
		//页面跳转
		return "saveSuccess";
	}
	
	//后台删除一级分类的方法
	public String delete(){
		
		//接收cid，可以使用模型驱动，删除一级分类，同时删除二级分类，必须先根据id查询，再进行删除
		category = categoryService.findByCid(category.getCid());
		//删除
		categoryService.delete(category);
		
		return "deleteSuccess";
	}
	
	//后台查询以及分类
	public String edit(){
		//根据cid查询一级分类
		category = categoryService.findByCid(category.getCid());
		//页面跳转
		return "editSuccess";
	}
	
	//后台编辑一级分类的方法
	public String update(){
		
		categoryService.update(category);
		
		return "updateSuccess";
	}
	
}
