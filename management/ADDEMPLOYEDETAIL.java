package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ADDEMPLOYEDETAIL extends JFrame {

	private JPanel contentPane;
	private JTextField elastname;
	private JTextField ephonenum1;
	private JTextField eid;
	private JTextField eaddress;
	private JTextField ephonenum2;
	private JTextField efirstname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDEMPLOYEDETAIL frame = new ADDEMPLOYEDETAIL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearfieldvalue() {
		eid.setText("");
		efirstname.setText("");
		ephonenum1.setText("");
		eaddress.setText("");
		ephonenum2.setText("");
		elastname.setText("");
		
	}
	public static void infomessage(String message,String title) {
		JOptionPane.showConfirmDialog(null, message, title,JOptionPane.INFORMATION_MESSAGE);
	}

	


	/**
	 * Create the frame.
	 */
	public ADDEMPLOYEDETAIL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		efirstname = new JTextField();
		efirstname.setBounds(179, 76, 112, 20);
		contentPane.add(efirstname);
		efirstname.setColumns(10);
		
		elastname = new JTextField();
		elastname.setBounds(179, 163, 112, 20);
		contentPane.add(elastname);
		elastname.setColumns(10);
		
		ephonenum1 = new JTextField();
		ephonenum1.setBounds(179, 248, 112, 20);
		contentPane.add(ephonenum1);
		ephonenum1.setColumns(10);
		
		eid = new JTextField();
		eid.setBounds(492, 76, 139, 20);
		contentPane.add(eid);
		eid.setColumns(10);
		
		eaddress = new JTextField();
		eaddress.setBounds(492, 163, 139, 20);
		contentPane.add(eaddress);
		eaddress.setColumns(10);
		
		ephonenum2 = new JTextField();
		ephonenum2.setBounds(492, 248, 139, 20);
		contentPane.add(ephonenum2);
		ephonenum2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(41, 79, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(41, 166, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PHONE NUM 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(41, 251, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(363, 79, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADDRESS");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(363, 166, 76, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PHONE NUM 2");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(363, 251, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = eid.getText();
				String firstname = efirstname.getText();
				String address =ephonenum1.getText();
				String phonenum1 = eaddress.getText();
				String lastname =elastname.getText();
				String phonenum2 =ephonenum2.getText();
		
				
	
			
				try {
					
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();

					
					String selectquery = "select  * from employedetails where firstname='"+firstname+"' and lastname='"+lastname+"'";
					
					ResultSet rs=st.executeQuery(selectquery);
					
					

					if(rs.next()) {
						
						infomessage("already employe details is added  ","create fresh entry");
						clearfieldvalue();
										}
					else
					{
						String query = "insert into employedetails(id,firstname,address,lastname,phonenum1,phonenum2)  values('"+id+"','"+firstname+"','"+address+"','"+lastname+"','"+phonenum1+"','"+phonenum2+"')";
						
						
						st.executeUpdate(query);
				
					infomessage("employee details is added","great work");
					clearfieldvalue();
		
					
				
					
					
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				
				
			}
		});
		btnNewButton.setBounds(202, 311, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearfieldvalue();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(349, 311, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("CREATE EMPLOYE DETAILS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_6.setBounds(221, 27, 252, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "confirm you want exit","exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)//exit button code
						{
						System.exit(0);
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(273, 376, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
