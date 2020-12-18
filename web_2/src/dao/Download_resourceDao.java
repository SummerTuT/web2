package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tools.DatabaseConnection;
import vo.resource;

public class Download_resourceDao {
	
	public ArrayList<resource> getResourcesList() throws Exception{
		 ArrayList<resource> list=new ArrayList<resource>();
		 resource res=new resource();
		 try{
			 DatabaseConnection dbc=new DatabaseConnection();
			 Connection con=dbc.getConnection();
			 String sql="select * from t_downloadlist";
			 PreparedStatement pst=con.prepareStatement(sql);
			 ResultSet rst=pst.executeQuery();
			 while(rst.next()){
				 res=new resource(rst.getInt("resourceId"),
						 			rst.getString("resourceName"),
						 			rst.getString("url"),
						 			rst.getString("description"),
						 			rst.getInt("size"),
						 			rst.getInt("star"),
						 			rst.getString("image"),
						 			rst.getString("time"));
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
