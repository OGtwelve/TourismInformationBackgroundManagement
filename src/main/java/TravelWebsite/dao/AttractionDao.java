/**
 * 
 */
package TravelWebsite.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import TravelWebsite.domain.Attraction;


/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *		attraction_id int primary key auto_increment,	-- 景点id
		attraction_name varchar(30),			-- 景点名
		attraction_position varchar(600),		-- 景点位置
		attraction_information varchar(500),		-- 景点信息
		opening_time_up time,			-- 开放时间开
		opening_time_off time,			-- 开发时间关
		attraction_project decimal(9.1),			-- 景点价格
		tour_id int ,
		foreign key(tour_id) references tour(tour_id)
		---------------------------------------------------------
		private Integer attractionIdInteger;
		private String attractionNameString;
		private String attractionPositionString;
		private String attractionInformationString;
		private String openingTimeUpDate;
		private Double attractionProjectDouble;
		private Integer tourIdInteger;
		
		private List<AttractionProject> attractionProjects;
		private Tour tour;
	
 */
public interface AttractionDao {
	
	/**
	 * 查询所有景点
	 * @return List<Attraction>
	 */
	@Results(id = "findAttractionAllMap",value = {
            @Result(id = true,column = "attraction_id",property = "attractionIdInteger"),
            @Result(column = "attraction_name",property = "attractionNameString"),
            @Result(column = "attraction_position",property = "attractionPositionString"),
            @Result(column = "attraction_information",property = "attractionInformationString"),
            @Result(column = "opening_time_up",property = "openingTimeUpDate"),
            @Result(column = "opening_time_off",property = "openingTimeOffDate"),
            @Result(column = "attraction_project",property = "attractionProjectDouble"),
            @Result(column = "tour_id",property = "tourIdInteger"),
            @Result(property = "tour",column = "tour_id",one = @One(select = "TravelWebsite.dao.TourDao.findTourId",fetchType = FetchType.EAGER)),
            @Result(property = "attractionProjects",column = "attraction_id",many = @Many(select = "TravelWebsite.dao.AttractionProjectDao.findAttractionProjectAllByAttractionId",fetchType = FetchType.LAZY))
    })
	@Select("select * from attraction")
	public List<Attraction> findAttractionAll();
	
	/**
	 * 通过景点id查询景点
	 * @param attractionIdInteger 景点id
	 * @return Attraction
	 */
	@Results(id = "AttractionMap",value = {
            @Result(id = true,column = "attraction_id",property = "attractionIdInteger"),
            @Result(column = "attraction_name",property = "attractionNameString"),
            @Result(column = "attraction_position",property = "attractionPositionString"),
            @Result(column = "attraction_information",property = "attractionInformationString"),
            @Result(column = "opening_time_up",property = "openingTimeUpDate"),
            @Result(column = "opening_time_off",property = "openingTimeOffDate"),
            @Result(column = "attraction_project",property = "attractionProjectDouble"),
            @Result(column = "tour_id",property = "tourIdInteger")
    })
	@Select("select * from attraction where attraction_id=#{INTEGER}")
	public Attraction findAttractionById(Integer attractionIdInteger);
	
	/**
	 * 通过公司id查询所有景点
	 * @param tourIdInteger 公司id
	 * @return List<Attraction>
	 */
	@ResultMap(value = "AttractionMap")
	@Select("select * from attraction where tour_id=#{INTEGER}")
	public List<Attraction> findAttractionByTourId(Integer tourIdInteger);
	
	/**
	 * 添加景点
	 * @param attraction
	 */
	@Insert("insert into attraction values(null,#{attractionNameString},#{attractionPositionString},#{attractionInformationString},#{openingTimeUpDate},#{openingTimeOffDate},#{attractionProjectDouble},#{tourIdInteger})")
	public void insertAttraction(Attraction attraction);
	
	/**
	 * 更新景点
	 * @param attraction
	 */
	@Update("update attraction set attraction_name=#{attractionNameString},attraction_position=#{attractionPositionString},attraction_information=#{attractionInformationString},opening_time_up=#{openingTimeUpDate},opening_time_off=#{openingTimeOffDate},attraction_project=#{attractionProjectDouble},tour_id=#{tourIdInteger} where attraction_id=#{attractionIdInteger}")
	public void updateAttraction(Attraction attraction);
	
	/**
	 * 通过景点id删除景点
	 * @param attractionIdInteger 景点id
	 */
	@Delete("delete from attraction where attraction_id=#{INTEGER}")
	public void deleteAttractionById(Integer attractionIdInteger);
}
