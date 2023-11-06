package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ADMINLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField adminuser;
	private JTextField adminpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMINLOGIN frame = new ADMINLOGIN();
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
	adminuser.setText("");
	adminpass.setText("");

	}
	/**
	 * Create the frame.
	 */
	public ADMINLOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(284, 43, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USER NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(187, 115, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(187, 172, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		adminuser = new JTextField();
		adminuser.setBounds(284, 112, 203, 20);
		contentPane.add(adminuser);
		adminuser.setColumns(10);
		
		adminpass = new JTextField();
		adminpass.setBounds(284, 169, 203, 20);
		contentPane.add(adminpass);
		adminpass.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String USERNAME =adminuser.getText();
					String PASSWORD =adminpass.getText();
			
					
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery = "select  * from admindetails where username='"+USERNAME+"' and pass_word='"+PASSWORD+"'";
					
					
					
					ResultSet rs=st.executeQuery(selectquery);
					

					if(rs.next()) {
						
						//infomessage("welcome ","alert");
						dispose();
						ADMINCONTROL ac= new ADMINCONTROL();  //antha wecome page la user name vara mari pananum athu pending
						ac.setLocationRelativeTo(null);
						ac.setVisible(true);					}
					else
					{
						
					
				
					infomessage("YOU ARE NOT VALID","GO BACK");
				
					
				
					
					
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(284, 215, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(398, 215, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("USERLOGIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				USERLOGIN ul = new USERLOGIN();
				ul.setLocationRelativeTo(null);//entha method kudutha antha form centre la varum
				ul.setVisible(true);
				}
			
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(284, 266, 203, 23);
		contentPane.add(btnNewButton_2);
	}
}
