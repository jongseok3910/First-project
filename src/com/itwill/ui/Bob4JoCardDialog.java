package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.service.JumunService;
import com.itwill.vo.Card;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Bob4JoCardDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField cardNoTF;
	private JTextField cvcTF;
	private JTextField validityMTF;
	private JTextField validityYTF;
	private JPasswordField passwordTF;
	
	Bob4JoMainFrame bob4JoMainFrame;
	MemberInfoPanel memberInfoPanel;
	JumunService jumunService;

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
		
		cardNoTF = new JTextField();
		cardNoTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(cardNoTF.getText().length()>=16) {
					e.consume();
				}
			}
		});
		cardNoTF.setBounds(180, 324, 215, 21);
		contentPanel.add(cardNoTF);
		cardNoTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("유효기간");
		lblNewLabel_2.setBounds(64, 373, 75, 15);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("카드고유확인번호");
		lblNewLabel_3.setBounds(64, 424, 163, 15);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("카드비밀번호");
		lblNewLabel_4.setBounds(64, 471, 104, 15);
		contentPanel.add(lblNewLabel_4);
		
		cvcTF = new JTextField();
		cvcTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(cvcTF.getText().length()>=3) {
					e.consume();
				}
			}
		});
		cvcTF.setBounds(180, 424, 50, 21);
		contentPanel.add(cvcTF);
		cvcTF.setColumns(10);
		
		validityMTF = new JTextField();
		validityMTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(validityMTF.getText().length()>=2) {
					e.consume();
				}
			}
		});
		validityMTF.setBounds(180, 373, 50, 21);
		contentPanel.add(validityMTF);
		validityMTF.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("월(2자리)/");
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_5.setBounds(231, 376, 81, 15);
		contentPanel.add(lblNewLabel_5);
		
		validityYTF = new JTextField();
		validityYTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(validityYTF.getText().length()>=2) {
					e.consume();
				}
			}
		});
		validityYTF.setColumns(10);
		validityYTF.setBounds(290, 373, 50, 21);
		contentPanel.add(validityYTF);
		
		JLabel lblNewLabel_6 = new JLabel("년(2자리)");
		lblNewLabel_6.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_6.setBounds(342, 376, 64, 15);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("※ 카드 뒷면 서명란에 표기된 CVC 번호");
		lblNewLabel_7.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_7.setBounds(231, 427, 245, 15);
		contentPanel.add(lblNewLabel_7);
		
		passwordTF = new JPasswordField();
		passwordTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(passwordTF.getText().length()>=4) {
					e.consume();
				}
			}
		});
		passwordTF.setBounds(180, 468, 95, 21);
		contentPanel.add(passwordTF);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(cardNoTF.getText().trim().equals("")||
								validityMTF.getText().trim().equals("")||
								validityYTF.getText().trim().equals("")||
								cvcTF.getText().trim().equals("")||
								passwordTF.getText().trim().equals("")
								) {
							JOptionPane.showMessageDialog(null, "카드정보를 정확히 입력해주세요.");
							return;
						}
						try {
							String card_no=cardNoTF.getText();
							int validityM = Integer.parseInt(validityMTF.getText());
							int validityY = Integer.parseInt(validityYTF.getText());
							String card_validity = validityM+"/"+validityY;
							int card_cvc = Integer.parseInt(cvcTF.getText());
							int card_password = Integer.parseInt(passwordTF.getText());
							/*
							 * 로그인멤버를 못불러옴
							 */
							//String member_no=memberInfoPanel.memberInfo.getMember_no();
							Card card = new Card(card_no,card_validity,card_cvc,card_password,"2021/02/0616");
							if(memberInfoPanel.registeredCard==null) {
								jumunService.cardInsert(card);
								JOptionPane.showMessageDialog(null, "카드등록이 완료되었습니다.");
							}else {
								jumunService.updateByCardMemberNo(card);
								JOptionPane.showMessageDialog(null, "카드수정이 완료되었습니다.");
							}
							memberInfoPanel.creditCardRegistLb.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/카드이미지.png")));
							dispose();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "카드정보를 정확히 입력해주세요.");
							return;
						}
					}
				});
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(51, 255, 0));
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
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(51, 255, 0));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		//service객체 생성
		jumunService = new JumunService();
		
	}//카드다이얼로그

	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame = bob4JoMainFrame;
	}
	public void setMemberInfoPanel(MemberInfoPanel memberInfoPanel) {
		this.memberInfoPanel = memberInfoPanel;
	}

}
