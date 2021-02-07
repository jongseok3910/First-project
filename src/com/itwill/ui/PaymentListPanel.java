package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.service.JumunService;
import com.itwill.vo.Food;
import com.itwill.vo.Jumun;
import com.itwill.vo.MemberInfo;
import com.itwill.vo.Store;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaymentListPanel extends JPanel {
	private JTextField storeNameTF;
	private JTextField foodNameTF;
	private JTextField quantityTF;
	private JTextField sumTF;
	private JList showPaymentDateList;
	
	Bob4JoMainFrame bob4JoMainFrame;
	JumunService jumunService;

	/**
	 * Create the panel.
	 */
	public PaymentListPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				paymentListList();
			}
		});
		setBackground(new Color(255, 204, 51));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 187, 368, 194);
		add(scrollPane);
		
		showPaymentDateList = new JList();
		showPaymentDateList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selectedIndex = showPaymentDateList.getSelectedIndex();
					if (selectedIndex==-1) {
						return;
					}
					MemberInfo member = bob4JoMainFrame.loginMember;
					String member_no=member.getMember_no();
					List<Jumun> jumunList = jumunService.selectByJumunMemberNoTypeIsNotNull(member_no);
					Jumun jumun = jumunList.get(selectedIndex);
					int store_no=jumun.getStore_no();
					Store store = jumunService.selectByStoreNo(store_no);
					String store_name=store.getStore_name();
					int food_no=jumun.getFood_no();
					Food food=jumunService.selectByFoodNo(food_no);
					String food_name=food.getFood_name();
					storeNameTF.setText(store_name);
					foodNameTF.setText(food_name);
					quantityTF.setText(jumun.getJumun_quantity()+"");
					sumTF.setText(jumun.getJumun_sum()+"");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(showPaymentDateList);
		
		JLabel manImageLb = new JLabel("");
		manImageLb.setIcon(new ImageIcon(PaymentListPanel.class.getResource("/com/itwill/ui/배달목록사진.png")));
		manImageLb.setBounds(24, 27, 366, 107);
		add(manImageLb);
		
		JLabel PaymentListLb = new JLabel("");
		PaymentListLb.setIcon(new ImageIcon(PaymentListPanel.class.getResource("/com/itwill/ui/주문내역글자.png")));
		PaymentListLb.setForeground(new Color(255, 255, 255));
		PaymentListLb.setBounds(3, 152, 412, 19);
		add(PaymentListLb);
		
		JLabel PaymentListLb_1 = new JLabel("");
		PaymentListLb_1.setIcon(new ImageIcon(PaymentListPanel.class.getResource("/com/itwill/ui/주문상세글자.png")));
		PaymentListLb_1.setForeground(Color.WHITE);
		PaymentListLb_1.setBounds(3, 394, 413, 19);
		add(PaymentListLb_1);
		
		JLabel menuLb = new JLabel("메뉴");
		menuLb.setHorizontalAlignment(SwingConstants.CENTER);
		menuLb.setBounds(37, 460, 57, 15);
		add(menuLb);
		
		JLabel quantityLb = new JLabel("수량");
		quantityLb.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLb.setBounds(37, 498, 57, 15);
		add(quantityLb);
		
		JLabel sumLb = new JLabel("총금액");
		sumLb.setHorizontalAlignment(SwingConstants.CENTER);
		sumLb.setBounds(37, 541, 57, 15);
		add(sumLb);
		
		JLabel storenameLb = new JLabel("가게명");
		storenameLb.setHorizontalAlignment(SwingConstants.CENTER);
		storenameLb.setBounds(37, 426, 57, 15);
		add(storenameLb);
		
		storeNameTF = new JTextField();
		storeNameTF.setEditable(false);
		storeNameTF.setBackground(new Color(255, 239, 213));
		storeNameTF.setBounds(113, 423, 237, 21);
		add(storeNameTF);
		storeNameTF.setColumns(10);
		
		foodNameTF = new JTextField();
		foodNameTF.setEditable(false);
		foodNameTF.setColumns(10);
		foodNameTF.setBackground(new Color(255, 239, 213));
		foodNameTF.setBounds(113, 457, 237, 21);
		add(foodNameTF);
		
		quantityTF = new JTextField();
		quantityTF.setEditable(false);
		quantityTF.setColumns(10);
		quantityTF.setBackground(new Color(255, 239, 213));
		quantityTF.setBounds(113, 495, 237, 21);
		add(quantityTF);
		
		sumTF = new JTextField();
		sumTF.setEditable(false);
		sumTF.setColumns(10);
		sumTF.setBackground(new Color(255, 239, 213));
		sumTF.setBounds(113, 538, 212, 21);
		add(sumTF);
		
		JLabel wonLb = new JLabel("원");
		wonLb.setHorizontalAlignment(SwingConstants.CENTER);
		wonLb.setBounds(324, 541, 26, 15);
		add(wonLb);
		
		//service객체 생성
		jumunService = new JumunService();

	}//페이먼트리스트패널
	private void paymentListList() {
		try {
			if(jumunService==null) {
				return;
			}
			MemberInfo member = bob4JoMainFrame.loginMember;
			String member_no=member.getMember_no();
			List<Jumun> jumunList = jumunService.selectByJumunMemberNoTypeIsNotNull(member_no);
			DefaultListModel defaultListModel=new DefaultListModel();
			for (Jumun jumun : jumunList) {
				defaultListModel.addElement(jumun.getJumun_paymentTime());
			}
			showPaymentDateList.setModel(defaultListModel);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;		
	}
}
