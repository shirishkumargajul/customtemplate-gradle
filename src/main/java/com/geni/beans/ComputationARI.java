package com.geni.beans;

public class ComputationARI {

	private String noOfNodes;
	private String noOfCores; // no. of VM or cores
	private String operatingSystem; // Windows Server 2008R2, Windows Server 7,
	private String osArchitecture;
	private String dedicatedServer;
	private String ramSize; 		// size of the ram in Mb or Gb
	private String gpu;				//yes or no
	private String gpuSize;	 			// need gpu or not
	
	
	public String getNoOfNodes() {
		return noOfNodes;
	}
	public void setNoOfNodes(String noOfNodes) {
		this.noOfNodes = noOfNodes;
	}
	public String getNoOfCores() {
		return noOfCores;
	}
	public void setNoOfCores(String noOfCores) {
		this.noOfCores = noOfCores;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getOsArchitecture() {
		return osArchitecture;
	}
	public void setOsArchitecture(String osArchitecture) {
		this.osArchitecture = osArchitecture;
	}
	public String getDedicatedServer() {
		return dedicatedServer;
	}
	public void setDedicatedServer(String dedicatedServer) {
		this.dedicatedServer = dedicatedServer;
	}
	public String getRamSize() {
		return ramSize;
	}
	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getGpuSize() {
		return gpuSize;
	}
	public void setGpuSize(String gpuSize) {
		this.gpuSize = gpuSize;
	}


}
