package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.geni.beans.NetworkARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NetworkRequirement extends ActionSupport implements ModelDriven<NetworkARI> {

	private static final long serialVersionUID = 1L;

	private NetworkARI network = new NetworkARI();
	private List<String> yesOrNoList;
	private List<String> bandwidthList;
	private List<String> ipList;
	private List<String> networkTypeList;

	public NetworkARI getNetwork() {
		return network;
	}

	public void setNetwork(NetworkARI network) {
		this.network = network;
	}

	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}

	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}

	public List<String> getBandwidthList() {
		return bandwidthList;
	}

	public void setBandwidthList(List<String> bandwidthList) {
		this.bandwidthList = bandwidthList;
	}

	public List<String> getIpList() {
		return ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}

	public List<String> getNetworkTypeList() {
		return networkTypeList;
	}

	public void setNetworkTypeList(List<String> networkTypeList) {
		this.networkTypeList = networkTypeList;
	}

	public NetworkRequirement() {
		bandwidthList = new ArrayList<String>();
		bandwidthList.add(getText("bandwidth.opt1"));
		bandwidthList.add(getText("bandwidth.opt2"));
		bandwidthList.add(getText("bandwidth.opt3"));
		bandwidthList.add(getText("bandwidth.opt4"));
		bandwidthList.add(getText("bandwidth.opt5"));
		bandwidthList.add(getText("bandwidth.opt6"));
		bandwidthList.add(getText("list.unknown"));

		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.yes"));
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.unknown"));

		ipList = new ArrayList<String>();
		ipList.add(getText("ip.public"));
		ipList.add(getText("ip.private"));
		ipList.add(getText("list.unknown"));

		networkTypeList = new ArrayList<String>();
		networkTypeList.add(getText("networkType.wired"));
		networkTypeList.add(getText("networkType.sdn"));
		networkTypeList.add(getText("list.unknown"));
	}

/*	public String getDefaultBandwidth() {
		return getText("bandwidth.opt1");
	}

	public String getDefaultIsolated() {
		return getText("list.no");
	}

	public String getDefaultIp() {
		return getText("ip.public");
	}

	public String getDefaultNfv() {
		return getText("list.yes");
	}

	public String getDefaultNetworkType() {
		return getText("networkType.wired");
	}*/

	public boolean isValid() {
		boolean val = true;
		if (network.getBandwidth().equals("null")) {
			addFieldError("bandwidth", getText("error.bandwidth"));
			val = false;
		}
		if (network.getIsolated().equals("null")) {
			addFieldError("isolated", getText("error.isolated"));
			val = false;
		}
		if (network.getIp().equals("null")) {
			addFieldError("ip", getText("error.ip"));
			val = false;
		}
		if (network.getNfv().equals("null")) {
			addFieldError("nfv", getText("error.nfv"));
			val = false;
		}
		if (network.getNetworkType().equals("null")) {
			addFieldError("networkType", getText("error.networkType"));
		}
		if (network.getLayer().equals("null")) {
			addFieldError("layer", getText("error.layer"));
			val = false;
		}
		return val;
	}

	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		NetworkARI network = PrePopulateService.getNetworkReq(general);
		if (network != null) {
			this.network.setBandwidth(network.getBandwidth());
			this.network.setIsolated(network.getIsolated());
			this.network.setLayer(network.getLayer());
			this.network.setIp(network.getIp());
			this.network.setNfv(network.getNfv());
			this.network.setNetworkType(network.getNetworkType());
		}
		return NONE;
	}

	public String setNetworkReq() {

		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(network.getBandwidth());
			System.out.println(network.getIsolated());
			System.out.println(network.getLayer());
			System.out.println(network.getIp());
			System.out.println(network.getNfv());
			System.out.println(network.getNetworkType());

			// set default bandwidth
			String unknownVal = getText("list.unknown");
			if (network.getBandwidth().equals(unknownVal)) {
				network.setBandwidth("10-20Mbps");
			}

			// set default isolated
			if (network.getIsolated().equals(unknownVal)) {
				network.setIsolated("no");
			}

			// set default layer
			if (network.getLayer().equals(unknownVal)) {
				network.setLayer("l3");
			}

			// set default ip
			if (network.getIp().equals(unknownVal)) {
				network.setIp("public");
			}

			// set default nfv
			if (network.getNfv().equals(unknownVal)) {
				network.setNfv("no");
			}

			// set default networkType
			if (network.getNetworkType().equals(unknownVal)) {
				network.setNetworkType("wired");
			}

			// set isolated or vpn and layer
			if (network.getIsolated().equals("yes") || network.getLayer().equals("l2")) {
				network.setLayer("l2");
			} else {
				network.setLayer("l3");
			}

			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("network", network);

			return SUCCESS;
		}
	}

	@Override
	public NetworkARI getModel() {
		return network;
	}

}
