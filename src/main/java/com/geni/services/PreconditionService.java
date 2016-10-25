package com.geni.services;

public class PreconditionService {
	/*private Precondition precondition = new Precondition();
	Precondition_Dao precondition_dao = new Precondition_Dao();


	public Precondition getPrecondition() {
		return precondition;
	}

	public void setPrecondition(Precondition precondition) {
		this.precondition = precondition;
	}

	public Precondition generatePrecondition(String emailID, NetworkARI network, StorageARI storage,
			ComputationARI computation) {
		
		this.getPrecondition().setNetwork_Req_ID(network);
		this.getPrecondition().setStorage_Req_ID(storage);;
		this.getPrecondition().setComputation_Req_ID(computation);
		this.getPrecondition().setUser_ID(emailID);
		
		String ARI_ID = precondition_dao.assignARItoUser(emailID);
		this.getPrecondition().setApprID(ARI_ID);
		return this.getPrecondition();
	}

	public boolean insertPrecondition(Precondition precondition) {
		return precondition_dao.insertPrecondition(precondition);
	}*/
}
