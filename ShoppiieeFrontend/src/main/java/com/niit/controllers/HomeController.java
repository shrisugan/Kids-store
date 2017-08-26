package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class HomeController {
	
	@Autowired
	public UserDAO user1;
	
	@Autowired
	public ProductDAO proDao;
	
	@Autowired
	public SupplierDAO supDao;
	
	@Autowired
	public CategoryDAO catsDao;
	
	@Autowired
	public CartDAO cart1;
	
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
	   
		ModelAndView mv = new ModelAndView("index");
		List<Category> categories=catsDao.getAllCategoryDetails();
		mv.addObject("catlist",categories);
		/*mv.getModelMap().addAttribute("clist", categories);*/
		return mv;
	}
	
	
	
	@RequestMapping("/ProductDetails")
	public ModelAndView product() {

		ModelAndView mv = new ModelAndView("ProductDetails");
		
		return mv;
	}
	
	@RequestMapping("/productdesc")
	public ModelAndView product1() {

		ModelAndView mv = new ModelAndView("productdesc");
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@RequestMapping("/userproduct")
	public ModelAndView userproduct() {

		ModelAndView mv = new ModelAndView("userproduct");
		
		return mv;
	}
	
		
	 @RequestMapping(value="/reg")
	 	public ModelAndView regpage()
	 	{
	 		ModelAndView m2=new ModelAndView("signup");
	 		return m2;
	 		
	 	}
	 
	  @RequestMapping(value ="/signup")
	  public ModelAndView addUser(HttpServletRequest request)
	  {
			
		  int u_id=Integer.parseInt(request.getParameter("uid"));
		  
		  String u_name=request.getParameter("username");
		  
		  String u_pass=request.getParameter("userpass");
		  
		  String u_addr=request.getParameter("useraddress");
		  
		  String u_mail=request.getParameter("email");
		  
		  String u_age=request.getParameter("age");
		 
		  String u_phone=request.getParameter("userphone");
		  
		  String u_gen=request.getParameter("gen");
		  
		  
		  
		  User u=new User();
		  u.setUser_Id(u_id);
		  u.setUserName(u_name);
		  u.setUserPassword(u_pass);
		  u.setUserAge(u_age);
		  u.setUser_Gender(u_gen);
		  u.setUser_Phone(u_phone);
		  u.setUserMailId(u_mail);
		  u.setUser_Address(u_addr);
		  u.setUserRole("User");
		  user1.addUser(u);
			System.out.println(u.getUser_Id());
			
			ModelAndView mv = new ModelAndView("index");
			return mv;
	  }

	
	@RequestMapping("/ProductList")
	public ModelAndView ProductList() {

					ModelAndView model = new ModelAndView("ProductList");

					return model;
				}
	
	@RequestMapping("/categorylist")
	public ModelAndView categorylist() {

		ModelAndView mv = new ModelAndView("Categorylist");
		
		return mv;
	}
	
	
	 @RequestMapping(value ="/admin/product_delete")
	   public ModelAndView delete(HttpServletRequest request)
	   {
			
			Product p=proDao.findById(Integer.parseInt(request.getParameter("id")));
			System.out.print(p);
			proDao.delete(p);
		   List<Product> list=proDao.getAllProductDetails();
		   ModelAndView mv = new ModelAndView("Adding");	
		   mv.addObject("list",list);
		  return mv;
		 
	   }
	  @RequestMapping(value="/admin/product_edit")
		public ModelAndView editProducts(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		ModelAndView mv=new ModelAndView("productedit");
		List<Category> clist=catsDao.getAllCategoryDetails();
	    List<Supplier> slist=supDao.getAllCategories();
		System.out.println(proDao.findById(id).toString());
		mv.addObject("product",proDao.findById(id) );	
		mv.addObject("clist", clist);
		mv.addObject("slist",slist);
		return mv;
		}
	  
	  
	  @RequestMapping(value = "/admin/product_update")
		public  ModelAndView updateProduct(HttpServletRequest request) 
		{ 
			System.out.println("in Products Controller");
			int id=Integer.parseInt(request.getParameter("pId"));
			String pname=request.getParameter("pn");
			/*String pdesc=request.getParameter("p_desc");*/
			int price=Integer.parseInt(request.getParameter("pp"));
			int cid=Integer.valueOf(request.getParameter("pc"));
			int sid=Integer.valueOf(request.getParameter("psc"));
			String img=request.getParameter("pimg");
			Category c=catsDao.getCategoryDetail(cid);
			Supplier s=supDao.getSupplierDetail(sid);
			Product p=new Product();
			p.setProdCategory(c);
			p.setProdName(pname);
			p.setProdPrice(price);
			p.setProdId(id);	
			/*String originalfile = file.getOriginalFilename();*/
			p.setImage(img);
			p.setProdSupplier(s);
			
			proDao.updateCategoryDetails(p);
			
			
			List<Category> clist=catsDao.getAllCategoryDetails();
			List<Supplier> slist=supDao.getAllSupplier();
			List<Product> list=proDao.getAllProductDetails();
		
			//ModelAndView mv = new ModelAndView("productList");
			ModelAndView mv = new ModelAndView("productlist");
			mv.addObject("slist", slist);
			mv.addObject("clist", clist);
			mv.addObject("list", list);
			return mv;
		}
	  
	  
	  
	  @RequestMapping("/productview")
		public ModelAndView productListFilter(HttpServletRequest request)
		{ 
			List<Product> list=proDao.getFilterProducts(Integer.valueOf(request.getParameter("id")));
			//List<Product> list=proDao.getAllProducts();
			ModelAndView mv = new ModelAndView("productview");	
			//mv.addObject("clist",clist);
			mv.addObject("list",list);
			return mv;
		}
	  
	  
	  @ModelAttribute
		 public void addAttributes(Model model)
		 
		 {
			 model.addAttribute("clist",catsDao.getAllCategoryDetails());
		 }
	  
	  
	 /* @RequestMapping("/productdetails")
	  public ModelAndView addCarttable(HttpServletRequest request) 
	  {
	  	
	  	int id=Integer.valueOf(request.getParameter("prodid"));
	  	
	  	int quan=Integer.valueOf(request.getParameter("prodquantity"));
	  	
	  	int price=Integer.valueOf(request.getParameter("prodprice"));
	  	int uid=Integer.valueOf(request.getParameter("userid"));
	  	int sid=Integer.valueOf(request.getParameter("suplierid"));
	  	
	  	UserModel c=user1.findById(uid);
	  	SupplierModel s=supplierDAO.findById(sid);
	  	System.out.println(""+id+""+quan+""+price);
	  	Product p= proDao.findById(id);
	  	Cart g=new Cart();
	  	g.setPrices(price);
	  	g.setQuantity(quan);
	  	g.setProdId(p);
	  	g.setSuplierid(s);
	  	g.setUserid(c);
	  	
	  	
	  	cart1.save(g);
	  	
	  	ModelAndView mv = new ModelAndView("productdesc");
	  	return mv;
	  }*/
	  
	  
	  
	  @RequestMapping("/product-details")
		public ModelAndView details(HttpServletRequest request){
		  	
		  	int id=Integer.parseInt(request.getParameter("id"));
		   Product p=proDao.findById(id);
				ModelAndView mv = new ModelAndView("ProductDetails");
				List<Category> c=catsDao.getAllCategoryDetails();
				mv.addObject("catalist",c);
				mv.addObject("productdt", p);
				
				return mv;
		  		  	
			 
		}
	  
	  @RequestMapping("/userlogged")
	  public String userlogged() {
		  return "redirect:/";
	  }
	  
}