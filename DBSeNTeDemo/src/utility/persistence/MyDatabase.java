package utility.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MyDatabase {

	private String url;
	private String user;
	private String password;
	private Connection con;
	
	public MyDatabase(String driver, String url, String user, String password) throws SQLException, ClassNotFoundException 
	{
		this.url = url;
		this.user = user;
		this.password = password;
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}
	
	public ArrayList<Object[]> query(String sql) throws SQLException
	{
		ArrayList<Object[]> list = new ArrayList<>();
		//Statement stmt = (Statement) statementElements;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
			Object[] objs=new Object[6];
			objs[0]=rs.getInt(1);
			objs[1]=rs.getString(2);
			objs[2]=rs.getString(3);
			objs[3]=rs.getInt(4);
			objs[4]=rs.getInt(5);
			objs[5]=rs.getBoolean(6);
			list.add(objs);
		}
		return list;
	}
	
	public int update (String sql) throws SQLException
	{
		Statement stmt = con.createStatement();
		stmt.executeQuery(sql);
		return stmt.getUpdateCount();
	}
	
	public int[] updateAll(ArrayList<String> sqlList) throws SQLException
	{
		int[] array = new int[sqlList.size()];
		for (int i=0;i<sqlList.size();i++)
		{
			array[i]= update(sqlList.get(i));
		}
		return array;
	}
}
