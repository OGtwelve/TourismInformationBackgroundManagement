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
 * @author 3187102230 王佳宝
 * 畅游旅游网
 *
 */
@Controller
public class CaptcherController {
	@RequestMapping(path = "/captcher")
	public void captcher(HttpServletResponse response,HttpServletRequest request) {
		 	int width = 80;
	        int height = 40;
	        //1.创建一个对象，在内存中存图片（验证码图片对象）
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        //2.美化图片
	        //2.1 填充背景色
// 	        graphics.setColor(Color.blue);
	        Graphics graphics = image.getGraphics(); //画笔对象
	        //        graphics.fill//填充
	        //        graphics.draw//画
	        graphics.setColor(Color.white);//画笔的颜色
	        graphics.fillRect(0,0,width,height);//填充 rect 矩形
//	        //2.2 画边框
//	        graphics.drawRect(0,0,width-1,height-1);

	        String str="QWERTYPADFGHLBNM123456789qwertypadfghjkbnm";
	        //生成随机角标
	        Random random = new Random();
	        String randomnumber="";
	        graphics.setColor(Color.black);//画笔的颜色
	        //2.3 写验证码
	        for (int i = 1; i <= 4; i++) {
	            int nextInt = random.nextInt(str.length());
	            //获取字符
	            char charAt = str.charAt(nextInt);//随机字符
	            randomnumber+=charAt;
	            graphics.drawString(charAt+"",width/5*i,20);
	        }

	        System.out.println("当前的验证码是："+randomnumber);
	        request.getSession().setAttribute("captche", randomnumber);

	        //2.4干扰线
	        graphics.setColor(Color.green);
	        //随机生成坐标点

	        for (int i = 0; i < 3; i++) {
	            int nextWidth = random.nextInt(width);
	            int nextHeight = random.nextInt(height);

	            int nextWidth2 = random.nextInt(width);
	            int nextHeight2 = random.nextInt(height);
	            graphics.drawLine(nextWidth,nextHeight,nextWidth2,nextHeight2);
	        }

	        //3.将图片输出到页面展示
	        try {
				ImageIO.write(image,"jpg",response.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
