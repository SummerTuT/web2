package filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.t_resources;
import dao.FindResource;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		String path=request.getServletPath();

		HttpSession session=request.getSession();
		String chrname=(String)session.getAttribute("currentUser");
		FindResource findresourceDao=new FindResource();
		ArrayList<t_resources> list=findresourceDao.find(chrname);
		
		boolean flag=false;
		for(t_resources a:list){
//			System.out.println("list"+a.getUrl());
			if(a.getUrl().equals(path)){
				flag=true;
				break;
			}
		}
		if(flag){
			chain.doFilter(request, resp);
		}
		else{
			request.setAttribute("info", "没有权限访问");
			request.getRequestDispatcher("/error.jsp").forward(request, resp);;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
