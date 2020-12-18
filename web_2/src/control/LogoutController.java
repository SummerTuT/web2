package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/servlet/logout.do")
public class LogoutController extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			Cookie cookie = new Cookie("username", "aaa");//2.设置Cookie的有效时间为0
			cookie.setMaxAge(0);//删除cookie的关键//3.将cookie发送给浏览器，来替换同名Cookie
			cookie.setPath("/");
			response.addCookie(cookie);
			
		 	HttpSession session = request.getSession();
	        session.removeAttribute("curUser");
	        RequestDispatcher rd=request.getRequestDispatcher("../login.html");
			rd.forward(request, response);
			
			
	}
	
	
	
	

}
