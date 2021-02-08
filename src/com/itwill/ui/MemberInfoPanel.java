package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.itwill.service.JumunService;
import com.itwill.service.MemberService;
import com.itwill.vo.Card;
import com.itwill.vo.MemberInfo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MemberInfoPanel extends JPanel {
	private JTextField nameTF;
	private JPasswordField passwordTF;
	private JTextField addressTF;
	private JButton withdrawBtn;
	private JButton nameChangeBtn;
	private JButton passwordChangeBtn;
	private JButton addressChangeBtn;
	
	Bob4JoMainFrame bob4JoMainFrame;
	FoodSelectPanel foodSelectPanel;
	MemberService memberService;
	JLabel creditCardRegistLb;
	JumunService jumunService;
	Card registeredCard;
	ImageIcon cardUnRegistered;
	ImageIcon cardRegistered;
	private JButton phoneNumberBtn;
	private JTextField phoneNumberTF;

	/**
	 * Create the panel.
	 */
	public MemberInfoPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				//회원정보패널을 눌렀을 때
				MemberInfo member=bob4JoMainFrame.loginMember;
				String member_no=member.getMember_no();
				nameTF.setText(member.getMember_name());
				phoneNumberTF.setText(member.getMember_phone());
				addressTF.setText(member.getMember_address());
				try {
					registeredCard = jumunService.selectByCardMemberNo(member_no);
					if(registeredCard==null) {
//						카드등록 안됐을때
						creditCardRegistLb.setIcon(cardUnRegistered);			
					} else {
//						카드등록 됐을때
						creditCardRegistLb.setIcon(cardRegistered);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setLayout(null);
		
		JLabel nameLb = new JLabel("이름");
		nameLb.setHorizontalAlignment(SwingConstants.CENTER);
		nameLb.setBounds(33, 217, 57, 15);
		add(nameLb);
		
		nameTF = new JTextField();
		nameTF.setBounds(102, 213, 207, 22);
		add(nameTF);
		nameTF.setColumns(10);
		
		nameChangeBtn = new JButton("변경");
		nameChangeBtn.addActionListener(new ActionListener() {
//			변경 버튼 클릭시 등록된 이름변경
			public void actionPerformed(ActionEvent e) {
				try {
//					이름 변경칸 공백이면 이름을 입력해주세요 출력
					if(nameTF.getText().trim().equals("")) {
						nameTF.setText("");
						nameTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 이름을 입력해주세요.");
						return;
					}else {
					MemberInfo member = bob4JoMainFrame.loginMember;
					String nameStr = nameTF.getText();
					member.setMember_name(nameStr);
//					System.out.println(memberInfo);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "이름이 변경되었습니다.");
					// 타이틀변경
					bob4JoMainFrame.setTitle(member.getMember_name()+"님 로그인");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		nameChangeBtn.setBounds(313, 213, 71, 23);
		add(nameChangeBtn);
		
		JLabel passLb = new JLabel("비밀번호");
		passLb.setHorizontalAlignment(SwingConstants.CENTER);
		passLb.setBounds(33, 262, 57, 15);
		add(passLb);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(102, 258, 207, 23);
		add(passwordTF);
		
		passwordChangeBtn = new JButton("변경");
		passwordChangeBtn.addActionListener(new ActionListener() {
//			변경버튼 클릭시 비밀번호 변경
			public void actionPerformed(ActionEvent e) {
				try {
//					비밀번호 변경칸 공백이면 비밀번호를 입력해주세요 출력
					if(passwordTF.getText().trim().equals("")) {
						passwordTF.setText("");
						passwordTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 비밀번호를 입력해주세요.");
						return;
					}else {
					MemberInfo member = bob4JoMainFrame.loginMember;
					char[] passChars = passwordTF.getPassword();
					String passwordStr = new String(passChars);
					member.setMember_password(passwordStr);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		passwordChangeBtn.setBounds(313, 258, 71, 23);
		add(passwordChangeBtn);
		
		addressTF = new JTextField();
		addressTF.setBounds(102, 353, 207, 21);
		add(addressTF);
		addressTF.setColumns(10);
		
		addressChangeBtn = new JButton("변경");
		addressChangeBtn.addActionListener(new ActionListener() {
//			변경버튼 클릭시 주소변경
			public void actionPerformed(ActionEvent e) {
				try {
//					비밀번호 변경칸 공백이면 비밀번호를 입력해주세요 출력
					if(addressTF.getText().trim().equals("")) {
						addressTF.setText("");
						addressTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 주소를 입력해주세요.");
						return;
					}else {
					MemberInfo member = bob4JoMainFrame.loginMember;
					String addressStr = addressTF.getText();
					member.setMember_address(addressStr);
					memberService.memberUpdate(member);
					JOptionPane.showMessageDialog(null, "주소가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		addressChangeBtn.setBounds(313, 352, 71, 23);
		add(addressChangeBtn);
		
		JLabel addressLb = new JLabel("주소");
		addressLb.setHorizontalAlignment(SwingConstants.CENTER);
		addressLb.setBounds(33, 356, 57, 15);
		add(addressLb);
		
		creditCardRegistLb = new JLabel("");
		creditCardRegistLb.addMouseListener(new MouseAdapter() {
//			카드등록 그림 클릭시 카드 다이알로그 연결
			@Override
			public void mouseClicked(MouseEvent e) {
				Bob4JoCardDialog bob4joCardDialog = new Bob4JoCardDialog();
				bob4joCardDialog.setBob4JoMainFrame(bob4JoMainFrame);
				//System.out.println(bob4JoMainFrame.loginMember);
				bob4joCardDialog.setModal(true);
				bob4joCardDialog.setVisible(true);
				creditCardRegistLb.setIcon(cardRegistered);
			}
		});
//		카드 미등록시 보이는 이미지
		cardUnRegistered = new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/카드등록.jpg"));
//		카드등록시 보이는 이미지
		cardRegistered = new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/카드등록시보이는카드.png"));
		
		creditCardRegistLb.setHorizontalAlignment(SwingConstants.CENTER);
		creditCardRegistLb.setIcon(cardUnRegistered);			
		creditCardRegistLb.setBounds(39, 428, 350, 130);
		add(creditCardRegistLb);
		
		JLabel 문구Lb = new JLabel(" 자주 사용하는 카드를 등록해주세요.");
		문구Lb.setHorizontalAlignment(SwingConstants.CENTER);
		문구Lb.setBounds(39, 399, 344, 15);
		add(문구Lb);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 189, 350, 2);
		add(separator);
		
		JLabel profileLb = new JLabel("");
		profileLb.setHorizontalAlignment(SwingConstants.CENTER);
		profileLb.setIcon(new ImageIcon(MemberInfoPanel.class.getResource("/com/itwill/ui/회원사진.png")));
		profileLb.setBounds(32, 10, 351, 181);
		add(profileLb);
		
		withdrawBtn = new JButton("탈퇴하기");
		withdrawBtn.addActionListener(new ActionListener() {
//			탈퇴하기 누르면 회원삭제
			public void actionPerformed(ActionEvent e) {
				try {
					MemberInfo member = bob4JoMainFrame.loginMember;
					int reception = JOptionPane.showConfirmDialog(null, "회원탈퇴를 하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					if(reception==JOptionPane.CLOSED_OPTION) {
						//우측 상단 X를 눌렀을 때
					}else if(reception==JOptionPane.YES_OPTION) {
						//예를 눌렀을 때 회원탈퇴
						memberService.memberUnRegister(member.getMember_id());
						JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
						bob4JoMainFrame.logoutProcess();
					}else {
						//아니오를 눌렀을 때
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		withdrawBtn.setBounds(281, 568, 108, 23);
		add(withdrawBtn);
		
		JLabel PhoneNumberLb = new JLabel("전화번호");
		PhoneNumberLb.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberLb.setBounds(33, 311, 57, 15);
		add(PhoneNumberLb);
		
		phoneNumberTF = new JTextField();
		phoneNumberTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					return;
				}
				if(phoneNumberTF.getText().length()>=11) {
					e.consume();
				}
			}
		});
		phoneNumberTF.setColumns(10);
		phoneNumberTF.setBounds(102, 308, 207, 21);
		add(phoneNumberTF);
		
		phoneNumberBtn = new JButton("변경");
		phoneNumberBtn.addActionListener(new ActionListener() {
//			변경버튼누르면 전화번호 변경
			public void actionPerformed(ActionEvent e) {
				try {
//					전화번호 변경칸 공백이면 전화번호를 입력해주세요 출력
					if(phoneNumberTF.getText().trim().equals("")) {
						phoneNumberTF.setText("");
						phoneNumberTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 전화번호를 입력해주세요.");
						return;
					} else {
						MemberInfo member = bob4JoMainFrame.loginMember;
						String phoneRawStr=phoneNumberTF.getText();
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
		phoneNumberBtn.setBounds(313, 307, 71, 23);
		add(phoneNumberBtn);

		//service객체 생성
		memberService = new MemberService();
		jumunService = new JumunService();
	}//멤버인포패널
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;		
	}
}
