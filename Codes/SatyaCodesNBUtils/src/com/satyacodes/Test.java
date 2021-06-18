/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.satyacodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) throws Exception {

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://swingdb.mdb");
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from login");
        System.out.println("ID \t | Name \t |  PASSWD");
        System.out.println("----------------------------------");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t | " + rs.getString(2) + " \t |  " + rs.getString(3) + "");
        }
    }
}
