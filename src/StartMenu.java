import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class StartMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenu frame = new StartMenu();
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
	public StartMenu() {
		setTitle("Neneng's Delicacies Online Delivery Service");
		Image img = new ImageIcon (this.getClass().getResource("/delivery.png")).getImage();
		setIconImage(img);
		setBackground(new Color(236,212,196));
		getContentPane().setBackground(new Color(255,239,217,255));
		setBounds(100, 100, 655, 460);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel buttons = new JPanel();
		buttons.setBounds(10, 210, 619, 168);
		getContentPane().add(buttons);
		buttons.setBackground(new Color(250, 235, 215));
		buttons.setOpaque(false);
		buttons.setLayout(null);
		
		JButton btnOrder = 	new JButton("Order now!");
		btnOrder.setBackground(new Color(255, 208, 166));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Customer c = new Customer();
				c.show();
				dispose();	
			}
		});
		btnOrder.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnOrder.setBounds(190, 39, 235, 50);
		btnOrder.setBorderPainted(false);
		buttons.add(btnOrder);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Segoe UI Light", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnNewButton.setBounds(276, 134, 66, 23);
		btnNewButton.setBackground(new Color(255, 208, 166));
		buttons.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBounds(166, 23, 295, 176);
		Image main = new ImageIcon (this.getClass().getResource("/main.png")).getImage();
		label.setIcon(new ImageIcon(main));
		getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(216,183,171,255));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		menuBar.add(mnFile);
		Image records = new ImageIcon (this.getClass().getResource("records.png")).getImage();
		
		JMenuItem mntmManage = new JMenuItem("Manage Orders");
		mnFile.add(mntmManage);
		mntmManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField password = new JPasswordField();
				Object[] message = {
						"Password:", password
				};
				int option = JOptionPane.showConfirmDialog(null, message, "Browse orders", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION) {
					if (password.getText().equals("nenengnoval")) 
					{
						JOptionPane.showMessageDialog(null,"Success!", "Browse orders" ,JOptionPane.PLAIN_MESSAGE);
						Records r = new Records();
						r.show();
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(null,"Password Incorrect!","Browse orders",JOptionPane.PLAIN_MESSAGE);
						}
					} else {
						setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					}
				
				
			}
		});
		mntmManage.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		Image customerIcon = new ImageIcon (this.getClass().getResource("customers.png")).getImage();
		mntmManage.setIcon(new ImageIcon(customerIcon));
		
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		Image close = new ImageIcon (this.getClass().getResource("close.png")).getImage();
		mntmClose.setIcon(new ImageIcon(close));
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		menuBar.add(mnHelp);
		
		JMenuItem mntmCFeedback = new JMenuItem("Feedback");
		mntmCFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Feedback f = new Feedback();
				f.show();
				dispose();
				
				
			}
		});
		mntmCFeedback.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		Image feedback = new ImageIcon (this.getClass().getResource("feedback.png")).getImage();
		mntmCFeedback.setIcon(new ImageIcon(feedback));
		mnHelp.add(mntmCFeedback);
		
		
	}
}
