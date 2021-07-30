/**
 * 
 */
package TravelWebsite.controller;

import java.io.File;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import TravelWebsite.domain.Account;
import TravelWebsite.domain.Attraction;
import TravelWebsite.domain.AttractionProject;
import TravelWebsite.domain.Catering;
import TravelWebsite.domain.Hotel;
import TravelWebsite.domain.Tour;
import TravelWebsite.domain.Transfer;
import TravelWebsite.domain.User;
import TravelWebsite.service.AdminService;
import TravelWebsite.utils.RandomStringUtil;
import TravelWebsite.utils.exception.SysException;

/**
 * @author 3187102230 王佳宝 旅游网 管理员模式
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	private ModelAndView goAdminList(ModelAndView modelAndView) {
		List<User> users = adminService.findUserAll();
		modelAndView.addObject("users", users);
		modelAndView.addObject("admin", "list");
		modelAndView.setViewName("/adminView/admin/list");
		return modelAndView;
	}
	private ModelAndView goTour(ModelAndView modelAndView) {
		List<Tour> tours = adminService.findTourAll();
		modelAndView.addObject("tours", tours);
		modelAndView.addObject("modelAndView","tours");
		modelAndView.setViewName("/adminView/admin/tour");
		return modelAndView;
	}
	private ModelAndView goAttraction(ModelAndView modelAndView) {
		List<Attraction> attractions=adminService.findAttractionAll();
		List<Tour> AttractionTours = adminService.findTourAll();
		modelAndView.addObject("AttractionTours", AttractionTours);
		modelAndView.addObject("attractions", attractions);
		modelAndView.addObject("modelAndView","attractions");
		modelAndView.setViewName("/adminView/admin/attraction");
		System.out.println();
		return modelAndView;
	}
	private ModelAndView goCatering(ModelAndView modelAndView) {
		List<Catering> caterings = adminService.findCateringAll();
		List<Tour> CateringTours = adminService.findTourAll();
		modelAndView.addObject("CateringTours", CateringTours);
		modelAndView.addObject("caterings", caterings);
		modelAndView.addObject("modelAndView","caterings");
		modelAndView.setViewName("/adminView/admin/catering");
		return modelAndView;
	}
	private ModelAndView goHotel(ModelAndView modelAndView) {
		List<Hotel> hotels = adminService.findHotelAll();
		List<Tour> HotelTours = adminService.findTourAll();
		modelAndView.addObject("HotelTours", HotelTours);
		modelAndView.addObject("hotels", hotels);
		modelAndView.addObject("modelAndView","hotels");
		modelAndView.setViewName("/adminView/admin/hotel");
		return modelAndView;
	}
	private ModelAndView goTransfer(ModelAndView modelAndView) {
		List<Transfer> transfers = adminService.findTransferAll();
		List<Tour> TransferTours = adminService.findTourAll();
		modelAndView.addObject("TransferTours", TransferTours);
		modelAndView.addObject("transfers", transfers);
		modelAndView.addObject("modelAndView","transfers");
		modelAndView.setViewName("/adminView/admin/transfer");
		return modelAndView;
	}

	/**
	 * 进入管理员主页
	 * @param modelAndView
	 * @param session
	 * @return admin/list.jsp
	 */
	@RequestMapping("")
	public ModelAndView admin(ModelAndView modelAndView, HttpSession session) {
		return goAdminList(modelAndView);
	}

	/**
	 * 进入添加管理员主页
	 * @param modelAndView
	 * @return admin/insert.jsp
	 */
	@RequestMapping("/adminInsert")
	public ModelAndView adminInsert(ModelAndView modelAndView) {

		modelAndView.addObject("admin", "insert");
		modelAndView.setViewName("/adminView/admin/insert");
		return modelAndView;
	}

	/**
	 * 添加管理员
	 * @param user 用户
	 * @param account 账户
	 * @param modelAndView
	 * @return admin/list.jsp
	 * @throws SysException 
	 */
	@RequestMapping(path = "/adminInsert", method = RequestMethod.POST)
	public ModelAndView adminInsertUserAndAccount(User user, Account account, ModelAndView modelAndView) throws SysException {
		try {
			user.setUserPasswordKeyString(RandomStringUtil.getRandomString(10));
			user.setUserPasswordEncryptionString(DigestUtils.md5Hex(user.getUserPasswordKeyString() + user.getUserPasswordEncryptionString()));
			adminService.insertAdminUserAndAccount(user, account);
			return  goAdminList(modelAndView);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SysException(e.toString());
		}
	}

	/**
	 * 更新管理员
	 * @param updateId
	 * @param updateName
	 * @param account
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/adminUpdate")
	public ModelAndView adminUpdate(@RequestParam("updateId") Integer updateId,
			@RequestParam("updateName") String updateName, Account account, ModelAndView modelAndView) {
		User user = adminService.findUserById(updateId);
		user.setUserNameString(updateName);
		account.setAccountUserIdInteger(updateId);
		adminService.updateAdminUserAndAccount(user, account);
		return  goAdminList(modelAndView);
	}

	/**
	 * 删除管理员
	 * @param userIdInteger
	 * @param accountIdInteger
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/adminDelete/{userId}/{accountId}")
	public ModelAndView adminDelete(@PathVariable("userId") Integer userIdInteger,
			@PathVariable("accountId") Integer accountIdInteger, ModelAndView modelAndView) {
		adminService.deleteAdminUserAndAccount(userIdInteger, accountIdInteger);
		return  goAdminList(modelAndView);
	}

	/**
	 * 更改管理员身份
	 * @param userIdInteger
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/isAdmin/{userId}")
	public ModelAndView isAdmin(@PathVariable("userId") Integer userIdInteger, ModelAndView modelAndView) {

		User user = adminService.findUserById(userIdInteger);
		if ("T".equals(user.getUserAdminString())) {
			user.setUserAdminString("F");
		} else {
			user.setUserAdminString("T");
		}
		adminService.updateAdminUser(user);
		return  goAdminList(modelAndView);
	}

	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/exitLogin")
	public String exitLogin(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/login";
	}

	/**
	 * 个人信息表
	 * @param session
	 * @return
	 * @throws SysException
	 */
	@RequestMapping("/myInformation")
	public @ResponseBody User myInformation(HttpSession session) throws SysException {
		User user = null;
		try {
			Integer myInformationIdInteger = (Integer) session.getAttribute("loginId");
			user = adminService.findUserById(myInformationIdInteger);
			List<Account> accounts = adminService.findAccountAllByUserId(myInformationIdInteger);
			user.setAccounts(accounts);
		} catch (Exception e) {
			// TODO: handle exception
			throw new SysException("myInformationId");
		}
		return user;
	}

	/**
	 * 进入管理旅游公司主页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/tour")
	public ModelAndView tour(ModelAndView modelAndView) {
		return goTour(modelAndView);
	}
	@RequestMapping("/attraction")
	public ModelAndView attraction(ModelAndView modelAndView) {
		return goAttraction(modelAndView);
	}
	@RequestMapping("/catering")
	public ModelAndView catering(ModelAndView modelAndView) {
		return goCatering(modelAndView);
	}
	@RequestMapping("/hotel")
	public ModelAndView hotel(ModelAndView modelAndView) {
		return goHotel(modelAndView);
	}
	@RequestMapping("/transfer")
	public ModelAndView transfer(ModelAndView modelAndView) {
		return goTransfer(modelAndView);
	}
	/**
	 * 对旅游公司的添加和更新操作
	 * @param tour
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/tour/update")
	public ModelAndView updateTour(Tour tour, ModelAndView modelAndView) {
		if (tour.getTourIdInteger() == null) {
			adminService.insertTour(tour);
		} else {
			adminService.updateTour(tour);
		}
		return goTour(modelAndView);
	}
	@RequestMapping("/attraction/update")
	public ModelAndView updateAttraction(MultipartFile attractionImg,Attraction attraction,HttpSession session,ModelAndView modelAndView) throws SysException {
		updateAttractionAndCateringAndHotelAndTransfer(attractionImg,attraction,session);
		return goAttraction(modelAndView);
	}
	@RequestMapping("/attractionProject/update")
	public ModelAndView updateAttractionProject(MultipartFile attractionProjectImg,AttractionProject attractionProject,HttpSession session,ModelAndView modelAndView) throws SysException {
		updateAttractionAndCateringAndHotelAndTransfer(attractionProjectImg,attractionProject,session);
		return goAttraction(modelAndView);
	}
	@RequestMapping("/catering/update")
	public ModelAndView updateCatering(MultipartFile cateringImg,Catering catering,HttpSession session,ModelAndView modelAndView) throws SysException{
		updateAttractionAndCateringAndHotelAndTransfer(cateringImg,catering,session);
		return goCatering(modelAndView);
	}
	@RequestMapping("/hotel/update")
	public ModelAndView updateHotel(MultipartFile hotelImg,Hotel hotel,HttpSession session,ModelAndView modelAndView) throws SysException{
		updateAttractionAndCateringAndHotelAndTransfer(hotelImg,hotel,session);
		return goHotel(modelAndView);
	}
	@RequestMapping("/transfer/update")
	public ModelAndView updateTransfer(MultipartFile transferImg,Transfer transfer,HttpSession session,ModelAndView modelAndView) throws SysException{
		System.out.println(transfer);
		updateAttractionAndCateringAndHotelAndTransfer(transferImg,transfer,session);
		return goTransfer(modelAndView);
	}
	/**
	 * 删除旅游公司
	 * @param tourIdInteger
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/tour/{tourIdInteger}")
	public ModelAndView deleteTour(@PathVariable("tourIdInteger") Integer tourIdInteger, ModelAndView modelAndView) {
		adminService.deleteTour(tourIdInteger);
		return goTour(modelAndView);
	}
	@RequestMapping("/attraction/{attractionIdInteger}")
	public ModelAndView deleteAttraction(@PathVariable("attractionIdInteger") Integer attractionIdInteger, ModelAndView modelAndView) {
		adminService.deleteAttractionById(attractionIdInteger);
		return goAttraction(modelAndView);
	}
	@RequestMapping("/attractionProject/{attractionProjectIdInteger}")
	public ModelAndView deleteattractionProject(@PathVariable("attractionProjectIdInteger") Integer attractionProjectIdInteger, ModelAndView modelAndView) {
		adminService.deleteAttractionProjectById(attractionProjectIdInteger);
		return goAttraction(modelAndView);
	}
	@RequestMapping("/catering/{cateringIdInteger}")
	public ModelAndView deleteCatering(@PathVariable("cateringIdInteger") Integer cateringIdInteger, ModelAndView modelAndView) {
		adminService.deleteCateringById(cateringIdInteger);
		return goCatering(modelAndView);
	}
	@RequestMapping("/hotel/{hotelIdInteger}")
	public ModelAndView deleteHotel(@PathVariable("hotelIdInteger") Integer hotelIdInteger, ModelAndView modelAndView) {
		adminService.deleteHotelById(hotelIdInteger);
		return goHotel(modelAndView);
	}
	@RequestMapping("/transfer/{transferIdInteger}")
	public ModelAndView deleteTransfer(@PathVariable("transferIdInteger") Integer transferIdInteger, ModelAndView modelAndView) {
		adminService.deleteTransferById(transferIdInteger);
		return goTransfer(modelAndView);
	}
	
	private void updateAttractionAndCateringAndHotelAndTransfer(MultipartFile img,Object object,HttpSession session) throws SysException {
		String objectName="";
		String pathname="";
		String objectNameString="";
		try {
			if(object instanceof Attraction) {
				Attraction attraction=(Attraction)object;
				objectName="attraction";
				objectNameString=attraction.getAttractionNameString();
					if(attraction.getAttractionIdInteger()==null) {
						//添加
							adminService.insertAttraction(attraction);
					}else {
						//修改
							adminService.updateAttraction(attraction);	
							pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+adminService.findAttractionById(attraction.getAttractionIdInteger()).getAttractionNameString()+".png");
							File file=new File(pathname);
							if(file.exists()) {
								//2.1 文件存在则删除
								file.delete();
							}
					}
				
			}else if(object instanceof AttractionProject){
				AttractionProject attractionProject=(AttractionProject)object;
				objectName="attractionProject";
				objectNameString=attractionProject.getAttractionItemString();
				if(attractionProject.getAttractionProjectIdInteger()==null) {
					//添加
						adminService.insertAttractionProject(attractionProject);
				}else {
					//修改
						adminService.updateAttractionProject(attractionProject);
						
						pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+adminService.findAttractionProjectById(attractionProject.getAttractionProjectIdInteger()).getAttractionItemString()+".png");
						File file=new File(pathname);
						if(file.exists()) {
							//2.1 文件存在则删除
							file.delete();
						}
						
				}
			}else if(object instanceof Catering){
				Catering catering=(Catering)object;
				objectName="catering";
				objectNameString=catering.getCateringNameString();
				if(catering.getCateringIdInteger()==null) {
					//添加
						adminService.insertCatering(catering);
				}else {
					//修改
						adminService.updateCatering(catering);
						
						pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+adminService.findCateringById(catering.getCateringIdInteger()).getCateringNameString()+".png");
						File file=new File(pathname);
						if(file.exists()) {
							//2.1 文件存在则删除
							file.delete();
						}
						
				}
			}else if(object instanceof Hotel){
				Hotel hotel=(Hotel)object;
				objectName="hotel";
				objectNameString=hotel.getHotelNameString();
				if(hotel.getHotelIdInteger()==null) {
					//添加
						adminService.insertHotel(hotel);
						
				}else {
					//修改
						adminService.updateHotel(hotel);
						
						pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+adminService.findHotelById(hotel.getHotelIdInteger()).getHotelNameString()+".png");
						File file=new File(pathname);
						if(file.exists()) {
							//2.1 文件存在则删除
							file.delete();
						}
				}
			}else {
				Transfer transfer=(Transfer)object;
				objectName="transfer";
				objectNameString=transfer.getTransferNameString();
				if(transfer.getTransferIdInteger()==null) {
					//添加
						adminService.insertTransfer(transfer);
				}else {
					//修改
						adminService.updateTransfer(transfer);	
						
						pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+adminService.findTransferById(transfer.getTransferIdInteger()).getTransferNameString()+".png");
						File file=new File(pathname);
						if(file.exists()) {
							//2.1 文件存在则删除
							file.delete();
						}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new SysException(e.toString());
		}
		System.out.println(pathname);
		String 	nameString =img.getOriginalFilename();
		
		if(RandomStringUtil.getRandomString(nameString).contains(".jpg")||RandomStringUtil.getRandomString(nameString).contains(".png")) {
			try {
				
				pathname=session.getServletContext().getRealPath("/img/"+objectName+"/"+objectNameString+".png");
				img.transferTo(new File(pathname));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new SysException(e.toString());
			} 
		}
		
	}
}
