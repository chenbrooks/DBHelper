/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Mysql;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tester.brooks.mysqlhelper.Entry.TableHelper;

/**
 *
 * @author chenbin
 */
public class MysqlTable extends TableHelper
{
    Connection connection;
    String tablename;
    
    public MysqlTable(String tablename)
    {
	super();
	this.tablename = tablename;
    }
    
    public MysqlTable(String tablename, Connection connection)
    {
	super();
	this.tablename = tablename;
	this.connection = connection;
	this.processFields();
    }
    
    public void processFields()
    {
	try {
	    Statement statement = this.connection.createStatement();
//	    System.out.println("process with table: " + tablename);
	    ResultSet resultSet = statement.executeQuery("desc " + this.tablename);
	    while(resultSet.next())
	    {
		MysqlField mysqlField = new MysqlField(resultSet.getString("Field"), 
			resultSet.getString("Type"),
			resultSet.getString("Null"));
//		System.out.print("\t" + resultSet.getString("Field") + "\t");
//		System.out.print("\t" + resultSet.getString("TYpe") + "\t");
//		System.out.print("\t" + resultSet.getString("Null") + "\t");
//		System.out.println("");
		fields.put(resultSet.getString("Field"), mysqlField);
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(MysqlTable.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public String getTableName() {
	return this.tablename;
    }
    
    @Override
    public String getTablePreName() {
	String[] name = this.tablename.split("_");
	return name[0];
    }

    @Override
    public String getTableRawName() {
	return this.tablename.substring(this.tablename.indexOf("_"));
    }
    
    
    
    
    
    
    
}