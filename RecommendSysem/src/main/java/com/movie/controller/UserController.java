package com.movie.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.pojo.User;
import com.movie.service.UserService;
import com.movie.utils.Message;

/**
 * 用户相关操作控制器
 * @author danbingbing
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//一个 jsp 页面名称的规定的变量定义
	//private static final String JSON_JSP = "login";
	
	@RequestMapping(value="/loginTest",method=RequestMethod.POST)
	public String loginTest() {
		
		return "login";
	}
	
	/**
	 * 检验用户的登录信息,验证成功后不刷新页面，将用户名展示出来表示登录成功
	 * @param User
	 * @return Message
	 */
	@ResponseBody
	@RequestMapping(value="/loginCheck",method=RequestMethod.POST)
	public Message checkLogin(User user,HttpSession session) {
		
		List<User> realUser = userService.findUsername(user.getUsername());
		
		if(realUser.size()==1){
			if(realUser.get(0).getPassword().equals(user.getPassword())){
				// 先清空密码，防止泄露
				realUser.get(0).setPassword(null);
				// 在session域中保存用户信息
				session.setAttribute("user", realUser.get(0));
				return Message.success().add("msg", "正在登录...");
			}else{
				return Message.failed().add("msg", "用户名或密码错误！");
			}
		}else{
			return Message.failed().add("msg", "不存在该用户！");
		}	
	}
	
	/**
	 * 检验用户的注册信息,验证成功后不刷新页面，将用户名展示出来表示注册成功
	 * @param User
	 * @return Message
	 */
	@ResponseBody
	@RequestMapping(value="/registerCheck",method=RequestMethod.POST)
	public Message registerLogin(User user) {
		
		String name = user.getName();
		String username = user.getUsername();
		String password = user.getPassword();
		
		// 注册时先判断用户名是否存在
		List<User> userList = userService.findUsername(user.getUsername());
		if(userList.size()==1){
			return Message.failed().add("msg", "该用户名已被注册，请修改您的用户名！");
		}else {
			// 判断用户名是否是合法，其中的 \\ 的第一个 \ 表示转义字符，实际正则表达式中只有一个 \
			String regular1 = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
			String regular2 = "(^[a-zA-Z0-9]{6,16}$)";
			String regular3 = "(^[a-zA-Z]\\w{5,15}$)";
			if(!name.matches(regular1)) {
				return Message.failed().add("msg", "昵称是6-16位的英文、数字和下划线或者是2-5位的中文组合！");
			}
			if(!username.matches(regular2)) {
				return Message.failed().add("msg", "用户名是6-16位的英文和数字组合！");
			}
			if(!password.matches(regular3)) {
				return Message.failed().add("msg", "密码只能包含6-16位的英文、数字或下划线，且只能以字母开始！");
			}else {
				return Message.success();
			}
		}
	}
	
	/**
	 * 用户信息注册
	 * @param User
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public Message register(User user) {
		
		userService.register(user);
		
		return Message.success().add("msg", "注册成功！");
		
	}
	
	/**
	 * 用户信息注册
	 * @param User
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value="/exit",method=RequestMethod.POST)
	public Message exitSystem(HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
		 // 清除session域中的user对象
	    session.removeAttribute("user");
		
		return Message.success().add("msg", "已安全退出系统！");
		
	}
	
}
