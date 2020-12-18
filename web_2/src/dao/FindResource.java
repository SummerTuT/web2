package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tools.DatabaseConnection;
import vo.resource;
import vo.t_resources;

public class FindResource {
	
	public ArrayList<t_resources> find( String  username){
		ArrayList<t_resources> list=new ArrayList<t_resources>();
		 t_resources res=new t_resources();
		 try{
			 DatabaseConnection dbc=new DatabaseConnection();
			 Connection con=dbc.getConnection();
			 String sql="select * from t_resource where resourceId in("
			 		+ "select resourceId from t_role_resource where roleId in("
			 		+ "select roleId from t_user_role where userName in("
			 		+ "select userName from t_user where chrName=?)))";
			 PreparedStatement pst=con.prepareStatement(sql);
			 pst.setString(1,username);
			 ResultSet rst=pst.executeQuery();
			 while(rst.next()){
				 res=new t_resources(rst.getInt("resourceId"),
						 			rst.getString("resourceName"),
						 			rst.getString("url")
						 			);
				 list.add(res);
			 }
			 con.close();
		 }
		 catch(Exception e){
				e.printStackTrace();
			}
		 return list;
	}
}
