package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.service.MemberService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class Bob4JoJoinDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	Bob4JoMainFrame bob4JoMainFrame;
	MemberService memberService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Bob4JoJoinDialog dialog = new Bob4JoJoinDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Bob4JoJoinDialog() {
		setTitle("회원가입");
		setBounds(100, 100, 460, 490);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("아이디");
			lblNewLabel_1.setBounds(48, 130, 86, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("비밀번호");
			lblNewLabel.setBounds(48, 180, 86, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setBounds(48, 230, 86, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setBounds(48, 280, 86, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("주소");
			lblNewLabel_4.setBounds(48, 330, 86, 15);
			contentPanel.add(lblNewLabel_4);
		}
		{
			textField = new JTextField();
			textField.setBounds(139, 130, 96, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(139, 180, 96, 21);
			contentPanel.add(passwordField);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(139, 230, 96, 21);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(139, 280, 96, 21);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(139, 330, 240, 21);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("JOIN");
			lblNewLabel_5.setFont(new Font("D2Coding", Font.BOLD, 35));
			lblNewLabel_5.setBounds(168, 10, 110, 118);
			contentPanel.add(lblNewLabel_5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("가입");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(51, 255, 51));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(51, 255, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//MemberService객체 생성
		memberService=new MemberService();
	}//조인다이얼로그
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
	}
	
}
