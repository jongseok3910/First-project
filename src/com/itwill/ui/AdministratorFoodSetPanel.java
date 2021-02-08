package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdministratorFoodSetPanel extends JPanel {
	private JTable sandwichTable;
	private JTable labTable;
	private JTable saladTable;
	private JTable sideMenuTable;
	private JTable cookieTable;
	private JTable drinkTable;
	private JTextField foodNoTF;
	private JTextField foodNameTF;
	private JTextField foodPriceTF;
	private JTextField foodCategoryTF;
	private JButton foodNoBtn;
	private JButton foodNameBtn;
	private JButton foodCategoryBtn;
	private JButton foodPriceBtn;
	private JPanel sandwichPanel;
	private JPanel labPanel;
	private JPanel saladPanel;
	private JPanel sideMenuPanel;
	private JPanel cookiePanel;
	private JPanel drinkPanel;
	private JButton foodAddBtn;
	private JButton foodDeleteBtn;
	private JLabel pictureLabel2;

	/**
	 * Create the panel.
	 */
	public AdministratorFoodSetPanel() {
		setBackground(new Color(220, 220, 220));
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setBounds(30, 62, 355, 348);
		add(tabbedPane);
		
		sandwichPanel = new JPanel();
		tabbedPane.addTab("샌드위치", null, sandwichPanel, null);
		sandwichPanel.setLayout(new BorderLayout(0, 0));
		
		sandwichTable = new JTable();
		sandwichTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		sandwichPanel.add(sandwichTable, BorderLayout.CENTER);
		
		labPanel = new JPanel();
		tabbedPane.addTab("랩", null, labPanel, null);
		labPanel.setLayout(new BorderLayout(0, 0));
		
		labTable = new JTable();
		labTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		labPanel.add(labTable, BorderLayout.CENTER);
		
		saladPanel = new JPanel();
		tabbedPane.addTab("샐러드", null, saladPanel, null);
		saladPanel.setLayout(new BorderLayout(0, 0));
		
		saladTable = new JTable();
		saladTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uC218\uB7C9"
			}
		));
		saladPanel.add(saladTable, BorderLayout.CENTER);
		
		sideMenuPanel = new JPanel();
		tabbedPane.addTab("사이드메뉴", null, sideMenuPanel, null);
		sideMenuPanel.setLayout(new BorderLayout(0, 0));
		
		sideMenuTable = new JTable();
		sideMenuTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		sideMenuPanel.add(sideMenuTable, BorderLayout.CENTER);
		
		cookiePanel = new JPanel();
		tabbedPane.addTab("쿠키", null, cookiePanel, null);
		cookiePanel.setLayout(new BorderLayout(0, 0));
		
		cookieTable = new JTable();
		cookieTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		cookiePanel.add(cookieTable, BorderLayout.CENTER);
		
		drinkPanel = new JPanel();
		tabbedPane.addTab("음료", null, drinkPanel, null);
		drinkPanel.setLayout(new BorderLayout(0, 0));
		
		drinkTable = new JTable();
		drinkTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		drinkPanel.add(drinkTable, BorderLayout.CENTER);
		
		JLabel noLb = new JLabel("번호");
		noLb.setHorizontalAlignment(SwingConstants.CENTER);
		noLb.setBounds(27, 452, 57, 15);
		add(noLb);
		
		JLabel foodNameLb = new JLabel("음식명");
		foodNameLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodNameLb.setBounds(27, 485, 57, 15);
		add(foodNameLb);
		
		JLabel priceLb = new JLabel("가격");
		priceLb.setHorizontalAlignment(SwingConstants.CENTER);
		priceLb.setBounds(27, 516, 57, 15);
		add(priceLb);
		
		JLabel categoryLb = new JLabel("카테고리");
		categoryLb.setHorizontalAlignment(SwingConstants.CENTER);
		categoryLb.setBounds(27, 549, 57, 15);
		add(categoryLb);
		
		foodNoTF = new JTextField();
		foodNoTF.setBounds(104, 449, 214, 21);
		add(foodNoTF);
		foodNoTF.setColumns(10);
		
		foodNameTF = new JTextField();
		foodNameTF.setColumns(10);
		foodNameTF.setBounds(104, 482, 214, 21);
		add(foodNameTF);
		
		foodPriceTF = new JTextField();
		foodPriceTF.setColumns(10);
		foodPriceTF.setBounds(104, 513, 214, 21);
		add(foodPriceTF);
		
		foodCategoryTF = new JTextField();
		foodCategoryTF.setColumns(10);
		foodCategoryTF.setBounds(104, 546, 214, 21);
		add(foodCategoryTF);
		
		foodNoBtn = new JButton("수정");
		foodNoBtn.setBounds(325, 448, 62, 23);
		add(foodNoBtn);
		
		foodNameBtn = new JButton("수정");
		foodNameBtn.setBounds(325, 481, 62, 23);
		add(foodNameBtn);
		
		foodPriceBtn = new JButton("수정");
		foodPriceBtn.setBounds(325, 512, 62, 23);
		add(foodPriceBtn);
		
		foodCategoryBtn = new JButton("수정");
		foodCategoryBtn.setBounds(325, 545, 62, 23);
		add(foodCategoryBtn);
		
		foodAddBtn = new JButton("추가");
		foodAddBtn.setBounds(103, 576, 97, 23);
		add(foodAddBtn);
		
		foodDeleteBtn = new JButton("삭제");
		foodDeleteBtn.setBounds(223, 576, 97, 23);
		add(foodDeleteBtn);
		
		JLabel pictureLabel1 = new JLabel("");
		pictureLabel1.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/관리자음식관리.png")));
		pictureLabel1.setBounds(12, 10, 391, 42);
		add(pictureLabel1);
		
		pictureLabel2 = new JLabel("");
		pictureLabel2.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/△▼.png")));
		pictureLabel2.setBounds(0, 409, 415, 33);
		add(pictureLabel2);

	}
}
