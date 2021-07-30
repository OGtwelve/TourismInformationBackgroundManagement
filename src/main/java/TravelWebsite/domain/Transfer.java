/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table transfer(
		transfer_id int primary key auto_increment,	-- 交通id
		transfer_name varchar(30),					-- 交通名
		transfer_information varchar(500),			-- 交通信息
		transfer_price decimal(9.1),				-- 交通价格
		tour_id int ,
		foreign key(tour_id) references tour(tour_id)
		);
 */
@SuppressWarnings("serial")
public class Transfer implements Serializable {
	private Integer transferIdInteger;
	private String transferNameString;
	private String transferInformationString;
	private Double transferPriceDouble;
	private Integer tourIdInteger;
	
	private Tour tour;

	/**
	 * @return the transferIdInteger
	 */
	public Integer getTransferIdInteger() {
		return transferIdInteger;
	}

	/**
	 * @param transferIdInteger the transferIdInteger to set
	 */
	public void setTransferIdInteger(Integer transferIdInteger) {
		this.transferIdInteger = transferIdInteger;
	}

	/**
	 * @return the transferNameString
	 */
	public String getTransferNameString() {
		return transferNameString;
	}

	/**
	 * @param transferNameString the transferNameString to set
	 */
	public void setTransferNameString(String transferNameString) {
		this.transferNameString = transferNameString;
	}

	/**
	 * @return the transferInformationString
	 */
	public String getTransferInformationString() {
		return transferInformationString;
	}

	/**
	 * @param transferInformationString the transferInformationString to set
	 */
	public void setTransferInformationString(String transferInformationString) {
		this.transferInformationString = transferInformationString;
	}

	/**
	 * @return the transferPriceDouble
	 */
	public Double getTransferPriceDouble() {
		return transferPriceDouble;
	}

	/**
	 * @param transferPriceDouble the transferPriceDouble to set
	 */
	public void setTransferPriceDouble(Double transferPriceDouble) {
		this.transferPriceDouble = transferPriceDouble;
	}

	/**
	 * @return the tourIdInteger
	 */
	public Integer getTourIdInteger() {
		return tourIdInteger;
	}

	/**
	 * @param tourIdInteger the tourIdInteger to set
	 */
	public void setTourIdInteger(Integer tourIdInteger) {
		this.tourIdInteger = tourIdInteger;
	}

	/**
	 * @return the tour
	 */
	public Tour getTour() {
		return tour;
	}

	/**
	 * @param tour the tour to set
	 */
	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Override
	public String toString() {
		return "Transfer [transferIdInteger=" + transferIdInteger + ", transferNameString=" + transferNameString
				+ ", transferInformationString=" + transferInformationString + ", transferPriceDouble="
				+ transferPriceDouble + ", tourIdInteger=" + tourIdInteger + "]";
	}
	
	
}
