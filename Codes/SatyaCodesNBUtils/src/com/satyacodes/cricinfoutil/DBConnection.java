package com.satyacodes.cricinfoutil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author KavetiS
 */
public class DBConnection {

    public static Properties loadPropertiesFile() throws Exception {
        Properties prop = new Properties();
        InputStream in = new FileInputStream("resources/cricinfo/db.properties");
        prop.load(in);
        in.close();
        return prop;
    }
    

    

    public static Connection getConnection() throws Exception {
        Properties prop = loadPropertiesFile();
        String driverClass = prop.getProperty("mysql.driver");
        String url = prop.getProperty("mysql.url");
        String username = prop.getProperty("mysql.username");
        String password = prop.getProperty("mysql.password");

        Class.forName(driverClass);
        Connection con = DriverManager.getConnection(url, username, password);

        if (con != null) {
            System.out.println("Connection SUccess " + con);
        } else {
            System.out.println("Connection Failed " + con);
        }
        return con;
    }



    public static void main(String[] args) throws Exception {
    	 Connection con = getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select * from user");
         System.out.println("ID \t | Name \t |  PASSWD");
         System.out.println("----------------------------------");
         while (rs.next()) {
             System.out.println(rs.getString(1) + "\t | " + rs.getString(2) + " \t |  " + rs.getString(3) + "");
         }
    }
}