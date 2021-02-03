package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class foodSelectPanel extends JPanel {
	private JTable sandwichTable;
	private JTable labTable;
	private JTable saladTable;
	private JTable sidemenuTable;
	private JTable cookieTable;
	private JTable drinkTable;
	private JButton basketBtn;
	private JComboBox quantityCB;

	/**
	 * Create the panel.
	 */
	public foodSelectPanel() {
		setBackground(new Color(204, 255, 204));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(19, 107, 374, 436);
		add(tabbedPane);
		
		JPanel sandwichPanel = new JPanel();
		tabbedPane.addTab("샌드위치", null, sandwichPanel, null);
		sandwichPanel.setLayout(new BorderLayout(0, 0));
		
		sandwichTable = new JTable();
		sandwichTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		sandwichPanel.add(sandwichTable, BorderLayout.CENTER);
		
		JPanel labPanel = new JPanel();
		tabbedPane.addTab("랩", null, labPanel, null);
		labPanel.setLayout(new BorderLayout(0, 0));
		
		labTable = new JTable();
		labTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		labPanel.add(labTable, BorderLayout.CENTER);
		
		JPanel saladPanel = new JPanel();
		tabbedPane.addTab("샐러드", null, saladPanel, null);
		saladPanel.setLayout(new BorderLayout(0, 0));
		
		saladTable = new JTable();
		saladPanel.add(saladTable, BorderLayout.CENTER);
		
		JPanel sidePanel = new JPanel();
		tabbedPane.addTab("사이드메뉴", null, sidePanel, null);
		sidePanel.setLayout(new BorderLayout(0, 0));
		
		sidemenuTable = new JTable();
		sidemenuTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		sidePanel.add(sidemenuTable);
		
		JPanel cookiePanel = new JPanel();
		tabbedPane.addTab("쿠키", null, cookiePanel, null);
		cookiePanel.setLayout(new BorderLayout(0, 0));
		
		cookieTable = new JTable();
		cookieTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		cookiePanel.add(cookieTable, BorderLayout.CENTER);
		
		JPanel drinkPanel = new JPanel();
		tabbedPane.addTab("음료", null, drinkPanel, null);
		drinkPanel.setLayout(new BorderLayout(0, 0));
		
		drinkTable = new JTable();
		drinkTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		drinkPanel.add(drinkTable, BorderLayout.CENTER);
		
		JComboBox storeCheckCB = new JComboBox();
		storeCheckCB.setBounds(105, 44, 277, 23);
		add(storeCheckCB);
		
		basketBtn = new JButton("장바구니");
		basketBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		basketBtn.setBounds(285, 570, 97, 23);
		add(basketBtn);
		
		JLabel storeLb = new JLabel("지점선택");
		storeLb.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		storeLb.setBounds(34, 48, 57, 15);
		add(storeLb);
		
		quantityCB = new JComboBox();
		quantityCB.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		quantityCB.setBounds(76, 571, 70, 23);
		add(quantityCB);
		
		JLabel lblNewLabel = new JLabel("수량");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lblNewLabel.setBounds(34, 575, 57, 15);
		add(lblNewLabel);

	}
}
