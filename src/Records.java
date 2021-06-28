import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Records extends JFrame {

	private JPanel contentPane;
	private JTable customerList;
	private JTable orderList;
	static File customer = new File("Customers.csv");
	static File order = new File("Orders.csv");
	static FileReader fr;
	static FileReader fr_list;
	static BufferedReader br;
	static BufferedReader br_list;
	static Object[][] row;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Records frame = new Records();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void customerTableList() {
		
		  Vector<Vector<String>> vectorVectorStringsData = new Vector<Vector<String>>();
		  Vector<String> vectorStrings = new Vector<String>();
	      Vector<String> vectorColumnIdentifiers = new Vector<String>();
	      String firstRow;
	      String[] columnIdentifiers;
	      DefaultTableModel model = (DefaultTableModel) customerList.getModel();
	      
	      try 
	      {
	    	  fr = new FileReader(customer);
	    	  br = new BufferedReader(fr);
	    	  
	    	  firstRow = br.readLine().trim();
	    	  
	    	  if (firstRow != null)
	    	  {
	    		  columnIdentifiers = firstRow.split(",");
	    		  vectorColumnIdentifiers = new Vector<String>();
	    		  for (int j =0; j < columnIdentifiers.length; j++) 
	    		  {
	    			  vectorColumnIdentifiers.add(columnIdentifiers[j]);
	    		  }
	    	  }
	    	  
	    	  Object[] tableLines = br.lines().toArray();
	    	  
	    	  for (int i = 0; i < tableLines.length; i++) {
	                String line = tableLines[i].toString().trim();
	                String[] dataRow = line.split(",");
	                vectorStrings = new Vector<String>();
	                for (int j =0; j < dataRow.length; j++) {
	                    vectorStrings.add(dataRow[j]);
	                }
	                vectorVectorStringsData.add(vectorStrings);
	            }
	    	  
	    	  fr.close();
	    	  
	    	  model.setDataVector(vectorVectorStringsData, vectorColumnIdentifiers);
	    	  
	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();
	      }
	
		
		}
	
	private void orderTableList() {
		
		  Vector<Vector<String>> vectorVectorStringsData = new Vector<Vector<String>>();
		  Vector<String> vectorStrings = new Vector<String>();
	      Vector<String> vectorColumnIdentifiers = new Vector<String>();
	      String firstRow;
	      String[] columnIdentifiers;
	      DefaultTableModel model = (DefaultTableModel) orderList.getModel();
	      
	      try 
	      {
	    	  fr = new FileReader(order);
	    	  br = new BufferedReader(fr);
	    	  
	    	  firstRow = br.readLine().trim();
	    	  
	    	  if (firstRow != null)
	    	  {
	    		  columnIdentifiers = firstRow.split(",");
	    		  vectorColumnIdentifiers = new Vector<String>();
	    		  for (int j =0; j < columnIdentifiers.length; j++) 
	    		  {
	    			  vectorColumnIdentifiers.add(columnIdentifiers[j]);
	    		  }
	    	  }
	    	  
	    	  Object[] tableLines = br.lines().toArray();
	    	  
	    	  for (int i = 0; i < tableLines.length; i++) {
	                String line = tableLines[i].toString().trim();
	                String[] dataRow = line.split(",");
	                vectorStrings = new Vector<String>();
	                for (int j =0; j < dataRow.length; j++) {
	                    vectorStrings.add(dataRow[j]);
	                }
	                vectorVectorStringsData.add(vectorStrings);
	            }
	    	  
	    	  fr.close();
	    	  
	    	  model.setDataVector(vectorVectorStringsData, vectorColumnIdentifiers);
	    	  
	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();
	      }
		
		
		
	}
	
	/**
	 * Create the frame.
	 */
	public Records() {
		setTitle("Browse Orders");
		Image img = new ImageIcon (this.getClass().getResource("/records.png")).getImage();
		setIconImage(img);
		setBackground(new Color(236,212,196));
		setBounds(100, 100, 655, 460);
		getContentPane().setBackground(new Color(255,239,217,255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel customers = new JPanel();
		customers.setBounds(10, 11, 619, 185);
		customers.setBorder(new TitledBorder(null, "Customers", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customers.setBackground(new Color(250, 235, 215));
		getContentPane().add(customers);
		customers.setLayout(null);
		
		JScrollPane cust_pane = new JScrollPane();
		cust_pane.setBounds(10, 21, 599, 153);
		customers.add(cust_pane);
		
		customerList = new JTable();
		cust_pane.setViewportView(customerList);
		customerList.setBackground(new Color(250, 250, 210));
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StartMenu s = new StartMenu();
				s.show();
				dispose();
				
			}
		});
		btnGoBack.setBounds(273, 388, 89, 23);
		getContentPane().add(btnGoBack);
		
		JPanel orders = new JPanel();
		orders.setBounds(10, 207, 619, 173);
		orders.setBorder(new TitledBorder(null, "Orders", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		orders.setBackground(new Color(250, 235, 215));
		getContentPane().add(orders);
		orders.setLayout(null);
		
		JScrollPane ord_pane = new JScrollPane();
		ord_pane.setBounds(10, 22, 599, 140);
		orders.add(ord_pane);
		
		orderList = new JTable();
		ord_pane.setViewportView(orderList);
		orderList.setBackground(new Color(250, 250, 210));
		
		customerTableList();
		orderTableList();
		
	}
		
		
	
}
