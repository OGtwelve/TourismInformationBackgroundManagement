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

import TravelWebsite.dao.AttractionDao;
import TravelWebsite.domain.Attraction;
import config.ApplicationContext;

/**
 * @author 3187102230 �����
 * ����������
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class AttractionDaoTest {
	@Resource(name = "attractionDao")
	public AttractionDao attractionDao;

	@Test
	public void findAttractionAll() {
		List<Attraction> attractions = attractionDao.findAttractionAll();
		for (Attraction attraction : attractions) {
			System.out.println(attraction.getTour());
			System.out.println(attraction);
			System.out.println(attraction.getAttractionProjects());
			System.out.println("-------------------------------");
		}
	}
	@Test
	public void findAttractionById() {
		System.out.println(attractionDao.findAttractionById(1));
		System.out.println(attractionDao.findAttractionById(1).getOpeningTimeUpDate());
	}
	@Test
	public void insertAttraction() {
		Attraction attraction=new Attraction();
		attraction.setAttractionNameString("���Ź�����");
		attraction.setAttractionPositionString("https://map.baidu.com/search/%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF/@13143579.911657145,2790595.54299,16.65z?querytype=s&da_src=shareurl&wd=%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF&c=300&src=0&pn=0&sug=0&l=13&b=(13238916,2977463;13300356,3007447)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1");
		attraction.setAttractionInformationString("�������Ǹ�����������С�����������Ÿ��ַ�����졢�����ϱڵĽ������㼯�˸�����ɫ��ʳ�̺����̣����������շ�����2017��7��8�գ��ڲ��������Ʒ���еĵ�41�������Ų�����ϣ����������ųɹ�����Ϊ�й���52�������Ų�����һ���ϵ����οͣ����鹺���������Ʊ�����԰ѵ�����Ҫ����һ������顣�����˳����Ʊ�ϵľ���һ���������ߣ���Ʊ�����ľ����У����Ը���ȫ�����չ��ҡ����ƽ��Ϲŵ�԰�־�Ʒ����ׯ��԰�������ٲ���ݣ�����������������԰������֣�ɹ�ʯ�񣩡����ٲ���ݺ͹��ʿ��������ݵȡ����⣬�������ϻ������Ͻ������ĺ����ù�������ϱڵİ���¥���Լ�19����ŷ½����ԭ�����������¹ݣ�����Ϊ����ֽ���������Թ��������������������֮�ơ�������죬����ס���ţ���������һ���Σ�5Сʱ���ҾͿ������ȫ���ˡ�����Ҫ������������ľ��裬���������ڵ���ס��һ������ô�Ҵ١����������һ�°���Ĺ����죬û����ô����οͣ����������Ժ�ƽ�����㻹�����������ʱ�������ڹ������ɳ̲�ϣ�������������������һ�ߡ�");
		attraction.setOpeningTimeUpDate("2020-01-01");
		attraction.setOpeningTimeOffDate("2020-12-31");
		attraction.setTourIdInteger(2);
		attractionDao.insertAttraction(attraction);
	}
	@Test
	public void updateAttraction() {
		Attraction attraction=new Attraction();
		attraction.setAttractionIdInteger(5);
		attraction.setAttractionNameString("���Ź�����12");
		attraction.setAttractionPositionString("https://map.baidu.com/search/%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF/@13143579.911657145,2790595.54299,16.65z?querytype=s&da_src=shareurl&wd=%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF&c=300&src=0&pn=0&sug=0&l=13&b=(13238916,2977463;13300356,3007447)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1");
		attraction.setAttractionInformationString("�������Ǹ�����������С�����������Ÿ��ַ�����졢�����ϱڵĽ������㼯�˸�����ɫ��ʳ�̺����̣����������շ�����2017��7��8�գ��ڲ��������Ʒ���еĵ�41�������Ų�����ϣ����������ųɹ�����Ϊ�й���52�������Ų�����һ���ϵ����οͣ����鹺���������Ʊ�����԰ѵ�����Ҫ����һ������顣�����˳����Ʊ�ϵľ���һ���������ߣ���Ʊ�����ľ����У����Ը���ȫ�����չ��ҡ����ƽ��Ϲŵ�԰�־�Ʒ����ׯ��԰�������ٲ���ݣ�����������������԰������֣�ɹ�ʯ�񣩡����ٲ���ݺ͹��ʿ��������ݵȡ����⣬�������ϻ������Ͻ������ĺ����ù�������ϱڵİ���¥���Լ�19����ŷ½����ԭ�����������¹ݣ�����Ϊ����ֽ���������Թ��������������������֮�ơ�������죬����ס���ţ���������һ���Σ�5Сʱ���ҾͿ������ȫ���ˡ�����Ҫ������������ľ��裬���������ڵ���ס��һ������ô�Ҵ١����������һ�°���Ĺ����죬û����ô����οͣ����������Ժ�ƽ�����㻹�����������ʱ�������ڹ������ɳ̲�ϣ�������������������һ�ߡ�");
		attraction.setOpeningTimeUpDate("08:00:00");
		attraction.setOpeningTimeOffDate("17:00:00");
		attractionDao.updateAttraction(attraction);
	}
	@Test
	public void delete() {
		attractionDao.deleteAttractionById(1);
	}
}
