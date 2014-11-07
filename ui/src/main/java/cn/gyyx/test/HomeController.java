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
 * �û��б�
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * �û��б�ҳ
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//logger.info("Welcome home! The client locale is {}.", locale);

		UserDAO userdao=new UserDAO();
		
		
		List<UserInfo> lists=userdao.GetList(null);

		logger.info("lists.size="+lists.size());

		model.addAttribute("users", lists);
		
		return "home";
	}
	
	/**
	 * �û��б�ҳ
	 */
	@RequestMapping(value = "/userlist", method = RequestMethod.POST)
	public String home(Locale locale, Model model,HttpServletRequest request) {
		
		String name=request.getParameter("names");
		
		logger.info("names="+name);
		
		UserDAO userdao=new UserDAO();
		
		
		String[] names = new String[]{name};
		
		if(name==""){
			names=null;
			
		}
		
		
		List<UserInfo> lists=userdao.GetList(names);
		
		model.addAttribute("users", lists);
		
		return "home";
	}
	
	
}