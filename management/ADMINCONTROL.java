package bus.management;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;

public class ADMINCONTROL extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADMINCONTROL frame = new ADMINCONTROL();
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
	public ADMINCONTROL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_4 = new JMenu("manage bus");
		mnNewMenu_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("add bus details");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//mntmNewMenuItem_4.removeAll();
				//addbusdetails abd =new addbusdetails();
				//mntmNewMenuItem_4.add(abd).setVisible(true);
				//abd.show();
			ADDBUSDETAIL abd=new ADDBUSDETAIL();
			abd.setLocationRelativeTo(null);
			abd.setVisible(true);				
			
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_4.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("all bus details");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALLBUSDETAILS abds=new ALLBUSDETAILS();
				abds.setLocationRelativeTo(null);
				abds.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("employee");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("add employee");
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADDEMPLOYEDETAIL ade = new ADDEMPLOYEDETAIL();
				ade.setLocationRelativeTo(null);
				ade.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("all employee");
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALLEMPLOYE aed=new ALLEMPLOYE();
				aed.setLocationRelativeTo(null);
				aed.setVisible(true);
				}
		});
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_2 = new JMenu("booking");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("add booking ");
		mntmNewMenuItem_14.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ADDBOOKING g=new ADDBOOKING();
				g.setLocationRelativeTo(null);
				g.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("all booking details");
		mntmNewMenuItem_19.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ALLBOOKINGDETAILS bbd=new ALLBOOKINGDETAILS();
				bbd.setLocationRelativeTo(null);
				bbd.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("see your booking");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SEEYOURBOOKING syb =new SEEYOURBOOKING();
				syb.setLocationRelativeTo(null);
				syb.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_5 = new JMenu("manage admin");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("add admin");
		mntmNewMenuItem_15.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ADMINLOGIN al=new ADMINLOGIN();
				al.setLocationRelativeTo(null);
				al.setVisible(true);
				
				
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_15);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "confirm you want exit","exit",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)//exit button code
						{
						System.exit(0);
					}
			}
		});
		menuBar.add(btnNewButton);
	}
}
