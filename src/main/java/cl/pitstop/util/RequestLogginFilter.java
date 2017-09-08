package cl.pitstop.util;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet Filter implementation class RequestLoggingFilter
 */

public class RequestLogginFilter implements Filter {
 
    private ServletContext context;
     
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }
 
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        
        System.out.println("Se ejecuto el filtro primero!");
        Object loginStatus = req.getSession().getAttribute("loginStatus");
        System.out.println("loginStatus:" + loginStatus);
        System.out.println("url:" + ((HttpServletRequest )request).getRequestURL() );
        System.out.println("url:" + ((HttpServletRequest )request).getRequestURI() );
        System.out.println("url:" + ((HttpServletRequest )request).getPathInfo() );
        if ( loginStatus == null && !((HttpServletRequest )request).getRequestURI().equals("/pitstop/admin/login") )
        {
        	System.out.println("Pedimos Sesion");
        	HttpServletResponse httpResponse = (HttpServletResponse) response;
        	httpResponse.sendRedirect("/pitstop/admin/login");
        }
        else
        {
        	System.out.println("Continuamos con la ejecución");
        }
        /*
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = request.getParameter(name);
            this.context.log(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
        }
         
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                this.context.log(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
            }
        }
        */
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
 
    @Override
	public void destroy() {
        //we can close resources here
    }
 
}