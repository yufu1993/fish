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
	
	//ʹ��ģ��������װ����
	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {
		return categorySecond;
	}
	
	//ע���������service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//����page
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//ע��һ������service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	//��ѯ��������ķ���
	public String findAllByPage(){
		PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
		//��pageBean���ݱ��浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//ҳ����ת
		return "findAll";
	}
	
	//��ת����Ӷ�������ķ���
	public String addPage(){
		//��ѯ���е�һ������
		List<Category> cList = categoryService.findAll();
		//��һ������洢��ֵջ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		//ҳ����ת
		return "addPageSuccess";
	}
	
	//�����������ķ���
	public String save(){
		
		categorySecondService.save(categorySecond);
		
		return "saveSuccess";
	}
	
	//ɾ����������ķ���
	public String delete(){
		//�������ɾ�����Ȳ�ѯ��ɾ��������cashcade
		categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		
		return "deleteSuccess";
	}
	
	//�༭��������ķ���
	public String edit(){
		//���ݶ�������id��ѯ�����������
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//��ѯ���е�һ������
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editSuccess";
	}
	
	
	//�޸Ķ�������ķ���
	public String update(){
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}
	
}
