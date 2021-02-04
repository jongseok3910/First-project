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
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField addressField;
	private JButton withdrawBtn;
	private JButton nameChangeBtn;
	private JButton passwordChangeBtn;
	private JButton addressBtn;

	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() {
		setLayout(null);
		
		JLabel nameLb = new JLabel("닉네임");
		nameLb.setHorizontalAlignment(SwingConstants.CENTER);
		nameLb.setBounds(32, 260, 57, 15);
		add(nameLb);
		
		nameField = new JTextField();
		nameField.setBounds(101, 256, 207, 22);
		add(nameField);
		nameField.setColumns(10);
		
		nameChangeBtn = new JButton("변경");
		nameChangeBtn.setBounds(312, 256, 71, 23);
		add(nameChangeBtn);
		
		JLabel passLb = new JLabel("비밀번호");
		passLb.setHorizontalAlignment(SwingConstants.CENTER);
		passLb.setBounds(32, 305, 57, 15);
		add(passLb);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(101, 301, 207, 23);
		add(passwordField);
		
		passwordChangeBtn = new JButton("변경");
		passwordChangeBtn.setBounds(312, 301, 71, 23);
		add(passwordChangeBtn);
		
		addressField = new JTextField();
		addressField.setBounds(101, 351, 207, 21);
		add(addressField);
		addressField.setColumns(10);
		
		addressBtn = new JButton("변경");
		addressBtn.setBounds(312, 350, 71, 23);
		add(addressBtn);
		
		JLabel lblNewLabel_3 = new JLabel("주소");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(32, 354, 57, 15);
		add(lblNewLabel_3);
		
		JLabel creditCardRegistLb = new JLabel("");
		creditCardRegistLb.setHorizontalAlignment(SwingConstants.CENTER);
		creditCardRegistLb.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/카드등록.jpg")));
		creditCardRegistLb.setBounds(39, 428, 350, 130);
		add(creditCardRegistLb);
		
		JLabel 문구Lb = new JLabel(" 자주 사용하는 카드를 등록해주세요.");
		문구Lb.setHorizontalAlignment(SwingConstants.CENTER);
		문구Lb.setBounds(39, 399, 344, 15);
		add(문구Lb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 224, 350, 2);
		add(separator);
		
		JLabel profileLb = new JLabel("");
		profileLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileLb.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/회원사진.png")));
		profileLb.setBounds(32, 27, 351, 181);
		add(profileLb);
		
		withdrawBtn = new JButton("탈퇴하기");
		withdrawBtn.setBounds(281, 568, 108, 23);
		add(withdrawBtn);

	}
}
