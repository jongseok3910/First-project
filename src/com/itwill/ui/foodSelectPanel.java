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

import com.itwill.service.JumunService;
import com.itwill.service.MemberService;
import com.itwill.vo.Food;
import com.itwill.vo.Store;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;

public class foodSelectPanel extends JPanel {
	private JTable sandwichTable;
	private JTable labTable;
	private JTable saladTable;
	private JTable sidemenuTable;
	private JTable cookieTable;
	private JTable drinkTable;
	private JButton basketBtn;
	private JComboBox quantityCB;
	MemberService memberService;
	JumunService jumunService;
	private JPanel sandwichPanel;
	private JPanel labPanel;
	private JPanel saladPanel;
	private JPanel sidePanel;
	private JPanel cookiePanel;
	private JPanel drinkPanel;
	private JTabbedPane foodTabbedPane;
	private JComboBox storeListCB;


	/**
	 * Create the panel.
	 */
	public foodSelectPanel() {
		setBackground(new Color(255, 215, 0));
		setLayout(null);
		
		foodTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		foodTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int index=foodTabbedPane.getSelectedIndex();
				int categoryNo=(index+1)*10;
				foodListTable(categoryNo);
			}
		});
		foodTabbedPane.setBounds(19, 107, 374, 436);
		add(foodTabbedPane);
		
		sandwichPanel = new JPanel();
		foodTabbedPane.addTab("샌드위치", null, sandwichPanel, null);
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
		
		labPanel = new JPanel();
		foodTabbedPane.addTab("랩", null, labPanel, null);
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
		
		saladPanel = new JPanel();
		foodTabbedPane.addTab("샐러드", null, saladPanel, null);
		saladPanel.setLayout(new BorderLayout(0, 0));
		
		saladTable = new JTable();
		saladPanel.add(saladTable, BorderLayout.CENTER);
		
		sidePanel = new JPanel();
		foodTabbedPane.addTab("사이드메뉴", null, sidePanel, null);
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
		
		cookiePanel = new JPanel();
		foodTabbedPane.addTab("쿠키", null, cookiePanel, null);
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
		
		drinkPanel = new JPanel();
		foodTabbedPane.addTab("음료", null, drinkPanel, null);
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
		
		storeListCB = new JComboBox();
		storeListCB.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try {
					List<Store> storeList= jumunService.selectStoreAll();
					DefaultComboBoxModel defaultComboBoxModel=new DefaultComboBoxModel();
					for (Store store : storeList) {
						defaultComboBoxModel.addElement(store.getStore_name());
					}
					storeListCB.setModel(defaultComboBoxModel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		storeListCB.setBounds(105, 44, 183, 23);
		add(storeListCB);
		
		basketBtn = new JButton("장바구니");
		basketBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Store_no = storeListCB.getSelectedIndex()+1;
				int quantity = quantityCB.getSelectedIndex()+1;
			}
		});
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
		
		JLabel foodImage = new JLabel("");
		foodImage.setHorizontalAlignment(SwingConstants.CENTER);
		foodImage.setIcon(new ImageIcon(foodSelectPanel.class.getResource("/com/itwill/ui/음식선택.png")));
		foodImage.setBounds(285, 10, 118, 117);
		add(foodImage);

		//service객체 생성
		memberService = new MemberService();
		jumunService = new JumunService();
		
		
		/**************************************/
		foodTabbedPane.setSelectedIndex(0);
		int index=foodTabbedPane.getSelectedIndex();
		int categoryNo=(index+1)*10;
		foodListTable(categoryNo);
		/**************************************/
		
	}//푸드셀렉트 패널
	private void foodListTable(int categoryNo) {
		try {
			if(jumunService==null) {
				return;
			}
			List<Food> foodList = jumunService.selectByCategoryNo(categoryNo);
			
			Vector foodListVector = new Vector();
			for (Food food : foodList) {
				Vector foodVector=new Vector();
				foodVector.add(food.getFood_name());
				foodVector.add(food.getFood_price());
				foodListVector.add(foodVector);
			}
			
			Vector columnNames=new Vector();
			columnNames.add("음식명");
			columnNames.add("가격");
			
			DefaultTableModel defaultTableModel =
					new DefaultTableModel(foodListVector, columnNames);
			if(categoryNo==10) {
				sandwichTable.setModel(defaultTableModel);				
			}else if(categoryNo==20) {
				labTable.setModel(defaultTableModel);
			}else if(categoryNo==30) {
				saladTable.setModel(defaultTableModel);
			}else if(categoryNo==40 ) {
				sidemenuTable.setModel(defaultTableModel);
			}else if(categoryNo==50 ) {
				cookieTable.setModel(defaultTableModel);
			}else if(categoryNo==60 ) {
				drinkTable.setModel(defaultTableModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
