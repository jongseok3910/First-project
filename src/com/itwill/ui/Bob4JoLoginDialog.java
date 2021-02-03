package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextPane;

public class Bob4JoLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bob4JoLoginDialog dialog = new Bob4JoLoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bob4JoLoginDialog() {
		setTitle("로그인");
		setBounds(100, 100, 520, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(127, 223, 69, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("비밀번호");
			lblNewLabel_1.setBounds(127, 278, 69, 15);
			contentPanel.add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setBounds(252, 220, 125, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 275, 125, 21);
		contentPanel.add(passwordField);
		{
			JLabel lblNewLabel_2 = new JLabel("LOGIN");
			lblNewLabel_2.setFont(new Font("D2Coding", Font.BOLD, 30));
			lblNewLabel_2.setBounds(205, 0, 91, 184);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("회원으로 로그인하시면 제공하는");
			lblNewLabel_3.setBounds(161, 125, 298, 29);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("다양한 서비스를 이용할 수 있습니다");
			lblNewLabel_4.setBounds(148, 149, 286, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("로그인");
				okButton.setBackground(new Color(51, 255, 51));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(51, 255, 51));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
