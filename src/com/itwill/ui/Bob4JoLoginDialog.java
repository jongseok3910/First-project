package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.service.MemberService;
import com.itwill.vo.MemberInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Bob4JoLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passwordTF;
	
	Bob4JoMainFrame bob4JoMainFrame;
	MemberService memberService;
	/**
	 * Create the dialog.
	 */
	public Bob4JoLoginDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bob4JoLoginDialog.class.getResource("/com/itwill/ui/창아이콘.png")));
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
		
		idTF = new JTextField();
		idTF.setBounds(252, 220, 125, 21);
		contentPanel.add(idTF);
		idTF.setColumns(10);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(252, 275, 125, 21);
		contentPanel.add(passwordTF);
		{
			JLabel lblNewLabel_2 = new JLabel("LOGIN");
			lblNewLabel_2.setFont(new Font("D2Coding", Font.BOLD, 35));
			lblNewLabel_2.setBounds(205, 0, 156, 184);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("회원으로 로그인하시면 제공하는");
			lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
			lblNewLabel_3.setBounds(161, 125, 298, 29);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("다양한 서비스를 이용할 수 있습니다");
			lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String idStr=idTF.getText();
						char[] passwordChars = passwordTF.getPassword();
						String passwordStr = new String(passwordChars);
						//공백 입력했을 때
						if(idStr.trim().equals("")||passwordStr.trim().equals("")) {
							idTF.setText("");
							passwordTF.setText("");
							JOptionPane.showMessageDialog(null, "아이디와 패스워드를 입력하세요");
							idTF.requestFocus();
							return;
						}
						//MemberService객체 로그인메쏘드 호출
						try {
							int result = memberService.login(idStr, passwordStr);
							/*
							 * 0.성공
							 * 1. 아이디존재안함
							 * 2. 패스워드 불일치
							 */
							if(result==0) {
								MemberInfo loginMember = memberService.selectById(idStr);
								bob4JoMainFrame.loginProcess(loginMember);
								dispose();
							}else if((result==1)) {
								JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다");
								idTF.requestFocus();
								idTF.setSelectionStart(0);
								idTF.setSelectionEnd(idStr.length());
							}else {
								JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다");
								passwordTF.requestFocus();
								passwordTF.setSelectionStart(0);
								passwordTF.setSelectionEnd(passwordStr.length());
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				okButton.setBackground(new Color(51, 255, 51));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(51, 255, 51));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//MemberService객체 생성
		memberService=new MemberService();
	}//로그인다이얼로그
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
	}
	
}
