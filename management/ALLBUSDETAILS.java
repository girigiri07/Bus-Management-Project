package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ALLBUSDETAILS extends JFrame {

	private JPanel contentPane;
	private final JTable tables = new JTable();
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALLBUSDETAILS frame = new ALLBUSDETAILS();
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
	public ALLBUSDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 625, 371);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tables);
		tables.setSurrendersFocusOnKeystroke(true);
		tables.setFillsViewportHeight(true);
		tables.setColumnSelectionAllowed(true);
		tables.setCellSelectionEnabled(true);
		
		JButton btnNewButton = new JButton("CLICK THIS BUTTON TO SEE ALL BUS DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery = "select  * from busdetails" ;
					ResultSet rs=st.executeQuery(selectquery);
					ResultSetMetaData	rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) tables.getModel() ;
					
					int cols=rsmd.getColumnCount();
					String[] colname=new String[cols];
					for(int i=0;i<cols;i++) {
						colname[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
						
					}
					
					
					while(rs.next()) {
						 String id ;
						 String bus_no  ;
						 String bus_dest ;
						 String bus_source  ;
						 String bus_price ;
						 String total_seat ; 
						 String starting_time  ;
						 String ending_time  ;
						id = rs.getString(1);
						bus_no =rs.getString(2);
						bus_dest = rs.getString(3);
						
							bus_source =rs.getString(4);
							bus_price=rs.getString(5);
						total_seat=rs.getString(6); 
					

							starting_time=rs.getString(7);
							ending_time=rs.getString(8);
							String [] row= {id,bus_no,bus_dest,bus_source,bus_price,total_seat,starting_time,ending_time} ;
						
							model.addRow(row);
							
							
					}
						con.close();
						
						
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton.setBounds(85, 19, 288, 23);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(516, 19, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
