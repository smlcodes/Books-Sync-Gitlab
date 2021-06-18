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
import com.satyacodes.bean.InvoiceBean;

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
public class InvoiceUtilGUI extends JFrame {

	private JPanel contentPane;
	private JTextField invTxt;
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
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JLabel lblNewLabel_1_6;
	private JTextField sno1;
	private JTextField sno2;
	private JTextField sno3;
	private JTextField sno4;
	private JTextField i1;
	private JTextField i2;
	private JTextField i3;
	private JTextField i4;
	private JLabel lblNewLabel_1_7;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JTextField q1;
	private JTextField q2;
	private JTextField q3;
	private JTextField q4;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField etctxt;
	private JTextField etctotal;
	private JLabel lblNewLabel_1_8;
	private JLabel lblNewLabel_1_9;
	private JTextField total;
	private JLabel lblNewLabel_1_10;
	private JTextField txtFooter;
	private TextArea services;
	private TextArea paymentDetails;

	String pattern = "dd-MM-yyyy";
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	private JTextField paymentTxt;
	private JTextField signature;
	private JTextField signatureName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceUtilGUI frame = new InvoiceUtilGUI();
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
	public InvoiceUtilGUI() {
		setTitle("Invoice Util");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(48, -45, 1473, 899);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("S.No");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(81, 255, 121, 38);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("InvNo\r\n");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(56, 21, 62, 38);
		contentPane.add(lblNewLabel_1_3);

		invTxt = new JTextField();
		invTxt.setFont(new Font("Tahoma", Font.BOLD, 18));
		invTxt.setBounds(118, 28, 86, 33);
		contentPane.add(invTxt);
		invTxt.setColumns(10);

		JLabel lblNewLabel_1_3_1 = new JLabel("Date");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(56, 69, 71, 38);
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
		dateTxt1.setBounds(118, 72, 86, 33);
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

		lblNewLabel_1 = new JLabel("Customer ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(66, 133, 146, 38);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_1_2 = new JLabel("Invoice Details");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(56, 225, 146, 38);
		contentPane.add(lblNewLabel_1_2);

		lblNewLabel_1_4 = new JLabel("Item Name");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(240, 255, 146, 38);
		contentPane.add(lblNewLabel_1_4);

		lblNewLabel_1_5 = new JLabel("Qty\r\n");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(851, 255, 146, 38);
		contentPane.add(lblNewLabel_1_5);

		lblNewLabel_1_6 = new JLabel("Price");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setForeground(Color.BLUE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(685, 255, 146, 38);
		contentPane.add(lblNewLabel_1_6);

		sno1 = new JTextField();
		sno1.setText("1");
		sno1.setBounds(94, 290, 95, 26);
		contentPane.add(sno1);
		sno1.setColumns(10);

		sno2 = new JTextField();
		sno2.setText("2");
		sno2.setColumns(10);
		sno2.setBounds(94, 332, 95, 26);
		contentPane.add(sno2);

		sno3 = new JTextField();
		sno3.setText("3");
		sno3.setColumns(10);
		sno3.setBounds(94, 374, 95, 26);
		contentPane.add(sno3);

		sno4 = new JTextField();
		sno4.setText("4");
		sno4.setColumns(10);
		sno4.setBounds(94, 419, 95, 26);
		contentPane.add(sno4);

		i1 = new JTextField();
		i1.setBounds(240, 290, 418, 26);
		contentPane.add(i1);
		i1.setColumns(10);

		i2 = new JTextField();
		i2.setColumns(10);
		i2.setBounds(240, 332, 418, 26);
		contentPane.add(i2);

		i3 = new JTextField();
		i3.setColumns(10);
		i3.setBounds(240, 374, 418, 26);
		contentPane.add(i3);

		i4 = new JTextField();
		i4.setColumns(10);
		i4.setBounds(240, 419, 418, 26);
		contentPane.add(i4);

		lblNewLabel_1_7 = new JLabel("Total\r\n");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setForeground(Color.BLUE);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(1012, 255, 146, 38);
		contentPane.add(lblNewLabel_1_7);

		p1 = new JTextField();
		p1.setText("0");
		p1.setColumns(10);
		p1.setBounds(707, 290, 95, 26);
		contentPane.add(p1);

		p2 = new JTextField();
		p2.setText("0");
		p2.setColumns(10);
		p2.setBounds(707, 332, 95, 26);
		contentPane.add(p2);

		p3 = new JTextField();
		p3.setText("0");
		p3.setColumns(10);
		p3.setBounds(707, 374, 95, 26);
		contentPane.add(p3);

		p4 = new JTextField();
		p4.setText("0");
		p4.setColumns(10);
		p4.setBounds(707, 419, 95, 26);
		contentPane.add(p4);

		q1 = new JTextField();
		q1.setText("1");
		q1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {

				if (!p1.getText().isEmpty() && !q1.getText().isEmpty()) {
					double d = (Double.parseDouble(p1.getText()) * Integer.parseInt(q1.getText()));
					t1.setText(d + "");
				}

			}
		});
		q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		q1.setColumns(10);
		q1.setBounds(860, 290, 95, 26);
		contentPane.add(q1);

		q2 = new JTextField();
		q2.setText("1");
		q2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (!p2.getText().isEmpty() && !q2.getText().isEmpty()) {
					double d = (Double.parseDouble(p2.getText()) * Integer.parseInt(q2.getText()));
					t2.setText(d + "");
				}

			}
		});
		q2.setColumns(10);
		q2.setBounds(860, 332, 95, 26);
		contentPane.add(q2);

		q3 = new JTextField();
		q3.setText("1");
		q3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (!p3.getText().isEmpty() && !q3.getText().isEmpty()) {
					double d = (Double.parseDouble(p3.getText()) * Integer.parseInt(q3.getText()));
					t3.setText(d + "");
				}

			}
		});
		q3.setColumns(10);
		q3.setBounds(860, 374, 95, 26);
		contentPane.add(q3);

		q4 = new JTextField();
		q4.setText("1");
		q4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (!p4.getText().isEmpty() && !q4.getText().isEmpty()) {
					double d = (Double.parseDouble(p4.getText()) * Integer.parseInt(q4.getText()));
					t4.setText(d + "");
				}

			}

		});
		q4.setColumns(10);
		q4.setBounds(860, 419, 95, 26);
		contentPane.add(q4);

		t1 = new JTextField();
		t1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		t1.setText("0");
		t1.setColumns(10);
		t1.setBounds(1010, 290, 121, 26);
		contentPane.add(t1);

		t2 = new JTextField();
		t2.setText("0");
		t2.setColumns(10);
		t2.setBounds(1010, 332, 121, 26);
		contentPane.add(t2);

		t3 = new JTextField();
		t3.setText("0");
		t3.setColumns(10);
		t3.setBounds(1010, 374, 121, 26);
		contentPane.add(t3);

		t4 = new JTextField();
		t4.setText("0");
		t4.setColumns(10);
		t4.setBounds(1010, 419, 121, 26);
		contentPane.add(t4);

		etctxt = new JTextField();
		etctxt.setColumns(10);
		etctxt.setBounds(860, 461, 95, 26);
		contentPane.add(etctxt);

		etctotal = new JTextField();
		etctotal.setText("0");
		etctotal.setColumns(10);
		etctotal.setBounds(1010, 461, 121, 26);
		contentPane.add(etctotal);

		lblNewLabel_1_8 = new JLabel("Etc.,");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setForeground(Color.BLUE);
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_8.setBounds(784, 461, 71, 38);
		contentPane.add(lblNewLabel_1_8);

		lblNewLabel_1_9 = new JLabel("TOTAL");
		lblNewLabel_1_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_9.setForeground(Color.RED);
		lblNewLabel_1_9.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1_9.setBounds(724, 503, 121, 54);
		contentPane.add(lblNewLabel_1_9);

		total = new JTextField();
		total.setText("0.0");
		total.setForeground(Color.RED);
		total.setFont(new Font("Tahoma", Font.BOLD, 28));
		total.setColumns(10);
		total.setBounds(860, 503, 271, 54);
		contentPane.add(total);

		lblNewLabel_1_10 = new JLabel("Our Services");
		lblNewLabel_1_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_10.setBounds(68, 528, 146, 38);
		contentPane.add(lblNewLabel_1_10);

		services = new TextArea();
		services.setBounds(68, 575, 517, 228);
		contentPane.add(services);

		txtFooter = new JTextField();
		txtFooter.setText("Footer\r\n");
		txtFooter.setColumns(10);
		txtFooter.setBounds(597, 787, 638, 26);
		contentPane.add(txtFooter);

		JButton printbtn = new JButton("PRINT");
		printbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				System.out.println(" =======================  Print Start ===============================");

				List<InvoiceBean> invList = getInvoiceBean();
				try {
					printInvoice(invList);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(" =======================  Print End ===============================");

			}
		});
		printbtn.setForeground(new Color(0, 128, 0));
		printbtn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		printbtn.setBounds(1156, 438, 180, 119);
		contentPane.add(printbtn);

		JButton btnSum = new JButton("SUM");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sum();

				// double d = ( Double.parseDouble( t1.getText()) +
				// Double.parseDouble(t2.getText()) + Double.parseDouble(t3.getText())
				// +Double.parseDouble(t4.getText()) + Double.parseDouble(etctotal.getText()) );

				/*
				 * double d = ( Double.parseDouble(p1.getText()) *
				 * Integer.parseInt(q1.getText()))+ ( Double.parseDouble(p2.getText()) *
				 * Integer.parseInt(q2.getText()))+ ( Double.parseDouble(p3.getText()) *
				 * Integer.parseInt(q3.getText()))+ ( Double.parseDouble(p4.getText()) *
				 * Integer.parseInt(q4.getText()))+ ( Double.parseDouble(etctotal.getText())) ;
				 * 
				 * 
				 * total.setText(d+"");
				 */

			}
		});
		btnSum.setForeground(new Color(165, 42, 42));
		btnSum.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSum.setBounds(1157, 374, 163, 47);
		contentPane.add(btnSum);

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					loadInvoiceData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLoad.setForeground(Color.BLUE);
		btnLoad.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnLoad.setBounds(1173, 16, 105, 47);
		contentPane.add(btnLoad);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					updateInvoiceData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 18));
		btnUpdate.setBounds(1173, 72, 105, 47);
		contentPane.add(btnUpdate);

		paymentTxt = new JTextField();
		paymentTxt.setText("Mode of Payment");
		paymentTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		paymentTxt.setColumns(10);
		paymentTxt.setBounds(603, 573, 197, 38);
		contentPane.add(paymentTxt);

		paymentDetails = new TextArea();
		paymentDetails.setColumns(60);
		paymentDetails.setBounds(603, 612, 501, 140);
		contentPane.add(paymentDetails);
		
		signature = new JTextField();
		signature.setText("Satya Kaveti");
		signature.setBounds(1174, 627, 180, 26);
		contentPane.add(signature);
		signature.setColumns(10);
		
		signatureName = new JTextField();
		signatureName.setText("( Kaveti VS Satyanarayana )");
		signatureName.setColumns(10);
		signatureName.setBounds(1173, 669, 181, 26);
		contentPane.add(signatureName);
	}

	private List<InvoiceBean> getInvoiceBean() {

		List<InvoiceBean> invList = new ArrayList<InvoiceBean>();

		InvoiceBean i = new InvoiceBean();

		i.setInvTxt((invTxt.getText()));
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
		i.setSno1((Integer.parseInt(sno1.getText())));
		i.setSno2((Integer.parseInt(sno2.getText())));
		i.setSno3((Integer.parseInt(sno3.getText())));
		i.setSno4((Integer.parseInt(sno4.getText())));
		i.setI1(i1.getText());
		i.setI2(i2.getText());
		i.setI3(i3.getText());
		i.setI4(i4.getText());
		i.setP1(Double.parseDouble(p1.getText()));
		i.setP2(Double.parseDouble(p2.getText()));
		i.setP3(Double.parseDouble(p3.getText()));
		i.setP4(Double.parseDouble(p4.getText()));
		i.setQ1((Integer.parseInt(q1.getText())));
		i.setQ2((Integer.parseInt(q2.getText())));
		i.setQ3((Integer.parseInt(q3.getText())));
		i.setQ4((Integer.parseInt(q4.getText())));
		i.setT1(Double.parseDouble(t1.getText()));
		i.setT2(Double.parseDouble(t2.getText()));
		i.setT3(Double.parseDouble(t3.getText()));
		i.setT4(Double.parseDouble(t4.getText()));
		i.setEtctxt(etctxt.getText());
		i.setEtctotal(Double.parseDouble(etctotal.getText()));
		i.setTotal((Double.parseDouble(total.getText())));
		i.setTxtFooter(txtFooter.getText());
		i.setServices(services.getText());
		i.setPaymentTxt(paymentTxt.getText());
		i.setPaymentDetails(paymentDetails.getText());

		i.setSno(i.getSno1());
		i.setItem(i.getI1());
		i.setPrice(i.getP1());
		i.setQty(i.getQ1());
		i.setTot(i.getT1());
		
		i.setSignature(signature.getText());
		i.setSignatureName(signatureName.getText());
		invList.add(i);

		if (i.getSno2() > 0 && !i.getI2().isEmpty() && i.getP2() > 0 && i.getT2() > 0) {
			InvoiceBean i2 = new InvoiceBean();
			i2.setSno(i.getSno2());
			i2.setItem(i.getI2());
			i2.setPrice(i.getP2());
			i2.setTot(i.getT2());
			i2.setQty(i.getQ2());
			i2.setEtctxt(etctxt.getText());
			i2.setEtctotal(Double.parseDouble(etctotal.getText()));
			i2.setTotal((Double.parseDouble(total.getText())));
			i2.setTxtFooter(txtFooter.getText());
			i2.setServices(services.getText());
			i2.setPaymentTxt(paymentTxt.getText());
			i2.setPaymentDetails(paymentDetails.getText());
			i2.setSignature(signature.getText());
			i2.setSignatureName(signatureName.getText());
			invList.add(i2);
		}

		if (i.getSno3() > 0 && !i.getI3().isEmpty() && i.getP3() > 0 && i.getT3() > 0) {
			InvoiceBean i3 = new InvoiceBean();
			i3.setSno(i.getSno3());
			i3.setItem(i.getI3());
			i3.setPrice(i.getP3());
			i3.setTot(i.getT3());
			i3.setQty(i.getQ3());

			i3.setEtctxt(etctxt.getText());
			i3.setEtctotal(Double.parseDouble(etctotal.getText()));
			i3.setTotal((Double.parseDouble(total.getText())));
			i3.setTxtFooter(txtFooter.getText());
			i3.setServices(services.getText());
			i3.setPaymentTxt(paymentTxt.getText());
			i3.setPaymentDetails(paymentDetails.getText());

			i3.setSignature(signature.getText());
			i3.setSignatureName(signatureName.getText());
			
			invList.add(i3);
		}

		if (i.getSno4() > 0 && !i.getI4().isEmpty() && i.getP4() > 0 && i.getT4() > 0) {
			InvoiceBean i4 = new InvoiceBean();
			i4.setSno(i.getSno4());
			i4.setItem(i.getI4());
			i4.setPrice(i.getP4());
			i4.setTot(i.getT4());
			i4.setQty(i.getQ4());

			i4.setEtctxt(etctxt.getText());
			i4.setEtctotal(Double.parseDouble(etctotal.getText()));
			i4.setTotal((Double.parseDouble(total.getText())));
			i4.setTxtFooter(txtFooter.getText());
			i4.setServices(services.getText());

			
			i4.setSignature(signature.getText());
			i4.setSignatureName(signatureName.getText());
			i4.setPaymentTxt(paymentTxt.getText());
			i4.setPaymentDetails(paymentDetails.getText());

			invList.add(i4);
		}

		return invList;

	}

	private void printInvoice(List<InvoiceBean> invList) throws Exception {

		try {
			InputStream inputStream = new FileInputStream("reports/InvoiceReport.jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			HashMap parameters = new HashMap();

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(invList);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/inovice.pdf");
			JasperViewer.viewReport(jasperPrint, false);
		} catch (JRException ex) {
			ex.printStackTrace();
		}
	}

	public void loadInvoiceData() throws Exception {
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from invoice where id=1");
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
			services.setText(rs.getString("services"));
			txtFooter.setText(rs.getString("footer"));
			paymentDetails.setText(rs.getString("paymentDetails"));
			paymentTxt.setText(rs.getString("paymentTxt"));

			String date = sdf.format(new java.util.Date());
			dateTxt1.setText(date);
			invTxt.setText("112");

			i1.setText(" Webiste Design & Development");
			p1.setText("7600");

			i2.setText(" Domain Registartion & Hosting");
			p2.setText("3100");

			i3.setText(" SEO performance Changes");
			p3.setText("1877.35");

			i4.setText(" Conent Creation");
			p4.setText("2817.65");

			etctxt.setText("TAX & Deductions");
			etctotal.setText("-550.00");

			System.out.println(" ----------- Load End ------------------");

		}
		rs.close();

	}

	public void updateInvoiceData() throws Exception {

		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();

		String qry = "UPDATE invoice SET   " + "compay=  '" + txtCompanyName.getText() + "', " + "phno= '"
				+ txtPhno.getText() + "',    " + "webemail= '" + txtWebsite.getText() + "',  " + "line1=  '"
				+ txtLine1.getText() + "',  " + "line2=  '" + txtLine2.getText() + "',   " + "cname=  '"
				+ txtCustname.getText() + "',  " + "ccompany=  '" + txtCustcompany.getText() + "', " + "cline1=  '"
				+ txtCustline1.getText() + "', " + "cline2=  '" + txtCustline2.getText() + "',  " + "services=  '"
				+ services.getText() + "', " + "paymentTxt=  '" + paymentTxt.getText() + "', " + "paymentDetails=  '"
				+ paymentDetails.getText() + "', " + "footer =  '" + txtFooter.getText() + "' " + " WHERE id=1";

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

	public void sum() {

		if (!p4.getText().isEmpty() && !q4.getText().isEmpty()) {
			double d = (Double.parseDouble(p4.getText()) * Integer.parseInt(q4.getText()));
			t4.setText(d + "");
		}

		if (!p3.getText().isEmpty() && !q3.getText().isEmpty()) {
			double d = (Double.parseDouble(p3.getText()) * Integer.parseInt(q3.getText()));
			t3.setText(d + "");
		}

		if (!p2.getText().isEmpty() && !q2.getText().isEmpty()) {
			double d = (Double.parseDouble(p2.getText()) * Integer.parseInt(q2.getText()));
			t2.setText(d + "");
		}

		if (!p1.getText().isEmpty() && !q1.getText().isEmpty()) {
			double d = (Double.parseDouble(p1.getText()) * Integer.parseInt(q1.getText()));
			t1.setText(d + "");
		}

		double d = (Double.parseDouble(p1.getText()) * Integer.parseInt(q1.getText()))
				+ (Double.parseDouble(p2.getText()) * Integer.parseInt(q2.getText()))
				+ (Double.parseDouble(p3.getText()) * Integer.parseInt(q3.getText()))
				+ (Double.parseDouble(p4.getText()) * Integer.parseInt(q4.getText()))
				+ (Double.parseDouble(etctotal.getText()));

		total.setText(d + "");

	}
}
