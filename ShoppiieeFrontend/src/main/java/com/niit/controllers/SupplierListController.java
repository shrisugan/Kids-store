package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierListController {
	
	@Autowired
	SupplierDAO sdao;

	@RequestMapping(value ="admin/supplierList")
    public ModelAndView add2() {
		List<Supplier> list=sdao.getAllSupplier();
       ModelAndView c1=new ModelAndView("supplierList");
	   c1.addObject("list", list);
		return c1;
    }


}
