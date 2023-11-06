package bus.management;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;

public class NEWUSER extends JFrame {

	private JPanel contentPane;
	private JTextField txtfirstname;
	private JTextField txtusername;
	private JTextField txtemailid;
	private JTextField txtlastname;
	private JTextField txtpassword;
	private JTextField txtweburl;
	private JTextField txtid;
	private JTextField txtaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NEWUSER frame = new NEWUSER();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//ethu vanthu register achu na message varum inserted mari
	
	public static void infomessage(String message,String title) {
		JOptionPane.showConfirmDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void clearfieldvalue() {
		txtid.setText("");
		txtfirstname.setText("");
		txtlastname.setText("");
		txtaddress.setText("");
		txtemailid.setText("");
		txtpassword.setText("");
		txtweburl.setText("");
		txtusername.setText("");
		
	}
	/**
	 * Create the frame.
	 */
	public NEWUSER() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW USER REGISTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(369, 30, 144, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(108, 84, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USER NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(108, 159, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMAIL ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(108, 215, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(222, 81, 121, 20);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(222, 156, 121, 20);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtemailid = new JTextField();
		txtemailid.setBounds(222, 212, 121, 20);
		contentPane.add(txtemailid);
		txtemailid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("LAST NAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(417, 84, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PASSWORD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(417, 159, 79, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("WEB URL");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(417, 215, 79, 14);
		contentPane.add(lblNewLabel_6);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(545, 81, 129, 20);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(545, 156, 129, 20);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		txtweburl = new JTextField();
		txtweburl.setBounds(545, 212, 129, 20);
		contentPane.add(txtweburl);
		txtweburl.setColumns(10);
		
		
		
		JButton butregister = new JButton("REGISTER");
		butregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String FIRSTNAME=txtfirstname.getText();
				String LASTNAME = txtlastname.getText();
				String USERNAME =txtusername.getText();
				String ID =txtid.getText();
				String PASSWORD =txtpassword.getText();
				String EMAILID =txtemailid.getText();
				String WEBURL =txtweburl.getText();
				String ADDRESS =txtaddress.getText();
				
				String url = "jdbc:mysql://localhost:3306/busmanagement";
				String Username= "root";
				String passWord= "GIRIGIRI2004";
				Connection con = DriverManager.getConnection(url,Username,passWord);
				Statement st=con.createStatement();
				
				String selectquery = "select  * from userdetails where USERNAME='"+USERNAME+"' and PASS_WORD='"+PASSWORD+"'";
				
				//entha mari duplicate login panna find panrathu entha mari query  vachu panalam 
				
				ResultSet rs=st.executeQuery(selectquery);
				

				if(rs.next()) {
					infomessage("already registed ","welcome bro");
				}
				else
				{
					
					String query = "insert into userdetails  values('"+ID+"','"+FIRSTNAME+"','"+LASTNAME+"','"+USERNAME+"','"+PASSWORD+"','"+EMAILID+"','"+WEBURL+"','"+ADDRESS+"')";
				
				
				
				
					st.executeUpdate(query);
				infomessage("information is inserted","Alert");
				dispose();
				USERLOGIN in=new USERLOGIN();
				in.setLocationRelativeTo(null);
				in.setVisible(true);
				
				
			
				
				
				}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		butregister.setFont(new Font("Tahoma", Font.BOLD, 11));
		butregister.setBounds(276, 342, 89, 23);
		contentPane.add(butregister);
		
		JButton butreset = new JButton("RESET");
		butreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearfieldvalue();
			}
		});
		butreset.setFont(new Font("Tahoma", Font.BOLD, 11));
		butreset.setBounds(389, 342, 89, 23);
		contentPane.add(butreset);
		
		JButton butalreadyhaveaccountsignin = new JButton("ALREADY HAVE ACCOUNT ? SIGN IN");
		butalreadyhaveaccountsignin.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				USERLOGIN ul = new USERLOGIN();
				ul.setLocationRelativeTo(null);//entha method kudutha antha form centre la varum
				ul.setVisible(true);
				
			}
		});
		butalreadyhaveaccountsignin.setFont(new Font("Tahoma", Font.BOLD, 11));
		butalreadyhaveaccountsignin.setBounds(276, 394, 318, 23);
		contentPane.add(butalreadyhaveaccountsignin);
		
		JLabel lblNewLabel_7 = new JLabel("ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(108, 272, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		txtid = new JTextField();
		txtid.setBounds(222, 269, 121, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("ADDRESS");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(417, 272, 64, 14);
		contentPane.add(lblNewLabel_8);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(545, 269, 129, 20);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "confirm you want exit","exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)//exit button code
						{
						System.exit(0);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(505, 342, 89, 23);
		contentPane.add(btnNewButton);
	}
}
