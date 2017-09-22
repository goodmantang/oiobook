package com.chinasofti.ssmdemo.ssm.common.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������֤�� Servlet implementation class CreateCaptchaServlet
 */
@WebServlet("/captcha")
public class CreateCaptchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final int IMG_HEIGHT = 35;
	private static final int IMG_WIDTH = 105;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("404.jsp");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String captcha = creatCeaptcha();

		request.getSession().setAttribute("captcha", captcha);
		System.out.println("session获取到的验证码"+request.getSession().getAttribute("captcha"));
		BufferedImage bi = createImage(captcha);

		ImageIO.write(bi, "JPEG", response.getOutputStream());

	}

	private BufferedImage createImage(String captcha) {
		// ������֤�뻺��ͼƬ
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		// ��ȡͼ��������
		Graphics g = image.getGraphics();
		// ���������
		Random random = new Random();
		// �趨����ɫ
		g.setColor(getRandColor(220, 250));
		// ����ʵ�ľ�������
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		// �趨����
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		for (int i = 0; i < captcha.length(); i++) {
			// ����֤����ʾ��ͼ����
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			// ���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
			g.drawString(String.valueOf(captcha.charAt(i)), 13 * i + 6, 16);
		}
		// ���ͼƬ
		g.dispose();
		return image;
	}

	/**
	 * ������ɸ�������ɫ�ķ���
	 * 
	 * @param fc
	 *            ����ɫϵֵ
	 * @param bc
	 *            ɫϵƫ����ֵ
	 * @return �����õ������ɫ
	 */
	private Color getRandColor(int fc, int bc) {
		// �����������
		Random random = new Random();
		// ����ɫϵֵ����
		if (fc > 255)
			// �޶�����ɫϵֵ���ֵ
			fc = 255;
		// ��ɫƫ����ֵ����
		if (bc > 255)
			// �޶���ɫƫ����ֵ���ֵ
			bc = 255;
		// ���ɵ������ɫ����ֵ
		int r = fc + random.nextInt(bc - fc);
		// ���ɵ������ɫ����ֵ
		int g = fc + random.nextInt(bc - fc);
		// ���ɵ������ɫ����ֵ
		int b = fc + random.nextInt(bc - fc);
		// �����������ɫ����
		return new Color(r, g, b);
	}

	public static String creatCeaptcha() {
		String src = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		StringBuilder sb = new StringBuilder();
		Random rd = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(src.charAt(rd.nextInt(src.length())));
		}

		return sb.toString();
	}

}
