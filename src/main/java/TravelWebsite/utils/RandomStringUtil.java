/**
 * 
 */
package TravelWebsite.utils;

import java.util.Random;

/**
 * @author 3187102230 王佳宝 畅游旅游网
 * 字符转换器
 */
public class RandomStringUtil {
	/**
	 * 生成随机字符串
	 * @param number 字符串的长度
	 * @return 随机字符串
	 */
	public static String getRandomString(int number) {

		String str = "QWERTYPADFGHLBNM123456789qwertypadfghjkbnm";//随机数值取值范围
		// 生成随机角标
		Random random = new Random();
		String randomnumber = "";
		for (int i = 0; i < number; i++) {
			int nextInt = random.nextInt(str.length());
			// 获取字符
			char charAt = str.charAt(nextInt);// 随机字符
			randomnumber += charAt;

		}
		return randomnumber;
	}
	
	/**
	 * 大写字符转换为小写字符
	 * @param randomNumber
	 * @return
	 */
	public static String getRandomString(String randomNumber) {
		String str = "";
		for (int i = 0; i < randomNumber.length(); i++) {//逐个获取随机数
			int anInt = (int) ((randomNumber.charAt(i)));
			if (anInt >= 65 && anInt <= 90) {
				str += String.valueOf((char) (anInt + 32));
			} else {
				str += String.valueOf((char) anInt);
			}
		}
		return str;
	}
}
