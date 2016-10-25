package com.geni.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geni.beans.ComputationARI;
import com.geni.beans.GeneralARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ComputationRequirement extends ActionSupport implements ModelDriven<ComputationARI>{

	private static final long serialVersionUID = 1L;
	
	private ComputationARI computation = new ComputationARI();
	private List<String> noOfNodesList;
	private List<String> noOfCoresList;
	private List<String> yesOrNoList;
	private List<String> osList;
	private List<String> ramSizeList;
	private List<String> osArchList;
	private HashMap<String,Object> gpuMap;
	private List<String> gpuSizeList;

	
	public List<String> getNoOfNodesList() {
		return noOfNodesList;
	}

	public void setNoOfNodesList(List<String> noOfNodesList) {
		this.noOfNodesList = noOfNodesList;
	}

	public HashMap getGpuMap() {
		return gpuMap;
	}

	public void setGpuMap(HashMap gpuMap) {
		this.gpuMap = gpuMap;
	}

	public List<String> getGpuSizeList() {
		return gpuSizeList;
	}

	public void setGpuSizeList(List<String> gpuSizeList) {
		this.gpuSizeList = gpuSizeList;
	}

	public List<String> getOsArchList() {
		return osArchList;
	}

	public void setOsArchList(List<String> osArchList) {
		this.osArchList = osArchList;
	}

	public List<String> getNoOfCoresList() {
		return noOfCoresList;
	}

	public void setNoOfCoresList(List<String> noOfCoresList) {
		this.noOfCoresList = noOfCoresList;
	}

	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}

	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}

	public List<String> getOsList() {
		return osList;
	}

	public void setOsList(List<String> osList) {
		this.osList = osList;
	}

	public List<String> getRamSizeList() {
		return ramSizeList;
	}

	public void setRamSizeList(List<String> ramSizeList) {
		this.ramSizeList = ramSizeList;
	}

	public ComputationARI getComputation() {
		return computation;
	}

	public void setComputation(ComputationARI computation) {
		this.computation = computation;
	}
	
	public ComputationRequirement() {
		noOfNodesList = new ArrayList<String>();
		noOfNodesList.add("1");
		noOfNodesList.add("2");
		noOfNodesList.add("3");
		noOfNodesList.add("4");
		noOfNodesList.add(getText("list.unknown"));
		
		noOfCoresList = new ArrayList<String>();
		noOfCoresList.add("1");
		noOfCoresList.add("2");
		noOfCoresList.add("3");
		noOfCoresList.add("4");
		noOfCoresList.add("5");
		noOfCoresList.add("6");
		noOfCoresList.add("7");
		noOfCoresList.add("8");
		noOfCoresList.add("9");
		noOfCoresList.add("10");
		noOfCoresList.add("12");
		noOfCoresList.add(getText("list.unknown"));
		
		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.yes"));
		yesOrNoList.add(getText("list.unknown"));
		
		osList = new ArrayList<String>();
		osList.add(getText("os.centos6"));
		osList.add(getText("os.centos7"));
		osList.add(getText("os.debian6"));
		osList.add(getText("os.debian7"));
		osList.add(getText("os.debian8"));
		osList.add(getText("os.fedora"));
		osList.add(getText("os.ubuntu12"));
		osList.add(getText("os.ubuntu14"));
		osList.add(getText("os.redhat7"));
		osList.add(getText("os.win2008R2"));
		osList.add(getText("os.win7"));
		osList.add(getText("list.unknown"));
		
		ramSizeList = new ArrayList<String>();
		ramSizeList.add(getText("ram.opt1"));
		ramSizeList.add(getText("ram.opt2"));
		ramSizeList.add(getText("ram.opt3"));
		ramSizeList.add(getText("ram.opt4"));
		ramSizeList.add(getText("ram.opt5"));
		ramSizeList.add(getText("ram.opt6"));
		ramSizeList.add(getText("ram.opt7"));
		ramSizeList.add(getText("ram.opt8"));
		ramSizeList.add(getText("ram.opt9"));
		ramSizeList.add(getText("list.unknown"));
		
		osArchList = new ArrayList<String>();
		osArchList.add(getText("osArch.32bit"));
		osArchList.add(getText("osArch.64bit"));
		osArchList.add(getText("list.unknown"));
		
		gpuSizeList = new ArrayList<String>();
		gpuSizeList.add(getText("gpu.opt1"));
		gpuSizeList.add(getText("gpu.opt2"));
		gpuSizeList.add(getText("gpu.opt3"));
		gpuSizeList.add(getText("gpu.opt4"));
		gpuSizeList.add(getText("gpu.opt5"));
		gpuSizeList.add(getText("gpu.opt6"));
		gpuSizeList.add(getText("gpu.opt7"));
		gpuSizeList.add(getText("list.unknown"));
		
		gpuMap =  new HashMap<String, Object>();
		gpuMap.put(getText("list.no"), "Not Applicable");
		gpuMap.put(getText("list.yes"), gpuSizeList);
		gpuMap.put(getText("list.unknown"), "Not Applicable");
		
	}
	
/*	public String getDefaultNoOfCores() {
		return "1";
	}
	public String getDefaultDedicatedServer() {
		return getText("list.no");
	}
	public String getDefaultOs() {
		return getText("os.ubuntu14");
	}
	public String getDefaultOsArch() {
		return getText("osArch.64bit");
	}
	public String getDefaultRamSize() {
		return getText("ram.opt1");
	}
	public String getDefaultGpu() {
		return getText("list.no");
	}
	public String getDefaultGpuSize() {
		return getText("gpu.opt1");
	}*/
	
	public boolean isValid() {
		boolean val = true;
		if (computation.getNoOfCores().equals("null")) {
			addFieldError("noOfCores", getText("error.noOfCores"));
			val = false;
		}
		if (computation.getDedicatedServer().equals("null")) {
			addFieldError("dedicatedServer", getText("error.dedicatedServer"));
			val = false;
		}
		if (computation.getOperatingSystem().equals("null")) {
			addFieldError("operatingSystem", getText("error.os"));
			val = false;
		}
		if (computation.getOsArchitecture().equals("null")) {
			addFieldError("osArchitecture", getText("error.osArch"));
			val = false;
		}
		if (computation.getRamSize().equals("null")) {
			addFieldError("ramSize", getText("error.ramSize"));
			val = false;
		}
		if (computation.getGpu().equals("null")) {
			addFieldError("gpu", getText("error.gpu"));
			val = false;
		}
		/*if (computation.getGpuSize().equals("null")) {
			addFieldError("gpuSize", getText("error.gpuSize"));
			val = false;
		}*/
		return val;
	}
	
	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		ComputationARI computation = PrePopulateService.getComputationReq(general);
		if (computation != null) {
			this.computation.setNoOfNodes(computation.getNoOfNodes());
			this.computation.setNoOfCores(computation.getNoOfCores());
			this.computation.setDedicatedServer(computation.getDedicatedServer());
			this.computation.setRamSize(computation.getRamSize());
			this.computation.setOperatingSystem(computation.getOperatingSystem());
			this.computation.setOsArchitecture(computation.getOsArchitecture());;
			this.computation.setGpu(computation.getGpu());
			//this.computation.setGpuSize(computation.getGpuSize());
		}
		return NONE;
	}
	
	public String setComputationReq() {
		
		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(computation.getNoOfCores());
			System.out.println(computation.getDedicatedServer());
			System.out.println(computation.getOperatingSystem());
			System.out.println(computation.getOsArchitecture());
			System.out.println(computation.getRamSize());
			System.out.println(computation.getGpu());
			System.out.println(computation.getGpuSize());
			
			//set default vm cores 
			if (computation.getNoOfCores().equals("null")) {
				computation.setNoOfCores("1");
			}
			
			//set default dedicated server
			if (computation.getDedicatedServer().equals("null")) {
				computation.setDedicatedServer("No");
			}
			
			//set default operating system
			if (computation.getOperatingSystem().equals("null")) {
				computation.setOperatingSystem("ubuntu_os_14");
			}
			
			//set os architecture based on ram size
			if (computation.getRamSize().equals("512MB - 1GB") || computation.getRamSize().equals("1GB - 2GB") || 
					computation.getRamSize().equals("2GB - 4GB")) {
				computation.setOsArchitecture("32 bit");
			} else {
				computation.setOsArchitecture("64 bit");
			}
			
			//set default GPU
			if (computation.getGpu().equals("null")) {
				computation.setGpu("No");
			}
			
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("computation", computation);
			
			return SUCCESS;
			
			/*//generate ARI
			if(this.generateARI() == true){
				return SUCCESS;
			}else{
				return ERROR;
			}*/
		}
		
	}

	@Override
	public ComputationARI getModel() {
		return computation;
	}
	
}
