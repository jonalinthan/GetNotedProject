/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

/**
 *
 * @author aaronmeltzer
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

/**
 * 
 *@author Jessica 
 */
public class ConnectionManager 
{
	public static final String DATABASE_URL = "jdbc:mysql://mysql1.cs.stonybrook.edu:3306/";
	public static final String DATABASE_USERNAME = "ntagliasacch";
	public static final String DATABASE_PASSWORD = "106474408";
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	
Connection connection;

	private ConnectionManager()
	{
		loadDriver();
		connection = null;
		connection = getConnection();

	}
	private static ConnectionManager manager;

	public static ConnectionManager getManager()
	{
		if(manager == null)
		{
			manager = new ConnectionManager();
			System.out.println("Connection has been established");
		}


		return manager;
	}

	public void loadDriver()
	{
		try
		{
			Class.forName(MYSQL_DRIVER).newInstance();
			System.out.println("Driver loaded");

		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not loaded");
		}
		catch (InstantiationException e){ e.printStackTrace(); } 
		catch (IllegalAccessException e){ e.printStackTrace(); } 
	}


	public Connection getConnection()
	{
		if(connection == null)
		{

			try 
			{
				connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
				System.out.println("Connection has been established");
			} catch (SQLException ex) {
				System.out.println("Connection has failed");
				ex.printStackTrace();
			}
			return connection;
		}else
		{

			return connection;
		}
	}


	public void closeConnection(){
		try {
			connection.close();
			System.out.println("Connection has been closed");
		} catch (SQLException e) {
			System.out.println("Close connection did not work");
			e.printStackTrace();
		}
	}

         public boolean checkUser(String name, String pass){
            try
		{
			Statement statement = ConnectionManager.getManager().getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT username, password FROM Accounts WHERE username= '"
                               + name + "' AND password ='" + pass + "'");
			
                        //Checks whether results set is empty.
                        if(rs.first()){
                            //Checks if username and password is correct.
                           if(rs.getString(1).equalsIgnoreCase(name)&&rs.getString(2).equals(pass)){
                               return true; 
                           } else return false;
                        }
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Invalid User.");
			e.printStackTrace();
		}
            return false;
        }

}

