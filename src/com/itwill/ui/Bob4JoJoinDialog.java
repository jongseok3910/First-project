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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Bob4JoJoinDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTF;
	private JPasswordField passwordTF;
	private JTextField nameTF;
	private JTextField phoneTF;
	private JTextField addressTF;
	
	Bob4JoMainFrame bob4JoMainFrame;
	MemberService memberService;
	private JButton idCheckBtn;

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
			idTF = new JTextField();
			idTF.setBounds(139, 130, 96, 21);
			contentPanel.add(idTF);
			idTF.setColumns(10);
		}
		{
			passwordTF = new JPasswordField();
			passwordTF.setBounds(139, 180, 96, 21);
			contentPanel.add(passwordTF);
		}
		{
			nameTF = new JTextField();
			nameTF.setBounds(139, 230, 96, 21);
			contentPanel.add(nameTF);
			nameTF.setColumns(10);
		}
		{
			phoneTF = new JTextField();
			phoneTF.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!Character.isDigit(c)) {
						e.consume();
						return;
					}
				}
			});
			phoneTF.setBounds(139, 280, 96, 21);
			contentPanel.add(phoneTF);
			phoneTF.setColumns(10);
		}
		{
			addressTF = new JTextField();
			addressTF.setBounds(139, 330, 240, 21);
			contentPanel.add(addressTF);
			addressTF.setColumns(10);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("JOIN");
			lblNewLabel_5.setFont(new Font("D2Coding", Font.BOLD, 35));
			lblNewLabel_5.setBounds(168, 10, 110, 118);
			contentPanel.add(lblNewLabel_5);
		}
		{
			idCheckBtn = new JButton("중복확인");
			idCheckBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String idStr=idTF.getText();
					//공백 입력했을 때
					if(idStr.trim().equals("")) {
						idTF.setText("");
						JOptionPane.showMessageDialog(null, "아이디와 패스워드를 입력하세요");
						idTF.requestFocus();
						return;
					}
					//memberservice 중복확인 메쏘드 호출
					try {
						boolean isSuccess=memberService.memberIdCheck(idStr);
						if(isSuccess) {
							JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다");
						}else {
							JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다");
							idTF.requestFocus();
							idTF.setSelectionStart(0);
							idTF.setSelectionEnd(idStr.length());
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			idCheckBtn.setBounds(262, 130, 91, 23);
			contentPanel.add(idCheckBtn);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("가입");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String idStr=idTF.getText();
						char[] passChars=passwordTF.getPassword();
						String passwordStr=new String(passChars);
						String nameStr=nameTF.getText();
						String phoneStr=phoneTF.getText();
						String addressStr=addressTF.getText();
						//유효성체크
						if(idStr.trim().equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
							idTF.setText("");
							idTF.requestFocus();
							return;
						}
						MemberInfo newMember=new MemberInfo(null, idStr, passwordStr, nameStr, phoneStr, addressStr, null);
						try {
							boolean isSuccess=memberService.memberRegister(newMember);
							if(isSuccess) {
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다");
								idTF.requestFocus();
								idTF.setSelectionStart(0);
								idTF.setSelectionEnd(idStr.length());
								return;
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(51, 255, 51));
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
