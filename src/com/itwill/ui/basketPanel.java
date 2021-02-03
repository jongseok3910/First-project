package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class basketPanel extends JPanel {
	private JTable basketTable;
	private JTextField totalTF;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public basketPanel() {
		setBackground(new Color(85, 107, 47));
		setLayout(null);
		
		basketTable = new JTable();
		basketTable.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uC218\uB7C9"
			}
		));
		basketTable.setBounds(40, 178, 340, 121);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"카드결제", "현장결제"}));
		comboBox.setBounds(118, 480, 251, 23);
		add(comboBox);
		
		JButton paymentBtn = new JButton("결제하기");
		paymentBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		paymentBtn.setBounds(35, 556, 132, 23);
		add(paymentBtn);
		
		JButton cancleBtn = new JButton("취소");
		cancleBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		cancleBtn.setBounds(237, 556, 132, 23);
		add(cancleBtn);
		
		JLabel listLb = new JLabel("장바구니 목록");
		listLb.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		listLb.setHorizontalAlignment(SwingConstants.CENTER);
		listLb.setBounds(24, 24, 368, 15);
		add(listLb);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\JAVA_BACKEND\\IT학원강의자료\\image\\4401e56c414bf5ac.jpg"));
		lblNewLabel_1.setBounds(98, 49, 225, 213);
		add(lblNewLabel_1);

	}
}
