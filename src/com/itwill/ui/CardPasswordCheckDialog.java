package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.service.JumunService;
import com.itwill.vo.Card;
import com.itwill.vo.Jumun;
import com.itwill.vo.MemberInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardPasswordCheckDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	
	Bob4JoMainFrame bob4JoMainFrame;
	BasketPanel basketPanel;
	JumunService jumunService;
	
	Bob4JoCardDialog bob4JoCardDialog;
//	private CardPasswordCheckDialog cardPasswordCheckDialog;

	/**
	 * Create the dialog.
	 */
	public CardPasswordCheckDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CardPasswordCheckDialog.class.getResource("/com/itwill/ui/창아이콘.png")));
		setBounds(100, 100, 291, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("카드비밀번호를 입력해주세요.");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("D2Coding", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 42, 248, 15);
		contentPanel.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 68, 251, 21);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					try {
						 MemberInfo member = bob4JoMainFrame.loginMember;
						 Card card = jumunService.selectByMemberNo(member.getMember_no());
//						 일치하면 확인되었습니다.
						 char[] passChars = passwordField.getPassword();
						 String passwordStr = new String(passChars);
						 if(passwordStr.equals(card.getCard_password()+"")) {
							 JOptionPane.showMessageDialog(null, "확인되었습니다.");
						 }else if(passwordStr.trim().equals("")) {
							 JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
						 }else {
							 JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						 }
//						 일치하지 않으면 비밀번호가 일치하지 않습니다.
					}
						catch (Exception e1) {
							e1.printStackTrace();
						}
					
					}
				});
				okButton.setBackground(new Color(240, 240, 240));
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(240, 240, 240));
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	// 다이어로그
	public void setBob4JoCardDialog(Bob4JoCardDialog bob4JoCardDialog) {
		this.bob4JoCardDialog = bob4JoCardDialog;
	}
	
		
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
		
	}

	public void setBasketPanel(BasketPanel basketPanel) {
		this.basketPanel=basketPanel;
		
	}
	
}
