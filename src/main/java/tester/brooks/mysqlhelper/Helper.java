/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tester.brooks.mysqlhelper;

import tester.brooks.mysqlhelper.Mysql.MysqlDB;

/**
 *
 * @author chenbin
 */
public class Helper 
{
    public static void main(String[] args) {
	MysqlDB mysqlJDBC1 = new MysqlDB("127.0.0.1", "bbase", "bb", "root", "root");
	MysqlDB mysqlJDBC2 = new MysqlDB("127.0.0.1", "xxbase", "bb", "root", "root");
	StructComparer comparer = new StructComparer(mysqlJDBC1, mysqlJDBC2);
	comparer.printResult();
    }
}
