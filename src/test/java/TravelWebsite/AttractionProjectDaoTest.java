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

import TravelWebsite.dao.AttractionProjectDao;
import TravelWebsite.domain.AttractionProject;
import config.ApplicationContext;

/**
 * @author 3187102230 李佳庆
 * 畅游旅游网
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContext.class)
public class AttractionProjectDaoTest {
	@Resource(name = "attractionProjectDao")
	public AttractionProjectDao attractionProjectDao;

	@Test
	public void findAttractionProjectAll() {
		List<AttractionProject> attractionProjects = attractionProjectDao.findAttractionProjectAll();
		for (AttractionProject attractionProject : attractionProjects) {
			System.out.println(attractionProject);
			System.out.println(attractionProject.getAttraction());
		}
	}
	@Test
	public void findAttractionProjectById() {
		System.out.println(attractionProjectDao.findAttractionProjectById(2));
	}
	@Test
	public void insertAttractionProject() {
		AttractionProject attractionProject=new AttractionProject();
		attractionProject.setAttractionItemString("日光岩");
		attractionProject.setAttractionProjectPriceDouble(0d);
		attractionProject.setAttractionPorjectInformationString("日光岩日光岩是鼓浪屿的龙头景点，包括日光岩和琴园两部分。顶峰一直径40多米的巨石凌空耸立，成为厦门的象征。zhenchenggong曾留下许多动人的传说。景区奇石叠磊，洞壑天成，海浪拍岸，树海叠嶂，繁花如星，富有亚热带浪漫迷情。拥有“一片瓦”、“鹭江龙窟”、“古避暑洞”、“龙头山寨”、“水操台”、“百米高台”等胜景。攀天梯，阅名人章句，一览众山小。琴园通过缆车与其相连，有现代游乐项目 “百鸟园”、“电影院”、“英雄园”等，并于1999年成为全国首家通过ISO14001标准的国家级风景名胜区。");
		attractionProject.setAttractionIdInteger(5);
		attractionProjectDao.insertAttractionProject(attractionProject);
	}
	@Test
	public void updateAttractionProject() {
		AttractionProject attractionProject=new AttractionProject();
		attractionProject.setAttractionItemString("日光岩");
		attractionProject.setAttractionProjectPriceDouble(0d);
		attractionProject.setAttractionPorjectInformationString("日光岩日光岩是鼓浪屿的龙头景点，包括日光岩和琴园两部分。顶峰一直径40多米的巨石凌空耸立，成为厦门的象征。zhenchenggong曾留下许多动人的传说。景区奇石叠磊，洞壑天成，海浪拍岸，树海叠嶂，繁花如星，富有亚热带浪漫迷情。拥有“一片瓦”、“鹭江龙窟”、“古避暑洞”、“龙头山寨”、“水操台”、“百米高台”等胜景。攀天梯，阅名人章句，一览众山小。琴园通过缆车与其相连，有现代游乐项目 “百鸟园”、“电影院”、“英雄园”等，并于1999年成为全国首家通过ISO14001标准的国家级风景名胜区。");
		attractionProject.setAttractionIdInteger(1);
		attractionProjectDao.updateAttractionProject(attractionProject);
	}
	@Test
	public void delete() {
		attractionProjectDao.deleteAttractionProjectById(1);
	}
}
