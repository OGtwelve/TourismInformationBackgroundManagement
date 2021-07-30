/**
 * 
 */
package TravelWebsite;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import TravelWebsite.dao.HotelDao;
import TravelWebsite.domain.Hotel;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class HotelDaoTest {
	@Resource(name = "hotelDao")
	public HotelDao hotelDao;

	@Test
	public void findHotelAll() {
		List<Hotel> hotels = hotelDao.findHotelAll();
		for (Hotel hotel : hotels) {
			System.out.println(hotel.getTour());
			System.out.println(hotel);
			System.out.println("-------------------------------");
		}
	}
	@Test
	public void findHotelById() {
		System.out.println(hotelDao.findHotelById(1));
	}
	@Test
	public void insertHotel() {
		Hotel hotel=new Hotel();
		hotel.setHotelNameString("酒店");
		hotel.setHotelInformationString("泰国马沙文咖喱");
		hotel.setHotelPriceDouble(38.0);
		hotel.setTourIdInteger(1);
		hotelDao.insertHotel(hotel);
	}
	@Test
	public void updateAttraction() {
		Hotel hotel=new Hotel();
		hotel.setHotelIdInteger(1);
		hotel.setHotelNameString("泰国马沙文咖喱");
		hotel.setHotelInformationString("泰国马沙文咖喱2");
		hotel.setHotelPriceDouble(38.0);
		hotel.setTourIdInteger(1);
		hotelDao.updateHotel(hotel);
	}
	@Test
	public void delete() {
		hotelDao.deleteHotelById(9);
	}
}
