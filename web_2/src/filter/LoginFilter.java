package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.User_loginDao;

public class LoginFilter implements Filter {
	
	String notPath="";
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
		
		if(notPath.indexOf(path)==-1){
			HttpSession session=request.getSession();
			if(session.getAttribute("currentUser")!=null){
				chain.doFilter(req, resp);
			}
			else{
				String value=null;
				Boolean flag=false;
				Cookie[] cookie=request.getCookies();
				for(Cookie a:cookie){
					if(a.getName().equals("username")){
						flag=true;
						value=a.getValue();
						break;
					}
				}
				System.out.println(value);
				if(flag){
					User_loginDao dao=new User_loginDao();
					User user=null;
					try {
						user=dao.getUser(value);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(user);
					session.removeAttribute("currentUser");
					String chr=user.getChrName();
					session.setAttribute("currentUser", chr);
					chain.doFilter(req, resp);
				}
				else{
					request.setAttribute("info", "没有权限访问");
					request.getRequestDispatcher("/error.jsp").forward(request, resp);
				}
			}
		}
		else{
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		notPath=config.getInitParameter("notCheckPath");
	}

}
