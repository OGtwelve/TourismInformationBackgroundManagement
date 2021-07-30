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

import TravelWebsite.dao.TransferDao;
import TravelWebsite.domain.Transfer;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class TransferDaoTest {
	@Resource(name = "transferDao")
	public TransferDao transferDao;

	@Test
	public void findTransferAll() {
		List<Transfer> transfers = transferDao.findTransferAll();
		for (Transfer transfer : transfers) {
			System.out.println(transfer.getTour());
			System.out.println(transfer);
			System.out.println("-------------------------------");
		}
	}
	@Test
	public void findTransferById() {
		System.out.println(transferDao.findTransferById(1));
	}
	@Test
	public void insertTransfer() {
		Transfer transfer=new Transfer();
		transfer.setTransferNameString("交通");
		transfer.setTransferInformationString("泰国马沙文咖喱");
		transfer.setTransferPriceDouble(38.0);
		transfer.setTourIdInteger(1);
		transferDao.insertTransfer(transfer);
	}
	@Test
	public void updateAttraction() {
		Transfer transfer=new Transfer();
		transfer.setTransferIdInteger(1);
		transfer.setTransferNameString("泰国马沙文咖喱");
		transfer.setTransferInformationString("泰国马沙文咖喱2");
		transfer.setTransferPriceDouble(38.0);
		transfer.setTourIdInteger(1);
		transferDao.updateTransfer(transfer);
	}
	@Test
	public void delete() {
		transferDao.deleteTransferById(1);
	}
}
