/**
 * 
 */
package TravelWebsite.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;


import TravelWebsite.domain.Tour;


/**
 * @author 3187102230 ���ѱ�
 * ����������
 *		tour_id int primary key auto_increment,		-- ��˾id
		tour_name varchar(30),					-- ��˾��
		tour_price decimal(9.1),				-- �۸�
		tour_phone varchar(11)					-- ��ϵ�绰
		---------------------------------------------------
		private Integer tourIdInteger;
		private String tourNameString;
		private Double tourPriceDouble;
		private String tourPhoneString;
		
		private List<Attraction> attractions;
		private List<Catering> caterings;
		private List<Hotel> hotels;
		private List<Transfer> transfers;
 */
public interface TourDao {
	/**
	 * ��ѯ�������ι�˾
	 * @return List<Tour>
	 */
	@Results(id = "findTourAllMap",value = {
            @Result(id = true,column = "tour_id",property = "tourIdInteger"),
            @Result(column = "tour_name",property = "tourNameString"),
            @Result(column = "tour_price",property = "tourPriceDouble"),
            @Result(column = "tour_phone",property = "tourPhoneString"),
            @Result(property = "attractions",column = "tour_id",many = @Many(select = "TravelWebsite.dao.AttractionDao.findAttractionByTourId",fetchType = FetchType.LAZY)),
            @Result(property = "caterings",column = "tour_id",many = @Many(select = "TravelWebsite.dao.CateringDao.findCateringByTourId",fetchType = FetchType.LAZY)),        
            @Result(property = "hotels",column = "tour_id",many = @Many(select = "TravelWebsite.dao.HotelDao.findHotelByTourId",fetchType = FetchType.LAZY)),
            @Result(property = "transfers",column = "tour_id",many = @Many(select = "TravelWebsite.dao.TransferDao.findTransferByTourId",fetchType = FetchType.LAZY))
            
    })
	@Select("select * from tour;")
	public List<Tour> findTourAll();
	
	/**
	 * ͨ����˾id��ѯ���ι�˾
	 * @param tourIdInteger ��˾id
	 * @return Tour
	 */
	@Results(id = "TourMap",value = {
            @Result(id = true,column = "tour_id",property = "tourIdInteger"),
            @Result(column = "tour_name",property = "tourNameString"),
            @Result(column = "tour_price",property = "tourPriceDouble"),
            @Result(column = "tour_phone",property = "tourPhoneString")
    })
	@Select("select * from tour where tour_id=#{INTEGER}")
	public Tour findTourId(Integer tourIdInteger);
	
	/**
	 * ������ι�˾
	 * @param tour
	 */
	@Insert("insert into tour values(null,#{tourNameString},#{tourPriceDouble},#{tourPhoneString})")
	public void insertTour(Tour tour);
	
	/**
	 * �������ι�˾
	 * @param tour
	 */
	@Update("update tour set tour_name=#{tourNameString},tour_price=#{tourPriceDouble},tour_phone=#{tourPhoneString} where tour_id=#{tourIdInteger}")
	public void updateTour(Tour tour);
	
	/**
	 * ͨ����˾idɾ�����ι�˾
	 * @param tourIdInteger ��˾id
	 */
	@Delete("delete from tour where tour_id=#{INTEGER}")
	public void deleteTour(Integer tourIdInteger);
}
