import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Feedback extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg = new ButtonGroup();
	static File custFeedback = new File("feedbacks.txt");
	static FileWriter fw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		setTitle("Feedback");
		Image img = new ImageIcon (this.getClass().getResource("/feedback.png")).getImage();
		setIconImage(img);
		setBackground(new Color(236,212,196));
		setBounds(100, 100, 655, 460);
		getContentPane().setBackground(new Color(255,239,217,255));
		getContentPane().setLayout(null);
		
		
		JLabel rate = new JLabel("Rate your experience with the service:");
		rate.setBounds(10, 11, 408, 60);
		rate.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		getContentPane().add(rate);
		
		JRadioButton Good = new JRadioButton("Good");
		Good.setOpaque(false);
		Good.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		Good.setBounds(230, 66, 81, 28);
		getContentPane().add(Good);
		
		JRadioButton Better = new JRadioButton("Better");
		Better.setOpaque(false);
		Better.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		Better.setBounds(313, 66, 81, 28);
		getContentPane().add(Better);
		
		JRadioButton Bad = new JRadioButton("Bad");
		Bad.setOpaque(false);
		Bad.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		Bad.setBounds(147, 66, 81, 28);
		getContentPane().add(Bad);
		
		JRadioButton Best = new JRadioButton("Best");
		Best.setOpaque(false);
		Best.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		Best.setBounds(396, 66, 81, 28);
		getContentPane().add(Best);
		
		bg.add(Bad);
		bg.add(Good);
		bg.add(Better);
		bg.add(Best);
		
		JLabel comments = new JLabel("Additional comments:");
		comments.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		comments.setBounds(10, 135, 408, 60);
		getContentPane().add(comments);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(250, 250, 210));
		textArea.setBounds(20, 185, 592, 183);
		getContentPane().add(textArea);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StartMenu s = new StartMenu();
				
				try {
					fw = new FileWriter(custFeedback, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter bw = new BufferedWriter(fw);
			
				String comments, rating, cmnts;
				String feedback;
				try
				{
					comments = textArea.getText();
					feedback = "";
					if (Bad.isSelected())
					{
						feedback = "Bad";
					}
					else if (Good.isSelected())
					{
						feedback = "Good";
					}
					else if (Better.isSelected())
					{
						feedback = "Better";
					}
					else if (Best.isSelected())
					{
						feedback = "Best";
					}
					
					rating = "Rating: " +feedback;
					cmnts = "Comments: " +comments;
					
					bw.write(rating);
					bw.newLine();
					bw.write(cmnts);
					bw.write("\n");
					bw.newLine();
					bw.newLine();
					bw.close();
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Thank you for your feedback!", "Feedback submitted", JOptionPane.INFORMATION_MESSAGE);
				s.show();
				dispose();
			}
		});
		Submit.setBounds(263, 388, 89, 23);
		getContentPane().add(Submit);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
}
