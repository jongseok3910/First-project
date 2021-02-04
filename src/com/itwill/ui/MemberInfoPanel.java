package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class MemberInfoPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() {
		setLayout(null);
		
		JLabel nameLb = new JLabel("닉네임");
		nameLb.setHorizontalAlignment(SwingConstants.CENTER);
		nameLb.setBounds(31, 294, 57, 15);
		add(nameLb);
		
		textField = new JTextField();
		textField.setBounds(100, 290, 207, 22);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("변경");
		btnNewButton.setBounds(311, 290, 71, 23);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(31, 339, 57, 15);
		add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 335, 207, 23);
		add(passwordField);
		
		JButton btnNewButton_1 = new JButton("변경");
		btnNewButton_1.setBounds(311, 335, 71, 23);
		add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 385, 207, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("변경");
		btnNewButton_2.setBounds(311, 384, 71, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(31, 388, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/카드등록.jpg")));
		lblNewLabel_4.setBounds(38, 462, 350, 149);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" 자주 사용하는 카드를 등록해주세요.");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(38, 433, 344, 15);
		add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 244, 350, 2);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/회원사진.png")));
		lblNewLabel.setBounds(31, 46, 351, 181);
		add(lblNewLabel);

	}
}