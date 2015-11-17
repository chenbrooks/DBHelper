/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Entry;

import java.util.HashMap;
import java.util.Map;
import tester.brooks.mysqlhelper.Mysql.MysqlField;

/**
 *
 * @author chenbin
 */
public class TableHelper 
{
    public Map<String, FieldHelper> fields;
    public String getTableName(){ return "";}
    public String getTablePreName(){ return "";}
    public String getTableRawName(){ return "";}

    public TableHelper()
    {
	fields = new HashMap<>();
    }
    public Map<String, FieldHelper> getFields() {
	return fields;
    }

    public void setFields(Map<String, FieldHelper> fields) {
	this.fields = fields;
    }
    
    
}
