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
 * @author 3187102230 ���ѱ�
 * ����������
 *		attraction_id int primary key auto_increment,	-- ����id
		attraction_name varchar(30),			-- ������
		attraction_position varchar(600),		-- ����λ��
		attraction_information varchar(500),		-- ������Ϣ
		opening_time_up time,			-- ����ʱ�俪
		opening_time_off time,			-- ����ʱ���
		attraction_project decimal(9.1),			-- ����۸�
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
	 * ��ѯ���о���
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
	 * ͨ������id��ѯ����
	 * @param attractionIdInteger ����id
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
	 * ͨ����˾id��ѯ���о���
	 * @param tourIdInteger ��˾id
	 * @return List<Attraction>
	 */
	@ResultMap(value = "AttractionMap")
	@Select("select * from attraction where tour_id=#{INTEGER}")
	public List<Attraction> findAttractionByTourId(Integer tourIdInteger);
	
	/**
	 * ��Ӿ���
	 * @param attraction
	 */
	@Insert("insert into attraction values(null,#{attractionNameString},#{attractionPositionString},#{attractionInformationString},#{openingTimeUpDate},#{openingTimeOffDate},#{attractionProjectDouble},#{tourIdInteger})")
	public void insertAttraction(Attraction attraction);
	
	/**
	 * ���¾���
	 * @param attraction
	 */
	@Update("update attraction set attraction_name=#{attractionNameString},attraction_position=#{attractionPositionString},attraction_information=#{attractionInformationString},opening_time_up=#{openingTimeUpDate},opening_time_off=#{openingTimeOffDate},attraction_project=#{attractionProjectDouble},tour_id=#{tourIdInteger} where attraction_id=#{attractionIdInteger}")
	public void updateAttraction(Attraction attraction);
	
	/**
	 * ͨ������idɾ������
	 * @param attractionIdInteger ����id
	 */
	@Delete("delete from attraction where attraction_id=#{INTEGER}")
	public void deleteAttractionById(Integer attractionIdInteger);
}
