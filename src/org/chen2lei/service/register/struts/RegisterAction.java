package org.chen2lei.service.register.struts;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.chen2lei.core.spring.BusinessConfig;
import org.chen2lei.service.register.business.RegisterBusiness;
import org.chen2lei.service.register.vo.RegisterResult;
import org.chen2lei.service.register.vo.RegisterVO;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import org.chen2lei.core.BaseAction;

@Namespace("/register")
@ParentPackage("json-default")
@Result(name="success", type="json")
@SuppressWarnings("serial")
public class RegisterAction extends BaseAction{
	
	private RegisterResult result = new RegisterResult();

	private Logger logger = Logger.getLogger(RegisterAction.class);
	
	@Action(value="showForm", results=@Result(name="success", location="/service/register/registerForm.jsp" ))
	public String showForm() {
		return "success";
	}
	
	@Action(value = "doRegister",results = {@Result(name="success", type="json")})
	public String doRegister() {
		RegisterVO registerVO = null;
		
		try {
			registerVO = getJsonObject(RegisterVO.class);
		} catch (JsonParseException e) {
			logger.error("jsong string="+ jsonString);
			logger.error("Can't parse user register info", e);
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.error("jsong string="+ jsonString);
			logger.error("Can't map to a Java object about user register info", e);
			e.printStackTrace();
		}
		
		if (logger.isDebugEnabled()){
			logger.debug("jsong string="+ jsonString);
		}
         
		RegisterBusiness processRegister = BusinessConfig.getBean(RegisterBusiness.class);
		String telNum = processRegister.newUser(registerVO);
		
		logger.debug("@@@telNum="+ telNum);
		
		result.setFlag(true);
		result.setErrorText("");
		result.setErrorCode("");

		return "success";
	}


	@JSON(name="result")
	public RegisterResult getResult() {
		return result;
	}

	public void setResult(RegisterResult result) {
		this.result = result;
	}
}


