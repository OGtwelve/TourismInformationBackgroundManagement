/**
 * 
 */
package TravelWebsite.domain;

import java.io.Serializable;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *游览项目表	游览项目及价格	
		create table attraction_project(
		attraction_project_id int primary key auto_increment,	-- 项目id
		attraction_items varchar(20),							-- 项目
		attraction_project_information varchar(500),			-- 项目信息
		attraction_project_price decimal(9.1),					-- 项目价格
		attraction_id int,
		foreign key(attraction_id) references attraction(attraction_id)
		);
 */
@SuppressWarnings("serial")
public class AttractionProject implements Serializable {
	private Integer attractionProjectIdInteger;
	private String attractionItemString;
	private String attractionPorjectInformationString;
	private Double attractionProjectPriceDouble;
	private Integer attractionIdInteger;
	
	private Attraction attraction;
	/**
	 * @return the attraction
	 */
	public Attraction getAttraction() {
		return attraction;
	}
	/**
	 * @param attraction the attraction to set
	 */
	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}
	/**
	 * @return the attractionProjectIdInteger
	 */
	public Integer getAttractionProjectIdInteger() {
		return attractionProjectIdInteger;
	}
	/**
	 * @return the attractionPorjectInformationString
	 */
	public String getAttractionPorjectInformationString() {
		return attractionPorjectInformationString;
	}
	/**
	 * @param attractionPorjectInformationString the attractionPorjectInformationString to set
	 */
	public void setAttractionPorjectInformationString(String attractionPorjectInformationString) {
		this.attractionPorjectInformationString = attractionPorjectInformationString;
	}
	/**
	 * @param attractionProjectIdInteger the attractionProjectIdInteger to set
	 */
	public void setAttractionProjectIdInteger(Integer attractionProjectIdInteger) {
		this.attractionProjectIdInteger = attractionProjectIdInteger;
	}
	/**
	 * @return the attractionItemString
	 */
	public String getAttractionItemString() {
		return attractionItemString;
	}
	/**
	 * @param attractionItemString the attractionItemString to set
	 */
	public void setAttractionItemString(String attractionItemString) {
		this.attractionItemString = attractionItemString;
	}
	/**
	 * @return the attractionProjectPriceDouble
	 */
	public Double getAttractionProjectPriceDouble() {
		return attractionProjectPriceDouble;
	}
	/**
	 * @param attractionProjectPriceDouble the attractionProjectPriceDouble to set
	 */
	public void setAttractionProjectPriceDouble(Double attractionProjectPriceDouble) {
		this.attractionProjectPriceDouble = attractionProjectPriceDouble;
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
	@Override
	public String toString() {
		return "AttractionProject [attractionProjectIdInteger=" + attractionProjectIdInteger + ", attractionItemString="
				+ attractionItemString + ", attractionPorjectInformationString=" + attractionPorjectInformationString
				+ ", attractionProjectPriceDouble=" + attractionProjectPriceDouble + ", attractionIdInteger="
				+ attractionIdInteger + "]";
	}
	
	
}
