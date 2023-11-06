package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ALLBOOKINGDETAILS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALLBOOKINGDETAILS frame = new ALLBOOKINGDETAILS();
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
	public ALLBOOKINGDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 921, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CLICK THIS BUTTON TO SEE  ALL BOOKING DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery1 = "select  * from bookingdetails ";
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
		btnNewButton.setBounds(186, 21, 328, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 81, 703, 321);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "confirm you want exit","exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)//exit button code
						{
						System.exit(0);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(632, 47, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
