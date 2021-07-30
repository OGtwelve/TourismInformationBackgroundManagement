/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table catering(
		catering_id int primary key auto_increment,	-- 餐饮id
		catering_name varchar(30),					-- 餐饮名
		catering_information varchar(500),			-- 餐饮信息
		catering_price decimal(9.1),				-- 餐饮价格
		tour_id int ,
		foreign key(tour_id) references tour(tour_id)
		);
 */
@SuppressWarnings("serial")
public class Catering implements Serializable {
	private Integer cateringIdInteger;
	private String cateringNameString;
	private String cateringInformationString;
	private Double cateringPriceDouble;
	private Integer tourIdInteger;
	
	
	private Tour tour;
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
	/**
	 * @return the cateringIdInteger
	 */
	public Integer getCateringIdInteger() {
		return cateringIdInteger;
	}
	/**
	 * @param cateringIdInteger the cateringIdInteger to set
	 */
	public void setCateringIdInteger(Integer cateringIdInteger) {
		this.cateringIdInteger = cateringIdInteger;
	}
	/**
	 * @return the cateringNameString
	 */
	public String getCateringNameString() {
		return cateringNameString;
	}
	/**
	 * @param cateringNameString the cateringNameString to set
	 */
	public void setCateringNameString(String cateringNameString) {
		this.cateringNameString = cateringNameString;
	}
	/**
	 * @return the cateringInformationString
	 */
	public String getCateringInformationString() {
		return cateringInformationString;
	}
	/**
	 * @param cateringInformationString the cateringInformationString to set
	 */
	public void setCateringInformationString(String cateringInformationString) {
		this.cateringInformationString = cateringInformationString;
	}
	/**
	 * @return the cateringPriceDouble
	 */
	public Double getCateringPriceDouble() {
		return cateringPriceDouble;
	}
	/**
	 * @param cateringPriceDouble the cateringPriceDouble to set
	 */
	public void setCateringPriceDouble(Double cateringPriceDouble) {
		this.cateringPriceDouble = cateringPriceDouble;
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
	@Override
	public String toString() {
		return "Catering [cateringIdInteger=" + cateringIdInteger + ", cateringNameString=" + cateringNameString
				+ ", cateringInformationString=" + cateringInformationString + ", cateringPriceDouble="
				+ cateringPriceDouble + ", tourIdInteger=" + tourIdInteger + "]";
	}
	
	
}
