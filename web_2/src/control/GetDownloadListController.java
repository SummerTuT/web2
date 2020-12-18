package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import dao.Download_resourceDao;
import vo.resource;

@WebServlet(urlPatterns="/servlet/GetDownloadListController.do")
public class GetDownloadListController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Download_resourceDao download=new Download_resourceDao();
		ArrayList<resource> downlist=null;
		try {
			downlist = download.getResourcesList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("downloadList", downlist);
		
		RequestDispatcher rd=request.getRequestDispatcher("/download.jsp");
		rd.forward(request, response);
	}



}
