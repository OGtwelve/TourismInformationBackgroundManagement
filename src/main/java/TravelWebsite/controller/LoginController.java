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
 * @author 3187102230 ���ѱ�
 * ����������
 * �û���¼����
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	/**
	 * ��ת����¼ҳ��
	 * @return
	 */
	@RequestMapping(path = "")
	public String login() {
		return "/loginView/login";
	}
	/**
	 * �û���¼
	 * @param loginName	�û���¼��Ϣ���˺������ֻ��Ż�����
	 * @param loginPassword	��¼����
	 * @param captcher	��֤��
	 * @param modelAndView
	 * @param request
	 * @return	/loginView/login.jsp or insert.jsp
	 */
	@RequestMapping(path = "",method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("loginName")String loginName ,@RequestParam("loginPassword")String loginPassword,@RequestParam("captcher")String captcher,ModelAndView modelAndView,HttpSession session) {
		Map<String, String> loginMap=new HashMap<String,String>();
		if(!RandomStringUtil.getRandomString(session.getAttribute("captche").toString()).equals(RandomStringUtil.getRandomString(captcher))) {
			modelAndView.addObject("loginMsg", "-�������֤������");
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
				modelAndView.addObject("loginMsg", "-������˺���Ϣ����");
			}else {
				User user=loginService.findUserById(loginIdInteger);
				if(!user.getUserPasswordEncryptionString().equals(DigestUtils.md5Hex(user.getUserPasswordKeyString()+loginPassword))) {
					modelAndView.addObject("loginMsg", "-�������������");
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
	 * �ж������ ע���˻��Ƿ����
	 * @param ajax
	 * @return
	 */
	@RequestMapping(path = "/insertAjax", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody String insertAjax(@RequestParam("name") String name,@RequestParam("ajax") String ajax) {
		String returnString="";
		if(loginService.findUserByUserName(ajax)!=null) {
			if("insertName".equals(name)) {
				returnString= "-���˻����Ѵ���";
			}
		}
		if(loginService.findAccountByPhone(ajax)!=null) {
			if("insertPhone".equals(name)) {
				returnString= "-���ֻ����Ѵ���";
			}
		}
		if(loginService.findAccountByEmail(ajax)!=null) {
			if("insertEmail".equals(name)) {
				returnString= "-�������Ѵ���";
			}
		}
//		�ֻ����������bug ������鵽  �����ѱ���3/25�ս�� ԭ��:���ݿ��ڳ����ظ�
		return returnString;
	}
	/**
	 * �û�ע��
	 * @param insertName 	ע���û���
	 * @param insertPhone	ע���ֻ���
	 * @param insertEmail	ע������
	 * @param insertPassword	ע������
	 * @param insertPasswordAgin	ע��ȷ������
	 * @param modelAndView
	 * @return	loginView/login.jsp
	 */
	@RequestMapping(path="/insert")
	public ModelAndView insert(@RequestParam("insertName")String insertName,@RequestParam("insertPhone")String insertPhone,@RequestParam("insertEmail")String insertEmail,@RequestParam("insertPassword")String insertPassword,@RequestParam("insertPasswordAgin")String insertPasswordAgin,ModelAndView modelAndView) {
		String insertMsg="";
		Map<String, String> insertMap=new HashMap<String, String>();
		
		if("".equals(insertName)) {
			insertMsg="-�������û���";
		}else if ("".equals(insertPhone)) {
			insertMsg="-�������ֻ���";
		}else if ("".equals(insertEmail)) {
			insertMsg="-����������";
		}else if ("".equals(insertPassword)) {
			insertMsg="-����������";
		}else if ("".equals(insertPasswordAgin)) {
			insertMsg="-������ȷ������";
		}else{
			if(insertName.length()>20) {
				insertMsg="-�û���̫����.....";
			}else if (!Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$").matcher(insertPhone).matches()) {
				insertMsg="-������ֻ�������";
			}else if (!Pattern.compile("^([A-Za-z0-9_\\-\\.\\u4e00-\\u9fa5])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,8})$").matcher(insertEmail).matches()) {
				insertMsg="-�������������";
			}else if(insertPassword.length()<3||insertPassword.length()>20) {
				insertMsg="-���뱣����3~20";
			}else if(!insertPassword.equals(insertPasswordAgin)) {
				insertMsg="-�뱣������һ��";
			}else {
				if(loginService.findUserByUserName(insertName)!=null) {
					insertMsg="-���˻����Ѵ���";
				}else if(loginService.findAccountByPhone(insertPhone)!=null) {
					insertMsg="-���ֻ����Ѵ���";
				}else if(loginService.findAccountByEmail(insertEmail)!=null) {
					insertMsg="-�������Ѵ���";
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
					account.setAccountGenderString("��");
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
	 * ��������
	 * @param forgotName �˻���Ϣ���˻������ֻ��Ż�����
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
			modelAndView.addObject("forgotMsg", "������˺���Ϣ��������������");
		} 
		modelAndView.setViewName("/loginView/login");
		return modelAndView;
	}
	
	/**
	 * �޸��û�����
	 * @param forgotId	�û�id
	 * @param updatePassword ������
	 * @param updatePasswordAgain	ȷ������
	 * @param modelAndView
	 * @param sessionStatus
	 * @return /loginView/login.jsp
	 */
	@RequestMapping("/update/{forgotId}")
	public ModelAndView update(@PathVariable("forgotId") Integer  forgotId,@RequestParam("updatePassword") String updatePassword,@RequestParam("updatePasswordAgain")String updatePasswordAgain,ModelAndView modelAndView,SessionStatus sessionStatus) {
		Map<String, String> updateMap=new HashMap<String,String>();
		
		if(updatePassword.length()<3 || updatePassword.length()>20) {
			modelAndView.addObject("updateMsg", "�����뱣����3~20");
		}else if(!updatePassword.equals(updatePasswordAgain)) {
			modelAndView.addObject("updateMsg", "�뱣������һ��");
		}else {
			User user=loginService.findUserById(forgotId);
			if(user.getUserPasswordEncryptionString().equals(DigestUtils.md5Hex(user.getUserPasswordKeyString()+updatePassword))) {
				modelAndView.addObject("updateMsg", "�����벻�ܺ;�������ͬ");
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
