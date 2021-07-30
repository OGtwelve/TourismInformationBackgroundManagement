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

import TravelWebsite.dao.TourDao;
import TravelWebsite.domain.Tour;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class TourDaoTest {
	@Resource(name = "tourDao")
	public TourDao tourDao;

	@Test
	public void findTourDaoAll() {
		List<Tour> tours = tourDao.findTourAll();
		for (Tour tour : tours) {
			System.out.println(tour);
			System.out.println(tour.getAttractions());
			System.out.println(tour.getCaterings());
			System.out.println(tour.getHotels());
			System.out.println(tour.getTransfers());
			System.out.println("-------------------------");
		}
	}
	@Test
	public void findTourDaoById() {
		System.out.println(tourDao.findTourId(1));
	}
	@Test
	public void insertTourDao() {

		Tour tour=new Tour();
		tour.setTourNameString("湖南中铁国际旅行社");
		tour.setTourPriceDouble(488d);
		tour.setTourPhoneString("89715147");
		tourDao.insertTour(tour);
	}
	@Test
	public void updateTourDao() {
		Tour tour=new Tour();
		tour.setTourIdInteger(1);
		tour.setTourNameString("新疆中国旅行社有限公司");
		tour.setTourPriceDouble(699d);
		tour.setTourPhoneString("13565990098");
		tourDao.updateTour(tour);
	}
	@Test
	public void delete() {
		tourDao.deleteTour(1);
	}
}
