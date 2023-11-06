package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class ADDBUSDETAIL extends JFrame {

	private JPanel contentPane;
	private JTextField txtbusno;
	private JTextField txtsource;
	private JTextField txtdestination;
	private JTextField txtendingtime;
	private JTextField txtseat;
	private JTextField txtprice;
	private JTextField txtid;
	private JTextField txtstartingtime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDBUSDETAIL frame = new ADDBUSDETAIL();
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
		txtdestination.setText("");
		txtsource.setText("");
		txtprice.setText("");
	    txtseat.setText("");
		txtendingtime.setText("");
		txtstartingtime.setText("");
	}
	
	/**
	 * Create the frame.
	 */
	public ADDBUSDETAIL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD BUS DETAIL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(338, 51, 200, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BUS NO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(65, 112, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SOURCE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(65, 175, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DESTINATION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(452, 175, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String busno = txtbusno.getText();
				String id = txtid.getText();
				String source =txtsource.getText();
				String destination =txtdestination.getText();
				String busprice=txtprice.getText();
				String busseat=txtseat.getText();
				String busendingtime=txtendingtime.getText();
				String busstartingtime=txtstartingtime.getText();
				//	java.util.Date date = txtdate.getText();
				
				//date pending see the private variable row num 25.movement also pending.

				//java.util.Date d=JDateChooser.
				
				
				//String selectdate=(JTextField)txtdate.getDateEditor()).getText();
			//	SimpleDateFormat df= new SimpleDateFormat("yyy-MM-dd");
				//String bdate = df.format(sqldate);
				//String busmovement=(String)txtmovement.getSelectedItem();
			
				try {
					
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery = "select  * from busdetails where bus_no='"+busno+"'";
					
					
					
					ResultSet rs=st.executeQuery(selectquery);
					

					if(rs.next()) {
						
						infomessage("already bu details is added  ","create fresh entry");
						clearfieldvalue();//entha method ain enga call panrom na apo tha avanga ory entry 
						//add panna odana fresh ah atha mari varum
										}
					else
					{
						String query = "insert into busdetails(id,bus_no,bus_dest,bus_source,bus_price,total_seat,starting_time,ending_time) values('"+id+"','"+busno+"','"+destination+"','"+source+"','"+busprice+"','"+busseat+"','"+busstartingtime+"','"+busendingtime+"')";
						
						
						st.executeUpdate(query);
				
					infomessage("bus details is added","great work");
					clearfieldvalue();
		
					
				
					
					
					}
					}
					catch(Exception e1) {
						System.out.println(e1);
					}

				}
				
			
		});
		btnNewButton.setBounds(278, 370, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearfieldvalue();
				
			}
		});
		btnNewButton_1.setBounds(487, 370, 89, 23);
		contentPane.add(btnNewButton_1);
		
		txtbusno = new JTextField();
		txtbusno.setBounds(203, 109, 136, 20);
		contentPane.add(txtbusno);
		txtbusno.setColumns(10);
		
		txtsource = new JTextField();
		txtsource.setBounds(203, 172, 136, 20);
		contentPane.add(txtsource);
		txtsource.setColumns(10);
		
		txtdestination = new JTextField();
		txtdestination.setBounds(613, 172, 154, 20);
		contentPane.add(txtdestination);
		txtdestination.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("STARTING TIME");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(65, 239, 89, 17);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("SEAT");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(452, 309, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PRICE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(65, 309, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		txtendingtime = new JTextField();
		txtendingtime.setBounds(613, 237, 154, 20);
		contentPane.add(txtendingtime);
		txtendingtime.setColumns(10);
		
		txtseat = new JTextField();
		txtseat.setBounds(613, 306, 154, 20);
		contentPane.add(txtseat);
		txtseat.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(203, 306, 136, 20);
		contentPane.add(txtprice);
		txtprice.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("BUS ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(452, 112, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtid = new JTextField();
		txtid.setBounds(613, 109, 154, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ENDING TIME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(452, 240, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		txtstartingtime = new JTextField();
		txtstartingtime.setBounds(203, 237, 136, 20);
		contentPane.add(txtstartingtime);
		txtstartingtime.setColumns(10);
		
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
		btnNewButton_2.setBounds(386, 417, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
