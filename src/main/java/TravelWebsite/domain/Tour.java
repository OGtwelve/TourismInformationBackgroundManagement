 /**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table tour(
		tour_id int primary key auto_increment,	-- 公司id
		tour_name varchar(30),					-- 公司名
		tour_price decimal(9.1),				-- 价格
		tour_phone varchar(11)					-- 联系电话
		);
 */
@SuppressWarnings("serial")
public class Tour implements Serializable {
	private Integer tourIdInteger;
	private String tourNameString;
	private Double tourPriceDouble;
	private String tourPhoneString;
	
	private List<Attraction> attractions;
	private List<Catering> caterings;
	private List<Hotel> hotels;
	private List<Transfer> transfers;
	/**
	 * @return the caterings
	 */
	public List<Catering> getCaterings() {
		return caterings;
	}

	/**
	 * @param caterings the caterings to set
	 */
	public void setCaterings(List<Catering> caterings) {
		this.caterings = caterings;
	}

	/**
	 * @return the hotels
	 */
	public List<Hotel> getHotels() {
		return hotels;
	}

	/**
	 * @param hotels the hotels to set
	 */
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	/**
	 * @return the transfers
	 */
	public List<Transfer> getTransfers() {
		return transfers;
	}

	/**
	 * @param transfers the transfers to set
	 */
	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
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
	 * @return the tourNameString
	 */
	public String getTourNameString() {
		return tourNameString;
	}

	/**
	 * @param tourNameString the tourNameString to set
	 */
	public void setTourNameString(String tourNameString) {
		this.tourNameString = tourNameString;
	}



	/**
	 * @return the tourPriceDouble
	 */
	public Double getTourPriceDouble() {
		return tourPriceDouble;
	}

	/**
	 * @param tourPriceDouble the tourPriceDouble to set
	 */
	public void setTourPriceDouble(Double tourPriceDouble) {
		this.tourPriceDouble = tourPriceDouble;
	}

	/**
	 * @return the tourPhoneString
	 */
	public String getTourPhoneString() {
		return tourPhoneString;
	}

	/**
	 * @param tourPhoneString the tourPhoneString to set
	 */
	public void setTourPhoneString(String tourPhoneString) {
		this.tourPhoneString = tourPhoneString;
	}

	/**
	 * @return the attractions
	 */
	public List<Attraction> getAttractions() {
		return attractions;
	}

	/**
	 * @param attractions the attractions to set
	 */
	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "Tour [tourIdInteger=" + tourIdInteger + ", tourNameString=" + tourNameString + ", tourPriceDouble="
				+ tourPriceDouble + ", tourPhoneString=" + tourPhoneString + "]";
	}
	
	
}
