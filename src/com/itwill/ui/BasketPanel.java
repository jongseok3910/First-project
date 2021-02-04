package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.service.JumunService;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BasketPanel extends JPanel {
	private JTable basketTable;
	private JTextField totalTF;
	private JTextField textField;
	private JComboBox paymentCB;
	private JButton paymentBtn;
	private JButton cancleBtn;
	
	JumunService jumunService;
	/**
	 * Create the panel.
	 */
	public BasketPanel() {
		setBackground(new Color(255, 204, 51));
		setLayout(null);
		
		basketTable = new JTable();
		basketTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uC218\uB7C9"
			}
		));
		basketTable.setBounds(41, 208, 340, 99);
		add(basketTable);
		
		JLabel totalLb = new JLabel("총금액");
		totalLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		totalLb.setHorizontalAlignment(SwingConstants.CENTER);
		totalLb.setBounds(36, 337, 62, 21);
		add(totalLb);
		
		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalTF.setBounds(118, 337, 205, 21);
		add(totalTF);
		totalTF.setColumns(10);
		
		JLabel wonLb = new JLabel("원");
		wonLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		wonLb.setHorizontalAlignment(SwingConstants.CENTER);
		wonLb.setBounds(335, 340, 31, 15);
		add(wonLb);
		
		JLabel requestLb = new JLabel("요청사항");
		requestLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		requestLb.setHorizontalAlignment(SwingConstants.CENTER);
		requestLb.setBounds(35, 412, 57, 15);
		add(requestLb);
		
		textField = new JTextField();
		textField.setBounds(118, 409, 251, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("결제수단");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 488, 57, 15);
		add(lblNewLabel);
		
		paymentCB = new JComboBox();
		paymentCB.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		paymentCB.setModel(new DefaultComboBoxModel(new String[] {"카드결제", "현장결제"}));
		paymentCB.setBounds(118, 480, 251, 23);
		add(paymentCB);
		
		paymentBtn = new JButton("결제하기");
		paymentBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		paymentBtn.setBounds(35, 556, 132, 23);
		add(paymentBtn);
		
		cancleBtn = new JButton("취소");
		cancleBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		cancleBtn.setBounds(237, 556, 132, 23);
		add(cancleBtn);
		
		JLabel listLb = new JLabel("장바구니 목록");
		listLb.setForeground(new Color(0, 0, 0));
		listLb.setFont(new Font("함초롬돋움", Font.PLAIN, 11));
		listLb.setHorizontalAlignment(SwingConstants.CENTER);
		listLb.setBounds(24, 25, 368, 25);
		add(listLb);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(BasketPanel.class.getResource("/com/itwill/ui/장바구니.png")));
		lblNewLabel_1.setBounds(110, 49, 193, 140);
		add(lblNewLabel_1);
		
		//service객체 생성
		jumunService = new JumunService();

	}//바스켓 패널
}
