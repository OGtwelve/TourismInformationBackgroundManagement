/**
 * 
 */
package TravelWebsite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import TravelWebsite.dao.AccountDao;
import TravelWebsite.dao.AttractionDao;
import TravelWebsite.dao.AttractionProjectDao;
import TravelWebsite.dao.CateringDao;
import TravelWebsite.dao.HotelDao;
import TravelWebsite.dao.TourDao;
import TravelWebsite.dao.TransferDao;
import TravelWebsite.dao.UserDao;
import TravelWebsite.domain.Account;
import TravelWebsite.domain.Attraction;
import TravelWebsite.domain.AttractionProject;
import TravelWebsite.domain.Catering;
import TravelWebsite.domain.Hotel;
import TravelWebsite.domain.Tour;
import TravelWebsite.domain.Transfer;
import TravelWebsite.domain.User;
import TravelWebsite.service.AdminService;

/**
 * @author 3187102230 Õıº—±¶
 * ≥©”Œ¬√”ŒÕ¯
 *
 */
@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AdminServiceImpl implements AdminService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private TourDao tourDao;
	@Autowired
	private AttractionDao attractionDao;
	@Autowired
	private AttractionProjectDao attractionProjectDao;
	@Autowired
	private CateringDao cateringDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private TransferDao transferDao;
	
	public List<User> findUserAll() {
		// TODO Auto-generated method stub
		return userDao.findUserAll();
	}

	public List<Tour> findTourAll() {
		// TODO Auto-generated method stub
		return tourDao.findTourAll();
	}

	public User findUserById(Integer userIdInteger) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userIdInteger);
	}
	public List<Account> findAccountAllByUserId(Integer userIdInteger) {
		// TODO Auto-generated method stub
		return accountDao.findAccountAllByUserId(userIdInteger);
	}

	public List<Attraction> findAttractionAll() {
		// TODO Auto-generated method stub
		return attractionDao.findAttractionAll();
	}

	public Attraction findAttractionById(Integer attractionIdInteger) {
		// TODO Auto-generated method stub
		return attractionDao.findAttractionById(attractionIdInteger);
	}

	public AttractionProject findAttractionProjectById(Integer attractionProjectIdInteger) {
		// TODO Auto-generated method stub
		return attractionProjectDao.findAttractionProjectById(attractionProjectIdInteger);
	}

	public List<Catering> findCateringAll() {
		// TODO Auto-generated method stub
		return cateringDao.findCateringAll();
	}

	public List<Hotel> findHotelAll() {
		// TODO Auto-generated method stub
		return hotelDao.findHotelAll();
	}

	public List<Transfer> findTransferAll() {
		// TODO Auto-generated method stub
		return transferDao.findTransferAll();
	}

	public Catering findCateringById(Integer cateringIdInteger) {
		// TODO Auto-generated method stub
		return cateringDao.findCateringById(cateringIdInteger);
	}

	public Hotel findHotelById(Integer hotelIdInteger) {
		// TODO Auto-generated method stub
		return hotelDao.findHotelById(hotelIdInteger);
	}

	public Transfer findTransferById(Integer transferIdInteger) {
		// TODO Auto-generated method stub
		return transferDao.findTransferById(transferIdInteger);
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertTour(Tour tour) {
		// TODO Auto-generated method stub
		tourDao.insertTour(tour);
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertAdminUserAndAccount(User user, Account account) {
		// TODO Auto-generated method stub
	    userDao.insertUser(user);
	    account.setAccountUserIdInteger(user.getUserIdInteger());
	    accountDao.insertAccount(account);
	    
	}
	
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertAttraction(Attraction attraction) {
		// TODO Auto-generated method stub
		attractionDao.insertAttraction(attraction);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertAttractionProject(AttractionProject attractionProject) {
		// TODO Auto-generated method stub
		attractionProjectDao.insertAttractionProject(attractionProject);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertCatering(Catering catering) {
		// TODO Auto-generated method stub
		cateringDao.insertCatering(catering);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelDao.insertHotel(hotel);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void insertTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		transferDao.insertTransfer(transfer);
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateAdminUserAndAccount(User user,Account account) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
		accountDao.updateAccount(account);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateAdminUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateTour(Tour tour) {
		// TODO Auto-generated method stub
		tourDao.updateTour(tour);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateAttraction(Attraction attraction) {
		// TODO Auto-generated method stub
		attractionDao.updateAttraction(attraction);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateAttractionProject(AttractionProject attractionProject) {
		// TODO Auto-generated method stub
		attractionProjectDao.updateAttractionProject(attractionProject);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateCatering(Catering catering) {
		// TODO Auto-generated method stub
		cateringDao.updateCatering(catering);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		hotelDao.updateHotel(hotel);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void updateTransfer(Transfer transfer) {
		// TODO Auto-generated method stub
		transferDao.updateTransfer(transfer);
	}

	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteAdminUserAndAccount(Integer userIdInteger, Integer accountIdInteger) {
		// TODO Auto-generated method stub
		accountDao.deleteAccountById(accountIdInteger);
		userDao.deleteUserById(userIdInteger);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteTour(Integer tourIdInteger) {
		// TODO Auto-generated method stub
		tourDao.deleteTour(tourIdInteger);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteAttractionById(Integer attractionIdInteger) {
		// TODO Auto-generated method stub
		attractionDao.deleteAttractionById(attractionIdInteger);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteAttractionProjectById(Integer attractionProjectIdInteger) {
		// TODO Auto-generated method stub
		attractionProjectDao.deleteAttractionProjectById(attractionProjectIdInteger);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteCateringById(Integer cateringIdInteger) {
		// TODO Auto-generated method stub
		cateringDao.deleteCateringById(cateringIdInteger);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteHotelById(Integer hotelIdInteger) {
		// TODO Auto-generated method stub
		hotelDao.deleteHotelById(hotelIdInteger);
	}
	@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
	public void deleteTransferById(Integer transferIdInteger) {
		// TODO Auto-generated method stub
		transferDao.deleteTransferById(transferIdInteger);
	}
	
	
	
	

}
