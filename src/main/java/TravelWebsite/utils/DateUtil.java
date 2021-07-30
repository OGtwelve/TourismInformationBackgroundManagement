/**
 * 
 */
package TravelWebsite.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 3187102230 王佳宝
 * 畅游旅游网
 * 时间转换类
 */
public class DateUtil {
	/**
	 * 字符串转日期类型
	 * @param source 字符串
	 * @return 日期
	 */
	public static Date setDate(String source) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public static String getString(Date format) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(format);
	}
}
