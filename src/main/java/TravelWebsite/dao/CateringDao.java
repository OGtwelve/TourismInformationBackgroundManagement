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

import TravelWebsite.domain.Catering;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 *		catering_id int primary key auto_increment,	-- ����id
		catering_name varchar(30),					-- ������
		catering_information varchar(500),			-- ������Ϣ
		catering_price decimal(9.1),				-- �����۸�
		tour_id int ,
		---------------------------------------------------------
		private Integer cateringIdInteger;
		private String cateringNameString;
		private String cateringInformationString;
		private Double cateringPriceDouble;
		private Integer tourIdInteger;
		
		private Tour tour;
 */
public interface CateringDao {
	/**
	 * ��ѯ���в���
	 * @return List<Catering>
	 */
	@Results(id = "findCateringAllMap",value = {
            @Result(id = true,column = "catering_id",property = "cateringIdInteger"),
            @Result(column = "catering_name",property = "cateringNameString"),
            @Result(column = "catering_information",property = "cateringInformationString"),
            @Result(column = "catering_price",property = "cateringPriceDouble"),
            @Result(column = "tour_id",property = "tourIdInteger"),
            @Result(property = "tour",column = "tour_id",one = @One(select = "TravelWebsite.dao.TourDao.findTourId",fetchType = FetchType.EAGER)),
    })
	@Select("select * from catering")
	public List<Catering> findCateringAll();
	
	/**
	 * ͨ������id��ѯ����
	 * @param cateringIdInteger ����id
	 * @return Catering
	 */
	@Results(id = "CateringMap",value = {
			 	@Result(id = true,column = "catering_id",property = "cateringIdInteger"),
	            @Result(column = "catering_name",property = "cateringNameString"),
	            @Result(column = "catering_information",property = "cateringInformationString"),
	            @Result(column = "catering_price",property = "cateringPriceDouble"),
	            @Result(column = "tour_id",property = "tourIdInteger")
    })
	@Select("select * from catering where catering_id=#{INTEGER}")
	public Catering findCateringById(Integer cateringIdInteger);
	
	/**
	 * ͨ����˾id��ѯ���в���
	 * @param tourIdInteger ��˾id
	 * @return List<Catering>
	 */
	@ResultMap(value = "CateringMap")
	@Select("select * from catering where tour_id=#{INTEGER}")
	public List<Catering> findCateringByTourId(Integer tourIdInteger);
	
	/**
	 * ��Ӳ���
	 * @param catering
	 */
	@Insert("insert into catering values(null,#{cateringNameString},#{cateringInformationString},#{cateringPriceDouble},#{tourIdInteger})")
	public void insertCatering(Catering catering);
	
	/**
	 * ���²���
	 * @param attraction
	 */
	@Update("update catering set catering_name=#{cateringNameString},catering_information=#{cateringInformationString},catering_price=#{cateringPriceDouble},tour_id=#{tourIdInteger} where catering_id=#{cateringIdInteger}")
	public void updateCatering(Catering catering);
	
	/**
	 * ͨ������idɾ������
	 * @param attractionIdInteger ����id
	 */
	@Delete("delete from Catering where catering_id=#{INTEGER}")
	public void deleteCateringById(Integer cateringIdInteger);
}
