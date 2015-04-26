package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.DummyDb;
import web.WebContextNames;
import domain.Privilege;
import domain.User;

@WebFilter({"/addDelPrivilegesForm.jsp","/Privilege","/listOfUsers.jsp"})
public class AdminFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response =(HttpServletResponse)arg1;
		
		ServletContext ctx = request.getServletContext();
		HttpSession session = request.getSession();
		DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfUsers);
	
		User u = null;
		for(User user : db.users) {
			if(user.getUserName().equals(session.getAttribute("username")))
				u = user;
		}
	
		if(u==null || u.getPrivilege()!=Privilege.ADMIN)
			request.getRequestDispatcher("accessdenied.jsp").forward(request, response);
		else
			chain.doFilter(request, response);
		
	}
	
	public void destroy() {
	}

}
