package com.geni.beans;

public class StorageARI {

	private String localStorageSize;
	private String localStorageDisk; 	// HDD , SSD
	private String remoteStorage;		// yes or no
	private String remoteStorageSize;
	private String remoteStorageLocation;	// storage geo location if storage type is remote
	private String remoteStorageDisk; 	// HDD, SSD
	
	public String getLocalStorageSize() {
		return localStorageSize;
	}
	public void setLocalStorageSize(String localStorageSize) {
		this.localStorageSize = localStorageSize;
	}
	public String getLocalStorageDisk() {
		return localStorageDisk;
	}
	public void setLocalStorageDisk(String localStorageDisk) {
		this.localStorageDisk = localStorageDisk;
	}
	public String getRemoteStorage() {
		return remoteStorage;
	}
	public void setRemoteStorage(String remoteStorage) {
		this.remoteStorage = remoteStorage;
	}
	public String getRemoteStorageSize() {
		return remoteStorageSize;
	}
	public void setRemoteStorageSize(String remoteStorageSize) {
		this.remoteStorageSize = remoteStorageSize;
	}
	public String getRemoteStorageLocation() {
		return remoteStorageLocation;
	}
	public void setRemoteStorageLocation(String remoteStorageLocation) {
		this.remoteStorageLocation = remoteStorageLocation;
	}
	public String getRemoteStorageDisk() {
		return remoteStorageDisk;
	}
	public void setRemoteStorageDisk(String remoteStorageDisk) {
		this.remoteStorageDisk = remoteStorageDisk;
	}

	

}
