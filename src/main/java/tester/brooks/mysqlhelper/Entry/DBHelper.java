/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chenbin
 */
public class DBHelper 
{
    public String dbname;
    public String tbpre;
    public Map<String, TableHelper> tables;
    
    public DBHelper(String dbname, String tbprename)
    {
	this.dbname = dbname;
	this.tbpre = tbprename;
	tables = new HashMap<>();
    }

    public Map<String, TableHelper> getTables() {
	return tables;
    }

    public void setTables(Map<String, TableHelper> tables) {
	this.tables = tables;
    }
    
    public String getRawTableName(String tablename)
    {
	return tablename.replace(this.tbpre, "");
    }
    
    
	    
}
