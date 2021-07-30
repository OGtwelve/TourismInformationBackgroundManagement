/**
 * 
 */
package TravelWebsite.dao;

import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;


import TravelWebsite.domain.AttractionProject;

/**
 * @author 3187102230 ���ѱ�
 * ����������
		attraction_project_id int primary key auto_increment,	-- ��Ŀid
		attraction_items varchar(20),							-- ��Ŀ
		attraction_project_information varchar(500),			-- ��Ŀ��Ϣ
		attraction_project_price decimal(9.1),					-- ��Ŀ�۸�
		attraction_id int,
		foreign key(attraction_id) references attraction(attraction_id)
-----------------------------------------------------------------------------------
		private Integer attractionProjectIdInteger;
		private String attractionItemString;
		private String attractionPorjectInformationString;
		private Double attractionProjectPriceDouble;
		private Integer attractionIdInteger;
		
		private Attraction attraction;
 */
public interface AttractionProjectDao {
	/**
	 * ��ѯ����������Ŀ
	 * @return List<AttractionProject>
	 */
	@Results(id = "findAttractionProjectAllMap",value = {
            @Result(id = true,column = "attraction_project_id",property = "attractionProjectIdInteger"),
            @Result(column = "attraction_items",property = "attractionItemString"),
            @Result(column = "attraction_project_information",property = "attractionPorjectInformationString"),
            @Result(column = "attraction_project_price",property = "attractionProjectPriceDouble"),
            @Result(column = "attraction_id",property = "attractionIdInteger"),
            @Result(property = "attraction",column = "attraction_id",one = @One(select = "TravelWebsite.dao.AttractionDao.findAttractionById",fetchType = FetchType.EAGER))
    })
	@Select("select * from attraction_project;")
	public List<AttractionProject> findAttractionProjectAll();
	
	/**
	 * ͨ����Ŀid����������Ŀ
	 * @param attractionProjectIdInteger ��Ŀid
	 * @return AttractionProject
	 */
	@Results(id = "AttractionProjectMap",value = {
            @Result(id = true,column = "attraction_project_id",property = "attractionProjectIdInteger"),
            @Result(column = "attraction_items",property = "attractionItemString"),
            @Result(column = "attraction_project_information",property = "attractionPorjectInformationString"),
            @Result(column = "attraction_project_price",property = "attractionProjectPriceDouble"),
            @Result(column = "attraction_id",property = "attractionIdInteger"),
    })
	@Select("select * from attraction_project where attraction_project_id=#{INTEGER}")
	public AttractionProject findAttractionProjectById(Integer attractionProjectIdInteger);
	
	/**
	 * ͨ������id��������������Ŀ
	 * @param attractionIdInteger ����id
	 * @return List<AttractionProject>
	 */
	@ResultMap(value ="AttractionProjectMap" )
	@Select("select * from attraction_project where attraction_id=#{INTEGER}")
	public List<AttractionProject> findAttractionProjectAllByAttractionId(Integer attractionIdInteger);
	
	/**
	 * ���������Ŀ
	 * @param attractionProject 
	 */
	@Insert("insert into attraction_project values(null,#{attractionItemString},#{attractionPorjectInformationString},#{attractionProjectPriceDouble},#{attractionIdInteger})")
	public void insertAttractionProject(AttractionProject attractionProject);
	
	/**
	 * ����������Ŀ
	 * @param attractionProject
	 */
	@Update("update attraction_project set attraction_items=#{attractionItemString},attraction_project_information=#{attractionPorjectInformationString},attraction_project_price=#{attractionProjectPriceDouble},attraction_id=#{attractionIdInteger} where attraction_project_id=#{attractionProjectIdInteger}")
	public void updateAttractionProject(AttractionProject attractionProject);
	
	/**
	 * ͨ����Ŀidɾ��������Ŀ
	 * @param attractionProjectIdInteger ��Ŀid
	 */
	@Delete("delete from attraction_project where attraction_project_id=#{INTEGER}")
	public void deleteAttractionProjectById(Integer attractionProjectIdInteger);
}
