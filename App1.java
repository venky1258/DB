package com.myproj.D2;


import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void insertData(Connection con,int id,String bname,float pr) throws SQLException
	{
		String q="insert into books values(?,?,?)";
		try(PreparedStatement ps=con.prepareStatement(q)){
			ps.setInt(1, id);
			ps.setString(2, bname);
			ps.setFloat(3,pr);
			int r=ps.executeUpdate();
			System.out.println(r);			
		}
		
	}
    public static void main( String[] args )
    {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/bdb?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
       insertData(con,12,"qqq",89);
		con.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
    }
}
