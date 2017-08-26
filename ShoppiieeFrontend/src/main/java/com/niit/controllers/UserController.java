package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAO;
import com.niit.model.User;


public class UserController {
	@Autowired
	UserDAO users;
	@RequestMapping(value ="/userlist")
    public ModelAndView add() {
    List<User>list=users.getAllUserDetails();
	ModelAndView c1=new ModelAndView("userlist");
	c1.addObject("clist", list);
		return c1;
    }

}
