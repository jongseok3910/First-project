package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

//					MemberInfo member = bob4JoMainFrame.loginMember;
//					String member_no = member.getMember_no();
//				//	Card card = jumunService.select 
//					try {
//						//jumunService.cardPasswordCheck
//						if (result == 0) {
//						//	Jumun card = jumunService.select(card_noStr);
//						//	bob4JoMainFrame.jumunService(cardpassword);
//						}else (result == 1){
//							JOptionPane.showMessageDialog(null,"카드 비밀번호가 일치하지 않습니다.");
//							
//						}
//						catch (Exception e1) {
//							e1.printStackTrace();
//						}
//					}
//					}
//				});
				okButton.setBackground(Color.GREEN);
				okButton.setForeground(Color.WHITE);
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
				cancelButton.setBackground(Color.GREEN);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;
		
	}

	public void setBasketPanel(BasketPanel basketPanel) {
		this.basketPanel=basketPanel;
		
	}
}
