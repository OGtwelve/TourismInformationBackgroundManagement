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

import TravelWebsite.dao.CateringDao;
import TravelWebsite.domain.Catering;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class CateringDaoTest {
	@Resource(name = "cateringDao")
	public CateringDao cateringDao;

	@Test
	public void findCateringAll() {
		List<Catering> caterings = cateringDao.findCateringAll();
		for (Catering catering : caterings) {
			System.out.println(catering.getTour());
			System.out.println(catering);
			System.out.println("-------------------------------");
		}
	}
	@Test
	public void findCateringById() {
		System.out.println(cateringDao.findCateringById(1));
	}
	@Test
	public void insertCatering() {
		Catering catering=new Catering();
		catering.setCateringNameString("泰国马沙文咖喱");
		catering.setCateringInformationString("泰国马沙文咖喱");
		catering.setCateringPriceDouble(38.0);
		catering.setTourIdInteger(1);
		cateringDao.insertCatering(catering);
	}
	@Test
	public void updateAttraction() {
		Catering catering=new Catering();
		catering.setCateringIdInteger(1);
		catering.setCateringNameString("泰国马沙文咖喱");
		catering.setCateringInformationString("泰国马沙文咖喱2");
		catering.setCateringPriceDouble(38.0);
		catering.setTourIdInteger(1);
		cateringDao.updateCatering(catering);
	}
	@Test
	public void delete() {
		cateringDao.deleteCateringById(1);
	}
}
