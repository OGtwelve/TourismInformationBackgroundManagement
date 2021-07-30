/**
 * 
 */
package TravelWebsite.utils;

import java.util.Random;

/**
 * @author 3187102230 ���ѱ� ����������
 * �ַ�ת����
 */
public class RandomStringUtil {
	/**
	 * ��������ַ���
	 * @param number �ַ����ĳ���
	 * @return ����ַ���
	 */
	public static String getRandomString(int number) {

		String str = "QWERTYPADFGHLBNM123456789qwertypadfghjkbnm";//�����ֵȡֵ��Χ
		// ��������Ǳ�
		Random random = new Random();
		String randomnumber = "";
		for (int i = 0; i < number; i++) {
			int nextInt = random.nextInt(str.length());
			// ��ȡ�ַ�
			char charAt = str.charAt(nextInt);// ����ַ�
			randomnumber += charAt;

		}
		return randomnumber;
	}
	
	/**
	 * ��д�ַ�ת��ΪСд�ַ�
	 * @param randomNumber
	 * @return
	 */
	public static String getRandomString(String randomNumber) {
		String str = "";
		for (int i = 0; i < randomNumber.length(); i++) {//�����ȡ�����
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
