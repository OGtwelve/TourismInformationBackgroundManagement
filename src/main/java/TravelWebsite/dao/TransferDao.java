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

import TravelWebsite.domain.Transfer;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 *		transfer_id int primary key auto_increment,	-- ��ͨid
		transfer_name varchar(30),					-- ��ͨ��
		transfer_information varchar(500),			-- ��ͨ��Ϣ
		transfer_price decimal(9.1),				-- ��ͨ�۸�
		tour_id int ,
		------------------------------------------------
		private Integer transferIdInteger;
		private String transferNameString;
		private String transferInformationString;
		private Double transferPriceDouble;
		private Integer tourIdInteger;
 */
public interface TransferDao {
	/**
	 * ��ѯ���н�ͨ
	 * @return List<Transfer>
	 */
	@Results(id = "findTransferAllMap",value = {
            @Result(id = true,column = "transfer_id",property = "transferIdInteger"),
            @Result(column = "transfer_name",property = "transferNameString"),
            @Result(column = "transfer_information",property = "transferInformationString"),
            @Result(column = "transfer_price",property = "transferPriceDouble"),
            @Result(column = "tour_id",property = "tourIdInteger"),
            @Result(property = "tour",column = "tour_id",one = @One(select = "TravelWebsite.dao.TourDao.findTourId",fetchType = FetchType.EAGER)),
    })
	@Select("select * from transfer")
	public List<Transfer> findTransferAll();
	
	/**
	 * ͨ����ͨid��ѯ��ͨ
	 * @param transferIdInteger ��ͨid
	 * @return Transfer
	 */
	@Results(id = "TransferMap",value = {
			 	@Result(id = true,column = "transfer_id",property = "transferIdInteger"),
	            @Result(column = "transfer_name",property = "transferNameString"),
	            @Result(column = "transfer_information",property = "transferInformationString"),
	            @Result(column = "transfer_price",property = "transferPriceDouble"),
	            @Result(column = "tour_id",property = "tourIdInteger")
    })
	@Select("select * from transfer where transfer_id=#{INTEGER}")
	public Transfer findTransferById(Integer transferIdInteger);
	
	/**
	 * ͨ����˾id��ѯ���н�ͨ
	 * @param tourIdInteger ��˾id
	 * @return List<Transfer>
	 */
	@ResultMap(value = "TransferMap")
	@Select("select * from transfer where tour_id=#{INTEGER}")
	public List<Transfer> findTransferByTourId(Integer tourIdInteger);
	
	/**
	 * ��ӽ�ͨ
	 * @param transfer
	 */
	@Insert("insert into transfer values(null,#{transferNameString},#{transferInformationString},#{transferPriceDouble},#{tourIdInteger})")
	public void insertTransfer(Transfer transfer);
	
	/**
	 * ���½�ͨ
	 * @param attraction
	 */
	@Update("update transfer set transfer_name=#{transferNameString},transfer_information=#{transferInformationString},transfer_price=#{transferPriceDouble},tour_id=#{tourIdInteger} where transfer_id=#{transferIdInteger}")
	public void updateTransfer(Transfer transfer);
	
	/**
	 * ͨ����ͨidɾ����ͨ
	 * @param attractionIdInteger ����id
	 */
	@Delete("delete from Transfer where transfer_id=#{INTEGER}")
	public void deleteTransferById(Integer transferIdInteger);
}
