package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.itwill.service.JumunService;
import com.itwill.vo.MemberInfo;
import com.itwill.vo.Store;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministratorStoreSetPanel extends JPanel {
	private JList showStoreList;
	private JTextField storeBisinessTimeTF;
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
	private JTextField storeVolumeTF;
	private JButton storeAddBtn;
	
	Bob4JoMainFrame bob4JoMainFrame;
	JumunService jumunService;

	/**
	 * Create the panel.
	 */
	public AdministratorStoreSetPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				storeListList();
			}
		});
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 145, 374, 184);
		add(scrollPane);
		
		showStoreList = new JList();
		showStoreList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int selecedIndex = showStoreList.getSelectedIndex();
					if(selecedIndex==-1) {
						return;
					}
					List<Store> storeList = jumunService.selectStoreAll();
					Store store = storeList.get(selecedIndex);
					storeBisinessTimeTF.setText(store.getStore_name());
					storeBusinessTimeTF.setText(store.getStore_businessTime());
					storePhoneTF.setText(store.getStore_phone());
					storeAddressTF.setText(store.getStore_address());
					storeEstimateTimeTF.setText(store.getJumun_estimatedTime());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(showStoreList);
		
		storeBisinessTimeTF = new JTextField();
		storeBisinessTimeTF.setBounds(83, 343, 229, 25);
		add(storeBisinessTimeTF);
		storeBisinessTimeTF.setColumns(10);
		
		storeNameUpdateBtn = new JButton("수정");
		storeNameUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeBisinessTimeTF.getText().trim().equals("")) {
						storeBisinessTimeTF.setText("");
						storeBisinessTimeTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 가게명을 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_name(storeBisinessTimeTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "가게명이 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
		storeTimeUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeBisinessTimeTF.getText().trim().equals("")) {
						storeBisinessTimeTF.setText("");
						storeBisinessTimeTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 영업시간을 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_businessTime(storeBisinessTimeTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "영업시간이 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
		storePhoneUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storePhoneTF.getText().trim().equals("")) {
						storePhoneTF.setText("");
						storePhoneTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 전화번호를 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_phone(storePhoneTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "전화번호가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
		storeAddressUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeAddressTF.getText().trim().equals("")) {
						storeAddressTF.setText("");
						storeAddressTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 주소를 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_address(storeAddressTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "주소가 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
		storeDeliveryUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		StoredeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		storeAddBtn = new JButton("추가하기");
		storeAddBtn.setBounds(308, 47, 81, 23);
		add(storeAddBtn);
		
		JLabel storeVolumeLb = new JLabel("가맹점 수");
		storeVolumeLb.setForeground(new Color(255, 255, 255));
		storeVolumeLb.setFont(new Font("D2Coding ligature", Font.PLAIN, 10));
		storeVolumeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeVolumeLb.setBounds(251, 22, 81, 15);
		add(storeVolumeLb);
		
		storeVolumeTF = new JTextField();
		storeVolumeTF.setBounds(329, 16, 60, 21);
		add(storeVolumeTF);
		storeVolumeTF.setColumns(10);
		//서비스 객체생성
		jumunService = new JumunService();

	}//패널
	private void storeListList() {
		try {
			if(jumunService==null) {
				return;
			}
			List<Store> storeList= jumunService.selectStoreAll();
			int storeCount=0;
			DefaultListModel defaultListModel=new DefaultListModel();
			for (Store store : storeList) {
				defaultListModel.addElement(store.getStore_name());
				storeCount+=1;
			}
			showStoreList.setModel(defaultListModel);
			storeVolumeTF.setText(storeCount+"개");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;		
	}
}
