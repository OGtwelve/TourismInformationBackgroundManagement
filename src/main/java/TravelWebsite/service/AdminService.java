/**
 * 
 */
package TravelWebsite.service;

import java.util.List;

import TravelWebsite.domain.Account;
import TravelWebsite.domain.Attraction;
import TravelWebsite.domain.AttractionProject;
import TravelWebsite.domain.Catering;
import TravelWebsite.domain.Hotel;
import TravelWebsite.domain.Tour;
import TravelWebsite.domain.Transfer;
import TravelWebsite.domain.User;

/**
 * @author 3187102230 Õıº—±¶
 * ≥©”Œ¬√”ŒÕ¯
 *
 */
public interface AdminService {
	public List<User> findUserAll();
	public List<Tour> findTourAll();
	public User findUserById(Integer userIdInteger);
	public List<Account> findAccountAllByUserId(Integer userIdInteger);
	public List<Attraction> findAttractionAll();
	public Attraction findAttractionById(Integer attractionIdInteger);
	public AttractionProject findAttractionProjectById(Integer attractionProjectIdInteger);
	public Catering findCateringById(Integer cateringIdInteger);
	public Hotel findHotelById(Integer hotelIdInteger);
	public Transfer findTransferById(Integer transferIdInteger);
	public List<Catering> findCateringAll();
	public List<Hotel> findHotelAll();
	public List<Transfer> findTransferAll();
	
	public void insertTour(Tour tour);
	public void insertAdminUserAndAccount(User user,Account account);
	public void insertAttraction(Attraction attraction);
	public void insertAttractionProject(AttractionProject attractionProject);
	public void insertCatering(Catering catering);
	public void insertHotel(Hotel hotel);
	public void insertTransfer(Transfer transfer);
	
	public void updateAdminUser(User user);
	public void updateAdminUserAndAccount(User user,Account account);
	public void updateTour(Tour tour);
	public void updateAttraction(Attraction attraction);
	public void updateAttractionProject(AttractionProject attractionProject);
	public void updateCatering(Catering catering);
	public void updateHotel(Hotel hotel);
	public void updateTransfer(Transfer transfer);
	
	public void deleteAdminUserAndAccount(Integer userIdInteger,Integer accountIdInteger);
	public void deleteTour(Integer tourIdInteger);
	public void deleteAttractionById(Integer attractionIdInteger);
	public void deleteAttractionProjectById(Integer attractionProjectIdInteger);
	public void deleteCateringById(Integer cateringIdInteger);
	public void deleteHotelById(Integer hotelIdInteger);
	public void deleteTransferById(Integer transferIdInteger);
}
