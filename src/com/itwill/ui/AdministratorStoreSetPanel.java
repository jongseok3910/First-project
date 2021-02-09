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
	private JTextField storeNameTF;
	private JButton storeNameUpdateBtn;
	private JTextField storeBusinessTimeTF;
	private JTextField storePhoneTF;
	private JTextField storeAddressTF;
	private JTextField storeEstimateTimeTF;
	private JButton storeDeleteBtn;
	private JButton storeTimeUpdateBtn;
	private JButton storePhoneUpdateBtn;
	private JButton storeAddressUpdateBtn;
	private JButton storeEstimatedTimeUpdateBtn;
	private JTextField storeVolumeTF;
	private JButton storeAddBtn;
	
	Bob4JoMainFrame bob4JoMainFrame;
	JumunService jumunService;

	/**
	 * Create the panel.
	 */
	public AdministratorStoreSetPanel() {
		
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 145, 373, 201);
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
					storeNameTF.setText(store.getStore_name());
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
		
		storeNameTF = new JTextField();
		storeNameTF.setBounds(82, 368, 229, 25);
		add(storeNameTF);
		storeNameTF.setColumns(10);
		
		storeNameUpdateBtn = new JButton("수정");
		storeNameUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeNameTF.getText().trim().equals("")) {
						storeNameTF.setText("");
						storeNameTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 가게명을 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_name(storeNameTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "가게명이 변경되었습니다.");
						storeListList();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		storeNameUpdateBtn.setBounds(329, 368, 60, 25);
		add(storeNameUpdateBtn);
		
		JLabel storeLb = new JLabel("가게명");
		storeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeLb.setBounds(14, 367, 67, 27);
		add(storeLb);
		
		JLabel storeBusinessTimeLb = new JLabel("영업시간");
		storeBusinessTimeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeBusinessTimeLb.setBounds(14, 408, 67, 27);
		add(storeBusinessTimeLb);
		
		storeBusinessTimeTF = new JTextField();
		storeBusinessTimeTF.setColumns(10);
		storeBusinessTimeTF.setBounds(82, 409, 229, 25);
		add(storeBusinessTimeTF);
		
		storeTimeUpdateBtn = new JButton("수정");
		storeTimeUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeNameTF.getText().trim().equals("")) {
						storeNameTF.setText("");
						storeNameTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 영업시간을 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setStore_businessTime(storeNameTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "영업시간이 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		storeTimeUpdateBtn.setBounds(329, 409, 60, 25);
		add(storeTimeUpdateBtn);
		
		JLabel sotrePhoneLb = new JLabel("전화번호");
		sotrePhoneLb.setHorizontalAlignment(SwingConstants.CENTER);
		sotrePhoneLb.setBounds(14, 452, 67, 27);
		add(sotrePhoneLb);
		
		storePhoneTF = new JTextField();
		storePhoneTF.setColumns(10);
		storePhoneTF.setBounds(82, 453, 229, 25);
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
		storePhoneUpdateBtn.setBounds(329, 453, 60, 25);
		add(storePhoneUpdateBtn);
		
		JLabel storeAddressLb = new JLabel("주소");
		storeAddressLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeAddressLb.setBounds(14, 500, 67, 27);
		add(storeAddressLb);
		
		storeAddressTF = new JTextField();
		storeAddressTF.setColumns(10);
		storeAddressTF.setBounds(82, 501, 229, 25);
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
		storeAddressUpdateBtn.setBounds(329, 501, 60, 25);
		add(storeAddressUpdateBtn);
		
		JLabel storeEstimatedTimeLb = new JLabel("배달시간");
		storeEstimatedTimeLb.setHorizontalAlignment(SwingConstants.CENTER);
		storeEstimatedTimeLb.setBounds(14, 547, 67, 27);
		add(storeEstimatedTimeLb);
		
		storeEstimateTimeTF = new JTextField();
		storeEstimateTimeTF.setColumns(10);
		storeEstimateTimeTF.setBounds(82, 548, 229, 25);
		add(storeEstimateTimeTF);
		
		storeEstimatedTimeUpdateBtn = new JButton("수정");
		storeEstimatedTimeUpdateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeEstimateTimeTF.getText().trim().equals("")) {
						storeEstimateTimeTF.setText("");
						storeEstimateTimeTF.requestFocus();
						JOptionPane.showMessageDialog(null, "변경할 배달시간을 입력해주세요.");
						return;
					}else {
						int selecedIndex = showStoreList.getSelectedIndex();
						if(selecedIndex==-1) {
							return;
						}
						List<Store> storeList = jumunService.selectStoreAll();
						Store store = storeList.get(selecedIndex);
						store.setJumun_estimatedTime(storeEstimateTimeTF.getText());
						jumunService.updateByStoreNo(store);
						JOptionPane.showMessageDialog(null, "배달시간이 변경되었습니다.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		storeEstimatedTimeUpdateBtn.setBounds(329, 548, 60, 25);
		add(storeEstimatedTimeUpdateBtn);
		
		storeDeleteBtn = new JButton("삭제하기");
		storeDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(storeNameTF.getText().trim().equals("")) {
						storeNameTF.setText("");
						storeNameTF.requestFocus();
						JOptionPane.showMessageDialog(null, "삭제할 가게명을 입력해주세요.");
						return;
					}else {
						String store_name = storeNameTF.getText();
						jumunService.deleteByStoreNo(store_name);
						JOptionPane.showMessageDialog(null, "가게가 삭제되었습니다.");
						storeListList();
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "삭제할 가게가 없습니다.");
				}
			}
		});
		storeDeleteBtn.setBounds(296, 80, 93, 23);
		add(storeDeleteBtn);
		
		JLabel storeListLb = new JLabel("가맹점 정보");
		storeListLb.setIcon(new ImageIcon(AdministratorStoreSetPanel.class.getResource("/com/itwill/ui/상점관리그림.png")));
		storeListLb.setBounds(15, 13, 284, 90);
		add(storeListLb);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdministratorStoreSetPanel.class.getResource("/com/itwill/ui/가맹점정보라벨.png")));
		lblNewLabel.setBounds(0, 113, 415, 25);
		add(lblNewLabel);
		
		storeAddBtn = new JButton("추가하기");
		storeAddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String storeStr = storeNameTF.getText();
				//가맹점 입력이 안되어 있으면
				if(storeStr.trim().equals("")) {
					storeNameTF.setText("");
					JOptionPane.showMessageDialog(null, "가맹점을 입력하세요.");
					storeNameTF.requestFocus();
					return;
				}
					
				try {
					String store_name=storeNameTF.getText();
					String store_businessTime=storeBusinessTimeTF.getText();
					String store_phone=storePhoneTF.getText();
					String store_address=storeAddressTF.getText();
					String jumun_estimatedTime=storeEstimateTimeTF.getText();
					Store newStore = new Store(0, store_name, store_businessTime, store_phone, store_address, jumun_estimatedTime, 0.0);
					jumunService.StoreInsert(newStore);
					JOptionPane.showMessageDialog(null, "가게가 추가되었습니다.");
					storeListList();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		storeAddBtn.setBounds(296, 47, 93, 23);
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
	public void storeListList() {
		try {
			if(jumunService==null) {
				return;
			}
			List<Store> storeList = jumunService.selectStoreAll();
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
