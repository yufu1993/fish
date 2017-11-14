package cn.itcast.shop.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.category.entity.Category;
import cn.itcast.shop.category.service.CategoryService;

/**
 * ��̨����һ������Action
 * @author 93449
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	//ģ��������װ����
	private Category category = new Category();
	public Category getModel() {
		return category;
	}
	
	//ע��һ������service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//��ѯ����һ������ķ���
	public String findAll(){
		
		List<Category> cList = categoryService.findAll();
		
		//���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//��̨����һ������ķ���
	public String save(){
			
		//����service����һ������
		categoryService.save(category);
		//ҳ����ת
		return "saveSuccess";
	}
	
	//��̨ɾ��һ������ķ���
	public String delete(){
		
		//����cid������ʹ��ģ��������ɾ��һ�����࣬ͬʱɾ���������࣬�����ȸ���id��ѯ���ٽ���ɾ��
		category = categoryService.findByCid(category.getCid());
		//ɾ��
		categoryService.delete(category);
		
		return "deleteSuccess";
	}
	
	//��̨��ѯ�Լ�����
	public String edit(){
		//����cid��ѯһ������
		category = categoryService.findByCid(category.getCid());
		//ҳ����ת
		return "editSuccess";
	}
	
	//��̨�༭һ������ķ���
	public String update(){
		
		categoryService.update(category);
		
		return "updateSuccess";
	}
	
}
