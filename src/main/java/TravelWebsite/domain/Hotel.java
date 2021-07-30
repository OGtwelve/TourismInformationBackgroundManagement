/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *create table  hotel(
		hotel_id int primary key auto_increment,		-- 酒店id
		hotel_name varchar(30),							-- 酒店名
		hotel_information varchar(500),					-- 酒店信息
		hotel_price decimal(9.1),						-- 酒店价格
		tour_id int ,
		foreign key(tour_id) references tour(tour_id)
		);
 */
@SuppressWarnings("serial")
public class Hotel implements Serializable {
	private Integer hotelIdInteger;
	private String hotelNameString;
	private String hotelInformationString;
	private Double hotelPriceDouble;
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
	 * @return the hotelIdInteger
	 */
	public Integer getHotelIdInteger() {
		return hotelIdInteger;
	}
	/**
	 * @param hotelIdInteger the hotelIdInteger to set
	 */
	public void setHotelIdInteger(Integer hotelIdInteger) {
		this.hotelIdInteger = hotelIdInteger;
	}
	/**
	 * @return the hotelNameString
	 */
	public String getHotelNameString() {
		return hotelNameString;
	}
	/**
	 * @param hotelNameString the hotelNameString to set
	 */
	public void setHotelNameString(String hotelNameString) {
		this.hotelNameString = hotelNameString;
	}
	/**
	 * @return the hotelInformationString
	 */
	public String getHotelInformationString() {
		return hotelInformationString;
	}
	/**
	 * @param hotelInformationString the hotelInformationString to set
	 */
	public void setHotelInformationString(String hotelInformationString) {
		this.hotelInformationString = hotelInformationString;
	}
	/**
	 * @return the hotelPriceDouble
	 */
	public Double getHotelPriceDouble() {
		return hotelPriceDouble;
	}
	/**
	 * @param hotelPriceDouble the hotelPriceDouble to set
	 */
	public void setHotelPriceDouble(Double hotelPriceDouble) {
		this.hotelPriceDouble = hotelPriceDouble;
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
		return "Hotel [hotelIdInteger=" + hotelIdInteger + ", hotelNameString=" + hotelNameString
				+ ", hotelInformationString=" + hotelInformationString + ", hotelPriceDouble=" + hotelPriceDouble
				+ ", tourIdInteger=" + tourIdInteger + "]";
	}
	
	
}
