package cn.gyyx.test;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gyyx.test.xuguochun.beans.UserInfo;
import cn.gyyx.test.xuguochun.dao.UserDAO;

/**
 * �û�ע��
 */
@Controller
public class UserController {

	
	/*
	 * ҳ��model
	 */
	 @ModelAttribute("UserInfo")  
     public UserInfo addUser(HttpServletRequest request, HttpServletResponse response) {  
		 UserInfo user= new UserInfo();
		 user.setUserName(request.getParameter("username"));
		 user.setPassword(request.getParameter("password"));
		 user.setSex(request.getParameter("sex"));
		 user.setMail(request.getParameter("mail"));
		 int myage=0;
	      try{
	    	  myage=Integer.parseInt(request.getParameter("age"));
 
	    }catch(Exception e){
	         
	     }
	    user.setAge(myage);
		 return user;
     }
	 
	 
	 /*
		 * �û�ע��
		 */
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public String register(Locale locale,Model model) {
			model.addAttribute("message", "");
			return "register";
		}
		
		/*
		 * �û�ע��
		 */
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String register(@ModelAttribute("UserInfo") UserInfo user,Model model, HttpServletResponse response) {		
			
			String errorMsg="ע��ɹ�";
			
			UserDAO userdao=new UserDAO();

			try{
				userdao.InsertUserInfo(user);
				
				response.sendRedirect("/ui/userlist");
			}
			catch (Exception e) {
				errorMsg="ע��ʧ��";
			}
			
			model.addAttribute("message", errorMsg);
			
			return "register";
		}

	 
	 
}
