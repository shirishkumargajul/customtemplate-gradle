package com.geni.services;

import com.geni.beans.*;

import Dao.ARI_Dao;

public class ARI_Generation_Service {
	ARI_Dao ARI_Dao = new ARI_Dao();
	
	public String generateARI(String emailId, GeneralARI general, NetworkARI network, StorageARI storage, ComputationARI computation, SoftwareARI software) {
		ApplicationRI ari = new ApplicationRI();
		ari.setUserId(emailId);
		ari.setGeneralARI(general);
		ari.setNetworkARI(network);
		ari.setStorageARI(storage);
		ari.setComputationARI(computation);
		ari.setSoftwareARI(software);
		return ARI_Dao.insertARI(ari);
	}
	
}
