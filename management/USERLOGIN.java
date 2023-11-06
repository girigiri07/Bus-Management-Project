package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class USERLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USERLOGIN frame = new USERLOGIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void infomessage(String message,String title) {
		JOptionPane.showConfirmDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
	}
public void clear() {
	txtusername.setText("");
	txtpassword.setText("");
}
	/**
	 * Create the frame.
	 */
	public USERLOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" USER LOGIN");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(212, 31, 132, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(151, 154, 68, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(151, 218, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		txtusername = new JTextField();
		txtusername.setBounds(292, 151, 202, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(292, 215, 202, 20);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					String USERNAME =txtusername.getText();
					String PASSWORD =txtpassword.getText();
			
					
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery = "select  * from userdetails where USERNAME='"+USERNAME+"' and PASS_WORD='"+PASSWORD+"'";
					
					
					
					ResultSet rs=st.executeQuery(selectquery);
					

					if(rs.next()) {
						
						infomessage("welcome","alert");
						dispose();
						CUSTOMERBOOKING cb=new CUSTOMERBOOKING();
						cb.setLocationRelativeTo(null);
						cb.setVisible(true);
											}
					else
					{
						
					
				
					infomessage("create new account","welcome bro");
					dispose();
					NEWUSER newuser=new NEWUSER();
					newuser.setLocationRelativeTo(null);
					newuser.setVisible(true);
					
					
				
					
					
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				
			
				

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(292, 280, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(405, 280, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CREATE ACCOUNT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NEWUSER nu = new NEWUSER();
				nu.setLocationRelativeTo(null);
				nu.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(292, 326, 202, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ADMINLOGIN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ADMINLOGIN al = new ADMINLOGIN();
				al.setLocationRelativeTo(null);
				al.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(151, 280, 115, 69);
		contentPane.add(btnNewButton_3);
	}
}
