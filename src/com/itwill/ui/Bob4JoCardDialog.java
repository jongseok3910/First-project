package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Bob4JoCardDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordField;
	
	MemberInfoPanel memberInfoPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bob4JoCardDialog dialog = new Bob4JoCardDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bob4JoCardDialog() {
		setTitle("카드등록/수정");
		setBounds(100, 100, 502, 645);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Bob4JoCardDialog.class.getResource("/com/itwill/ui/카드이미지.png")));
		lblNewLabel.setBounds(64, 47, 360, 201);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("카드번호");
			lblNewLabel_1.setBounds(64, 324, 87, 15);
			contentPanel.add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setBounds(180, 324, 215, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("유효기간");
		lblNewLabel_2.setBounds(64, 373, 75, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("카드고유확인번호");
		lblNewLabel_3.setBounds(64, 424, 163, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("카드비밀번호");
		lblNewLabel_4.setBounds(64, 471, 104, 15);
		contentPanel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 424, 50, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(180, 373, 50, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("월(2자리)/");
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(231, 376, 81, 15);
		contentPanel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(290, 373, 50, 21);
		contentPanel.add(textField_4);
		
		JLabel lblNewLabel_6 = new JLabel("년(2자리)");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setBounds(342, 376, 64, 15);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("※ 카드 뒷면 서명란에 표기된 CVC 번호");
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(231, 427, 245, 15);
		contentPanel.add(lblNewLabel_7);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 468, 95, 21);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(51, 255, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(51, 255, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setMemberInfoPanel(MemberInfoPanel memberInfoPanel) {
		this.memberInfoPanel = memberInfoPanel;
	}
}
