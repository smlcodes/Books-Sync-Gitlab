package com.satyacodes.cricinfoutil;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*   // https://stackoverflow.com/questions/2425958/how-to-i-retrieve-an-image-from-a-url-and-store-it-as-a-blob-in-java-google-app
	//String qry = "INSERT INTO odistats (name, country, matches, batInngs, notouts, runs, fifties, hundreads, batBest, batAvg, batStr, bowInngs, wickets, fourWik, fiveWik, bowBest, bowAvg, bowStr, econ, profId, picUrl) VALUES ('Sachin', 'IND', '101', '77', '7', '1766', '12', '1', '122', '28.88', '99.98', '78', '66', '3', '1', '45-5', '33.98', '56.90', '5.08', '12345', 'www.picurl.com');";
 * // (name, country, matches, batInngs, notouts, runs, fifties, hundreads, batBest, batAvg, batStr, 
 * 		1		2		3		4			5		6		7		8			9		10		11
 * 
 * 		bowInngs, wickets, fourWik, fiveWik, bowBest, bowAvg, bowStr, econ, profId, picUrl, picImg)
 * 		12			13		14			15		16		17		18		19	  20	 21		22
 * */


public class StatsDBMain {
	
	
	
public static int savePlayer(PlayerInfo p, String tableName ) throws Exception {
	
	String qry = "INSERT INTO  "+tableName+"  "
			+ " (name, country, matches, batInngs, notouts, runs, fifties, hundreads, batBest, batAvg, batStr,"
			+ " bowInngs, wickets, fourWik, fiveWik, bowBest, bowAvg, bowStr, econ, profId, picUrl, picImg)"
			+ "  values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? "
			+ " , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? ) ";
	Connection con = DBConnection.getConnection();
	
	PreparedStatement st =con.prepareStatement(qry);  
		
	st.setString(1, p.getName());
	st.setString(2, p.getCountry());
	st.setInt(3, p.getMat());
	st.setInt(4, p.getBatIngs());
	st.setInt(5, p.getNotouts());
	st.setInt(6, p.getRuns());
	st.setInt(7, p.getFiftys());
	st.setInt(8, p.getHundrds());
	st.setInt(9, p.getHigh());
	st.setFloat(10, p.getBatAvg());
	st.setFloat(11, p.getBatStr());
	st.setInt(12, p.getBowIngs());
	st.setInt(13, p.getWik());
	st.setInt(14, p.getWik4());
	st.setInt(15, p.getWik5());
	st.setString(16, p.getBowBest());
	st.setFloat(17, p.getBowAvg());
	st.setFloat(18, p.getBowStr());
	st.setFloat(19, p.getEcon());
	st.setInt(20, p.getProfileId());
	st.setString(21, p.getPic());
	
	
	URL url = new URL(p.getPic());
	InputStream input = new BufferedInputStream(url.openStream());
	st.setBinaryStream(22, input);
	
	return st.executeUpdate();
	
}	


	public static void getPlayer() throws Exception {
//Creating a Statement object
		Connection con = DBConnection.getConnection();
		Statement stmt = con.createStatement();
//retrieving the data
		ResultSet rs = stmt.executeQuery("select * from odistats");

		int i = 0;
		System.out.println("Contents of the table");
		while (rs.next()) {
			String name = rs.getString("name");
			System.out.println(name);
			InputStream inputStream = rs.getBinaryStream("picImg");
			byte byteArray[] = new byte[inputStream.available()];
			inputStream.read(byteArray);
			FileOutputStream outPutStream = new FileOutputStream(name.trim()+".jpeg");
			outPutStream.write(byteArray);
			
		}
	}
	
	
	public static void downloadPlayerImage(PlayerInfo p) throws Exception {

		URL url = new URL(p.getPic());
		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		int n = 0;
		while (-1 != (n = in.read(buf))) {
			out.write(buf, 0, n);
		}
		out.close();
		in.close();
		byte[] response = out.toByteArray();
		FileOutputStream fos = new FileOutputStream(p.getProfileId() + ".jpg");
		fos.write(response);
		fos.close();
		System.out.println(p.getPic());

	}

	
	
	public static void main(String[] args) {
		try {
			getPlayer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
