package bus.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class ADDBOOKING extends JFrame {

	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADDBOOKING frame = new ADDBOOKING();
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
	public ADDBOOKING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SOURCE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(20, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		comboBox.setBounds(139, 18, 101, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("DESTINATION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(20, 75, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CLICK THIS BUTTON TO SELECT  THE BUS SOURCE ");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery1 = "select  bus_source from busdetails " ;
					ResultSet rs=st.executeQuery(selectquery1);
					DefaultComboBoxModel model =(DefaultComboBoxModel) comboBox.getModel();
					
				
				while(rs.next()) {
						
					
						//comboBox.addItem(Integer.toString(rs.getInt("bus_source")));
					comboBox.addItem((rs.getString("bus_source")));
					}
					
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setBounds(284, 18, 307, 23);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(139, 71, 101, 22);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("CLICK THIS BUTTON TO SELECT THE BUS DESTINATION");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery2 = "select  bus_dest from busdetails " ;
					ResultSet rs=st.executeQuery(selectquery2);
					DefaultComboBoxModel model =(DefaultComboBoxModel) comboBox_1.getModel();
					
				
				while(rs.next()) {
						
					
						//comboBox.addItem(Integer.toString(rs.getInt("bus_source")));
					comboBox_1.addItem((rs.getString("bus_dest")));
					}
					
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnNewButton_1.setBounds(284, 71, 307, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("DATE");
		lblNewLabel_2.setBounds(623, 55, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(666, 55, 156, 18);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 185, 625, 250);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_2 = new JButton("CLICK THIS BUTTON TO SEE THE SELECTED BUS  DETAILS");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String SOURCE=(String) comboBox.getSelectedItem();
				String DESTINATION=(String) comboBox_1.getSelectedItem();
				try {
					String url = "jdbc:mysql://localhost:3306/busmanagement";
					String Username= "root";
					String passWord= "GIRIGIRI2004";
					Connection con = DriverManager.getConnection(url,Username,passWord);
					Statement st=con.createStatement();
					
					String selectquery1 = "select  * from busdetails where bus_dest= '"+DESTINATION+"' and bus_source='"+SOURCE+"'" ;
					ResultSet rs=st.executeQuery(selectquery1);
					ResultSetMetaData	rsmd= rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel) table_1.getModel() ;
					
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
						 String bus_time  ;
						id = rs.getString(1);
						bus_no =rs.getString(2);
						bus_dest = rs.getString(3);
						
							bus_source =rs.getString(4);
							bus_price=rs.getString(5);
						total_seat=rs.getString(6); 
					

							bus_time=rs.getString(7);
							String [] row= {id,bus_no,bus_dest,bus_source,bus_price,total_seat,bus_time} ;
							model.addRow(row);
							
					}
						con.close();
						
						
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_2.setBounds(131, 147, 365, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CREATE BOOKING");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CREATEBOOKING bbc=new CREATEBOOKING();
			bbc.setLocationRelativeTo(null);
			bbc.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(683, 239, 139, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "confirm you want exit","exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)//exit button code
						{
						System.exit(0);
					}
			}
		});
		btnNewButton_4.setBounds(704, 301, 89, 23);
		contentPane.add(btnNewButton_4);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
