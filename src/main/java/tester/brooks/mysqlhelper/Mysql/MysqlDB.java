/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tester.brooks.mysqlhelper.Entry.DBHelper;

/**
 *
 * @author chenbin
 */
public class MysqlDB extends DBHelper
{
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/devuch";
    String username = "root";
    String password = "root";
    Connection connection;
    
    public MysqlDB()
    {
	super(null, null);
	this.connect();
    }
    
    public MysqlDB(String host, String dbname, String username, String password)
    {
	super(dbname, "");
	this.username = username;
	this.password = password;
	this.url = "jdbc:mysql://" + host + ":3306/" + dbname;
	this.connect();
	this.processTables();
    }
    
    public MysqlDB(String host, String dbname, String tbprename, String username, String password)
    {
	
	super(dbname, tbprename);
	this.username = username;
	this.password = password;
	this.url = "jdbc:mysql://" + host + ":3306/" + dbname;
	this.connect();
	this.processTables();
    }
    
    public void connect()
    {
	try {
	    Class.forName(this.driver);
	    connection = (Connection) DriverManager.getConnection(this.url, this.username, this.password);
	} catch (ClassNotFoundException | SQLException ex) {
	    Logger.getLogger(MysqlDB.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    //public ArrayList<MysqlTable> getTables()
    public void processTables()
    { 
	try {
	    Statement statement = this.connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("show tables");
	    while(resultSet.next())
	    {
		//System.out.println(resultSet.getString(1));
		String tablename = resultSet.getString(1);
		MysqlTable table = new MysqlTable(tablename, this.connection);
		tables.put(this.getRawTableName(tablename), table);
	    }
	    
	    //System.err.println(resultSet.toString());
	} catch (SQLException ex) {
	    Logger.getLogger(MysqlDB.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
    
    
}
