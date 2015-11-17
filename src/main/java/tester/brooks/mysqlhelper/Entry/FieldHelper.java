/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Entry;
/**
 *
 * @author chenbin
 */
public class FieldHelper 
{
    public String fieldname;
    public String fieldtype;
    public String isnull;
    public FieldHelper() {
    }
    public FieldHelper(String name, String type, String isnull) {
	this.setFieldname(name);
	this.setFieldtype(type);
	this.setIsnull(isnull);
    }

    public String getFieldname() {
	return fieldname;
    }

    public void setFieldname(String fieldname) {
	this.fieldname = fieldname;
    }

    public String getFieldtype() {
	return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
	this.fieldtype = fieldtype;
    }

    public String getIsnull() {
	return isnull;
    }

    public void setIsnull(String isnull) {
	this.isnull = isnull;
    }
}
