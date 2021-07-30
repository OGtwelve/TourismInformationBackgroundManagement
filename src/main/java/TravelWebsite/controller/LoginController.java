/**
 * 
 */
package TravelWebsite.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import TravelWebsite.domain.Account;
import TravelWebsite.domain.User;
import TravelWebsite.service.LoginService;
import TravelWebsite.utils.RandomStringUtil;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 * 用户登录控制
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	/**
	 * 跳转至登录页面
	 * @return
	 */
	@RequestMapping(path = "")
	public String login() {
		return "/loginView/login";
	}
	/**
	 * 用户登录
	 * @param loginName	用户登录信息：账号名、手机号或邮箱
	 * @param loginPassword	登录密码
	 * @param captcher	验证码
	 * @param modelAndView
	 * @param request
	 * @return	/loginView/login.jsp or insert.jsp
	 */
	@RequestMapping(path = "",method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("loginName")String loginName ,@RequestParam("loginPassword")String loginPassword,@RequestParam("captcher")String captcher,ModelAndView modelAndView,HttpSession session) {
		Map<String, String> loginMap=new HashMap<String,String>();
		if(!RandomStringUtil.getRandomString(session.getAttribute("captche").toString()).equals(RandomStringUtil.getRandomString(captcher))) {
			modelAndView.addObject("loginMsg", "-输入的验证码有误");
		}else {
			Integer loginIdInteger=null;
			if(loginService.findUserByUserName(loginName)!=null) {
				loginIdInteger=loginService.findUserByUserName(loginName).getUserIdInteger();
			}
			if(loginService.findAccountByPhone(loginName)!=null) {
				loginIdInteger=loginService.findAccountByPhone(loginName).getAccountUserIdInteger();
			}        
			if(loginService.findAccountByEmail(loginName)!=null) {
				loginIdInteger=loginService.findAccountByEmail(loginName).getAccountUserIdInteger();
			}
			if(loginIdInteger==null) {
				modelAndView.addObject("loginMsg", "-输入的账号信息有误");
			}else {
				User user=loginService.findUserById(loginIdInteger);
				if(!user.getUserPasswordEncryptionString().equals(DigestUtils.md5Hex(user.getUserPasswordKeyString()+loginPassword))) {
					modelAndView.addObject("loginMsg", "-输入的密码有误");
				}else {
					session.setAttribute("loginId", loginIdInteger);
					if("T".equals(user.getUserAdminString())) {
						modelAndView.setViewName("redirect:/admin");
					}else {
						modelAndView.setViewName("redirect:/error");
					}
					return modelAndView;
				
				}
			}
		}
		loginMap.put("loginName", loginName);
		loginMap.put("loginPassword", loginPassword);
		
		modelAndView.addObject("loginMap", loginMap);
		modelAndView.setViewName("/loginView/login");
		return modelAndView;
	}
	
	/**
	 * 判断输入的 注册账户是否存在
	 * @param ajax
	 * @return
	 */
	@RequestMapping(path = "/insertAjax", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String insertAjax(@RequestParam("name") String name,@RequestParam("ajax") String ajax) {
		String returnString="";
		if(loginService.findUserByUserName(ajax)!=null) {
			if("insertName".equals(name)) {
				returnString= "-该账户名已存在";
			}
		}
		if(loginService.findAccountByPhone(ajax)!=null) {
			if("insertPhone".equals(name)) {
				returnString= "-该手机号已存在";
			}
		}
		if(loginService.findAccountByEmail(ajax)!=null) {
			if("insertEmail".equals(name)) {
				returnString= "-该邮箱已存在";
			}
		}
//		手机号邮箱查重bug 并不会查到  由王佳宝于3/25日解决 原因:数据库内出现重复
		return returnString;
	}
	/**
	 * 用户注册
	 * @param insertName 	注册用户名
	 * @param insertPhone	注册手机号
	 * @param insertEmail	注册邮箱
	 * @param insertPassword	注册密码
	 * @param insertPasswordAgin	注册确认密码
	 * @param modelAndView
	 * @return	loginView/login.jsp
	 */
	@RequestMapping(path="/insert")
	public ModelAndView insert(@RequestParam("insertName")String insertName,@RequestParam("insertPhone")String insertPhone,@RequestParam("insertEmail")String insertEmail,@RequestParam("insertPassword")String insertPassword,@RequestParam("insertPasswordAgin")String insertPasswordAgin,ModelAndView modelAndView) {
		String insertMsg="";
		Map<String, String> insertMap=new HashMap<String, String>();
		
		if("".equals(insertName)) {
			insertMsg="-请输入用户名";
		}else if ("".equals(insertPhone)) {
			insertMsg="-请输入手机号";
		}else if ("".equals(insertEmail)) {
			insertMsg="-请输入邮箱";
		}else if ("".equals(insertPassword)) {
			insertMsg="-请输入密码";
		}else if ("".equals(insertPasswordAgin)) {
			insertMsg="-请输入确认密码";
		}else{
			if(insertName.length()>20) {
				insertMsg="-用户名太长了.....";
			}else if (!Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$").matcher(insertPhone).matches()) {
				insertMsg="-输入的手机号有误";
			}else if (!Pattern.compile("^([A-Za-z0-9_\\-\\.\\u4e00-\\u9fa5])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,8})$").matcher(insertEmail).matches()) {
				insertMsg="-输入的邮箱有误";
			}else if(insertPassword.length()<3||insertPassword.length()>20) {
				insertMsg="-密码保持在3~20";
			}else if(!insertPassword.equals(insertPasswordAgin)) {
				insertMsg="-请保持密码一致";
			}else {
				if(loginService.findUserByUserName(insertName)!=null) {
					insertMsg="-该账户名已存在";
				}else if(loginService.findAccountByPhone(insertPhone)!=null) {
					insertMsg="-该手机号已存在";
				}else if(loginService.findAccountByEmail(insertEmail)!=null) {
					insertMsg="-该邮箱已存在";
				}else {
					User user=new User();
					Account account=new Account();
					
					user.setUserNameString(insertName);
					user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
					user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString()+insertPassword));
					user.setUserAdminString("F");
					
					account.setAccountPhoneString(insertPhone);
					account.setAccountEmailString(insertEmail);
					account.setAccountIdCardString(null);
					account.setAccountAgeString("0");
					account.setAccountGenderString("男");
					account.setAccountBalanceDouble(0d);
					
					loginService.insertLogin(user, account);
					modelAndView.addObject("insertToLoginName", insertName);
					modelAndView.setViewName("/loginView/login");				
					return modelAndView;
				}
			}
		}
		
		insertMap.put("insertName", insertName);
		insertMap.put("insertPhone", insertPhone);
		insertMap.put("insertEmail", insertEmail);
		insertMap.put("insertPassword", insertPassword);
		insertMap.put("insertPasswordAgin", insertPasswordAgin);
		
		modelAndView.addObject("insertMap", insertMap);
		modelAndView.addObject("insertMsg", insertMsg);
		modelAndView.setViewName("/loginView/login");
		return modelAndView;
	}
	
	/**
	 * 忘记密码
	 * @param forgotName 账户信息：账户名、手机号或邮箱
	 * @param modelAndView
	 * @return loginView/login.jsp
	 */
	@RequestMapping(path = "/forgot")
	public ModelAndView forgot(@RequestParam("forgotName")String forgotName,ModelAndView modelAndView) {
		Integer findForgotIdInteger=null;
		if(loginService.findUserByUserName(forgotName)!=null) {
			findForgotIdInteger=loginService.findUserByUserName(forgotName).getUserIdInteger();
		}
		if(loginService.findAccountByPhone(forgotName)!=null) {
			findForgotIdInteger=loginService.findAccountByPhone(forgotName).getAccountUserIdInteger();
		}        
		if(loginService.findAccountByEmail(forgotName)!=null) {
			findForgotIdInteger=loginService.findAccountByEmail(forgotName).getAccountUserIdInteger();
		}
		if(findForgotIdInteger!=null) {
			modelAndView.addObject("forgotId",findForgotIdInteger);
		}else {
			modelAndView.addObject("forgotMsg", "输入的账号信息有误，请重新输入");
		} 
		modelAndView.setViewName("/loginView/login");
		return modelAndView;
	}
	
	/**
	 * 修改用户密码
	 * @param forgotId	用户id
	 * @param updatePassword 新密码
	 * @param updatePasswordAgain	确认密码
	 * @param modelAndView
	 * @param sessionStatus
	 * @return /loginView/login.jsp
	 */
	@RequestMapping("/update/{forgotId}")
	public ModelAndView update(@PathVariable("forgotId") Integer  forgotId,@RequestParam("updatePassword") String updatePassword,@RequestParam("updatePasswordAgain")String updatePasswordAgain,ModelAndView modelAndView,SessionStatus sessionStatus) {
		Map<String, String> updateMap=new HashMap<String,String>();
		
		if(updatePassword.length()<3 || updatePassword.length()>20) {
			modelAndView.addObject("updateMsg", "新密码保持在3~20");
		}else if(!updatePassword.equals(updatePasswordAgain)) {
			modelAndView.addObject("updateMsg", "请保持密码一致");
		}else {
			User user=loginService.findUserById(forgotId);
			if(user.getUserPasswordEncryptionString().equals(DigestUtils.md5Hex(user.getUserPasswordKeyString()+updatePassword))) {
				modelAndView.addObject("updateMsg", "新密码不能和旧密码相同");
			}else {
				user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
				user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString()+updatePassword));
				
				loginService.updateLogin(user);
				modelAndView.addObject("forgotId", "");
				modelAndView.addObject("updateToLoginName", user.getUserNameString());
			}
		}
		updateMap.put("updatePassword", updatePassword);
		updateMap.put("updatePasswordAgain", updatePasswordAgain);
		modelAndView.addObject("updateMap", updateMap);
		modelAndView.setViewName("/loginView/login");
		return modelAndView;
	}
}
