/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper.Mysql;

import tester.brooks.mysqlhelper.Entry.FieldHelper;

/**
 *
 * @author chenbin
 */
public class MysqlField extends FieldHelper
{
    public MysqlField() {
	super();
    }
    public MysqlField(String name, String type, String isnull) {
	super(name, type, isnull);
    }
}
