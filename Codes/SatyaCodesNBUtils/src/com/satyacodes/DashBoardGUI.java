/**
 * 
 */
package com.satyacodes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.satyacodes.cricinfoutil.CricInfoUtilGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;

/**
 * @author KavetiS
 *
 */
public class DashBoardGUI extends JFrame {

  private JPanel contentPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          DashBoardGUI frame = new DashBoardGUI();
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
  public DashBoardGUI() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 1140, 683);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("File");
    menuBar.add(mnNewMenu);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Logout");
    mntmNewMenuItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		

            LoginGUI sf = new LoginGUI();
            sf.setVisible(true);
    	}
    });
    mnNewMenu.add(mntmNewMenuItem);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton btnNewButton = new JButton("Jasper Util");
    btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
            JasperUtilGUI sf = new JasperUtilGUI();
            sf.setVisible(true);
    	}
    });
    btnNewButton.setBounds(305, 102, 219, 65);
    contentPane.add(btnNewButton);
    
    JButton btnInvoiceutil = new JButton("Invoice Util");
    btnInvoiceutil.setFont(new Font("Verdana", Font.BOLD, 18));
    btnInvoiceutil.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		

            InvoiceUtilGUI sf = new InvoiceUtilGUI();
            sf.setVisible(true);
    		
    	}
    });
    btnInvoiceutil.setBounds(38, 102, 219, 65);
    contentPane.add(btnInvoiceutil);
    
    JButton letterUtilButton = new JButton("Letter Util");
    letterUtilButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		 LetterPadGUI sf = new LetterPadGUI();
             sf.setVisible(true);
    	}
    });
    letterUtilButton.setFont(new Font("Verdana", Font.BOLD, 18));
    letterUtilButton.setBounds(563, 102, 219, 65);
    contentPane.add(letterUtilButton);
    
    JButton cricInfoutilbtn = new JButton("CricInfo Util");
    cricInfoutilbtn.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	      CricInfoUtilGUI sf = new CricInfoUtilGUI();
              sf.setVisible(true);
    	}
    });
    cricInfoutilbtn.setFont(new Font("Verdana", Font.BOLD, 18));
    cricInfoutilbtn.setBounds(38, 376, 219, 65);
    contentPane.add(cricInfoutilbtn);
  }
}
