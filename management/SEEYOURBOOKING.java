package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class SEEYOURBOOKING extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SEEYOURBOOKING frame = new SEEYOURBOOKING();
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
	public SEEYOURBOOKING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 856, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 74, 84, 14);
		contentPane.add(lblNewLabel);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(154, 71, 137, 20);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(400, 74, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(567, 71, 156, 20);
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("CLICK THIS BUTTON TO SEE YOUR BOOKING DETAILS");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String firstname1 =txtfirstname.getText();
				String lastname1 =txtlastname.getText();
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery1 = "select  * from bookingdetails where firstname= '"+firstname1+"' and lastname='"+lastname1+"'" ;
					ResultSet rs=st.executeQuery(selectquery1);
					ResultSetMetaData	rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table.getModel() ;
					
					int cols=rsmd.getColumnCount();
					String[] colname=new String[cols];
					for(int i=0;i<cols;i++) {
						colname[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
						
					}
					
					
					while(rs.next()) {
						 String id ;
						 String firstname ;
						 String lastname ;
						 
						 String dest ;
						 
						 String price ;
						 String seat ; 
						 String source  ;
						 String bus_no  ;
						
						id = rs.getString(1);
						firstname =rs.getString(2);
						lastname = rs.getString(3);
						dest=rs.getString(4);
						
							
							price=rs.getString(5);
						seat=rs.getString(6); 
						source =rs.getString(7);
						bus_no =rs.getString(8);

							
							String [] row= {id,firstname,lastname,dest,price,seat,source,bus_no} ;
							model.addRow(row);
							
					}
					
					
					
					
										con.close();
										
				}
						catch(Exception e1) {
						
						
							System.out.println(e1);
						}
				
				}
				
			
				
			
		});
		btnNewButton_2.setBounds(268, 157, 319, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton = new JButton("Exit");
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
		btnNewButton.setBounds(759, 157, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("FIRST FILL  YOUR  BOOKING  DETAILS  THEN CLICK BOOKING DETAILS BUTTON");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(256, 11, 443, 14);
		contentPane.add(lblNewLabel_2);
		}

}
