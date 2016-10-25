package com.geni.actions;

import java.io.File;

import com.geni.beans.ApplicationRI;
import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.beans.StorageARI;
import com.geni.services.CustomTemplateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomTemplate extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private File file;
	private String fileURL;
	private String output;
	
	
	

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getCTXML() {
		ActionContext ctx = ActionContext.getContext();
		
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		NetworkARI network = (NetworkARI) ctx.getSession().get("network");
		StorageARI storage = (StorageARI) ctx.getSession().get("storage");
		ComputationARI computation = (ComputationARI) ctx.getSession().get("computation");
		
		ApplicationRI appRI = new ApplicationRI();
		appRI.setGeneralARI(general);
		appRI.setNetworkARI(network);
		appRI.setStorageARI(storage);
		appRI.setComputationARI(computation);
		
		CustomTemplateService ctService = new CustomTemplateService();
		this.output = ctService.deployResources(appRI);
		return SUCCESS;
	}

}
