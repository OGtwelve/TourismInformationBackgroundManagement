/**
 * 
 */
package TravelWebsite.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 * ʱ��ת����
 */
public class DateUtil {
	/**
	 * �ַ���ת��������
	 * @param source �ַ���
	 * @return ����
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
