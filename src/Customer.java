import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Customer extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField Address;
	private JTextField Number;
	private JTextField Email;
	
	static File customer = new File("Customers.csv");
	static File order = new File("Orders.csv");
	static FileWriter fw;
	static FileWriter fw_list;
	static FileWriter scan;
	static FileWriter scan_list;
	static FileReader fr;
	static FileReader fr_list;
	Prices p = new Prices();
	private JTextField amount;
	private JTable table;
	private JTextField total;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if (customer.createNewFile() == true && order.createNewFile())
					{
						String header = "Customer ID, Name, Address, Contact #, E-mail, Payment";
						scan = new FileWriter(customer);
						scan.write(header);
						scan.append("\n");
						scan.close();
						
						String headerOrd = "Product, Quantity, Price, Subtotal, Total, Order ID";
						scan_list = new FileWriter(order);
						scan_list.write(headerOrd);
						scan_list.append("\n");
						scan_list.close();
						
						
					}
					else
					{
						System.out.println();
					}
					
					Customer customerframe = new Customer();
					customerframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	public Customer() {
		Image img = new ImageIcon (this.getClass().getResource("/delivery.png")).getImage();
		setIconImage(img);
		setTitle("Order Now!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 460);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,239,217,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JPanel secondPanel = 	new JPanel();
		secondPanel.setBorder(new TitledBorder(null, "Food & Price", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		secondPanel.setToolTipText("");
		secondPanel.setBackground(new Color(250, 235, 215));
		secondPanel.setBounds(336, 11, 293, 400);
		contentPane.add(secondPanel);
		secondPanel.setLayout(null);
		
		JLabel food = new JLabel("");
		food.setBounds(33, 93, 233, 202);
		secondPanel.add(food);
		
		JLabel price = new JLabel("");
		price.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		price.setBounds(43, 306, 223, 48);
		secondPanel.add(price);
		
		JLabel lblOrderNo = new JLabel("ORDER No:");
		lblOrderNo.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblOrderNo.setBounds(22, 25, 80, 20);
		secondPanel.add(lblOrderNo);
		
		JLabel orderno = new JLabel("");
		orderno.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		orderno.setBounds(54, 50, 196, 32);
		secondPanel.add(orderno);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setBorder(new TitledBorder(null, "Customer Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		firstPanel.setToolTipText("");
		firstPanel.setBackground(new Color(250, 235, 215));
		firstPanel.setBounds(10, 11, 316, 400);
		contentPane.add(firstPanel);
		firstPanel.setLayout(null);
		
		JButton btnAcceptOrder_1 = new JButton("Go Back");
		btnAcceptOrder_1.setFont(new Font("Segoe UI Light", Font.BOLD, 11));
		btnAcceptOrder_1.setBounds(165, 366, 107, 23);
		btnAcceptOrder_1.setBackground(new Color(255, 208, 166));
		firstPanel.add(btnAcceptOrder_1);
		btnAcceptOrder_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				StartMenu f = new StartMenu();
				f.show();
				dispose();
			}
		});
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblName.setBounds(10, 31, 65, 24);
		firstPanel.add(lblName);
		
		Name = new JTextField();
		Name.setBackground(new Color(250, 250, 210));
		Name.setBounds(60, 33, 246, 20);
		firstPanel.add(Name);
		Name.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblAddress.setBounds(10, 66, 65, 24);
		firstPanel.add(lblAddress);
		
		Address = new JTextField();
		Address.setBackground(new Color(250, 250, 210));
		Address.setColumns(10);
		Address.setBounds(70, 68, 236, 20);
		firstPanel.add(Address);
		
		JLabel lblContactNo = new JLabel("Contact No.:");
		lblContactNo.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblContactNo.setBounds(10, 101, 117, 24);
		firstPanel.add(lblContactNo);
		
		Number = new JTextField();
		Number.setBackground(new Color(250, 250, 210));
		Number.setColumns(10);
		Number.setBounds(99, 104, 207, 20);
		firstPanel.add(Number);
		
		JLabel lblEmailAddress = new JLabel("Email address:");
		lblEmailAddress.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblEmailAddress.setBounds(10, 135, 133, 24);
		firstPanel.add(lblEmailAddress);
		
		Email = new JTextField();
		Email.setBackground(new Color(250, 250, 210));
		Email.setColumns(10);
		Email.setBounds(109, 138, 197, 20);
		firstPanel.add(Email);
		
		amount = new JTextField();
		amount.setBackground(new Color(250, 250, 210));
		amount.setBounds(72, 205, 96, 21);
		firstPanel.add(amount);
		amount.setColumns(10);
		
		JLabel lblOrder = new JLabel("Product:");
		lblOrder.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblOrder.setBounds(10, 170, 65, 24);
		firstPanel.add(lblOrder);
		
		JLabel lblAmount = new JLabel("Quantity:");
		lblAmount.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblAmount.setBounds(10, 202, 65, 24);
		firstPanel.add(lblAmount);
		
		
		
		String choice[] = {"Puto cheese", "Kutsinta", 
				"Banana cake", "Suman", "Chocolate cake", "Carrot cake",
				"Macaroons"};
		JComboBox pastries = new JComboBox(choice);
		pastries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String appear;
				appear = (String)pastries.getSelectedItem();
				try {
				if (appear.equals("Puto cheese"))
				{
					Image puto = new ImageIcon (this.getClass().getResource("/puto.jpg")).getImage();
					food.setIcon(new ImageIcon(puto));
					price.setText("Puto: Php " +p.puto()+ "/pc");
					
				}
				else if (appear.equals("Kutsinta"))
				{
					Image kutsinta = new ImageIcon (this.getClass().getResource("/kutsinta.jpg")).getImage();
					food.setIcon(new ImageIcon(kutsinta));
					price.setText("Kutsinta: Php " +p.kutsinta()+ "/pc");
				}
				
				else if (appear.equals("Banana cake"))
				{
					Image bCake = new ImageIcon (this.getClass().getResource("/bCake.jpg")).getImage();
					food.setIcon(new ImageIcon(bCake));
					price.setText("Banana cake: Php " +p.bCake()+ "/loaf");
				}
				
				else if (appear.equals("Suman"))
				{
					Image suman = new ImageIcon (this.getClass().getResource("suman.jpg")).getImage();
					food.setIcon(new ImageIcon(suman));
					price.setText("Suman: Php " +p.suman()+ "/pc");
				}
				
				else if (appear.equals("Chocolate cake"))
				{
					Image chocoCake = new ImageIcon (this.getClass().getResource("/chocoCake.jpg")).getImage();
					food.setIcon(new ImageIcon(chocoCake));
					price.setText("Chocolate cake: Php " +p.choCake());
				}
				
				else if (appear.equals("Carrot cake"))
				{
					Image cCake = new ImageIcon (this.getClass().getResource("/cCake.jpg")).getImage();
					food.setIcon(new ImageIcon(cCake));
					price.setText("Carrot cake: Php " +p.cCake()+ "/slice");
				}
				
				else if (appear.equals("Macaroons"))
				{
					Image macaroons = new ImageIcon (this.getClass().getResource("/macaroons.jpg")).getImage();
					food.setIcon(new ImageIcon(macaroons));
					price.setText("Macaroons: Php " +p.macaroons()+ "/pc");
				}
				}
				catch (Exception exp) 
				{
					JOptionPane.showMessageDialog(null, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				
			}
		});
		pastries.setFont(new Font("Segoe UI Light", Font.BOLD, 11));
		pastries.setBackground(new Color(255, 208, 166));
		pastries.setBounds(65, 172, 103, 20);
		firstPanel.add(pastries);
		
		
		JScrollPane order_scrollPane = new JScrollPane();
		order_scrollPane.setBounds(10, 237, 296, 94);
		firstPanel.add(order_scrollPane);
		
		
		table = new JTable();
		order_scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Quantity", "Price", "Subtotal"
			}
		));
		table.setBackground(new Color(250, 250, 210));
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		
		JButton btnAddOrder = new JButton("Add order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Prices p = new Prices();
				String register, amnt;
				
				try {
				do {
				register = (String)pastries.getSelectedItem();
				amnt = (String)amount.getText();
				
				
		
				if (register == "Puto cheese")
				{	
					double amt = Double.parseDouble(amnt);
					p.putoAdd(amt);
					String puto = Double.toString(p.puto());
					String putoTotal = Double.toString(p.putoAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), puto, putoTotal};
					model.addRow(data);
				}
				
				else if (register == "Kutsinta")
				{
					double amt = Double.parseDouble(amnt);
					p.kutsintaAdd(amt);
					String kutsinta = Double.toString(p.kutsinta());
					String kutsintaTotal = Double.toString(p.kutsintaAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), kutsinta, kutsintaTotal};
					model.addRow(data);
				}
				
				else if (register == "Banana cake")
				{
					double amt = Double.parseDouble(amnt);
					p.bcakeAdd(amt);
					String bCake = Double.toString(p.bCake());
					String bCakeTotal = Double.toString(p.bcakeAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), bCake, bCakeTotal};
					model.addRow(data);
					
				}
				
				else if (register == "Suman")
				{
					double amt = Double.parseDouble(amnt);
					p.sumanAdd(amt);
					String suman = Double.toString(p.suman());
					String sumanTotal = Double.toString(p.sumanAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), suman, sumanTotal};
					model.addRow(data);
				}
				
				else if (register == "Carrot cake")
				{
					double amt = Double.parseDouble(amnt);
					p.carCakeAdd(amt);
					String carCake = Double.toString(p.cCake());
					String carCakeTotal = Double.toString(p.carCakeAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), carCake, carCakeTotal};
					model.addRow(data);
				}
				
				else if (register == "Macaroons")
				{
					double amt = Double.parseDouble(amnt);
					p.macaroonsAdd(amt);
					String macaroons = Double.toString(p.macaroons());
					String macaroonsTotal = Double.toString(p.macaroonsAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), macaroons, macaroonsTotal};
					model.addRow(data);
					
				}
				
				else if (register == "Chocolate cake")
				{	
					double amt = Double.parseDouble(amnt);
					p.cCakeAdd(amt);
					String choCake = Double.toString(p.choCake());
					String cCakeTotal = Double.toString(p.cCakeAdd(amt));
					String data[] = {(String)pastries.getSelectedItem(), (String)amount.getText(), choCake, cCakeTotal};
					model.addRow(data);
				}
				
				} while (false);
				
			
				}
				catch (Exception exp)
				{
					JOptionPane.showMessageDialog(null, "Invalid quantity!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				double sum = 0;
				double Total = 0;
				for (int x = 0 ; x < table.getRowCount(); x++)
				{
					sum = Double.parseDouble(table.getValueAt(x, 3).toString());
					Total+=sum;
				}
				
				total.setText("Php " +Double.toString(Total));
				amount.setText("");
				
			}
		});
		btnAddOrder.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
		btnAddOrder.setBackground(new Color(255, 208, 166));
		btnAddOrder.setBounds(178, 169, 128, 23);
		firstPanel.add(btnAddOrder);
		
		
		
		JButton btnAcceptOrder = new JButton("Accept Order");
		btnAcceptOrder.setFont(new Font("Segoe UI Light", Font.BOLD, 10));
		btnAcceptOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				double total1 = 0;
				for (int y = 0 ; y < table.getRowCount(); y++)
				{
					double amount = Double.parseDouble((String) table.getValueAt(y, 3));
					total1+=amount;
				}
				int confirm = JOptionPane.showConfirmDialog(null, "Confirm Order? (Total Amount: Php " +total1+ ")", "Accept Order", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (confirm == JOptionPane.YES_OPTION) 
				{
					
					Random generate = new Random();
				
				int random = generate.nextInt(1000);
				
				try {
					fw = new FileWriter(customer, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fw_list = new FileWriter(order, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fr = new FileReader(customer);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fr_list = new FileReader(order);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
				StartMenu s = new StartMenu();
				BufferedWriter bw_list = new BufferedWriter(fw_list);
				BufferedReader br = new BufferedReader(fr);
				
				
				
				List<String> customerOrder = new ArrayList<String>();
				String readLine;
				
				try {
					
					if (Name.getText().isEmpty() || Address.getText().isEmpty() || Number.getText().isEmpty() || Email.getText().isEmpty()) 
					{
						JOptionPane.showMessageDialog(null, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					else 
					{	
					
					String name, address, number, ordernum, email, customer, total_;
					
					name = Name.getText();
					address = Address.getText();
					number = Number.getText();
					email = Email.getText();
					
					
					
					ordernum = "050569-" +random;
					orderno.setText("050569-"+random);
					
					double totalAmount = 0;
					for (int y = 0 ; y < table.getRowCount(); y++)
					{
						double amount = Double.parseDouble((String) table.getValueAt(y, 3));
						totalAmount+=amount;
					}
					
					total_ = Double.toString(totalAmount);
					customer = ordernum+ "," +name+ "," +address+ "," +number+ "," +email+ "," +total_;
						
					
						for (int i = 0 ; i < table.getRowCount() ; i++) 
						{
							for (int j = 0; j < table.getColumnCount(); j++) 
							{
								bw_list.write(table.getValueAt(i, j).toString()+",");
							}
							
							bw_list.write(total_);
							bw_list.write(",");
							bw_list.write(ordernum);
							bw_list.newLine(); 
						}
						
						bw_list.close();
					
					
					
					fw.write(customer);
					fw.append("\n");
				
					
					
					JOptionPane.showMessageDialog(null, "Your order has been processed.", "Thank you for purchasing!", JOptionPane.INFORMATION_MESSAGE);
					s.show();
					dispose();
					fw.close();
					
					}
					}
				catch (IOException exp)
				{
					JOptionPane.showMessageDialog(null, "Invalid input!", "ERROR", JOptionPane.ERROR_MESSAGE);
					//exp.printStackTrace();
				}
					
				}
				
				else if (confirm == JOptionPane.NO_OPTION) 
				{
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
					
			
			}
		});
		btnAcceptOrder.setBounds(29, 366, 107, 23);
		btnAcceptOrder.setBackground(new Color(255, 208, 166));
		firstPanel.add(btnAcceptOrder);
		
		JButton btnRmvButton = new JButton("Remove Order");
		btnRmvButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = table.getSelectedRow();
				if (i >= 0)
				{
					model.removeRow(i);
					double sum = 0;
					double Total = 0;
					for (int x = 0 ; x < table.getRowCount(); x++)
					{
						sum = Double.parseDouble(table.getValueAt(x, 3).toString());
						Total-=sum;
					}
					
					total.setText("Php " +Double.toString(Total));
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Delete Error!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnRmvButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 10));
		btnRmvButton.setBackground(new Color(255, 208, 166));
		btnRmvButton.setBounds(178, 204, 128, 23);
		firstPanel.add(btnRmvButton);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		lblTotal.setBounds(188, 342, 46, 14);
		firstPanel.add(lblTotal);
		
		total = new JTextField();
		total.setBackground(new Color(250, 250, 210));
		total.setBounds(230, 340, 76, 20);
		firstPanel.add(total);
		total.setColumns(10);
	
		
	}
}
