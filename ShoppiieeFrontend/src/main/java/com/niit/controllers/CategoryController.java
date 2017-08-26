package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
class CategoryController {
	
	@Autowired
    CategoryDAO categorys;
	

	@Autowired
	SupplierDAO suppliers;
	
	

	@Autowired
	ProductDAO products;
	
	/*@Autowired
	private ProductDAO productDAO;*/

	

	@RequestMapping(value ="/admin/add")
	   public ModelAndView add() {

			List<Category> clist=categorys.getAllCategoryDetails();
		    List<Supplier> slist=suppliers.getAllCategories();
		    
			ModelAndView mv = new ModelAndView("Adding");
			mv.addObject("clist", clist);
			mv.addObject("slist",slist);
			return mv;
	   }
	 
	 @RequestMapping(value ="/admin/category")
	    public ModelAndView addcategory(HttpServletRequest request)
	    {
	        
		 
		 /*String c_id=String.valueOf(request.getParameter("cId"));*/
		 int c_id=Integer.parseInt(request.getParameter("cId"));
			String c_name=request.getParameter("cn");
			System.out.println(c_id+"---"+c_name);
			categorys.addCategory(new Category(c_id, c_name, null));
			
			Category c=new Category();
			c.setCategoryId(c_id);
			c.setCategoryName(c_name);
			ModelAndView mv = new ModelAndView("Adding");
			return mv;
	    }
	 
	 @RequestMapping(value ="/admin/supplier")
	    public ModelAndView addsupplier(HttpServletRequest request)
	    {
	        
		 /*String s_id=String.valueOf(request.getParameter("sId"));*/
		 int s_id=Integer.parseInt(request.getParameter("sId"));
			String s_name=request.getParameter("sn");
			System.out.println(s_id+"---"+s_name);
			suppliers.addSupplier(new Supplier(s_id, s_name,null));
			ModelAndView mv = new ModelAndView("Adding");
			return mv;
	    }
	 
	 @RequestMapping(value ="/admin/product")
	    public ModelAndView addproduct(@RequestParam("file") MultipartFile file ,HttpServletRequest request)
	    {
	        
		    /*String p_id=request.getParameter("pId");*/
		    int p_id=Integer.parseInt(request.getParameter("pid"));
			String p_name=request.getParameter("pn");
			/*String p_img=request.getParameter("pimg");*/
			String originalfile = file.getOriginalFilename();
			String pdes=request.getParameter("pdes");
			int p_price=Integer.parseInt(request.getParameter("pp"));
			/*String p_cat=request.getParameter("pc");*/
			int p_cat=Integer.parseInt(request.getParameter("pc"));
			/*String p_sc=request.getParameter("psc");*/
			int p_sc=Integer.parseInt(request.getParameter("psc"));
			System.out.println(p_id+"---"+p_name+"---"+p_cat+"---"+p_price+"---"+p_sc);
			Category c=categorys.getCategoryDetail(p_cat);
			Supplier s=suppliers.getSupplierDetail(p_sc);
			Product t=new Product();
			t.setProdId(p_id);
			/*t.setImage(p_img);*/
			t.setImage(originalfile);
			t.setProdDescription(pdes);
			t.setProdName(p_name);
			t.setProdPrice(p_price);
			t.setProdCategory(c);
			t.setProdSupplier(s);
			
			ModelAndView mv = new ModelAndView("Adding");
			
			List<Category> clist=categorys.getAllCategoryDetails();
		    List<Supplier> slist=suppliers.getAllCategories();
			mv.addObject("clist", clist);
			mv.addObject("slist",slist);
			
			System.out.println("in controllers");
			products.addProduct(t);
			String filepath = request.getSession().getServletContext().getRealPath("/") + "resources/product/" + file.getOriginalFilename();
			
			System.out.println(filepath);
			try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}

			
			return mv;

			
			
	    }
	 
	 @ModelAttribute
	 public void addAttributes(Model model)
	 
	 {
		 model.addAttribute("clist",categorys.getAllCategoryDetails());
	 }
	 
	 
	 @RequestMapping("/product")
		public ModelAndView product(HttpServletRequest request) 
		{
			
	        int id=Integer.valueOf(request.getParameter("id"));
	        Product p=products.findById(id);
			ModelAndView mv = new ModelAndView("productdesc");
			List<Category> c=categorys.getAllCategoryDetails();
			mv.addObject("catalist",c);
			mv.addObject("product", p);
			
			return mv;
		}
			
		
}
