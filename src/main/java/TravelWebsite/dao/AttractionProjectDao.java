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
 * @author 3187102230 王佳宝
 * 畅游旅游网
		attraction_project_id int primary key auto_increment,	-- 项目id
		attraction_items varchar(20),							-- 项目
		attraction_project_information varchar(500),			-- 项目信息
		attraction_project_price decimal(9.1),					-- 项目价格
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
	 * 查询所有游览项目
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
	 * 通过项目id查找游览项目
	 * @param attractionProjectIdInteger 项目id
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
	 * 通过景点id查找所有游览项目
	 * @param attractionIdInteger 景点id
	 * @return List<AttractionProject>
	 */
	@ResultMap(value ="AttractionProjectMap" )
	@Select("select * from attraction_project where attraction_id=#{INTEGER}")
	public List<AttractionProject> findAttractionProjectAllByAttractionId(Integer attractionIdInteger);
	
	/**
	 * 添加游览项目
	 * @param attractionProject 
	 */
	@Insert("insert into attraction_project values(null,#{attractionItemString},#{attractionPorjectInformationString},#{attractionProjectPriceDouble},#{attractionIdInteger})")
	public void insertAttractionProject(AttractionProject attractionProject);
	
	/**
	 * 更新游览项目
	 * @param attractionProject
	 */
	@Update("update attraction_project set attraction_items=#{attractionItemString},attraction_project_information=#{attractionPorjectInformationString},attraction_project_price=#{attractionProjectPriceDouble},attraction_id=#{attractionIdInteger} where attraction_project_id=#{attractionProjectIdInteger}")
	public void updateAttractionProject(AttractionProject attractionProject);
	
	/**
	 * 通过项目id删除游览项目
	 * @param attractionProjectIdInteger 项目id
	 */
	@Delete("delete from attraction_project where attraction_project_id=#{INTEGER}")
	public void deleteAttractionProjectById(Integer attractionProjectIdInteger);
}
