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
 * @author 3187102230 ���ѱ�
 * ����������
 *		hotel_id int primary key auto_increment,		-- �Ƶ�id
		hotel_name varchar(30),							-- �Ƶ���
		hotel_information varchar(500),					-- �Ƶ���Ϣ
		hotel_price decimal(9.1),						-- �Ƶ�۸�
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
	 * ��ѯ���оƵ�
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
	 * ͨ���Ƶ�id��ѯ�Ƶ�
	 * @param hotelIdInteger �Ƶ�id
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
	 * ͨ����˾id��ѯ���оƵ�
	 * @param tourIdInteger ��˾id
	 * @return List<Hotel>
	 */
	@ResultMap(value = "HotelMap")
	@Select("select * from hotel where tour_id=#{INTEGER}")
	public List<Hotel> findHotelByTourId(Integer tourIdInteger);
	
	/**
	 * ��ӾƵ�
	 * @param hotel
	 */
	@Insert("insert into hotel values(null,#{hotelNameString},#{hotelInformationString},#{hotelPriceDouble},#{tourIdInteger})")
	public void insertHotel(Hotel hotel);
	
	/**
	 * ���¾Ƶ�
	 * @param attraction
	 */
	@Update("update hotel set hotel_name=#{hotelNameString},hotel_information=#{hotelInformationString},hotel_price=#{hotelPriceDouble},tour_id=#{tourIdInteger} where hotel_id=#{hotelIdInteger}")
	public void updateHotel(Hotel hotel);
	
	/**
	 * ͨ���Ƶ�idɾ���Ƶ�
	 * @param attractionIdInteger ����id
	 */
	@Delete("delete from Hotel where hotel_id=#{INTEGER}")
	public void deleteHotelById(Integer hotelIdInteger);
}
