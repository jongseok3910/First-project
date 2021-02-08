package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.itwill.service.MemberService;
import com.itwill.vo.MemberInfo;

import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdministratorMemberSetPanel extends JPanel {
	private JTextField memberIdTF;
	private JTextField memberPWTF;
	private JTextField memberNameTF;
	private JTextField memberPhoneTF;
	private JTextField memberAddressTF;
	private JTextField memberJoinDateTF;

	Bob4JoMainFrame bob4JoMainFrame;
	MemberService memberService;

	private JTextField totalMemberTF;
	private JList showMemberList;

	/**
	 * Create the panel.
	 */
	public AdministratorMemberSetPanel() {

		setBackground(new Color(211, 211, 211));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				memberListList();
			}
		});

		setLayout(null);
		
		JLabel memberIDLabel = new JLabel("회원아이디");
		memberIDLabel.setBounds(29, 370, 80, 15);
		add(memberIDLabel);
		
		JLabel memberPWLabel = new JLabel("회원비밀번호");
		memberPWLabel.setBounds(29, 410, 80, 15);
		add(memberPWLabel);
		
		JLabel memberNameLabel = new JLabel("회원이름");
		memberNameLabel.setBounds(29, 450, 80, 15);
		add(memberNameLabel);
		
		JLabel memberPhoneLabel = new JLabel("회원전화번호");
		memberPhoneLabel.setBounds(29, 490, 80, 15);
		add(memberPhoneLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 202, 352, 142);
		add(scrollPane);
		
		showMemberList = new JList();
		showMemberList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selecedIndex = showMemberList.getSelectedIndex();
					if(selecedIndex==-1) {
						return;
					}
					List<MemberInfo> memberList = memberService.selectMemberAll();
					MemberInfo member = memberList.get(selecedIndex);
					memberIdTF.setText(member.getMember_id());
					memberPWTF.setText(member.getMember_password());
					memberNameTF.setText(member.getMember_name());
					memberPhoneTF.setText(member.getMember_phone());
					memberAddressTF.setText(member.getMember_address());
					memberJoinDateTF.setText(member.getJoinDate());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(showMemberList);
		
		JLabel memberAddressLabel = new JLabel("회원주소");
		memberAddressLabel.setBounds(29, 530, 80, 15);
		add(memberAddressLabel);
		
		JLabel memberJoinDateLabel = new JLabel("회원가입일");
		memberJoinDateLabel.setBounds(29, 570, 80, 15);
		add(memberJoinDateLabel);
		
		memberIdTF = new JTextField();
		memberIdTF.setBounds(116, 367, 195, 21);
		add(memberIdTF);
		memberIdTF.setColumns(10);
		
		memberPWTF = new JTextField();
		memberPWTF.setBounds(116, 407, 195, 21);
		add(memberPWTF);
		memberPWTF.setColumns(10);
		
		memberNameTF = new JTextField();
		memberNameTF.setBounds(116, 447, 195, 21);
		add(memberNameTF);
		memberNameTF.setColumns(10);
		
		memberPhoneTF = new JTextField();
		memberPhoneTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(memberPhoneTF.getText().length()>=11) {
					e.consume();
				}
			}
		});
		memberPhoneTF.setBounds(116, 487, 195, 21);
		add(memberPhoneTF);
		memberPhoneTF.setColumns(10);
		
		memberAddressTF = new JTextField();
		memberAddressTF.setBounds(116, 527, 195, 21);
		add(memberAddressTF);
		memberAddressTF.setColumns(10);
		
		memberJoinDateTF = new JTextField();
		memberJoinDateTF.setBounds(116, 567, 195, 21);
		add(memberJoinDateTF);
		memberJoinDateTF.setColumns(10);
		
		JButton memberPWChangeBtn = new JButton("수정");
		memberPWChangeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					비밀번호 변경칸 공백이면 비밀번호를 입력해주세요 출력
					if(memberPWTF.getText().trim().equals("")) {
						memberPWTF.setText("");
						memberPWTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 비밀번호를 입력해주세요.");
						return;
					}else {
					String member_id = memberIdTF.getText();
					MemberInfo member = memberService.selectById(member_id);
					String passwordStr = memberPWTF.getText();
					member.setMember_password(passwordStr);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		memberPWChangeBtn.setBounds(326, 406, 55, 23);
		add(memberPWChangeBtn);
		
		JButton memberNameChangeBtn = new JButton("수정");
		memberNameChangeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					이름 변경칸 공백이면 이름을 입력해주세요 출력
					if(memberNameTF.getText().trim().equals("")) {
						memberNameTF.setText("");
						memberNameTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 이름을 입력해주세요.");
						return;
					}else {
					String member_id = memberIdTF.getText();
					MemberInfo member = memberService.selectById(member_id);
					String nameStr = memberNameTF.getText();
					member.setMember_name(nameStr);
//					System.out.println(memberInfo);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "이름이 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		memberNameChangeBtn.setBounds(326, 446, 55, 23);
		add(memberNameChangeBtn);
		
		JButton memberPhoneChangeBtn = new JButton("수정");
		memberPhoneChangeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					전화번호 변경칸 공백이면 전화번호를 입력해주세요 출력
					if(memberPhoneTF.getText().trim().equals("")) {
						memberPhoneTF.setText("");
						memberPhoneTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 전화번호를 입력해주세요.");
						return;
					} else {
						String member_id = memberIdTF.getText();
						MemberInfo member = memberService.selectById(member_id);
						String phoneRawStr=memberPhoneTF.getText();
						String phone1=phoneRawStr.substring(0,3);
						String phone2=phoneRawStr.substring(3,7);
						String phone3=phoneRawStr.substring(7,11);
						String phoneStr=phone1+"-"+phone2+"-"+phone3;
						member.setMember_phone(phoneStr);
						memberService.memberUpdate(member);
						JOptionPane.showMessageDialog(null, "전화번호가 변경되었습니다.");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		memberPhoneChangeBtn.setBounds(326, 486, 55, 23);
		add(memberPhoneChangeBtn);
		
		JButton memberAddressChangeBtn = new JButton("수정");
		memberAddressChangeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					비밀번호 변경칸 공백이면 비밀번호를 입력해주세요 출력
					if(memberAddressTF.getText().trim().equals("")) {
						memberAddressTF.setText("");
						memberAddressTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 주소를 입력해주세요.");
						return;
					}else {
					String member_id = memberIdTF.getText();
					MemberInfo member = memberService.selectById(member_id);
					String addressStr = memberAddressTF.getText();
					member.setMember_address(addressStr);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "주소가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		memberAddressChangeBtn.setBounds(326, 526, 55, 23);
		add(memberAddressChangeBtn);
		
		JButton memberDeleteBtn = new JButton("삭제");
		memberDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(memberService==null) {
						return;
					}
					String member_id = memberIdTF.getText();
					int reception = JOptionPane.showConfirmDialog(null, "회원탈퇴를 하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					if(reception==JOptionPane.CLOSED_OPTION) {
						//우측 상단 X를 눌렀을 때
					}else if(reception==JOptionPane.YES_OPTION) {
						//예를 눌렀을 때 회원탈퇴
						memberService.memberUnRegister(member_id);
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
					}else {
						//아니오를 눌렀을 때
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		memberDeleteBtn.setBounds(290, 169, 91, 23);
		add(memberDeleteBtn);
		
		JLabel memberListLabel = new JLabel("회원정보리스트");
		memberListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberListLabel.setBounds(173, 177, 115, 15);
		add(memberListLabel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setIcon(new ImageIcon(AdministratorMemberSetPanel.class.getResource("/com/itwill/ui/관리자회원리스트.png")));
		lblNewLabel.setBounds(12, 10, 195, 194);
		add(lblNewLabel);
		
		JButton memberIDChangeBtn_1 = new JButton("검색");
		memberIDChangeBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String member_id = memberNameTF.getText();
					if (memberService.isExistedId(member_id)==false) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
						return;
					}
					MemberInfo member = memberService.selectById(member_id);
					memberPWTF.setText(member.getMember_password());
					memberNameTF.setText(member.getMember_name());
					memberPhoneTF.setText(member.getMember_phone());
					memberAddressTF.setText(member.getMember_address());
					memberJoinDateTF.setText(member.getJoinDate());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		memberIDChangeBtn_1.setBounds(326, 366, 55, 23);
		add(memberIDChangeBtn_1);
		

		JLabel lblNewLabel_4 = new JLabel("총 인원수");
		lblNewLabel_4.setBounds(216, 152, 62, 15);
		add(lblNewLabel_4);
		
		totalMemberTF = new JTextField();
		totalMemberTF.setBounds(290, 146, 91, 21);
		add(totalMemberTF);
		totalMemberTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdministratorMemberSetPanel.class.getResource("/com/itwill/ui/관리자회원리스트Bob4Jo.png")));
		lblNewLabel_1.setBounds(219, 10, 160, 120);
		add(lblNewLabel_1);


		memberService = new MemberService();

	}//관리자멤버패널
	private void memberListList() {
		try {
			if(memberService==null) {
				return;
			}
			List<MemberInfo> memberList= memberService.selectMemberAll();
			int memberCount=0;
			DefaultListModel defaultListModel=new DefaultListModel();
			for (MemberInfo member : memberList) {
				defaultListModel.addElement(member.getMember_no());
				defaultListModel.addElement(member.getMember_id());
				memberCount+=1;
			}
			showMemberList.setModel(defaultListModel);
			totalMemberTF.setText(memberCount+"명");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;		
	}
}
