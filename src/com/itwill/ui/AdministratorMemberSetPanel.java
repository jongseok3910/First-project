package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

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

public class AdministratorMemberSetPanel extends JPanel {
	private JTextField memberIDtextField;
	private JTextField memberPWtextField;
	private JTextField memberNametextField;
	private JTextField memberPhonetextField;
	private JTextField memberAddresstextField;
	private JTextField memberJoinDatetextField;

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
		scrollPane.setViewportView(showMemberList);
		
		JLabel memberAddressLabel = new JLabel("회원주소");
		memberAddressLabel.setBounds(29, 530, 80, 15);
		add(memberAddressLabel);
		
		JLabel memberJoinDateLabel = new JLabel("회원가입일");
		memberJoinDateLabel.setBounds(29, 570, 80, 15);
		add(memberJoinDateLabel);
		
		memberIDtextField = new JTextField();
		memberIDtextField.setBounds(116, 367, 195, 21);
		add(memberIDtextField);
		memberIDtextField.setColumns(10);
		
		memberPWtextField = new JTextField();
		memberPWtextField.setBounds(116, 407, 195, 21);
		add(memberPWtextField);
		memberPWtextField.setColumns(10);
		
		memberNametextField = new JTextField();
		memberNametextField.setBounds(116, 447, 195, 21);
		add(memberNametextField);
		memberNametextField.setColumns(10);
		
		memberPhonetextField = new JTextField();
		memberPhonetextField.setBounds(116, 487, 195, 21);
		add(memberPhonetextField);
		memberPhonetextField.setColumns(10);
		
		memberAddresstextField = new JTextField();
		memberAddresstextField.setBounds(116, 527, 195, 21);
		add(memberAddresstextField);
		memberAddresstextField.setColumns(10);
		
		memberJoinDatetextField = new JTextField();
		memberJoinDatetextField.setBounds(116, 567, 195, 21);
		add(memberJoinDatetextField);
		memberJoinDatetextField.setColumns(10);
		
		JButton memberPWChangeBtn = new JButton("수정");
		memberPWChangeBtn.setBounds(326, 406, 55, 23);
		add(memberPWChangeBtn);
		
		JButton memberNameChangeBtn = new JButton("수정");
		memberNameChangeBtn.setBounds(326, 446, 55, 23);
		add(memberNameChangeBtn);
		
		JButton memberPhoneChangeBtn = new JButton("수정");
		memberPhoneChangeBtn.setBounds(326, 486, 55, 23);
		add(memberPhoneChangeBtn);
		
		JButton memberAddressChangeBtn = new JButton("수정");
		memberAddressChangeBtn.setBounds(326, 526, 55, 23);
		add(memberAddressChangeBtn);
		
		JButton memberDeleteBtn = new JButton("삭제");
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
