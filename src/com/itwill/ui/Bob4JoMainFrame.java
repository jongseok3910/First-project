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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	private JPanel administratorPanel;
	private JTabbedPane adminTabbedPane;
	private AdministratorStoreSetPanel administratorStoreSetPanel;
	private AdministratorMemberSetPanel administratorMemberSetPanel;
	private AdministratorFoodSetPanel administratorFoodSetPanel;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Bob4JoMainFrame.class.getResource("/com/itwill/ui/????????????.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 710);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu memberMenu = new JMenu("Bob4Jo");
		menuBar.add(memberMenu);
		
		loginMenuItem = new JMenuItem("?????????");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bob4JoLoginDialog loginDialog = new Bob4JoLoginDialog();
				loginDialog.setBob4JoMainFrame(Bob4JoMainFrame.this);
				loginDialog.setModal(true);
				loginDialog.setVisible(true);
			}
		});
		memberMenu.add(loginMenuItem);
		
		logoutMenuItem = new JMenuItem("????????????");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutProcess();
			}
		});
		memberMenu.add(logoutMenuItem);
		logoutMenuItem.setEnabled(false);
		
		joinMenuItem = new JMenuItem("??????");
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
		
		JMenuItem exitMenuItem = new JMenuItem("??????");
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
		lblNewLabel.setIcon(new ImageIcon(Bob4JoMainFrame.class.getResource("/com/itwill/ui/????????????.png")));
		mainImagePanel.add(lblNewLabel, BorderLayout.CENTER);
		
		mainUsePanel = new JPanel();
		baseCardLayoutPanel.add(mainUsePanel, "mainUsePanel");
		mainUsePanel.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		mainUsePanel.add(tabbedPane, BorderLayout.CENTER);
		
		foodSelectPanel = new FoodSelectPanel();
		tabbedPane.addTab("????????????", null, foodSelectPanel, null);
		
		basketPanel = new BasketPanel();
		tabbedPane.addTab("????????????", null, basketPanel, null);
		
		paymentListPanel = new PaymentListPanel();
		tabbedPane.addTab("????????????", null, paymentListPanel, null);
		
		memberInfoPanel = new MemberInfoPanel();
		tabbedPane.addTab("????????????", null, memberInfoPanel, null);
		/**************************************/
		foodSelectPanel.setBob4JoMainFrame(this);
		basketPanel.setBob4JoMainFrame(this);
		paymentListPanel.setBob4JoMainFrame(this);
		memberInfoPanel.setBob4JoMainFrame(this);
		
		administratorPanel = new JPanel();
		baseCardLayoutPanel.add(administratorPanel, "adminPanel");
		administratorPanel.setLayout(new BorderLayout(0, 0));
		
		adminTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		administratorPanel.add(adminTabbedPane, BorderLayout.CENTER);
		
		administratorStoreSetPanel = new AdministratorStoreSetPanel();
		administratorStoreSetPanel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				administratorStoreSetPanel.storeListList();
			}
		});
		administratorStoreSetPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				administratorStoreSetPanel.storeListList();
			}
		});
		adminTabbedPane.addTab("????????? ??????", null, administratorStoreSetPanel, null);
		
		administratorMemberSetPanel = new AdministratorMemberSetPanel();
		administratorMemberSetPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				administratorMemberSetPanel.memberListTable();
			}
		});
		
		administratorFoodSetPanel = new AdministratorFoodSetPanel();
		adminTabbedPane.addTab("?????? ??????", null, administratorFoodSetPanel, null);
		adminTabbedPane.addTab("?????? ??????", null, administratorMemberSetPanel, null);
		/**************************************/
		
		
		
		
	}//MainFrame
	public void loginProcess(MemberInfo loginMember) {
		/*
		 * 0.??????????????? ??????
		 * 1.MemberMainFrame???????????????
		 * 2.?????????,??????????????????????????? ????????????
		 * 3.??????????????????????????? ?????????
		 */
		this.loginMember=loginMember;
		setTitle(loginMember.getMember_name()+"??? ?????????");
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
