package com.satyacodes.cricinfoutil;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Button;
import java.awt.Label;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CricInfoUtilGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtInputProfUrls;
	private JTextField txtOutputXlsx;
	public static JProgressBar progressBar;
	public static JProgressBar progressBar2;
	private JTextField txtdbinputxls;
	private JTextField txtTableName;
	private JTextField profileFileTxt;
	private JTextField urlTxt;
	private JTextField maxPagesTxt;
	JLabel lblStepgrab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CricInfoUtilGUI frame = new CricInfoUtilGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CricInfoUtilGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, -45, 1454, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton testDBBun = new JButton("Test DB Connection");
		testDBBun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = DBConnection.getConnection();
					if (con != null) {
						JOptionPane.showMessageDialog(contentPane, "Connection Success !!");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Connection Failed  !!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, "Connection Failed  !! " + e.getMessage());
				}

			}
		});
		testDBBun.setBounds(602, 28, 193, 50);
		contentPane.add(testDBBun);

		JLabel lblNewLabel = new JLabel("Step 2 :Read Profile links & Convert into Excel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(512, 152, 422, 40);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Profile links file");
		lblNewLabel_1.setBounds(512, 208, 135, 20);
		contentPane.add(lblNewLabel_1);

		txtInputProfUrls = new JTextField();
		txtInputProfUrls.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtInputProfUrls.setText("resources/cricinfo/profileurlstest.txt");
		txtInputProfUrls.setBounds(512, 231, 370, 40);
		contentPane.add(txtInputProfUrls);
		txtInputProfUrls.setColumns(10);

		txtOutputXlsx = new JTextField();
		txtOutputXlsx.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtOutputXlsx.setText("resources/cricinfo/cric.xlsx");
		txtOutputXlsx.setColumns(10);
		txtOutputXlsx.setBounds(512, 327, 370, 40);
		contentPane.add(txtOutputXlsx);

		JLabel lblNewLabel_1_1 = new JLabel("Output File");
		lblNewLabel_1_1.setBounds(512, 304, 135, 20);
		contentPane.add(lblNewLabel_1_1);

		JButton urlsToXlsConvertBtn = new JButton("Covert");
		urlsToXlsConvertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println("============== 1: ");

				String inputTxt = txtInputProfUrls.getText();
				String outputXls = new File(txtOutputXlsx.getText()).getAbsolutePath();

				System.out.println("============== 2: " + inputTxt + ", " + outputXls);

				convertProfilesToXlsx(inputTxt, outputXls, progressBar);

			}
		});
		urlsToXlsConvertBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		urlsToXlsConvertBtn.setBounds(512, 397, 157, 40);
		contentPane.add(urlsToXlsConvertBtn);

		progressBar = new JProgressBar();
		progressBar.setBounds(512, 474, 370, 27);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		contentPane.add(progressBar);

		progressBar2 = new JProgressBar();
		progressBar2.setBounds(1000, 474, 337, 27);
		progressBar2.setValue(0);
		progressBar2.setStringPainted(true);
		contentPane.add(progressBar2);

		JLabel lblStep = new JLabel("Step 3 : Store XLS Data into Database");
		lblStep.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStep.setBounds(1000, 152, 337, 40);
		contentPane.add(lblStep);

		JLabel lblNewLabel_1_2 = new JLabel("Xls file location");
		lblNewLabel_1_2.setBounds(1000, 208, 135, 20);
		contentPane.add(lblNewLabel_1_2);

		txtdbinputxls = new JTextField();
		txtdbinputxls.setText("resources/cricinfo/cric.xlsx");
		txtdbinputxls.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtdbinputxls.setColumns(10);
		txtdbinputxls.setBounds(1000, 231, 337, 40);
		contentPane.add(txtdbinputxls);

		JLabel lblNewLabel_1_2_1 = new JLabel("Table Name");
		lblNewLabel_1_2_1.setBounds(1000, 304, 135, 20);
		contentPane.add(lblNewLabel_1_2_1);

		txtTableName = new JTextField();
		txtTableName.setText("odistats");
		txtTableName.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTableName.setColumns(10);
		txtTableName.setBounds(1000, 333, 337, 40);
		contentPane.add(txtTableName);

		JButton xlsTodbBtn = new JButton("Save to Database");
		xlsTodbBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String inputxls = new File(txtdbinputxls.getText()).getAbsolutePath();
				String tableName = txtTableName.getText();
				try {
					excelRowToPlayerInfo(inputxls, tableName);
					JOptionPane.showMessageDialog(contentPane, " Saving to DB Completed");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, " Saving to DB Failed......." + e.getMessage());
				}

			}
		});
		xlsTodbBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		xlsTodbBtn.setBounds(1000, 397, 225, 40);
		contentPane.add(xlsTodbBtn);

		JButton dbsriptBtn = new JButton("DB Script File");
		dbsriptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String dbScipt = new File("resources/cricinfo/cricdb.txt").getAbsolutePath();
				System.out.println(dbScipt);

				try {
					Desktop.getDesktop().open(new File(dbScipt));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		dbsriptBtn.setBounds(810, 28, 135, 50);
		contentPane.add(dbsriptBtn);

		Label label = new Label("CricCards Data Util");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.BLACK);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Segoe UI", Font.BOLD, 40));
		label.setBounds(33, 10, 462, 88);
		contentPane.add(label);

		JButton btnClearDbTable = new JButton("Clear DB Table");
		btnClearDbTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = DBConnection.getConnection();
					String qry = "delete from " + txtTableName.getText();
					System.out.println(qry);
					int i = con.createStatement().executeUpdate(qry);
					if (i > 0)
						JOptionPane.showMessageDialog(contentPane, "Table Data Cleared !! : ");

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "Table Data Clean Failed  !!" + e1.getCause());
				}

			}
		});
		btnClearDbTable.setBounds(957, 28, 181, 50);
		contentPane.add(btnClearDbTable);

		 lblStepgrab = new JLabel("Step 1 :Grab Profile Urls");
		 lblStepgrab.setBackground(Color.BLUE);
		lblStepgrab.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStepgrab.setBounds(15, 152, 303, 40);
		contentPane.add(lblStepgrab);

		JLabel lblNewLabel_1_3 = new JLabel("EspnCricInfo URL ");
		lblNewLabel_1_3.setBounds(33, 208, 135, 20);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Save File Location");
		lblNewLabel_1_3_1.setBounds(33, 397, 135, 20);
		contentPane.add(lblNewLabel_1_3_1);

		profileFileTxt = new JTextField();
		profileFileTxt.setText("resources/cricinfo/profileurlstest.txt");
		profileFileTxt.setFont(new Font("Tahoma", Font.BOLD, 14));
		profileFileTxt.setColumns(10);
		profileFileTxt.setBounds(33, 419, 374, 40);
		contentPane.add(profileFileTxt);

		JButton grabUrlsBtn = new JButton("Grab Urls");
		grabUrlsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String url = urlTxt.getText();
				String outputTxt = new File(profileFileTxt.getText()).getAbsolutePath();
				int maxPage = Integer.parseInt(maxPagesTxt.getText().trim());

				try {
					ProfileUrlsGrabberUtil.grabUrls(url, outputTxt, maxPage);
					lblStepgrab.setBackground(Color.GREEN);
					
					JOptionPane.showMessageDialog(contentPane, " Grabing URL's Completed  ");
					Desktop.getDesktop().open(new File(outputTxt));
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane, " Grabing URL's Failed Due To ::  "+e.getMessage());
				}

			}
		});
		grabUrlsBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		grabUrlsBtn.setBounds(33, 482, 135, 40);
		contentPane.add(grabUrlsBtn);

		urlTxt = new JTextField();
		urlTxt.setHorizontalAlignment(SwingConstants.LEFT);
		urlTxt.setText(
				"https://stats.espncricinfo.com/ci/engine/stats/index.html?class=2;filter=advanced;orderby=matches;size=20;spanmin1=05+Jan+1988;spanval1=span;template=results;type=allround");
		urlTxt.setBounds(36, 237, 381, 40);
		contentPane.add(urlTxt);
		urlTxt.setColumns(10);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Max. Pages");
		lblNewLabel_1_3_2.setBounds(33, 304, 135, 20);
		contentPane.add(lblNewLabel_1_3_2);
		
		maxPagesTxt = new JTextField();
		maxPagesTxt.setText("1");
		maxPagesTxt.setHorizontalAlignment(SwingConstants.CENTER);
		maxPagesTxt.setColumns(10);
		maxPagesTxt.setBounds(33, 327, 85, 32);
		contentPane.add(maxPagesTxt);
		
		JButton btnOpenXls = new JButton("Open XLS");
		btnOpenXls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String outputXls = new File(txtOutputXlsx.getText()).getAbsolutePath();
				try {
					Desktop.getDesktop().open(new File(outputXls));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOpenXls.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpenXls.setBounds(725, 397, 157, 40);
		contentPane.add(btnOpenXls);
		
		JButton btnOpenTxt = new JButton("Open Txt");
		btnOpenTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String outputXls = new File(profileFileTxt.getText()).getAbsolutePath();
				try {
					Desktop.getDesktop().open(new File(outputXls));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnOpenTxt.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOpenTxt.setBounds(183, 482, 135, 40);
		contentPane.add(btnOpenTxt);
	}

	private void convertProfilesToXlsx(String inputTxt, String outputXls, JProgressBar progressLabel) {

		EspnCricInfoODIStats odiStats = new EspnCricInfoODIStats();

		ArrayList<String> urls = odiStats.getProfileUrls(inputTxt);
		List<PlayerInfo> playersList = odiStats.getStats(urls);
		try {
			ExcelGenerator.playersExcelGeneratorGUI(playersList, outputXls, progressLabel);

			JOptionPane.showMessageDialog(contentPane, "Excel Generation Completed. " + outputXls);
			Desktop.getDesktop().open(new File(outputXls));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, " Excel Generation Failed......." + e.getMessage());

		}

	}

	public static int savePlayer(PlayerInfo p, String tableName) throws Exception {

		String qry = "INSERT INTO  " + tableName + "  "
				+ " (name, country, matches, batInngs, notouts, runs, fifties, hundreads, batBest, batAvg, batStr,"
				+ " bowInngs, wickets, fourWik, fiveWik, bowBest, bowAvg, bowStr, econ, profId, picUrl, picImg)"
				+ "  values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? "
				+ " , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ? ) ";
		Connection con = DBConnection.getConnection();

		PreparedStatement st = con.prepareStatement(qry);

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

	public static void excelRowToPlayerInfo(String xlsInput, String tableName) throws Exception {

		FileInputStream inputStream = new FileInputStream(new File(xlsInput));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		int totalrows = firstSheet.getPhysicalNumberOfRows();
		Iterator<Row> iterator = firstSheet.iterator();
		int i = 0;

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			if (nextRow.getRowNum() == 0) {
				System.out.println(" *********** Skipping Column Row[0] From Excel ***************");
				continue; // just skip the rows if row number is 0 or 1
			}

			Iterator<Cell> cellIterator = nextRow.cellIterator();
			PlayerInfo p = new PlayerInfo();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();
				switch (columnIndex) {
				case 0:
					p.setName(getCellValue(nextCell).toString());
					break;
				case 1:
					p.setCountry(getCellValue(nextCell).toString());
					break;
				case 2:
					p.setMat((int) Math.round(((Double) getCellValue(nextCell))));
					break;
				case 3:
					p.setBatIngs((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 4:
					p.setNotouts((int) Math.round((Double) getCellValue(nextCell)));
					break;

				case 5:
					p.setRuns((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 6:
					p.setFiftys((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 7:
					p.setHundrds((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 8:
					p.setHigh((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 9:
					p.setBatAvg(Float.parseFloat(getCellValue(nextCell).toString()));
					break;

				case 10:
					p.setBatStr(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 11:
					p.setBowIngs((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 12:
					p.setWik((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 13:
					p.setWik5((int) Math.round((Double) getCellValue(nextCell)));
					break;
				case 14:
					p.setBowBest((getCellValue(nextCell).toString()));
					break;
				case 15:
					p.setBowAvg(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 16:
					p.setBowStr(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 17:
					p.setEcon(Float.parseFloat(getCellValue(nextCell).toString()));
					break;
				case 18:
					p.setProfileId((int) Math.round((Double) getCellValue(nextCell)));
					break;

				case 19:
					p.setPic((getCellValue(nextCell).toString()));
					break;

				case 20:
					p.setWik4((int) Math.round((Double) getCellValue(nextCell)));
					break;

				}

			}

			i++;
			System.out.println(i + " -->> Saving Player Object : " + p.getProfileId());
			progressBar2.setValue(100);
			StatsDBMain.savePlayer(p, tableName);

		}

		inputStream.close();

	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}
}
