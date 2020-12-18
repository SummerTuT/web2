 package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.resource;


@WebServlet(urlPatterns = "/servlet/DownloadController.do")
public class DownloadController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		
		HttpSession session=request.getSession();
		ArrayList<resource> list=new ArrayList<resource>();
		list=(ArrayList<resource>)session.getAttribute("downloadList");

		String id_path="";
//		String name="";
		for(int i=0;i<list.size();i++){
			if(id==list.get(i).getResourceId()){
				id_path=list.get(i).getUrl();
//				name=list.get(i).getName();
				break;
			}
		}
		System.out.println(id_path);
		String path=request.getServletContext().getRealPath(id_path);
		String filename=path.substring(path.lastIndexOf("\\")+1);
		response.setHeader("content-disposition","attachment;filename="
							+URLEncoder.encode(filename,"UTF-8"));
		System.out.println(path);
		InputStream in=new FileInputStream(path);
		
		int len=0;
		byte[] buffer=new byte[1024];
		ServletOutputStream out=response.getOutputStream();
		while((len=in.read(buffer))!=-1){
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
		
	}

}
