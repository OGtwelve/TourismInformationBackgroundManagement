/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *景点表
		create table attraction(
		attraction_id int primary key auto_increment,	-- 景点id
		attraction_name varchar(30),			-- 景点名
		attraction_position varchar(600),		-- 景点位置
		attraction_information varchar(500),		-- 景点信息
		opening_time_up time,			-- 开放时间开
		opening_time_off time,			-- 开发时间关
		attraction_project decimal(9.1),			-- 景点价格
		tour_id int ,
		foreign key(tour_id) references tour(tour_id)
		);
 */
@SuppressWarnings("serial")
public class Attraction implements Serializable {
	private Integer attractionIdInteger;
	private String attractionNameString;
	private String attractionPositionString;
	private String attractionInformationString;
	private String openingTimeUpDate;
	private String openingTimeOffDate;
	private Double attractionProjectDouble;
	private Integer tourIdInteger;
	
	private List<AttractionProject> attractionProjects;
	private Tour tour;
	
	/**
	 * @return the attractionProjectDouble
	 */
	public Double getAttractionProjectDouble() {
		return attractionProjectDouble;
	}

	/**
	 * @param attractionProjectDouble the attractionProjectDouble to set
	 */
	public void setAttractionProjectDouble(Double attractionProjectDouble) {
		this.attractionProjectDouble = attractionProjectDouble;
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

	/**
	 * @return the attractionIdInteger
	 */
	public Integer getAttractionIdInteger() {
		return attractionIdInteger;
	}

	/**
	 * @param attractionIdInteger the attractionIdInteger to set
	 */
	public void setAttractionIdInteger(Integer attractionIdInteger) {
		this.attractionIdInteger = attractionIdInteger;
	}

	/**
	 * @return the attractionNameString
	 */
	public String getAttractionNameString() {
		return attractionNameString;
	}

	/**
	 * @param attractionNameString the attractionNameString to set
	 */
	public void setAttractionNameString(String attractionNameString) {
		this.attractionNameString = attractionNameString;
	}

	/**
	 * @return the attractionPositionString
	 */
	public String getAttractionPositionString() {
		return attractionPositionString;
	}

	/**
	 * @param attractionPositionString the attractionPositionString to set
	 */
	public void setAttractionPositionString(String attractionPositionString) {
		this.attractionPositionString = attractionPositionString;
	}

	
	/**
	 * @return the attractionInformationString
	 */
	public String getAttractionInformationString() {
		return attractionInformationString;
	}

	/**
	 * @param attractionInformationString the attractionInformationString to set
	 */
	public void setAttractionInformationString(String attractionInformationString) {
		this.attractionInformationString = attractionInformationString;
	}

	
	/**
	 * @return the openingTimeUpDate
	 */
	public String getOpeningTimeUpDate() {
		return openingTimeUpDate;
	}

	/**
	 * @param openingTimeUpDate the openingTimeUpDate to set
	 */
	public void setOpeningTimeUpDate(String openingTimeUpDate) {
		this.openingTimeUpDate = openingTimeUpDate;
	}

	/**
	 * @return the openingTimeOffDate
	 */
	public String getOpeningTimeOffDate() {
		return openingTimeOffDate;
	}

	/**
	 * @param openingTimeOffDate the openingTimeOffDate to set
	 */
	public void setOpeningTimeOffDate(String openingTimeOffDate) {
		this.openingTimeOffDate = openingTimeOffDate;
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
	 * @return the attractionProjects
	 */
	public List<AttractionProject> getAttractionProjects() {
		return attractionProjects;
	}

	/**
	 * @param attractionProjects the attractionProjects to set
	 */
	public void setAttractionProjects(List<AttractionProject> attractionProjects) {
		this.attractionProjects = attractionProjects;
	}

	@Override
	public String toString() {
		return "Attraction [attractionIdInteger=" + attractionIdInteger + ", attractionNameString="
				+ attractionNameString + ", attractionPositionString=" + attractionPositionString
				+ ", attractionInformationString=" + attractionInformationString + ", openingTimeUpDate="
				+ openingTimeUpDate + ", openingTimeOffDate=" + openingTimeOffDate + ", attractionProjectDouble="
				+ attractionProjectDouble + ", tourIdInteger=" + tourIdInteger + "]";
	}
	
	
}
