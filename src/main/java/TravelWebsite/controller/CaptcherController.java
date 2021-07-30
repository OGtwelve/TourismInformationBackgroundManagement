/**
 * 
 */
package TravelWebsite.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 3187102230 ���ѱ�
 * ����������
 *
 */
@Controller
public class CaptcherController {
	@RequestMapping(path = "/captcher")
	public void captcher(HttpServletResponse response,HttpServletRequest request) {
		 	int width = 80;
	        int height = 40;
	        //1.����һ���������ڴ��д�ͼƬ����֤��ͼƬ����
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        //2.����ͼƬ
	        //2.1 ��䱳��ɫ
// 	        graphics.setColor(Color.blue);
	        Graphics graphics = image.getGraphics(); //���ʶ���
	        //        graphics.fill//���
	        //        graphics.draw//��
	        graphics.setColor(Color.white);//���ʵ���ɫ
	        graphics.fillRect(0,0,width,height);//��� rect ����
//	        //2.2 ���߿�
//	        graphics.drawRect(0,0,width-1,height-1);

	        String str="QWERTYPADFGHLBNM123456789qwertypadfghjkbnm";
	        //��������Ǳ�
	        Random random = new Random();
	        String randomnumber="";
	        graphics.setColor(Color.black);//���ʵ���ɫ
	        //2.3 д��֤��
	        for (int i = 1; i <= 4; i++) {
	            int nextInt = random.nextInt(str.length());
	            //��ȡ�ַ�
	            char charAt = str.charAt(nextInt);//����ַ�
	            randomnumber+=charAt;
	            graphics.drawString(charAt+"",width/5*i,20);
	        }

	        System.out.println("��ǰ����֤���ǣ�"+randomnumber);
	        request.getSession().setAttribute("captche", randomnumber);

	        //2.4������
	        graphics.setColor(Color.green);
	        //������������

	        for (int i = 0; i < 3; i++) {
	            int nextWidth = random.nextInt(width);
	            int nextHeight = random.nextInt(height);

	            int nextWidth2 = random.nextInt(width);
	            int nextHeight2 = random.nextInt(height);
	            graphics.drawLine(nextWidth,nextHeight,nextWidth2,nextHeight2);
	        }

	        //3.��ͼƬ�����ҳ��չʾ
	        try {
				ImageIO.write(image,"jpg",response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
