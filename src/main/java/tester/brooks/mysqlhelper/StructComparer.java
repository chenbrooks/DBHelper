/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper;

import com.mysql.jdbc.Field;
import java.util.ArrayList;
import java.util.Map;
import tester.brooks.mysqlhelper.Entry.DBHelper;
import tester.brooks.mysqlhelper.Entry.FieldHelper;
import tester.brooks.mysqlhelper.Entry.TableHelper;

/**
 *
 * @author chenbin
 */
public class StructComparer 
{
    DBHelper sourceDB;
    DBHelper targetDB;
    ArrayList<TableOutput> outs;
    public StructComparer()
    {
	
    }
    
    public StructComparer(DBHelper sourceDBHelper, DBHelper targetDBHelper)
    {
	outs = new ArrayList<>();
	this.sourceDB = sourceDBHelper;
	this.targetDB = targetDBHelper;
	this.compare();
    }
    
    public void compare()
    {
	Map<String, TableHelper> sourcetables = sourceDB.getTables();
	Map<String, TableHelper> targettables = targetDB.getTables();
	
	
	for(Map.Entry<String, TableHelper> tableItem : sourcetables.entrySet())
	{
	    TableHelper table = tableItem.getValue();
	    TableOutput out = new TableOutput();
	    out.setLefttbname(table.getTableName());
	    boolean checkTable = targettables.containsKey(tableItem.getKey());
	    String righttable = "未找到匹配项";
	    if(checkTable)
	    {
		righttable = targettables.get(tableItem.getKey()).getTableName();
		Map<String, FieldHelper> sourcefields = table.getFields();
		Map<String, FieldHelper> targetfields = targettables.get(tableItem.getKey()).getFields();
		ArrayList<FieldOutput> fields = new ArrayList<>();
		for(Map.Entry<String, FieldHelper> fieldItem : sourcefields.entrySet())
		{
		    FieldOutput fieldOutput = new FieldOutput();
		    fieldOutput.setSourcefield(fieldItem.getValue().getFieldname());
		    boolean checkField = targetfields.containsKey(fieldItem.getKey());
		    String rightfield = "未打到匹配项";
		    if(checkField)
		    {
			rightfield = (targetfields.get(fieldItem.getKey()).getFieldname());
		    }
		    fieldOutput.setTargetfield(rightfield);
		    fieldOutput.setFieldresult(checkField);
		    fields.add(fieldOutput);
		}
		out.setFieldOutputs(fields);
	    }
	    out.setTableresult(checkTable);
	    out.setRighttbname(righttable);
	    outs.add(out);
	    
	}
    }

    public DBHelper getSourceDB() {
	return sourceDB;
    }

    public void setSourceDB(DBHelper sourceDB) {
	this.sourceDB = sourceDB;
    }

    public DBHelper getTargetDB() {
	return targetDB;
    }

    public void setTargetDB(DBHelper targetDB) {
	this.targetDB = targetDB;
    }

    public ArrayList<TableOutput> getOuts() {
	return outs;
    }

    public void setOuts(ArrayList<TableOutput> outs) {
	this.outs = outs;
    }
    
    public void printResult() {
	for(TableOutput out : this.outs)
	{
	    out.print();
	}
    }
    
    
}

class TableOutput
{
    String sourcetable;
    String targettable;
    boolean tableresult;
    ArrayList<FieldOutput> fieldOutputs;

    public void print()
    {
	System.out.println("==========");
	System.out.println(getLefttbname() + " : " + getRighttbname() + " ? " + getTableresult());
	if(getTableresult())
	{
	    for(FieldOutput fieldOutput : fieldOutputs)
	    {
		System.out.println("\t" + fieldOutput.getSourcefield() + " : " + 
			fieldOutput.getTargetfield() + " ? " + fieldOutput.isFieldresult());
	    }
	}
    }

    public String getLefttbname() {
	return sourcetable;
    }

    public void setLefttbname(String lefttbname) {
	this.sourcetable = lefttbname;
    }

    public String getRighttbname() {
	return targettable;
    }

    public void setRighttbname(String righttbname) {
	this.targettable = righttbname;
    }

    public boolean getTableresult() {
	return tableresult;
    }

    public void setTableresult(boolean tableresult) {
	this.tableresult = tableresult;
    }  

    public ArrayList<FieldOutput> getFieldOutputs() {
	return fieldOutputs;
    }

    public void setFieldOutputs(ArrayList<FieldOutput> fieldOutputs) {
	this.fieldOutputs = fieldOutputs;
    }
    
    
}

class FieldOutput
{
    String sourcefield;
    String targetfield;
    boolean fieldresult;

    public String getSourcefield() {
	return sourcefield;
    }

    public void setSourcefield(String sourcefield) {
	this.sourcefield = sourcefield;
    }

    public String getTargetfield() {
	return targetfield;
    }

    public void setTargetfield(String targetfield) {
	this.targetfield = targetfield;
    }

    public boolean isFieldresult() {
	return fieldresult;
    }

    public void setFieldresult(boolean fieldresult) {
	this.fieldresult = fieldresult;
    }
    
    
}