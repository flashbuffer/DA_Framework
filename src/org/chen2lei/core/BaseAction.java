package org.chen2lei.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionSupport;



public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	private static final long serialVersionUID = -9034340417209815859L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
    
    protected String jsonString;
    protected ObjectMapper mapper = new ObjectMapper();
	
    private Logger logger = Logger.getLogger(BaseAction.class);
    
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public <T> T getJsonObject(Class<T> cls)  throws JsonParseException, JsonMappingException{
		StringBuffer buffer;
		try {
			System.out.println(System.getProperty("file.encoding"));
			System.out.println("??????000");
			request.setCharacterEncoding("utf-8");
			BufferedReader reader = new BufferedReader( new InputStreamReader(request.getInputStream(),"utf-8"));
			String lineText = reader.readLine();
			buffer = new StringBuffer();
			while(lineText != null){
				buffer.append(lineText);
				lineText = reader.readLine();
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		jsonString = buffer.toString();
		if (logger.isDebugEnabled()) {
			logger.debug("json=" + jsonString);
		}
		
		if (StringUtils.isEmpty(jsonString)) {
			logger.error("JSON String is EMPTY!");
			return null;
		}
		
		try {
		 return (T)	mapper.readValue(jsonString, cls);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String getJsonString() {
		return jsonString;
	}


}
