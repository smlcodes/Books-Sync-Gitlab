package com.satyacodes.cricinfoutil;

/**
 * 
 * https://stats.espncricinfo.com/ci/engine/stats/index.html?class=2;filter=advanced;orderby=player;size=200;spanmin1=05+Jan+1988;spanval1=span;template=results;type=allround
 * 
 * 
 * 
 * 
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EspnCricInfoTestStats {
	
	
	
	
	public static void main(String[] args) {
		
		ArrayList<String> urls = getProfileUrls();		
		List<PlayerInfo> playersList = getStats(urls);
		try {
			ExcelGenerator.playersExcelGenerator(playersList, "espnstats_Test");
		} catch (Exception e) {
			System.out.println(" Excel Generation Failed........."+e);
		}
	
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t MATS \t RUNS \t 50's \t 100s \t AVG. \t \t STR. \t \t HIGH \t WICK \t 5WIK \t AVG. \t \t STR. \t \t ECON  \t \t Coun \t \t NAME ");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		
		for(PlayerInfo playerInfo : playersList) {
			System.out.println("\t "+playerInfo.getMat()+" \t "+playerInfo.getRuns()+" \t "+playerInfo.getFiftys()+
					" \t "+playerInfo.getHundrds()+" \t "+playerInfo.getBatAvg()+" \t \t "+playerInfo.getBatStr()+
					" \t \t "+playerInfo.getHigh()+" \t "+playerInfo.getWik()+" \t "+playerInfo.getWik4()+" \t "+playerInfo.getBowAvg()+" \t \t "+playerInfo.getBowAvg()+
					" \t \t "+playerInfo.getBowAvg()+"  \t "+playerInfo.getCountry().trim()+" \t \t "+playerInfo.getName().trim()+" ");
		
		}
		

	}
	
	
	
	

	static ArrayList<String> getProfileUrls() {
	
		Scanner s = null;
		try {
			s = new Scanner(new File("profileurlstest.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();

		return list;

	}
	
	
	
	
	
	
	public static List<PlayerInfo> getStats(ArrayList<String> profileUrls) {
		
		List<PlayerInfo> playersList = new ArrayList<PlayerInfo>();
		FileWriter myWriter = null;
		try {
			myWriter = new FileWriter("errorsUrls.txt");
		} catch (Exception e1) {
			System.out.println(" Error File");
		}
	      
		
		int count = 1;
		for(String url : profileUrls) {
			System.out.println(count+": "+url);
			count++;
		
		PlayerInfo playerInfo = new PlayerInfo();
		
		int	profileId =	Integer.parseInt(url.substring(url.lastIndexOf("/")+1, url.lastIndexOf(".")));
		playerInfo.setProfileId(profileId);
		
		Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect(url).get();
           
            Elements nameDiv = doc.getElementsByClass("ciPlayernametxt");
            for (Element ele : nameDiv) {
            	playerInfo.setName(ele.getElementsByTag("h1").text());  
            	playerInfo.setCountry(ele.getElementsByTag("h3").text());
				
			}            
           
            // String srcValue = imageElement.attr("src");  // exact content value of the attribute   
            Element imageElement = doc.select("img").first();
            String pic = imageElement.absUrl("src");  //absolute URL on src
            playerInfo.setPic(pic);
          
             
          
            
            
				/*
				 * System.out.println("=================================================");
				 * System.out.println("                   BATTING DETAILS               ");
				 * System.out.println("=================================================");
				 */
            
            Element table = doc.select("table[class=engineTable]").get(0);
            Elements rows = table.select("tr");// Select tr’s
       
            /*
             * Elements testsData = rows.get(1).select("td");
            Elements odisData = rows.get(2).select("td");
            Elements t20IsData = rows.get(3).select("td");
            Elements fcsData = rows.get(4).select("td");
            Elements t20sData = rows.get(5).select("td");*/
            
            
            int dataIndex=0;
            int odiIndex = -1;
            for(Element elem :rows ) {
            	
            	//System.out.println(dataIndex+" : "+elem.getAllElements().get(0).text());
            	if(elem.getAllElements().get(0).text().contains("Tests")){
            		odiIndex = dataIndex;
            		break;
            	} 
            	dataIndex++;
            }
            
            
           if( odiIndex != -1) {
            Elements odisData = rows.get(odiIndex).select("td");
           // System.out.println(odisData);
           
            /*
             * Mat	Inns	NO	Runs	HS	Ave	BF	SR	100	50	4s	6s	Ct	St
				1	2		3	4		5	6	7	8	9	10	11	12	13	14
             * odisData.get(1).text()
             */

            playerInfo.setMat(Integer.parseInt(odisData.get(1).text()));
            playerInfo.setBatIngs(Integer.parseInt(   (  (odisData.get(2).text().contains("-")) || (odisData.get(2).text().isEmpty())  ) ? "0" : odisData.get(2).text()   ));
			playerInfo.setNotouts(Integer.parseInt(   (  (odisData.get(3).text().contains("-")) || (odisData.get(3).text().isEmpty())  ) ? "0" : odisData.get(3).text()   ));
			playerInfo.setRuns(Integer.parseInt(   (  (odisData.get(4).text().contains("-")) || (odisData.get(4).text().isEmpty())  ) ? "0" : odisData.get(4).text()   ));
			
			String hs =   (  (odisData.get(5).text().contains("-")) || (odisData.get(5).text().isEmpty())  ) ? "0" : odisData.get(5).text()   ;
			if(hs.contains("*")) {				
				hs = hs.replace("*", "");
			}
			
			playerInfo.setHigh(Integer.parseInt(hs));
			playerInfo.setBatAvg(Float.parseFloat(  (  (odisData.get(6).text().contains("-")) || (odisData.get(6).text().isEmpty())  ) ? "0" : odisData.get(6).text()   ));
			playerInfo.setBatStr(Float.parseFloat(   (  (odisData.get(8).text().contains("-")) || (odisData.get(8).text().isEmpty())  ) ? "0" : odisData.get(8).text()   ));
			playerInfo.setHundrds(Integer.parseInt(  (  (odisData.get(9).text().contains("-")) || (odisData.get(9).text().isEmpty())  ) ? "0" : odisData.get(9).text()   ));		
			playerInfo.setFiftys(Integer.parseInt(   (  (odisData.get(10).text().contains("-")) || (odisData.get(10).text().isEmpty())  ) ? "0" : odisData.get(10).text()   ));
			
			
				/*
				 * 
				 * System.out.println("=================================================");
				 * System.out.println("                   BOWLING DETAILS               ");
				 * System.out.println("=================================================");
				 */
            
             table = doc.select("table[class=engineTable]").get(1);
             rows = table.select("tr");// Select tr’s
            /* testsData = rows.get(1).select("td");            
             t20IsData = rows.get(3).select("td");
             fcsData = rows.get(4).select("td");
             t20sData = rows.get(5).select("td");
             */
            //System.out.println(odisData);
             odisData = rows.get(2).select("td");
			
			
			/*
			 * 	Mat	Inns	Balls	Runs	Wkts	BBI	BBM	Ave	Econ	SR	4w	5w	10W
			 * 	1	2		3		4		5		6	7	8	9		10	11	12	13
			 * 
			 *  * */
             
             
         

			playerInfo.setBowIngs(Integer.parseInt(  (  (odisData.get(2).text().contains("-")) || (odisData.get(2).text().isEmpty())  ) ? "0" : odisData.get(2).text()   ));
            playerInfo.setWik(Integer.parseInt(   (  (odisData.get(5).text().contains("-")) || (odisData.get(5).text().isEmpty())  ) ? "0" : odisData.get(5).text()   ));
			playerInfo.setBowBest(odisData.get(6).text());
			playerInfo.setBowAvg(Float.parseFloat(    (  (odisData.get(8).text().contains("-")) || (odisData.get(8).text().isEmpty())  ) ? "0" : odisData.get(8).text()   ));
			playerInfo.setEcon(Float.parseFloat(   (  (odisData.get(9).text().contains("-")) || (odisData.get(9).text().isEmpty())  ) ? "0" : odisData.get(9).text()   ));
			playerInfo.setBowStr(Float.parseFloat(   (  (odisData.get(10).text().contains("-")) || (odisData.get(10).text().isEmpty())  ) ? "0" : odisData.get(10).text()   ));
            playerInfo.setWik4(Integer.parseInt(   (  (odisData.get(11).text().contains("-")) || (odisData.get(11).text().isEmpty())  ) ? "0" : odisData.get(11).text()   ));
			playerInfo.setWik5(Integer.parseInt(   (  (odisData.get(12).text().contains("-")) || (odisData.get(12).text().isEmpty())  ) ? "0" : odisData.get(12).text()   ));
			
	/*		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t MATS \t RUNS \t 50's \t 100s \t AVG. \t \t STR. \t \t HIGH \t WICK \t 5WIK \t AVG. \t \t STR. \t \t ECON  \t \t Coun \t \t NAME ");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("\t "+playerInfo.getMat()+" \t "+playerInfo.getRuns()+" \t "+playerInfo.getFiftys()+
					" \t "+playerInfo.getHundrds()+" \t "+playerInfo.getBatAvg()+" \t \t "+playerInfo.getBatStr()+
					" \t \t "+playerInfo.getHigh()+" \t "+playerInfo.getWik()+" \t "+playerInfo.getWik4()+" \t "+playerInfo.getBowAvg()+" \t \t "+playerInfo.getBowAvg()+
					" \t \t "+playerInfo.getBowAvg()+"  \t "+playerInfo.getCountry().trim()+" \t \t "+playerInfo.getName().trim()+" ");
			
          
    */       
			playersList.add(playerInfo);
            
           }
            
            

        } catch (Exception e) {
        	try {
				myWriter.append("\n "+url);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            e.printStackTrace();
        }

		
        
     
		
	}
		
		return playersList;
	
	}
	
	
	
	

}
