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

import TravelWebsite.domain.Hotel;


/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *		hotel_id int primary key auto_increment,		-- 酒店id
		hotel_name varchar(30),							-- 酒店名
		hotel_information varchar(500),					-- 酒店信息
		hotel_price decimal(9.1),						-- 酒店价格
		tour_id int ,
		-------------------------------------------------------------
		private Integer hotelIdInteger;
		private String hotelNameString;
		private String hotelInformationString;
		private Double hotelPriceDouble;
		private Integer tourIdInteger;
		
		private Tour tour;
 */
public interface HotelDao {
	/**
	 * 查询所有酒店
	 * @return List<Hotel>
	 */
	@Results(id = "findHotelAllMap",value = {
            @Result(id = true,column = "hotel_id",property = "hotelIdInteger"),
            @Result(column = "hotel_name",property = "hotelNameString"),
            @Result(column = "hotel_information",property = "hotelInformationString"),
            @Result(column = "hotel_price",property = "hotelPriceDouble"),
            @Result(column = "tour_id",property = "tourIdInteger"),
            @Result(property = "tour",column = "tour_id",one = @One(select = "TravelWebsite.dao.TourDao.findTourId",fetchType = FetchType.EAGER)),
    })
	@Select("select * from hotel")
	public List<Hotel> findHotelAll();
	
	/**
	 * 通过酒店id查询酒店
	 * @param hotelIdInteger 酒店id
	 * @return Hotel
	 */
	@Results(id = "HotelMap",value = {
			 	@Result(id = true,column = "hotel_id",property = "hotelIdInteger"),
	            @Result(column = "hotel_name",property = "hotelNameString"),
	            @Result(column = "hotel_information",property = "hotelInformationString"),
	            @Result(column = "hotel_price",property = "hotelPriceDouble"),
	            @Result(column = "tour_id",property = "tourIdInteger")
    })
	@Select("select * from hotel where hotel_id=#{INTEGER}")
	public Hotel findHotelById(Integer hotelIdInteger);
	
	/**
	 * 通过公司id查询所有酒店
	 * @param tourIdInteger 公司id
	 * @return List<Hotel>
	 */
	@ResultMap(value = "HotelMap")
	@Select("select * from hotel where tour_id=#{INTEGER}")
	public List<Hotel> findHotelByTourId(Integer tourIdInteger);
	
	/**
	 * 添加酒店
	 * @param hotel
	 */
	@Insert("insert into hotel values(null,#{hotelNameString},#{hotelInformationString},#{hotelPriceDouble},#{tourIdInteger})")
	public void insertHotel(Hotel hotel);
	
	/**
	 * 更新酒店
	 * @param attraction
	 */
	@Update("update hotel set hotel_name=#{hotelNameString},hotel_information=#{hotelInformationString},hotel_price=#{hotelPriceDouble},tour_id=#{tourIdInteger} where hotel_id=#{hotelIdInteger}")
	public void updateHotel(Hotel hotel);
	
	/**
	 * 通过酒店id删除酒店
	 * @param attractionIdInteger 景点id
	 */
	@Delete("delete from Hotel where hotel_id=#{INTEGER}")
	public void deleteHotelById(Integer hotelIdInteger);
}
