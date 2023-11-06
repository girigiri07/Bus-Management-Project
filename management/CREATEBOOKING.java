package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CREATEBOOKING extends JFrame {

	private JPanel contentPane;
	private JTextField txtbusno;
	private JTextField txtsource;
	private JTextField txtdest;
	private JTextField txtseat;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtprice;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CREATEBOOKING frame = new CREATEBOOKING();
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

	public void clearfieldvalue() {
		txtid.setText("");
		txtbusno.setText("");
		txtdest.setText("");
		txtsource.setText("");
		txtprice.setText("");
	    txtseat.setText("");
		txtfirstname.setText("");
		txtlastname.setText("");
	}
	/**
	 * Create the frame.
	 */
	public CREATEBOOKING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE BOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(297, 22, 207, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUS NO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(54, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SOURCE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(54, 137, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DESTINATION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(54, 203, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SEAT");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(54, 287, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FIRST NAME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(461, 80, 68, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("LAST NAME");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(461, 137, 68, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PRICE");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(461, 203, 68, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("ID NO");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(461, 287, 68, 14);
		contentPane.add(lblNewLabel_8);
		
		txtbusno = new JTextField();
		txtbusno.setBounds(200, 77, 141, 20);
		contentPane.add(txtbusno);
		txtbusno.setColumns(10);
		
		txtsource = new JTextField();
		txtsource.setBounds(200, 134, 141, 20);
		contentPane.add(txtsource);
		txtsource.setColumns(10);
		
		txtdest = new JTextField();
		txtdest.setBounds(200, 200, 141, 20);
		contentPane.add(txtdest);
		txtdest.setColumns(10);
		
		txtseat = new JTextField();
		txtseat.setBounds(200, 284, 141, 20);
		contentPane.add(txtseat);
		txtseat.setColumns(10);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(601, 77, 131, 20);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(601, 134, 131, 20);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(601, 200, 131, 20);
		contentPane.add(txtprice);
		txtprice.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(601, 284, 131, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String firstname = txtfirstname.getText();
				String bus =txtbusno.getText();
				String source = txtsource.getText();
				String lastname =txtlastname.getText();
				String seat =txtseat.getText();
				String price =txtprice.getText();
				String destination =txtdest.getText();
		
				
	
			
				try {
					
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();

					
					String selectquery = "select  * from bookingdetails where firstname='"+firstname+"' and lastname='"+lastname+"'";
					
					ResultSet rs=st.executeQuery(selectquery);
					
					

					if(rs.next()) {
						
						infomessage("already booking details is added  ","create fresh entry");
						clearfieldvalue();
										}
					else
					{
						String query = "insert into bookingdetails  values('"+id+"','"+firstname+"','"+lastname+"','"+destination+"','"+price+"','"+seat+"','"+source+"','"+bus+"')";
						
						
						st.executeUpdate(query);
				
					infomessage("booking details is added","Thank You");
					clearfieldvalue();
		
					
				
					
					
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				
			}
		});
		btnNewButton.setBounds(274, 370, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearfieldvalue();
				//reset method also use this method
			}
		});
		btnNewButton_1.setBounds(459, 370, 89, 23);
		contentPane.add(btnNewButton_1);
		
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(370, 410, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
