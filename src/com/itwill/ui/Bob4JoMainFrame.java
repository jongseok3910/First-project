package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Bob4JoMainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bob4JoMainFrame frame = new Bob4JoMainFrame();
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
	public Bob4JoMainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bob4JoMainFrame.class.getResource("/com/itwill/ui/창아이콘.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 710);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("SUBWAY");
		menuBar.add(memberMenu);
		
		JMenuItem loginMenuItem = new JMenuItem("로그인");
		memberMenu.add(loginMenuItem);
		
		JMenuItem logoutMenuItem = new JMenuItem("로그아웃");
		memberMenu.add(logoutMenuItem);
		
		JMenuItem joinMenuItem = new JMenuItem("가입");
		memberMenu.add(joinMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, "name_1287698926322500");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Bob4JoMainFrame.class.getResource("/com/itwill/ui/메인로고.png")));
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_1287940689146700");
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_2.add(tabbedPane, BorderLayout.CENTER);
	}

}
