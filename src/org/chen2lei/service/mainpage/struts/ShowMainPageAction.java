package org.chen2lei.service.mainpage.struts;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import org.chen2lei.core.BaseAction;
import org.chen2lei.core.DeviceUtils;

@SuppressWarnings("serial")
@Namespace("")
@Action(value = "showMainPage", results = {
		@Result(name = "PC", location = "/service/mainPage/mainPage.jsp"),
		@Result(name = "mobile", location = "/service/mainPage/mainPage.jsp"),
		@Result(name = "pad", location = "/service/mainPage/mainPage.jsp") })
public class ShowMainPageAction extends BaseAction {

	public String execute() throws Exception {
		if (DeviceUtils.isMobile(request)) {
			return "mobile";	
		}if (DeviceUtils.isPad(request)) {
			return "pad";	
		}else {
			return "PC";	
		}
	}
}
