package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.dao.FoodDao;
import com.itwill.service.JumunService;
import com.itwill.vo.Food;

import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class AdministratorFoodSetPanel extends JPanel {
	private JTabbedPane adminfoodTabbedPane;
	private JTable adminSandwichTable;
	private JTable adminLabTable;
	private JTable adminSaladTable;
	private JTable adminSideMenuTable;
	private JTable adminCookieTable;
	private JTable adminDrinkTable;
	private JTextField adminFoodNoTF;
	private JTextField adminFoodNameTF;
	private JTextField adminFoodPriceTF;
	private JTextField adminFoodCategoryTF;
	private JButton foodUpdateBtn;
	private JButton foodDeleteBtn;

	Bob4JoMainFrame bob4JoMainFrame;
	JumunService jumunService;
	int selectedFoodNo;
	private JButton foodAddBtn;

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
		adminfoodTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index=adminfoodTabbedPane.getSelectedIndex();
				int categoryNo=(index+1)*10;
				adminFoodListTable(categoryNo);
			}
		});
		scrollPane.setViewportView(adminfoodTabbedPane);
		
		JPanel adminSandwichPanel = new JPanel();
		adminfoodTabbedPane.addTab("샌드위치", null, adminSandwichPanel, null);
		adminSandwichPanel.setLayout(new BorderLayout(0, 0));
		
		adminSandwichTable = new JTable();
		adminSandwichTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminSandwichTable.getSelectedRow();
					selectedFoodNo = (Integer)adminSandwichTable.getValueAt(selectedRow, 0);	
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("샌드위치");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminLabTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminLabTable.getSelectedRow();
					selectedFoodNo = (Integer)adminLabTable.getValueAt(selectedRow, 0);
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("랩");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminSaladTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminSaladTable.getSelectedRow();
					selectedFoodNo = (Integer)adminSaladTable.getValueAt(selectedRow, 0);
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("샐러드");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminSideMenuTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminSideMenuTable.getSelectedRow();
					selectedFoodNo = (Integer)adminSideMenuTable.getValueAt(selectedRow, 0);
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("사이드메뉴");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminCookieTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminCookieTable.getSelectedRow();
					selectedFoodNo = (Integer)adminCookieTable.getValueAt(selectedRow, 0);
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("쿠키");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminDrinkTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedRow = adminDrinkTable.getSelectedRow();
					selectedFoodNo = (Integer)adminDrinkTable.getValueAt(selectedRow, 0);
					Food food = jumunService.selectByFoodNo(selectedFoodNo);
					adminFoodNoTF.setText(food.getFood_no()+"");
					adminFoodNameTF.setText(food.getFood_name());
					adminFoodPriceTF.setText(food.getFood_price()+"");
					adminFoodCategoryTF.setText("음료");
				} catch (Exception e1) {
					return;
				}
			}
		});
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
		adminFoodNoTF.setBounds(91, 447, 264, 21);
		add(adminFoodNoTF);
		adminFoodNoTF.setColumns(10);
		
		JLabel foodNameLb = new JLabel("음식명");
		foodNameLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodNameLb.setBounds(22, 482, 57, 15);
		add(foodNameLb);
		
		adminFoodNameTF = new JTextField();
		adminFoodNameTF.setColumns(10);
		adminFoodNameTF.setBounds(91, 479, 264, 21);
		add(adminFoodNameTF);
		
		JLabel foodPriceLb = new JLabel("가격");
		foodPriceLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodPriceLb.setBounds(22, 519, 57, 15);
		add(foodPriceLb);
		
		adminFoodPriceTF = new JTextField();
		adminFoodPriceTF.setColumns(10);
		adminFoodPriceTF.setBounds(91, 516, 264, 21);
		add(adminFoodPriceTF);
		
		JLabel foodCategoryLb = new JLabel("카테고리");
		foodCategoryLb.setHorizontalAlignment(SwingConstants.CENTER);
		foodCategoryLb.setBounds(22, 552, 57, 15);
		add(foodCategoryLb);
		
		adminFoodCategoryTF = new JTextField();
		adminFoodCategoryTF.setColumns(10);
		adminFoodCategoryTF.setBounds(91, 549, 264, 21);
		add(adminFoodCategoryTF);
		
		foodAddBtn = new JButton("추가");
		foodAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int food_no = Integer.parseInt(adminFoodNoTF.getText());
					String food_name = adminFoodNameTF.getText();
					int food_price = Integer.parseInt(adminFoodPriceTF.getText());
					int category_no=0;
					String category_name=adminFoodCategoryTF.getText();
					if(category_name.equals("샌드위치")) {
						category_no=10;
					}else if(category_name.equals("랩")) {
						category_no=20;
					}else if(category_name.equals("샐러드")) {
						category_no=30;
					}else if(category_name.equals("사이드메뉴")) {
						category_no=40;
					}else if(category_name.equals("쿠키")) {
						category_no=50;
					}else if(category_name.equals("음료")) {
						category_no=60;
					}
					Food newFood = new Food(food_no,food_name,food_price,category_no);
					jumunService.foodInsert(newFood);
					JOptionPane.showMessageDialog(null, "메뉴가 추가되었습니다.");
					adminFoodListTable(category_no);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "입력을 다시 확인해주세요");
				}
				
			}
		});
		foodAddBtn.setBounds(42, 580, 73, 23);
		add(foodAddBtn);
		
		foodUpdateBtn = new JButton("수정");
		foodUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int food_no = Integer.parseInt(adminFoodNoTF.getText());
					String food_name = adminFoodNameTF.getText();
					int food_price = Integer.parseInt(adminFoodPriceTF.getText());
					int category_no=0;
					String category_name=adminFoodCategoryTF.getText();
					if(category_name.equals("샌드위치")) {
						category_no=10;
					}else if(category_name.equals("랩")) {
						category_no=20;
					}else if(category_name.equals("샐러드")) {
						category_no=30;
					}else if(category_name.equals("사이드메뉴")) {
						category_no=40;
					}else if(category_name.equals("쿠키")) {
						category_no=50;
					}else if(category_name.equals("음료")) {
						category_no=60;
					}
					Food newFood = new Food(food_no,food_name,food_price,category_no);
					jumunService.foodUpdateByFoodNo(newFood);
					JOptionPane.showMessageDialog(null, "메뉴를 수정하였습니다.");
					adminFoodListTable(category_no);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "수정을 실패하였습니다.");
				}
			}
		});
		foodUpdateBtn.setBounds(148, 580, 73, 23);
		add(foodUpdateBtn);
		
		foodDeleteBtn = new JButton("삭제");
		foodDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int food_no = Integer.parseInt(adminFoodNoTF.getText());
					jumunService.foodDeleteByFoodNo(food_no);
					JOptionPane.showMessageDialog(null, "메뉴가 삭제되었습니다.");
					adminFoodNoTF.setText("");
					adminFoodNameTF.setText("");
					adminFoodPriceTF.setText("");
					adminFoodCategoryTF.setText("");
					int index=adminfoodTabbedPane.getSelectedIndex();
					int categoryNo=(index+1)*10;
					adminFoodListTable(categoryNo);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "삭제할 메뉴를 다시 클릭해주세요.");
				}
			}
		});
		foodDeleteBtn.setBounds(256, 580, 66, 23);
		add(foodDeleteBtn);
		
		JLabel pictureLb3 = new JLabel("");
		pictureLb3.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/△▼.png")));
		pictureLb3.setBounds(0, 60, 415, 21);
		add(pictureLb3);
		
		//서비스객체 생성
		jumunService = new JumunService();
		
		/*********************************/
		adminfoodTabbedPane.setSelectedIndex(0);
		
		
		JLabel lblNewLabel = new JLabel("");
//		동기화 버튼
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminFoodNoTF.setText("");
				adminFoodNameTF.setText("");
				adminFoodPriceTF.setText("");
				adminFoodCategoryTF.setText("");
				
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AdministratorFoodSetPanel.class.getResource("/com/itwill/ui/동기화.png")));
		lblNewLabel.setBounds(346, 580, 46, 21);
		add(lblNewLabel);
		int index=adminfoodTabbedPane.getSelectedIndex();
		int categoryNo=(index+1)*10;
		adminFoodListTable(categoryNo);
		/*********************************/

	}//푸드셋패널
	public void adminFoodListTable(int categoryNo) {
		try {
			if(jumunService==null) {
				return;
			}
			List<Food> foodList = jumunService.selectByCategoryNo(categoryNo);
			
			Vector foodListVector = new Vector();
			for (Food food : foodList) {
				Vector foodVector = new Vector();
				foodVector.add(food.getFood_no());
				foodVector.add(food.getFood_name());
				foodVector.add(food.getFood_price());
				foodListVector.add(foodVector);
			}
			
			Vector columnNames=new Vector();
			columnNames.add("번호");
			columnNames.add("음식명");
			columnNames.add("가격");
			
			DefaultTableModel defaultTableModel =
					new DefaultTableModel(foodListVector, columnNames);
			if(categoryNo==10) {
				adminSandwichTable.setModel(defaultTableModel);				
			}else if(categoryNo==20) {
				adminLabTable.setModel(defaultTableModel);
			}else if(categoryNo==30) {
				adminSaladTable.setModel(defaultTableModel);
			}else if(categoryNo==40 ) {
				adminSideMenuTable.setModel(defaultTableModel);
			}else if(categoryNo==50 ) {
				adminCookieTable.setModel(defaultTableModel);
			}else if(categoryNo==60 ) {
				adminDrinkTable.setModel(defaultTableModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
	}
}
