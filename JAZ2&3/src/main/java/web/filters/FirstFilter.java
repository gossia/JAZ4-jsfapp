package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/addDelPrivilegesForm.jsp","/addressForm.jsp","/listOfUsers.jsp","/loggedOut.jsp","/premium.jsp",
	"registered.jsp","/userProfile.jsp","/Address","/Logout"})

public class FirstFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)arg0; //mapowanie potrzebne zeby nie wywalalo bledu
		HttpServletResponse response =(HttpServletResponse)arg1;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("username")!=null)
			chain.doFilter(request, response);
		else
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void destroy() {
	}
}
