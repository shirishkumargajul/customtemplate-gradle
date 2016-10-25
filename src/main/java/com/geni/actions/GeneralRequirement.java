package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GeneralRequirement extends ActionSupport implements ModelDriven<GeneralARI> {

	private static final long serialVersionUID = 1L;

	private GeneralARI general = new GeneralARI();
	private List<String> appKindList;
	private List<String> appPriorityList;
	private List<String> appDataSizeList;

	public GeneralARI getGeneral() {
		return general;
	}
	public void setGeneral(GeneralARI general) {
		this.general = general;
	}
	public List<String> getAppKindList() {
		return appKindList;
	}
	public void setAppKindList(List<String> appKindList) {
		this.appKindList = appKindList;
	}
	public List<String> getAppPriorityList() {
		return appPriorityList;
	}
	public void setAppPriorityList(List<String> appPriorityList) {
		this.appPriorityList = appPriorityList;
	}
	public List<String> getAppDataSizeList() {
		return appDataSizeList;
	}
	public void setAppDataSizeList(List<String> appDataSizeList) {
		this.appDataSizeList = appDataSizeList;
	}
	
	public GeneralRequirement() {
		appKindList = new ArrayList<String>();
		appKindList.add(getText("appKind.commonApp"));
		appKindList.add(getText("appKind.dataIntensiveApp"));
		appKindList.add(getText("appKind.missionCriticalApp"));
		appKindList.add(getText("appKind.streamingApp"));
		appKindList.add(getText("appKind.virtualDesktop"));
		appKindList.add(getText("list.unknown"));
		
		appPriorityList = new ArrayList<String>();
		appPriorityList.add(getText("appPriority.availability"));
		appPriorityList.add(getText("appPriority.performance"));
		appPriorityList.add(getText("appPriority.throughput"));
		appPriorityList.add(getText("list.unknown"));
		
		appDataSizeList = new ArrayList<String>();
		appDataSizeList.add(getText("appDataSize.MB"));
		appDataSizeList.add(getText("appDataSize.GB"));
		appDataSizeList.add(getText("appDataSize.TB"));
		appDataSizeList.add(getText("list.unknown"));
	}

	public boolean isValid() {
		boolean isValid = true;
		if (StringUtils.isEmptyOrWhitespaceOnly(general.getAppName())) {
			addFieldError("appName", getText("error.appName"));
			isValid = false;
		}
		if (general.getAppKind().equals("null")) {
			addFieldError("appKind", getText("error.appKind"));
			isValid = false;
		}
		if (general.getAppPriority().equals("null")) {
			addFieldError("appPriority", getText("error.appPriority"));
			isValid = false;
		}
		if (general.getAppDataSize().equals("null")) {
			addFieldError("appDataSize", getText("error.appDataSize"));
			isValid = false;
		}
		return isValid;
	}
	
	public String getDefaultAppKind() {
		return "RiceKb";
	}
	
	public String display() {
		general.setAppName("SoyKb");
		//general.setAppKind(getText("appKind.missionCriticalApp"));
		//general.setAppPriority(getText("appPriority.availability"));
		general.setAppDataSize(getText("appDataSize.GB"));
		return NONE;
	}
	
	public String setGeneralReq() {
		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(general.getAppName());
			System.out.println(general.getAppKind());
			System.out.println(general.getAppPriority());
			System.out.println(general.getAppDataSize());
	
			// set default appPriority
			if (general.getAppPriority().equals("default")) {
				general.setAppPriority("availability");
			}
	
			// set default appKind
			if (general.getAppKind().equals("default")) {
				general.setAppKind("webApp");
			}
	
			// set default dataSize
			if (general.getAppDataSize().equals("default")) {
				general.setAppDataSize("GB");
			}
	
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("emailid", "arjun");
			ctx.getSession().put("general", general);
	
			return SUCCESS;
		}
	}

	public GeneralARI getModel() {
		return general;
	}

}
