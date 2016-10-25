package com.geni.beans;

public class NetworkARI {
	private String bandwidth;// 10Mbps, 20Mbps, 1Gbps, 10Gbps, and 100Gbps
	private String isolated;
	private String layer;	// layer 2, layer 3, and all (mapped to isolated network)
	private String ip;
	private String nfv;
	private String networkType;	// SDN or Wired

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}
	
	public String getIsolated() {
		return isolated;
	}

	public void setIsolated(String isolated) {
		this.isolated = isolated;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public String getNfv() {
		return nfv;
	}

	public void setNfv(String nfv) {
		this.nfv = nfv;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

}
