package com.dsib.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidImageServlet extends HttpServlet {

	int width = 0;
	int height = 0;
	int randomStrNum = 0;

	/**
	 * Constructor of the object.
	 */
	public ValidImageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 获取字符串
		String randomStr = getRadomStr(randomStrNum);
		if (null != session) {
			// 设置参数
			session.removeAttribute("randomStr");
			session.setAttribute("randomStr", randomStr);
			// 设置相应类型，输出图片客户端不缓存
			response.setContentType("text/html; charset=GBK");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0L);
			response.setContentType("image/jpeg");

			// 输出到页面
			rander(randomStr, response.getOutputStream(), width, height);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		width = Integer.parseInt(this.getInitParameter("width"));
		height = Integer.parseInt(this.getInitParameter("height"));
		randomStrNum = Integer.parseInt(this.getInitParameter("num"));
	}

	// 验证码字符串
	Random random = new Random();

	public String getRadomStr(int number) {
		Random random = new Random();
		String text = "";
		String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "q",
				"w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d",
				"f", "g", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m" };
		int num = str.length;
		for (int i = 0; i < number; i++) {
			text += str[random.nextInt(num)];
		}
		return text;
	}

	/**
	 * 产生随机颜色
	 */
	public Color getRandColor() {
		Random random = new Random();
		Color[] color = new Color[5];
		color[0] = new Color(32, 158, 25);
		color[1] = new Color(218, 42, 19);
		color[2] = new Color(31, 75, 208);
		color[3] = new Color(0, 102, 182);
		color[4] = new Color(171, 0, 85);
		return color[random.nextInt(5)];
	}

	/**
	 * 产生随机字体
	 */
	public Font getRandFontFamily() {
		Random random = new Random();
		Font[] font = new Font[5];
		font[0] = new Font("宋体", Font.BOLD, 35);
		font[1] = new Font("隶书", Font.BOLD, 35);
		font[2] = new Font("楷体", Font.BOLD, 35);
		font[3] = new Font("Forte", Font.BOLD, 35);
		font[4] = new Font("Wide Latin", Font.BOLD, 35);
		return font[random.nextInt(5)];
	}

	/**
	 * create image
	 * 
	 * @throws IOException
	 */
	public void rander(String randomStr, OutputStream out, int width, int height)
			throws IOException {
		// 在内存中创建图片
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_INDEXED);
		// 获取图形上下文
		Graphics2D g = (Graphics2D) bi.getGraphics();
		// 设置边框
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setFont(getRandFontFamily());
		g.setColor(Color.black);
		// 验证码 每个验证码的水平位置不同
		String[] str = new String[randomStr.length()];
		for (int i = 0; i < str.length; i++) {
			str[i] = randomStr.substring(i, i + 1);
			int w = 0;
			int x = (i + 1) % 3;
			if (x == random.nextInt(7)) {
				w = 25 - random.nextInt(5);
			} else {
				w = 25 + random.nextInt(5);
			}
			// 随机颜色
			g.setColor(getRandColor());
			g.drawString(str[i], 20 * i + 10, w);
		}
		// 随机产生干扰点
		for (int i = 0; i < 70; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			Color color = new Color(random.nextInt(255), random.nextInt(255),
					random.nextInt(255));

			g.setColor(color);
			g.drawOval(x, y, 0, 0);
		}
		// 生产干扰线
		for (int i = 0; i < 8; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);

			g.setColor(getRandColor());
			g.drawLine(x, y, x1, y1);
		}

		// 图像生效
		g.dispose();
		// 输出页面
		ImageIO.write(bi, "jpeg", out);
	}

}
