package Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.geni.beans.*;
import com.mysql.jdbc.*;

import utility.MysqlJdbc;
public class MacroOperatorDao {
	//MacroOperator macro = new MacroOperator();
	private MacroOperator macro;
	private List<List<String>> preconditionFeaturesList;
	
	public String getDataFromARI(int apprid){
		List<List<String>> tempPreconditionFeaturesList = new ArrayList<List<String>>();
		//List<Integer> tempApprid = new ArrayList<Integer>();
		String Flag = "ERROR";
		Connection connection = MysqlJdbc.getConnection();
		Statement stmt = null;
		try{
			
			String sql = "select * from applicationri where apprid = '" + apprid +"'";
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
				while(rs.next()){
					List<String> onePreconditionFeaturesPair = new ArrayList<String>();
					onePreconditionFeaturesPair.add(rs.getString("features"));
					onePreconditionFeaturesPair.add(rs.getString("precondition"));
					//print the data we received
					System.out.println("feautures = " + rs.getString("features"));
					System.out.println("precondition = " + rs.getString("precondition"));
					
					tempPreconditionFeaturesList.add(onePreconditionFeaturesPair);
				}
				setPreconditionFeaturesList(tempPreconditionFeaturesList);
				Flag = "SUCCESS";
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlJdbc.closeConn(stmt, connection);
		}
		//print the data
//		for(int i = 0; i < tempPreconditionFeaturesList.size();i++){
//			System.out.println(i + " = " + tempPreconditionFeaturesList.get(i).get(0) + " || " + tempPreconditionFeaturesList.get(i).get(1));	
//		}
		return Flag;	
	}
	
	public void insertMacroOperator2Database(MacroOperator mo){
		setMacro(mo);
		//print data waiting to insert
		System.out.println(macro.getApplicationIdentifie() + " || " + macro.getDomain() + " || " + macro.getResource() + " || " + macro.getPrecondition());
		Connection connection = MysqlJdbc.getConnection();
		PreparedStatement pstmt = null;
		try{
			
			String sql = "insert into macroperators(domain,resource,precondition,totalCost,ApplicationIdentifie) values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, macro.getDomain());
			pstmt.setString(2, macro.getResource());
			pstmt.setString(3, macro.getPrecondition());
			pstmt.setFloat(4, (float) 0.0);
			pstmt.setInt(5, macro.getApplicationIdentifie());
			pstmt.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			MysqlJdbc.closeConn(pstmt, connection);
		}
	}
	
	public MacroOperator getMacro() {
		return macro;
	}
	
	public void setMacro(MacroOperator macro) {
		this.macro = macro;
	}
	
	
	public List<List<String>> getPreconditionFeaturesList() {
		return preconditionFeaturesList;
	}
	public void setPreconditionFeaturesList(
			List<List<String>> preconditionFeaturesList) {
		this.preconditionFeaturesList = preconditionFeaturesList;
	}
		
	}

