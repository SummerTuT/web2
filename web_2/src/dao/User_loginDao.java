package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tools.DatabaseConnection;
import vo.User;


public class User_loginDao {
	public User getUser(String username ) throws Exception{
		User use=null;
		try{
			DatabaseConnection dbc=new DatabaseConnection();
			
			String sql="select *from t_user where userName=?";
			Connection con=dbc.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,username);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				use=new User(rs.getString("userName"),
								rs.getString("password"),
								rs.getString("chrName"));
				
			}
			//关闭连接
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return use;
	}
	
	public User getUserByChrName(String username ) throws Exception{
		User use=null;
		try{
			DatabaseConnection dbc=new DatabaseConnection();
			
			String sql="select *from t_user where chrName=?";
			Connection con=dbc.getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,username);
			ResultSet rs=pst.executeQuery();
			if(rs.next()){
				use=new User(rs.getString("userName"),
								rs.getString("password"),
								rs.getString("chrName"));
				
			}
			//关闭连接
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return use;
	}
}
