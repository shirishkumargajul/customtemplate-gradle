package com.geni.actions;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.GeneralARI;
import com.geni.beans.StorageARI;
import com.geni.services.PrePopulateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StorageRequirement extends ActionSupport implements ModelDriven<StorageARI>{

	private static final long serialVersionUID = 1L;
	
	private StorageARI storage = new StorageARI();
	private List<String> storageSizeList;
	private List<String> storageDiskList;
	private List<String> yesOrNoList;
	
	public StorageARI getStorage() {
		return storage;
	}
	public void setStorage(StorageARI storage) {
		this.storage = storage;
	}
	public List<String> getStorageSizeList() {
		return storageSizeList;
	}
	public void setStorageSizeList(List<String> storageSizeList) {
		this.storageSizeList = storageSizeList;
	}
	public List<String> getStorageDiskList() {
		return storageDiskList;
	}
	public void setStorageDiskList(List<String> storageDiskList) {
		this.storageDiskList = storageDiskList;
	}
	public List<String> getYesOrNoList() {
		return yesOrNoList;
	}
	public void setYesOrNoList(List<String> yesOrNoList) {
		this.yesOrNoList = yesOrNoList;
	}
	
	public StorageRequirement() {
		storageSizeList = new ArrayList<String>();
		storageSizeList.add(getText("storageSizeList.opt1"));
		storageSizeList.add(getText("storageSizeList.opt2"));
		storageSizeList.add(getText("storageSizeList.opt3"));
		storageSizeList.add(getText("storageSizeList.opt4"));
		storageSizeList.add(getText("storageSizeList.opt5"));
		storageSizeList.add(getText("storageSizeList.opt6"));
		storageSizeList.add(getText("storageSizeList.opt7"));
		storageSizeList.add(getText("storageSizeList.opt8"));
		storageSizeList.add(getText("storageSizeList.opt9"));
		storageSizeList.add(getText("list.unknown"));
		
		storageDiskList = new ArrayList<String>();
		storageDiskList.add(getText("storageDiskList.hdd"));
		storageDiskList.add(getText("storageDiskList.ssd"));
		storageDiskList.add(getText("list.unknown"));
		
		yesOrNoList = new ArrayList<String>();
		yesOrNoList.add(getText("list.yes"));
		yesOrNoList.add(getText("list.no"));
		yesOrNoList.add(getText("list.unknown"));
	}
	
	/*public String getDefaultStorageSize() {
		return getText("storageSizeList.opt1");
	}
	
	public String getDefaultStorageDisk() {
		return getText("storageDiskList.hdd");
	}
	
	public String getDefaultRemoteStorage() {
		return getText("list.no");
	}*/
	
	public boolean isValid() {
		boolean val = true;
		if (storage.getLocalStorageDisk().equals("null")) {
			addFieldError("localStorageSize", getText("error.storageSize"));
			val = false;
		}
		if (storage.getLocalStorageDisk().equals("null")) {
			addFieldError("localStorageDisk", getText("error.storageDisk"));
			val = false;
		}
		if (storage.getRemoteStorage().equals("null")) {
			addFieldError("remoteStorage", getText("error.remoteStorage"));
			val = false;
		}
		
		if (storage.getRemoteStorage().equals("Yes")) {
			if (storage.getRemoteStorageSize().equals("null")) {
				addFieldError("remoteStorageSize", getText("error."));
				val = false;
			}
			if (storage.getRemoteStorageDisk().equals("null")) {
				addFieldError("remoteStorageDisk", getText("error."));
				val = false;
			}
			if (storage.getRemoteStorageLocation().equals("null")) {
				addFieldError("remoteStorageLocation", getText("error."));
				val = false;
			}
		}
		return val;
	}
	
	public String display() {
		ActionContext ctx = ActionContext.getContext();
		GeneralARI general = (GeneralARI) ctx.getSession().get("general");
		StorageARI storage = PrePopulateService.getStorageReq(general);
		if (storage != null) {
			this.storage.setLocalStorageSize(storage.getLocalStorageSize());
			this.storage.setLocalStorageDisk(storage.getLocalStorageDisk());
			this.storage.setRemoteStorage(storage.getRemoteStorage());
		}
		return NONE;
	}

	public String setStorageReq() {
		
		if (!isValid()) {
			return INPUT;
		} else {
			System.out.println(storage.getLocalStorageSize());
			System.out.println(storage.getLocalStorageDisk());
			System.out.println(storage.getRemoteStorage());
			System.out.println();
			System.out.println();
			System.out.println();
			
			String unknownVal = getText("list.unknown");
			//set default local storage disk type
			if (storage.getLocalStorageDisk().equals(unknownVal)) {
				storage.setLocalStorageDisk(getText("storageDiskList.hdd"));
			}
			
			//set default remote storage
			if (storage.getRemoteStorage().equals(unknownVal)) {
				storage.setRemoteStorage(getText("list.no"));
			}
			
			
			ActionContext ctx = ActionContext.getContext();
			ctx.getSession().put("storage", storage);
			
			return SUCCESS;
		}
	}

	@Override
	public StorageARI getModel() {
		return storage;
	}
}
