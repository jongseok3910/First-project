package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdministratorStoreSetPanel extends JPanel {
	private JList storeList;
	private JTextField storeNameTF;
	private JButton storeNameUpdateBtn;
	private JTextField storeBusinessTimeTF;
	private JTextField storePhoneTF;
	private JTextField storeAddressTF;
	private JTextField storeDeliveryTF;
	private JTextField storeEstimateTimeTF;
	private JButton StoredeleteBtn;
	private JButton storeTimeUpdateBtn;
	private JButton storePhoneUpdateBtn;
	private JButton storeAddressUpdateBtn;
	private JButton storeDeliveryUpdateBtn;
	private JButton storeEstimatedTimeUpdateBtn;

	/**
	 * Create the panel.
	 */
	public AdministratorStoreSetPanel() {
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 145, 374, 184);
		add(scrollPane);
		
		storeList = new JList();
		scrollPane.setViewportView(storeList);
		
		storeNameTF = new JTextField();
		storeNameTF.setBounds(83, 343, 229, 25);
		add(storeNameTF);
		storeNameTF.setColumns(10);
		
		storeNameUpdateBtn = new JButton("수정");
		storeNameUpdateBtn.setBounds(330, 343, 60, 25);
		add(storeNameUpdateBtn);
		
		JLabel storeLb = new JLabel("가게명");
		storeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeLb.setBounds(15, 342, 67, 27);
		add(storeLb);
		
		JLabel storeBusinessTimeLb = new JLabel("영업시간");
		storeBusinessTimeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeBusinessTimeLb.setBounds(15, 383, 67, 27);
		add(storeBusinessTimeLb);
		
		storeBusinessTimeTF = new JTextField();
		storeBusinessTimeTF.setColumns(10);
		storeBusinessTimeTF.setBounds(83, 384, 229, 25);
		add(storeBusinessTimeTF);
		
		storeTimeUpdateBtn = new JButton("수정");
		storeTimeUpdateBtn.setBounds(330, 384, 60, 25);
		add(storeTimeUpdateBtn);
		
		JLabel sotrePhoneLb = new JLabel("전화번호");
		sotrePhoneLb.setHorizontalAlignment(SwingConstants.CENTER);
		sotrePhoneLb.setBounds(15, 427, 67, 27);
		add(sotrePhoneLb);
		
		storePhoneTF = new JTextField();
		storePhoneTF.setColumns(10);
		storePhoneTF.setBounds(83, 428, 229, 25);
		add(storePhoneTF);
		
		storePhoneUpdateBtn = new JButton("수정");
		storePhoneUpdateBtn.setBounds(330, 428, 60, 25);
		add(storePhoneUpdateBtn);
		
		JLabel storeAddressLb = new JLabel("주소");
		storeAddressLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeAddressLb.setBounds(15, 475, 67, 27);
		add(storeAddressLb);
		
		storeAddressTF = new JTextField();
		storeAddressTF.setColumns(10);
		storeAddressTF.setBounds(83, 476, 229, 25);
		add(storeAddressTF);
		
		storeAddressUpdateBtn = new JButton("수정");
		storeAddressUpdateBtn.setBounds(330, 476, 60, 25);
		add(storeAddressUpdateBtn);
		
		JLabel sotreDeliverypriceLb = new JLabel("배달요금");
		sotreDeliverypriceLb.setHorizontalAlignment(SwingConstants.CENTER);
		sotreDeliverypriceLb.setBounds(15, 515, 67, 27);
		add(sotreDeliverypriceLb);
		
		storeDeliveryTF = new JTextField();
		storeDeliveryTF.setColumns(10);
		storeDeliveryTF.setBounds(83, 516, 229, 25);
		add(storeDeliveryTF);
		
		storeDeliveryUpdateBtn = new JButton("수정");
		storeDeliveryUpdateBtn.setBounds(330, 516, 60, 25);
		add(storeDeliveryUpdateBtn);
		
		JLabel storeEstimatedTimeLb = new JLabel("배달시간");
		storeEstimatedTimeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeEstimatedTimeLb.setBounds(15, 558, 67, 27);
		add(storeEstimatedTimeLb);
		
		storeEstimateTimeTF = new JTextField();
		storeEstimateTimeTF.setColumns(10);
		storeEstimateTimeTF.setBounds(83, 559, 229, 25);
		add(storeEstimateTimeTF);
		
		storeEstimatedTimeUpdateBtn = new JButton("수정");
		storeEstimatedTimeUpdateBtn.setBounds(330, 559, 60, 25);
		add(storeEstimatedTimeUpdateBtn);
		
		StoredeleteBtn = new JButton("삭제하기");
		StoredeleteBtn.setBounds(308, 80, 81, 23);
		add(StoredeleteBtn);
		
		JLabel storeListLb = new JLabel("가맹점 정보");
		storeListLb.setIcon(new ImageIcon(AdministratorStoreSetPanel.class.getResource("/com/itwill/ui/상점관리그림.png")));
		storeListLb.setBounds(15, 13, 284, 90);
		add(storeListLb);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdministratorStoreSetPanel.class.getResource("/com/itwill/ui/가맹점정보라벨.png")));
		lblNewLabel.setBounds(0, 113, 415, 25);
		add(lblNewLabel);

	}
}
