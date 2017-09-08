package cl.pitstop.util;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
 
public class ApplicationLogger implements Interceptor{
	private static final Logger LOGGER = Logger.getLogger(ApplicationLogger.class);
    private static final long serialVersionUID = 1L;
 
    @Override
	public String intercept(ActionInvocation invocation) throws Exception {
 
        String className = invocation.getAction().getClass().getName();
        String method =  invocation.getProxy().getMethod();
        long startTime = System.currentTimeMillis();
        LOGGER.info("Before calling action: " + className + " - " + method);
 
        String result = invocation.invoke();
 
        long endTime = System.currentTimeMillis();
        LOGGER.info("After calling action: " + className + " - " + method
                + " Time taken: " + (endTime - startTime) + " ms");
 
        return result;
    }
 
    @Override
	public void destroy() {
        System.out.println("Destroying LoggerInterceptor...");
    }
    @Override
	public void init() {
        System.out.println("Initializing LoggerInterceptor...");
    }
}
