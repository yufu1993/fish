package cn.itcast.shop.categorysecond.admincategorysecond;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.category.service.CategoryService;
import cn.itcast.shop.categorysecond.entity.CategorySecond;
import cn.itcast.shop.categorysecond.service.CategorySecondService;
import cn.itcast.shop.utils.PageBean;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	
	//使用模型驱动封装的类
	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//注入二级分类service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//接收page
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//注入一级分类service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//查询二级分类的方法
	public String findAllByPage(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		//将pageBean数据保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//页面跳转
		return "findAll";
	}
	
	//跳转到添加二级分类的方法
	public String addPage(){
		//查询所有的一级分类
		List<Category> cList = categoryService.findAll();
		//将一级分类存储到值栈中
		ActionContext.getContext().getValueStack().set("cList", cList);
		//页面跳转
		return "addPageSuccess";
	}
	
	//保存二级分类的方法
	public String save(){
		
		categorySecondService.save(categorySecond);
		
		return "saveSuccess";
	}
	
	//删除二级分类的方法
	public String delete(){
		//如果级联删除，先查询再删除，配置cashcade
		categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		
		return "deleteSuccess";
	}
	
	//编辑二级分类的方法
	public String edit(){
		//根据二级分类id查询二级分类对象
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//查询所有的一级分类
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	
	
	//修改二级分类的方法
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
