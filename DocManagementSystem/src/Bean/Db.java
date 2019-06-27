
package Bean;


import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;




public class Db {
	
	public  Connection connection;
	  String urlString ="jdbc:mysql://localhost:3306/docmanagement"; ;
	  String userString ="root" ;
	  String passString =  "_tOBHuDry7-v";
	  String driver =  "com.mysql.jdbc.Driver";
	Statement statement;
	PreparedStatement pStatement;
	ResultSet rs;
	public Db()
	{
		
	this.conn();
		
	}
	public  void conn()
	{
		try {
			Class.forName(driver);
			
			connection = DriverManager.getConnection(urlString, userString, passString);
			
			if(!connection.isClosed())
			{
				System.out.print("连接成功");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void is_ok()
	{
		try {
			if(connection==null||connection.isClosed())
			{
				this.conn();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void insertuser(String userid,String userpass)
	{
		String sqlString = String.format("insert into user (userid,password) values ('%s','%s')",userid,userpass);
		System.out.println(sqlString);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlString);
			statement.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public String querryPass(String userid)
	{
		ResultSet rSet;
		String reString = null;
		is_ok();
		String sqlString = "select password from user where userid = '"+userid+"'";
		System.out.println(sqlString);
		try {
			 statement = connection.createStatement();
			rSet = statement.executeQuery(sqlString);
			if(rSet.first())
			{
				
				reString =  rSet.getString("password");
				rSet.close();
			}
			statement.close();
			rSet.close();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reString;
	}
	public int getdocnums()
	{
		is_ok();
		int re = 0;
		String sqlString = "select count(*) from docinf";
		try {
			Statement statement = connection.createStatement();
			ResultSet rsResultSet = statement.executeQuery(sqlString);
			rsResultSet.first();
			re =  rsResultSet.getInt(1);
			statement.close();
			rsResultSet.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
		
		
	}
	public  HashMap<String, HashSet<String>> querryrole()
	{
		String sqlString = "select * from roleuser";
		HashMap<String, HashSet<String>> hashMap = new HashMap<>();
		try {
			is_ok();
			statement = connection.createStatement();
			ResultSet rSet =  statement.executeQuery(sqlString);
			while(rSet.next())
			{
				
				String useridString = rSet.getString("userid");
				String roleString = rSet.getString("role");
				//System.out.print(useridString);
				if(hashMap.containsKey(useridString))
				{
					HashSet<String> set = hashMap.get(useridString);
					set.add(roleString);
					hashMap.put(useridString, set);
					
				}
				else {
					HashSet<String> set = new HashSet<>();
					set.add(roleString);
					hashMap.put(useridString, set);
				}
				
			}
			rSet.close();
			statement.close();
			return hashMap;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

		
	}
	public void Insertdocinf(String userid,String title,String main,String path)
	{
		is_ok();
		String sqlString  =String.format("insert into docinf (userid,title,main,path) values (%s,%s,%s,%s)",
				"'"+userid+"'","'"+title+"'","'"+main+"'","'"+path+"'");
		System.out.println(sqlString);
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqlString);
			statement.close();
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void delete(String filepath)
	{
		String sqlString = String.format("delete from docinf where path='%s'",filepath);
		System.out.println(sqlString);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(sqlString);
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public ArrayList<DocInf> getDividePages(int start,int end)
	{
		ArrayList<DocInf> reArrayList = new ArrayList<>();
		String sqlString = String.format("select * from docinf LIMIT %d,%d", start,5);
		System.out.println(sqlString);
		try {
			 statement = connection.createStatement();
			rs = statement.executeQuery(sqlString);
			while(rs.next())
			{
				String useridString =rs.getString("userid");
				String titleString = rs.getString("title");
				String mainString = rs.getString("main");
				String pathString = rs.getString("path");
				DocInf docInf = new DocInf(useridString,titleString,mainString,pathString);
				reArrayList.add(docInf);	
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reArrayList;
	}
	public static void main(String[] args) {
		Db db = new Db();
		//String sqlString = "select * from roleuser";
		//db.querryrole();
		//administrator
		//System.err.println(db.querryPass("administrator"));
		//db.Insertdocinf("administrator", "1", "1", "1");
//		ArrayList<DocInf> reArrayList =db.getDividePages(0, 5);
//		for(DocInf tempDocInf:reArrayList)
//		{
//			System.out.println(tempDocInf.getTitle());
//		}
//		
		System.out.println(db.getdocnums());
	}

}
