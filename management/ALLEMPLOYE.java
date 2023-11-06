package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ALLEMPLOYE extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ALLEMPLOYE frame = new ALLEMPLOYE();
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
	public ALLEMPLOYE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CLICK THIS BUTTON TO SEE ALL EMPLOYE DETAILS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery1 = "select  * from employedetails"; 
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
						 String firstname  ;
						 String lastname ;
						 String phonenum1  ;
						 String phonenum2 ;
						 String address ; 
						
						id = rs.getString(1);
						firstname=rs.getString(2);
						lastname = rs.getString(3);
						
							phonenum1=rs.getString(4);
							phonenum2=rs.getString(5);
						address=rs.getString(6); 
					

						
							String [] row= {id,firstname,lastname,phonenum1,phonenum2,address} ;
							model.addRow(row);
							
					}
						con.close();
						
						
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(137, 11, 318, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 87, 571, 243);
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
		btnNewButton_1.setBounds(496, 53, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
