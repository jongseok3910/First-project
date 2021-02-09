package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.vo.Jumun;
import com.itwill.vo.MemberInfo;

import javax.swing.JMenuBar;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Bob4JoMainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	MemberInfo loginMember;
	private JMenuItem loginMenuItem;
	private JMenuItem logoutMenuItem;
	private JMenuItem joinMenuItem;
	private JPanel mainImagePanel;
	private JPanel mainUsePanel;
	private JPanel baseCardLayoutPanel;
	private FoodSelectPanel foodSelectPanel;
	private BasketPanel basketPanel;
	private PaymentListPanel paymentListPanel;
	private MemberInfoPanel memberInfoPanel;
	private JTabbedPane tabbedPane;
	private JPanel AdministratorPanel;
	private JTabbedPane AdminTabbedPane;
	private AdministratorStoreSetPanel administratorStoreSetPanel;
	private AdministratorMemberSetPanel administratorMemberSetPanel;
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bob4JoMainFrame frame = new Bob4JoMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bob4JoMainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bob4JoMainFrame.class.getResource("/com/itwill/ui/창아이콘.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 710);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("Bob4Jo");
		menuBar.add(memberMenu);
		
		loginMenuItem = new JMenuItem("로그인");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bob4JoLoginDialog loginDialog = new Bob4JoLoginDialog();
				loginDialog.setBob4JoMainFrame(Bob4JoMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
			}
		});
		memberMenu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
		});
		memberMenu.add(logoutMenuItem);
		logoutMenuItem.setEnabled(false);
		
		joinMenuItem = new JMenuItem("가입");
		joinMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bob4JoJoinDialog joinDialog = new Bob4JoJoinDialog();
				joinDialog.setBob4JoMainFrame(Bob4JoMainFrame.this);
				joinDialog.setModal(true);
				joinDialog.setVisible(true);
			}
		});
		memberMenu.add(joinMenuItem);
		
		JSeparator separator = new JSeparator();
		memberMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		memberMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		baseCardLayoutPanel = new JPanel();
		contentPane.add(baseCardLayoutPanel, BorderLayout.CENTER);
		baseCardLayoutPanel.setLayout(new CardLayout(0, 0));
		
		mainImagePanel = new JPanel();
		mainImagePanel.setBackground(Color.WHITE);
		baseCardLayoutPanel.add(mainImagePanel, "mainPanel");
		mainImagePanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Bob4JoMainFrame.class.getResource("/com/itwill/ui/메인로고.png")));
		mainImagePanel.add(lblNewLabel, BorderLayout.CENTER);
		
		mainUsePanel = new JPanel();
		baseCardLayoutPanel.add(mainUsePanel, "mainUsePanel");
		mainUsePanel.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainUsePanel.add(tabbedPane, BorderLayout.CENTER);
		
		foodSelectPanel = new FoodSelectPanel();
		tabbedPane.addTab("메뉴선택", null, foodSelectPanel, null);
		
		basketPanel = new BasketPanel();
		tabbedPane.addTab("장바구니", null, basketPanel, null);
		
		paymentListPanel = new PaymentListPanel();
		tabbedPane.addTab("주문목록", null, paymentListPanel, null);
		
		memberInfoPanel = new MemberInfoPanel();
		tabbedPane.addTab("회원정보", null, memberInfoPanel, null);
		/**************************************/
		foodSelectPanel.setBob4JoMainFrame(this);
		basketPanel.setBob4JoMainFrame(this);
		paymentListPanel.setBob4JoMainFrame(this);
		memberInfoPanel.setBob4JoMainFrame(this);
		
		AdministratorPanel = new JPanel();
		baseCardLayoutPanel.add(AdministratorPanel, "adminPanel");
		AdministratorPanel.setLayout(new BorderLayout(0, 0));
		
		AdminTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		AdministratorPanel.add(AdminTabbedPane, BorderLayout.CENTER);
		
		administratorStoreSetPanel = new AdministratorStoreSetPanel();
		AdminTabbedPane.addTab("가맹점 관리", null, administratorStoreSetPanel, null);
		
		administratorMemberSetPanel = new AdministratorMemberSetPanel();
		AdminTabbedPane.addTab("회원 관리", null, administratorMemberSetPanel, null);
		/**************************************/
		
		
		
		
	}//MainFrame
	public void loginProcess(MemberInfo loginMember) {
		/*
		 * 0.로그인멤버 저장
		 * 1.MemberMainFrame타이틀변경
		 * 2.로그인,회원가입메뉴아이템 불활성화
		 * 3.로그아웃메뉴아이템 활성화
		 */
		this.loginMember=loginMember;
		setTitle(loginMember.getMember_name()+"님 로그인");
		loginMenuItem.setEnabled(false);
		logoutMenuItem.setEnabled(true);
		joinMenuItem.setEnabled(false);
		if(loginMember.getMember_id().equals("ADMIN1")) {
			CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
			cl.show(baseCardLayoutPanel, "adminPanel");
		}else {			
			CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
			cl.show(baseCardLayoutPanel, "mainUsePanel");
		}
	}
	public void logoutProcess() {
		this.loginMember=null;
		setTitle("");
		loginMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(true);
		CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
		cl.show(baseCardLayoutPanel,"mainPanel");
	}
	public void changePanel(int tab_no) {
		tabbedPane.setSelectedIndex(tab_no);
	}
	public Jumun selectedJumun() {
		return foodSelectPanel.selectedJumun;
	}
}
