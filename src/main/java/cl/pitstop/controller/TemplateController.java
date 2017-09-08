package cl.pitstop.controller;

import com.opensymphony.xwork2.*;

public class TemplateController extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String aboutus(){
		return SUCCESS;
	}
	
	public String news(){
		return SUCCESS;
	}
	
	

}
