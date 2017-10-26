package filter;

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

import beans.LoginBean;

@WebFilter(filterName = "LoginFilter", urlPatterns = { "/secured/*" })
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		LoginBean lb = (LoginBean) ((HttpServletRequest)request).getSession().getAttribute("loginBean");
		
		if(lb == null || !lb.isZalogowany()){
			String contextPath = ((HttpServletRequest) request).getContextPath();
			((HttpServletResponse)response).sendRedirect(contextPath + "/logowanie.xhtml");
		} else {
			chain.doFilter(request, response);			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
