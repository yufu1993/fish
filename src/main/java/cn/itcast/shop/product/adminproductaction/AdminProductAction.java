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
	
	//ģ������
	private Product product = new Product();
	public Product getModel() {
		return product;
	}
	
	//����page����
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//�ļ��ϴ���Ҫ�Ĳ���
	private File upload;//�ϴ����ļ�
	private String uploadFileName;//�����ļ��ϴ����ļ���
	private String uploadContentType;//�����ļ��ϴ����ļ�MIME����
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//ע����Ʒ��service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//ע���������service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//��̨��ѯ������Ʒ ����ҳ
	public String findAllByPage(){
		//����service��ɲ�ѯ
		PageBean<Product> pageBean = productService.findByPage(page);
		//�����ݴ��ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//ҳ����ת
		return "findAllSuccess";
	}
	
	//��̨�����Ʒҳ����ת�ķ���
	public String addPage(){
		//��ѯ���еĶ������༯��
		List<CategorySecond> cslist = categorySecondService.findAll();
		//ͨ��ֵջ���б�������
		ActionContext.getContext().getValueStack().set("cslist", cslist);
		//ҳ����ת
		return "addPageSuccess";
	}
	
	public String save() throws IOException{
		//����service��ɱ���Ĳ���
		product.setPdate(new Date());
		
		if(upload != null){
			//����ļ��ϴ��Ĵ��̵ľ���·��
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			System.out.println(realPath);
			//����һ���ļ�
			File diskFile = new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		productService.save(product);
		
		
		return "saveSuccess";
	}
	
	//ɾ����Ʒ�ķ���
	public String delete(){
		//�Ȳ�ѯ��ɾ��
		product = productService.findByPid(product.getPid());
		//ɾ���ϴ���ͼƬ
		String path = product.getImage();
		if(path != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+path);
			File file= new File(realPath);
			file.delete();
		}
		//ɾ����Ʒ
		productService.delete(product);
		//ҳ����ת
		return "deleteSuccess";
		
	}
	
	//�༭��Ʒҳ����ת�ķ���
	public String edit(){
		
		//��ѯҪ�༭����Ʒ
		product = productService.findByPid(product.getPid());
		//��ѯ���еĶ�������
		List<CategorySecond> csList = categorySecondService.findAll();
		//�浽ֵջ��
		ActionContext.getContext().getValueStack().set("csList", csList);
		
		
		return "editSuccess";
	}
}
