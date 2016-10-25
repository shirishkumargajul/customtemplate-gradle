package com.geni.services;

import java.util.ArrayList;
import java.util.List;

import com.geni.beans.MacroOperator;

import Dao.MacroOperatorDao;
import Dao.ResourceSpaceDao;

public class MacroOperatorService {
	private MacroOperator mo;
	private MacroOperatorDao mod;
	private ResourceSpaceDao rsd = new ResourceSpaceDao();
	
	public MacroOperatorService() {
		this.mo = new MacroOperator();
		this.mod = new MacroOperatorDao();
	}

	// public MacroOperatorService(int apprId){
	// setMo(new MacroOperator());
	// setMod(new MacroOperatorDao());
	// this.MacroOperatorGeneration(apprId);
	// }

	public boolean MacroOperatorGeneration(String apprId) {
		String ack = null;

		List<List<String>> tempPreconditionFeaturesList = new ArrayList<List<String>>();
		String resourceClass = null;
		String resource = null;
		if (mod.getDataFromARI(apprid)(apprId).equals("SUCCESS")) {
			tempPreconditionFeaturesList = mod.getPreconditionFeaturesList();
			for (int i = 0; i < tempPreconditionFeaturesList.size(); i++) {
				String[] features = tempPreconditionFeaturesList.get(i).get(0)
						.split(",");
				if (features.length > 1) {
					for (int j = 0; j < features.length; j++) {
						if (j == 0) {
							mo.setDomain(features[0]);
						} else {
							resourceClass = features[j];
							mo.setResource(resource = rsd.findRealResource(mo.getDomain(), resourceClass).size() != 0 ? resourceClass : null);
							mo.setPrecondition(tempPreconditionFeaturesList
									.get(i).get(1));
							mo.setApplicationIdentifie(apprId);
							mod.insertMacroOperator2Database(mo);
						}
					}
				} else if (features.length == 1) {
					mo.setDomain(features[0]);
					mo.setResource(null);
					mo.setPrecondition(tempPreconditionFeaturesList.get(i).get(
							1));
					mo.setApplicationIdentifie(apprId);
					mod.insertMacroOperator2Database(mo);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public MacroOperator getMo() {
		return mo;
	}

	public void setMo(MacroOperator mo) {
		this.mo = mo;
	}

	public MacroOperatorDao getMod() {
		return mod;
	}

	public void setMod(MacroOperatorDao mod) {
		this.mod = mod;
	}
}
