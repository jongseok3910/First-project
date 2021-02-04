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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PaymentListPanel extends JPanel {
	private JTextField storeNameTF;
	private JTextField menuTF;
	private JTextField quantityTF;
	private JTextField sumTF;

	/**
	 * Create the panel.
	 */
	public PaymentListPanel() {
		setBackground(new Color(255, 204, 51));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 187, 368, 194);
		add(scrollPane);
		
		JList showPaymentDateList = new JList();
		scrollPane.setViewportView(showPaymentDateList);
		
		JLabel manImageLb = new JLabel("");
		manImageLb.setIcon(new ImageIcon(PaymentListPanel.class.getResource("/com/itwill/ui/배달목록사진.png")));
		manImageLb.setBounds(24, 27, 366, 107);
		add(manImageLb);
		
		JLabel PaymentListLb = new JLabel("------------------------------주문내역------------------------------");
		PaymentListLb.setForeground(new Color(255, 255, 255));
		PaymentListLb.setBounds(3, 152, 413, 19);
		add(PaymentListLb);
		
		JLabel PaymentListLb_1 = new JLabel("------------------------------주문상세------------------------------");
		PaymentListLb_1.setForeground(Color.WHITE);
		PaymentListLb_1.setBounds(2, 412, 413, 19);
		add(PaymentListLb_1);
		
		JLabel menuLb = new JLabel("메뉴");
		menuLb.setHorizontalAlignment(SwingConstants.CENTER);
		menuLb.setBounds(37, 498, 57, 15);
		add(menuLb);
		
		JLabel quantityLb = new JLabel("수량");
		quantityLb.setHorizontalAlignment(SwingConstants.CENTER);
		quantityLb.setBounds(37, 542, 57, 15);
		add(quantityLb);
		
		JLabel sumLb = new JLabel("총금액");
		sumLb.setHorizontalAlignment(SwingConstants.CENTER);
		sumLb.setBounds(37, 592, 57, 15);
		add(sumLb);
		
		JLabel storenameLb = new JLabel("가게명");
		storenameLb.setHorizontalAlignment(SwingConstants.CENTER);
		storenameLb.setBounds(37, 453, 57, 15);
		add(storenameLb);
		
		storeNameTF = new JTextField();
		storeNameTF.setBackground(new Color(255, 239, 213));
		storeNameTF.setBounds(113, 450, 237, 21);
		add(storeNameTF);
		storeNameTF.setColumns(10);
		
		menuTF = new JTextField();
		menuTF.setColumns(10);
		menuTF.setBackground(new Color(255, 239, 213));
		menuTF.setBounds(113, 495, 237, 21);
		add(menuTF);
		
		quantityTF = new JTextField();
		quantityTF.setColumns(10);
		quantityTF.setBackground(new Color(255, 239, 213));
		quantityTF.setBounds(113, 539, 237, 21);
		add(quantityTF);
		
		sumTF = new JTextField();
		sumTF.setColumns(10);
		sumTF.setBackground(new Color(255, 239, 213));
		sumTF.setBounds(113, 589, 212, 21);
		add(sumTF);
		
		JLabel wonLb = new JLabel("원");
		wonLb.setHorizontalAlignment(SwingConstants.CENTER);
		wonLb.setBounds(326, 592, 26, 15);
		add(wonLb);

	}
}