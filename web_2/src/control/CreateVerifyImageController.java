package control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImage;



@WebServlet(urlPatterns = "/servlet/CreateVerifyImageController.do")
public class CreateVerifyImageController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建一个图像对象
		CreateImage createImage=new CreateImage();
		
		//生成字符串
		String vCode=createImage.createCode();
		//把这个字符串保存到共享区中
		HttpSession session=request.getSession();
		session.setAttribute("verityCode", vCode);
		
		
//		System.out.println("vCode"+vCode);
		//浏览器返回内容
		response.setContentType("img/jpeg");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		//以字节流形式发过去
		BufferedImage image=createImage.CreateImage(vCode);
		ServletOutputStream out =response.getOutputStream();
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
	}
}
