package Dao;

import org.bson.types.ObjectId;

import com.geni.beans.ApplicationRI;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import utility.MongoDB;

public class ARI_Dao {
	//get ARI id from usersappdata
/*	public String getUserIdFromEmail(String emailID){
		String ARI_ID = null;
		Connection conn = MysqlJdbc.getConnection();
		Statement stmt = null;
		try{
			PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("insert into usersapp(email) values(?)");
			ps.setString(1, emailID);
			if(ps.executeUpdate() == 1){
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from usersappdata where email ='"+emailID+"'");
				while(rs.next()){
					//System.out.println(rs.getString("pass"));
					ARI_ID = rs.getString("apprid");
				}
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			MysqlJdbc.closeConn(stmt, conn);
		}
		return ARI_ID;
	}*/
	
	/*//insert generated ARI into table
	public boolean insertARI(ApplicationReqIdentifier ari){
		boolean flag = false;
		Connection conn = MysqlJdbc.getConnection();
		Statement stmt = null;
		try {
			//insert network features and preconditions into tables
			 PreparedStatement ps_network = (PreparedStatement) conn.prepareStatement("insert into applicationri(apprid,precondition,features) values(?,?,?)");
			 ps_network.setString(1,ARI.getApprID());
		     String network_pre = ARI.getNetwork().getLayer();
		     if(ARI.getNetwork().getBandwidth() != null){
		    	 network_pre = network_pre + "," + ARI.getNetwork().getBandwidth();
		     }
		     ps_network.setString(2,network_pre);
		     ps_network.setString(3, "Network"+","+ARI.getNetwork().getResources_type());
		     
		     //insert storage features and preconditions into tables
		     PreparedStatement ps_storage = (PreparedStatement) conn.prepareStatement("insert into applicationri(apprid,precondition,features) values(?,?,?)");
		     ps_storage.setString(1, ARI.getApprID());
		     String storage_pre = ARI.getStorage().getStorage_disk()+","+ARI.getStorage().getStorage_persistent();
		     if(ARI.getStorage().getStorage_size() != null){
		    	 storage_pre = storage_pre + "," + ARI.getStorage().getStorage_size();
		     }
		     ps_storage.setString(2,storage_pre);
		     ps_storage.setString(3, "Storage"+","+ARI.getStorage().getStorage_type());
		     
		     //insert computation features and preconditions into tables
		     PreparedStatement ps_computation = (PreparedStatement) conn.prepareStatement("insert into applicationri(apprid,precondition,features) values(?,?,?)");
		     ps_computation.setString(1, ARI.getApprID());
		     String computation_pre = ARI.getComputation().getOperating_system();
		     if(ARI.getComputation().getProcessor_type() != null){
		    	 computation_pre = computation_pre + "," + ARI.getComputation().getProcessor_type();
		     }
		     if(ARI.getComputation().getSize_RAM() != null){
		    	 computation_pre = computation_pre + "," + ARI.getComputation().getSize_RAM();
		     }
		     ps_computation.setString(2, computation_pre);
		     ps_computation.setString(3, "Computation"+ "," +ARI.getComputation().getServer_type());
		     
		     if(ps_network.executeUpdate() == 1){
		    	 if(ps_storage.executeUpdate() == 1){
		    		 if(ps_computation.executeUpdate() == 1){
		    			 flag = true;
		    		 }
		    	 }
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			MysqlJdbc.closeConn(stmt, conn);
		}
		return flag;
	}*/
	
	public String insertARI(ApplicationRI ari) {
		String ariJson = "{ " +
              "'userId': '" + ari.getUserId() + "',"+
              "'appId': '" + ari.getUserId() + "',"+
              "'services' : " + 
                                         "{general : { " +
                                                              "precondition: 'AppName'," +
                                                              "feature: '" + ari.getGeneralARI().getAppName() +
                                                              "'}"+
                                        
                                         "}}";
		DBObject dbObject = (DBObject)JSON.parse(ariJson);
		DB db = MongoDB.getMongoConnection("local");
		DBCollection collection = db.getCollection("ari");
		collection.insert(dbObject);   
		ObjectId id = (ObjectId) dbObject.get("_id");
		System.out.println(id.toString());
		return id.toString();
		
	}
}
