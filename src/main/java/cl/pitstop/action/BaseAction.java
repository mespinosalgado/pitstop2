package cl.pitstop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements SessionAware,
        ServletRequestAware,
        ServletResponseAware {

    protected Map<String, Object> session;
    private HttpServletRequest request;
    private HttpServletResponse response;
   
    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;

    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;

    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;

    }

    /**
     * @return the session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * @return the request
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @return the response
     */
    public HttpServletResponse getResponse() {
        return response;
    }
}