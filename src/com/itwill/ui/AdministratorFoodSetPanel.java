package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.service.JumunService;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdministratorFoodSetPanel extends JPanel {
	private JTabbedPane adminfoodTabbedPane;
	private JTable adminSandwichTable;
	private JTable adminLabTable;
	private JTable adminSaladTable;
	private JTable adminSideMenuTable;
	private JTable adminCookieTable;
	private JTable adminDrinkTable;
	private JTextField adminFoodNoTF;
	private JTextField admindFoodNameTF;
	private JTextField adminFoodPriceTF;
	private JTextField adminFoodCategoryTF;
	private JButton updateFoodNoBtn;
	private JButton updateFoodNameBtn;
	private JButton updateFoodPriceBtn;
	private JButton updateFoodCategoryBtn;
	private JButton foodAddBtn;
	private JButton foodDeleteBtn;
	
	Bob4JoMainFrame bob4JoMainFrame;
	JumunService jumunService;

	/**
	 * Create the panel.
	 */
	public AdministratorFoodSetPanel() {
		setBackground(new Color(220, 220, 220));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 89, 368, 319);
		add(scrollPane);
		
		adminfoodTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setViewportView(adminfoodTabbedPane);
		
		JPanel adminSandwichPanel = new JPanel();
		adminfoodTabbedPane.addTab("샌드위치", null, adminSandwichPanel, null);
		adminSandwichPanel.setLayout(new BorderLayout(0, 0));
		
		adminSandwichTable = new JTable();
		adminSandwichTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		adminSandwichPanel.add(adminSandwichTable, BorderLayout.CENTER);
		
		JPanel adminLabPanel = new JPanel();
		adminfoodTabbedPane.addTab("랩", null, adminLabPanel, null);
		adminLabPanel.setLayout(new BorderLayout(0, 0));
		
		adminLabTable = new JTable();
		adminLabTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC74C\uC2DD\uBA85", "\uAC00\uACA9"
			}
		));
		adminLabPanel.add(adminLabTable, BorderLayout.CENTER);
		
		JPanel adminSaladPanel = new JPanel();
		adminfoodTabbedPane.addTab("샐러드", null, adminSaladPanel, null);
		adminSaladPanel.setLayout(new BorderLayout(0, 0));
		
		adminSaladTable = new JTable();
		adminSaladTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		adminSaladPanel.add(adminSaladTable, BorderLayout.CENTER);
		
		JPanel adminSideMenuPanel = new JPanel();
		adminfoodTabbedPane.addTab("사이드메뉴", null, adminSideMenuPanel, null);
		adminSideMenuPanel.setLayout(new BorderLayout(0, 0));
		
		adminSideMenuTable = new JTable();
		adminSideMenuTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		adminSideMenuPanel.add(adminSideMenuTable, BorderLayout.CENTER);
		
		JPanel adminCookiePanel = new JPanel();
		adminfoodTabbedPane.addTab("쿠키", null, adminCookiePanel, null);
		adminCookiePanel.setLayout(new BorderLayout(0, 0));
		
		adminCookieTable = new JTable();
		adminCookieTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		adminCookiePanel.add(adminCookieTable, BorderLayout.CENTER);
		
		JPanel adminDrinkPanel = new JPanel();
		adminfoodTabbedPane.addTab("음료", null, adminDrinkPanel, null);
		adminDrinkPanel.setLayout(new BorderLayout(0, 0));
		
		adminDrinkTable = new JTable();
		adminDrinkTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		adminDrinkPanel.add(adminDrinkTable, BorderLayout.CENTER);
		
		JLabel pictureLb1 = new JLabel("");
		pictureLb1.setHorizontalAlignment(SwingConstants.CENTER);
		pictureLb1.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/관리자음식관리.png")));
		pictureLb1.setBounds(12, 10, 391, 53);
		add(pictureLb1);
		
		JLabel pictureLb2 = new JLabel("");
		pictureLb2.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/△▼.png")));
		pictureLb2.setBounds(0, 415, 415, 21);
		add(pictureLb2);
		
		JLabel noLb = new JLabel("번호");
		noLb.setHorizontalAlignment(SwingConstants.CENTER);
		noLb.setBounds(22, 450, 57, 15);
		add(noLb);
		
		adminFoodNoTF = new JTextField();
		adminFoodNoTF.setBounds(91, 447, 214, 21);
		add(adminFoodNoTF);
		adminFoodNoTF.setColumns(10);
		
		updateFoodNoBtn = new JButton("수정");
		updateFoodNoBtn.setBounds(319, 446, 71, 23);
		add(updateFoodNoBtn);
		
		JLabel foodNameLb = new JLabel("음식명");
		foodNameLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodNameLb.setBounds(22, 482, 57, 15);
		add(foodNameLb);
		
		admindFoodNameTF = new JTextField();
		admindFoodNameTF.setColumns(10);
		admindFoodNameTF.setBounds(91, 479, 214, 21);
		add(admindFoodNameTF);
		
		updateFoodNameBtn = new JButton("수정");
		updateFoodNameBtn.setBounds(319, 478, 71, 23);
		add(updateFoodNameBtn);
		
		JLabel foodPriceLb = new JLabel("가격");
		foodPriceLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodPriceLb.setBounds(22, 519, 57, 15);
		add(foodPriceLb);
		
		adminFoodPriceTF = new JTextField();
		adminFoodPriceTF.setColumns(10);
		adminFoodPriceTF.setBounds(91, 516, 214, 21);
		add(adminFoodPriceTF);
		
		updateFoodPriceBtn = new JButton("수정");
		updateFoodPriceBtn.setBounds(319, 515, 71, 23);
		add(updateFoodPriceBtn);
		
		JLabel foodCategoryLb = new JLabel("카테고리");
		foodCategoryLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodCategoryLb.setBounds(22, 552, 57, 15);
		add(foodCategoryLb);
		
		adminFoodCategoryTF = new JTextField();
		adminFoodCategoryTF.setColumns(10);
		adminFoodCategoryTF.setBounds(91, 549, 214, 21);
		add(adminFoodCategoryTF);
		
		updateFoodCategoryBtn = new JButton("수정");
		updateFoodCategoryBtn.setBounds(319, 548, 71, 23);
		add(updateFoodCategoryBtn);
		
		foodAddBtn = new JButton("추가하기");
		foodAddBtn.setBounds(91, 580, 97, 23);
		add(foodAddBtn);
		
		foodDeleteBtn = new JButton("삭제하기");
		foodDeleteBtn.setBounds(208, 580, 97, 23);
		add(foodDeleteBtn);
		
		JLabel pictureLb3 = new JLabel("");
		pictureLb3.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/△▼.png")));
		pictureLb3.setBounds(0, 60, 415, 21);
		add(pictureLb3);

	}//푸드셋패널
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
	}
}
