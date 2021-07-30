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
 * @author 3187102230 李佳庆
 * 畅游旅游网
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
		attraction.setAttractionNameString("厦门鼓浪屿");
		attraction.setAttractionPositionString("https://map.baidu.com/search/%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF/@13143579.911657145,2790595.54299,16.65z?querytype=s&da_src=shareurl&wd=%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF&c=300&src=0&pn=0&sug=0&l=13&b=(13238916,2977463;13300356,3007447)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1");
		attraction.setAttractionInformationString("鼓浪屿是个宁静美丽的小岛，这里有着各种风格迥异、中西合壁的建筑，汇集了各种特色的食铺和商铺，充满了文艺范儿。2017年7月8日，在波兰克拉科夫举行的第41届世界遗产大会上，鼓浪屿申遗成功，成为中国第52项世界遗产。第一次上岛的游客，建议购买鼓浪屿联票，可以把岛上主要景点一次玩个遍。你可以顺着套票上的景点一个个往下走，套票包括的景点有：可以俯视全岛的日光岩、堪称江南古典园林精品的菽庄花园（含钢琴博物馆）、明代风格建筑的皓月园（内有郑成功石像）、风琴博物馆和国际刻字艺术馆等。除外，鼓浪屿上还有闽南建筑风格的海天堂构及中完合壁的八卦楼，以及19世纪欧陆风格的原西方国家领事馆，正因为其多种建筑风格，所以鼓浪屿又有万国建筑博览之称。玩鼓浪屿，可以住厦门，坐船过来一日游，5小时左右就可以玩遍全岛了。但是要真正体会鼓浪屿的精髓，建议至少在岛上住上一晚，不那么匆促。你可以享受一下傍晚的鼓浪屿，没有那么多的游客，你的心情可以很平静，你还可以在日落的时候漫步在鼓浪屿的沙滩上，就这样安安静静的走一走。");
		attraction.setOpeningTimeUpDate("2020-01-01");
		attraction.setOpeningTimeOffDate("2020-12-31");
		attraction.setTourIdInteger(2);
		attractionDao.insertAttraction(attraction);
	}
	@Test
	public void updateAttraction() {
		Attraction attraction=new Attraction();
		attraction.setAttractionIdInteger(5);
		attraction.setAttractionNameString("厦门鼓浪屿12");
		attraction.setAttractionPositionString("https://map.baidu.com/search/%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF/@13143579.911657145,2790595.54299,16.65z?querytype=s&da_src=shareurl&wd=%E5%8E%A6%E9%97%A8%E9%BC%93%E6%B5%AA%E5%B1%BF&c=300&src=0&pn=0&sug=0&l=13&b=(13238916,2977463;13300356,3007447)&from=webmap&biz_forward=%7B%22scaler%22:1,%22styles%22:%22pl%22%7D&device_ratio=1");
		attraction.setAttractionInformationString("鼓浪屿是个宁静美丽的小岛，这里有着各种风格迥异、中西合壁的建筑，汇集了各种特色的食铺和商铺，充满了文艺范儿。2017年7月8日，在波兰克拉科夫举行的第41届世界遗产大会上，鼓浪屿申遗成功，成为中国第52项世界遗产。第一次上岛的游客，建议购买鼓浪屿联票，可以把岛上主要景点一次玩个遍。你可以顺着套票上的景点一个个往下走，套票包括的景点有：可以俯视全岛的日光岩、堪称江南古典园林精品的菽庄花园（含钢琴博物馆）、明代风格建筑的皓月园（内有郑成功石像）、风琴博物馆和国际刻字艺术馆等。除外，鼓浪屿上还有闽南建筑风格的海天堂构及中完合壁的八卦楼，以及19世纪欧陆风格的原西方国家领事馆，正因为其多种建筑风格，所以鼓浪屿又有万国建筑博览之称。玩鼓浪屿，可以住厦门，坐船过来一日游，5小时左右就可以玩遍全岛了。但是要真正体会鼓浪屿的精髓，建议至少在岛上住上一晚，不那么匆促。你可以享受一下傍晚的鼓浪屿，没有那么多的游客，你的心情可以很平静，你还可以在日落的时候漫步在鼓浪屿的沙滩上，就这样安安静静的走一走。");
		attraction.setOpeningTimeUpDate("08:00:00");
		attraction.setOpeningTimeOffDate("17:00:00");
		attractionDao.updateAttraction(attraction);
	}
	@Test
	public void delete() {
		attractionDao.deleteAttractionById(1);
	}
}
