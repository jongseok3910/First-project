package com.itwill.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class Bob4JoMainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	MemberInfo loginMember;
	private JMenuItem loginMenuItem;
	private JMenuItem logoutMenuItem;
	private JMenuItem joinMenuItem;
	private JPanel baseCardLayoutPanel;
	private JPanel nextPanel;
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
		
		JMenu memberMenu = new JMenu("SUBWAY");
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
		memberMenu.add(logoutMenuItem);
		logoutMenuItem.setEnabled(false);
		
		joinMenuItem = new JMenuItem("가입");
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		baseCardLayoutPanel = new JPanel();
		baseCardLayoutPanel.setBackground(Color.WHITE);
		panel.add(baseCardLayoutPanel, "mainPanel");
		baseCardLayoutPanel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Bob4JoMainFrame.class.getResource("/com/itwill/ui/메인로고.png")));
		baseCardLayoutPanel.add(lblNewLabel, BorderLayout.CENTER);
		
		nextPanel = new JPanel();
		panel.add(nextPanel, "nextPanel");
		nextPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		nextPanel.add(tabbedPane, BorderLayout.CENTER);
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
		//CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
		//cl.show(baseCardLayoutPanel, "mainPanel");
	}
	public void logoutProcess() {
		this.loginMember=null;
		setTitle("");
		loginMenuItem.setEnabled(true);
		logoutMenuItem.setEnabled(false);
		joinMenuItem.setEnabled(true);
		//CardLayout cl=(CardLayout)baseCardLayoutPanel.getLayout();
		//cl.show(baseCardLayoutPanel,"mainPanel");
	}

}
