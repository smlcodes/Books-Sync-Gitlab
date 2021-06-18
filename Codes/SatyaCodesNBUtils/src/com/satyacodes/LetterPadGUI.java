/**
 * 
 */
package com.satyacodes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.util.ResourceUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.Font;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Component;
import javax.swing.Box;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.satyacodes.bean.LetterBean;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

/**
 * @author KavetiS
 *
 */

/**
 * 
 * REF:
 * http://refermycode.com/jaspertutorial/chapter-5-generating-report-with-java-pojo-classes/
 * 
 **/
public class LetterPadGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtLine1;
	private JTextField txtCompanyName;
	private JTextField dateTxt1;
	private JTextField txtLine2;
	private JTextField txtPhno;
	private JTextField txtWebsite;
	private JTextField txtCustname;
	private JTextField txtCustcompany;
	private JTextField txtCustline1;
	private JTextField txtCustline2;
	private JLabel lblNewLabel_1;
	private JTextField txtFooter;

	String pattern = "dd-MM-yyyy";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	private JTextField signature;
	private JTextField signatureName;
	private JTextArea letterDatatxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LetterPadGUI frame = new LetterPadGUI();
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
	public LetterPadGUI() {
		setTitle("letter Util");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(48, -45, 1204, 899);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_3_1 = new JLabel("Date");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(68, 32, 71, 38);
		contentPane.add(lblNewLabel_1_3_1);

		txtCompanyName = new JTextField();
		txtCompanyName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCompanyName.selectAll();
			}
		});
		txtCompanyName.setText("Company Name");
		txtCompanyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCompanyName.setBounds(219, 21, 451, 38);
		contentPane.add(txtCompanyName);
		txtCompanyName.setColumns(10);

		dateTxt1 = new JTextField();
		dateTxt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				dateTxt1.selectAll();
			}
		});
		dateTxt1.setText("date");
		dateTxt1.setFont(new Font("Tahoma", Font.BOLD, 11));
		dateTxt1.setColumns(10);
		dateTxt1.setBounds(68, 72, 136, 33);
		contentPane.add(dateTxt1);

		txtLine2 = new JTextField();
		txtLine2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLine2.selectAll();
			}
		});
		txtLine2.setText("Line 2");
		txtLine2.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtLine2.setColumns(10);
		txtLine2.setBounds(685, 71, 458, 39);
		contentPane.add(txtLine2);

		txtPhno = new JTextField();
		txtPhno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPhno.selectAll();
			}
		});
		txtPhno.setText("Ph.no");
		txtPhno.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPhno.setColumns(10);
		txtPhno.setBounds(685, 21, 215, 38);
		contentPane.add(txtPhno);

		txtWebsite = new JTextField();
		txtWebsite.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtWebsite.selectAll();
			}
		});
		txtWebsite.setText("website/email");
		txtWebsite.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtWebsite.setColumns(10);
		txtWebsite.setBounds(905, 21, 238, 38);
		contentPane.add(txtWebsite);

		txtLine1 = new JTextField();
		txtLine1.setText("Line1");
		txtLine1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLine1.selectAll();
			}
		});
		txtLine1.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtLine1.setColumns(10);
		txtLine1.setBounds(219, 69, 451, 38);
		contentPane.add(txtLine1);

		txtCustname = new JTextField();
		txtCustname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtCustname.selectAll();
			}
		});
		txtCustname.setText("custName");
		txtCustname.setBounds(68, 167, 254, 26);
		contentPane.add(txtCustname);
		txtCustname.setColumns(10);

		txtCustcompany = new JTextField();
		txtCustcompany.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCustcompany.selectAll();
			}
		});
		txtCustcompany.setText("custCompany");
		txtCustcompany.setColumns(10);
		txtCustcompany.setBounds(334, 167, 254, 26);
		contentPane.add(txtCustcompany);

		txtCustline1 = new JTextField();
		txtCustline1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCustline1.selectAll();
			}
		});
		txtCustline1.setText("custLine1");
		txtCustline1.setColumns(10);
		txtCustline1.setBounds(603, 167, 254, 26);
		contentPane.add(txtCustline1);

		txtCustline2 = new JTextField();
		txtCustline2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCustline2.selectAll();
			}
		});
		txtCustline2.setText("custLine2");
		txtCustline2.setColumns(10);
		txtCustline2.setBounds(872, 167, 271, 26);
		contentPane.add(txtCustline2);

		lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(66, 133, 146, 38);
		contentPane.add(lblNewLabel_1);

		txtFooter = new JTextField();
		txtFooter.setText("Footer\r\n");
		txtFooter.setColumns(10);
		txtFooter.setBounds(68, 714, 789, 26);
		contentPane.add(txtFooter);

		JButton printbtn = new JButton("PRINT");
		printbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println(" =======================  Print Start ===============================");

				List<LetterBean> invList = getLetterBean();
				try {
					printletter(invList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(" =======================  Print End ===============================");

			}
		});
		printbtn.setForeground(new Color(0, 128, 0));
		printbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		printbtn.setBounds(885, 621, 180, 119);
		contentPane.add(printbtn);

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					loadletterData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoad.setForeground(Color.BLUE);
		btnLoad.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnLoad.setBounds(905, 228, 105, 47);
		contentPane.add(btnLoad);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					updateletterData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnUpdate.setBounds(905, 291, 105, 47);
		contentPane.add(btnUpdate);
		
		signature = new JTextField();
		signature.setText("Satya Kaveti");
		signature.setBounds(885, 502, 180, 26);
		contentPane.add(signature);
		signature.setColumns(10);
		
		signatureName = new JTextField();
		signatureName.setText("( Kaveti VS Satyanarayana )");
		signatureName.setColumns(10);
		signatureName.setBounds(884, 544, 181, 26);
		contentPane.add(signatureName);
		
		letterDatatxt = new JTextArea();
		letterDatatxt.setFont(new Font("Consolas", Font.PLAIN, 14));
		letterDatatxt.setText("letterData");
		letterDatatxt.setBounds(68, 228, 790, 470);
		contentPane.add(letterDatatxt);
	}

	private List<LetterBean> getLetterBean() {

		List<LetterBean> invList = new ArrayList<LetterBean>();

		LetterBean i = new LetterBean();

		
		i.setTxtLine1(txtLine1.getText());
		i.setTxtCompanyName(txtCompanyName.getText());
		i.setDateTxt1(dateTxt1.getText());
		i.setTxtLine2(txtLine2.getText());
		i.setTxtPhno(txtPhno.getText());
		i.setTxtWebsite(txtWebsite.getText());
		i.setTxtCustname(txtCustname.getText());
		i.setTxtCustcompany(txtCustcompany.getText());
		i.setTxtCustline1(txtCustline1.getText());
		i.setTxtCustline2(txtCustline2.getText());
		
		i.setTxtFooter(txtFooter.getText());

		
		i.setSignature(signature.getText());
		i.setSignatureName(signatureName.getText());
		i.setLetterData(letterDatatxt.getText());
		
		invList.add(i);


		return invList;

	}

	private void printletter(List<LetterBean> invList) throws Exception {

		try {
			InputStream inputStream = new FileInputStream("reports/LetterReport.jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			HashMap parameters = new HashMap();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(invList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/letter.pdf");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	public void loadletterData() throws Exception {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from letter where id=1");
		if (rs.next()) {
			// services footer
			System.out.println(" ----------- Load Start ------------------");
			txtCompanyName.setText(rs.getString("compay"));
			txtLine1.setText(rs.getString("line1"));
			txtLine2.setText(rs.getString("line2"));
			txtPhno.setText(rs.getString("phno"));
			txtWebsite.setText(rs.getString("webemail"));
			txtCustname.setText(rs.getString("cname"));
			txtCustcompany.setText(rs.getString("ccompany"));
			txtCustline1.setText(rs.getString("cline1"));
			txtCustline2.setText(rs.getString("cline2"));
			txtFooter.setText(rs.getString("footer"));
			letterDatatxt.setText(rs.getString("letterData"));
			String date = sdf.format(new java.util.Date());
			dateTxt1.setText(date);
		

			System.out.println(" ----------- Load End ------------------");

		}
		rs.close();

	}

	public void updateletterData() throws Exception {

		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();

		String qry = "UPDATE letter SET   " + "compay=  '" + txtCompanyName.getText() + "', " + "phno= '"
				+ txtPhno.getText() + "',    " + "webemail= '" + txtWebsite.getText() + "',  " + "line1=  '"
				+ txtLine1.getText() + "',  " + "line2=  '" + txtLine2.getText() + "',   " + "cname=  '"
				+ txtCustname.getText() + "',  " + "ccompany=  '" + txtCustcompany.getText() + "', " + "cline1=  '"
				+ txtCustline1.getText() + "', " + "cline2=  '" + txtCustline2.getText() + "'  , "
				+ "letterData=  '" + letterDatatxt.getText() + "'  WHERE id=1";

		System.out.println("Qry :: " + qry);

		int res = st.executeUpdate(qry);
		if (res > 0) {

			JOptionPane.showMessageDialog(contentPane, "Data Updated Successfully .");
		} else {

			JOptionPane.showMessageDialog(contentPane, "Update Failed", "Update", JOptionPane.ERROR_MESSAGE);

		}

		st.close();
		con.close();

	}
}
