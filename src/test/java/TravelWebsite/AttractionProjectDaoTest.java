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
 * @author 3187102230 �����
 * ����������
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
		attractionProject.setAttractionItemString("�չ���");
		attractionProject.setAttractionProjectPriceDouble(0d);
		attractionProject.setAttractionPorjectInformationString("�չ����չ����ǹ��������ͷ���㣬�����չ��Һ���԰�����֡�����һֱ��40���׵ľ�ʯ�����������Ϊ���ŵ�������zhenchenggong��������ද�˵Ĵ�˵��������ʯ���ڣ�������ɣ������İ����������֣��������ǣ��������ȴ��������顣ӵ�С�һƬ�ߡ������ؽ����ߡ������ű����������ͷɽկ������ˮ��̨���������׸�̨����ʤ���������ݣ��������¾䣬һ����ɽС����԰ͨ���³��������������ִ�������Ŀ ������԰��������ӰԺ������Ӣ��԰���ȣ�����1999���Ϊȫ���׼�ͨ��ISO14001��׼�Ĺ��Ҽ��羰��ʤ����");
		attractionProject.setAttractionIdInteger(5);
		attractionProjectDao.insertAttractionProject(attractionProject);
	}
	@Test
	public void updateAttractionProject() {
		AttractionProject attractionProject=new AttractionProject();
		attractionProject.setAttractionItemString("�չ���");
		attractionProject.setAttractionProjectPriceDouble(0d);
		attractionProject.setAttractionPorjectInformationString("�չ����չ����ǹ��������ͷ���㣬�����չ��Һ���԰�����֡�����һֱ��40���׵ľ�ʯ�����������Ϊ���ŵ�������zhenchenggong��������ද�˵Ĵ�˵��������ʯ���ڣ�������ɣ������İ����������֣��������ǣ��������ȴ��������顣ӵ�С�һƬ�ߡ������ؽ����ߡ������ű����������ͷɽկ������ˮ��̨���������׸�̨����ʤ���������ݣ��������¾䣬һ����ɽС����԰ͨ���³��������������ִ�������Ŀ ������԰��������ӰԺ������Ӣ��԰���ȣ�����1999���Ϊȫ���׼�ͨ��ISO14001��׼�Ĺ��Ҽ��羰��ʤ����");
		attractionProject.setAttractionIdInteger(1);
		attractionProjectDao.updateAttractionProject(attractionProject);
	}
	@Test
	public void delete() {
		attractionProjectDao.deleteAttractionProjectById(1);
	}
}
