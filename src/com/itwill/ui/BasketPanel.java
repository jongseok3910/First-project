package com.itwill.ui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.service.JumunService;
import com.itwill.vo.Card;
import com.itwill.vo.Food;
import com.itwill.vo.Jumun;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasketPanel extends JPanel {
	private JTable basketTable;
	private JTextField totalTF;
	private JTextField requestTF;
	private JComboBox paymentCB;
	private JButton paymentBtn;
	private JButton returnBtn;
	
	JumunService jumunService;
	Bob4JoMainFrame bob4JoMainFrame;
	private JScrollPane scrollPane;
	FoodSelectPanel foodSelectPanel;
	/**
	 * Create the panel.
	 */
	public BasketPanel() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				jumunListTable();
				List<Jumun> jumunList=null;
				try {
					jumunList = jumunService.selectByJumunTypeIsNull(bob4JoMainFrame.loginMember.getMember_no());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int sum = 0;
				for (Jumun jumun : jumunList) {
					sum+=jumun.getJumun_sum();
				}
				totalTF.setText(sum+"");
			}
		});
		setBackground(new Color(255, 204, 51));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 208, 340, 99);
		add(scrollPane);
		
		basketTable = new JTable();
		scrollPane.setViewportView(basketTable);
		basketTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\uC74C\uC2DD\uBA85", "\uC218\uB7C9"
			}
		));
		
		JLabel totalLb = new JLabel("총금액");
		totalLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		totalLb.setHorizontalAlignment(SwingConstants.CENTER);
		totalLb.setBounds(36, 337, 62, 21);
		add(totalLb);
		
		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalTF.setBounds(118, 337, 205, 21);
		add(totalTF);
		totalTF.setColumns(10);
		
		JLabel wonLb = new JLabel("원");
		wonLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		wonLb.setHorizontalAlignment(SwingConstants.CENTER);
		wonLb.setBounds(335, 340, 31, 15);
		add(wonLb);
		
		JLabel requestLb = new JLabel("요청사항");
		requestLb.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		requestLb.setHorizontalAlignment(SwingConstants.CENTER);
		requestLb.setBounds(35, 412, 57, 15);
		add(requestLb);
		
		requestTF = new JTextField();
		requestTF.setBounds(118, 409, 251, 21);
		add(requestTF);
		requestTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("결제수단");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 488, 57, 15);
		add(lblNewLabel);
		
		paymentCB = new JComboBox();
		paymentCB.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		paymentCB.setModel(new DefaultComboBoxModel(new String[] {"카드결제", "현장결제"}));
		paymentCB.setBounds(118, 480, 251, 23);
		add(paymentCB);
		
		paymentBtn = new JButton("결제하기");
		paymentBtn.setForeground(new Color(0, 0, 0));
		paymentBtn.setBackground(new Color(240, 240, 240));
		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String member_no = bob4JoMainFrame.loginMember.getMember_no();
				String jumun_request = requestTF.getText();
				int paymentTypeIndex = paymentCB.getSelectedIndex();
				if(paymentTypeIndex==0) {
					/*
					 * 카드결제 완성안됨
					 */
					try {
						Card card = jumunService.selectByCardMemberNo(member_no);
						if(card!=null) {
						CardPasswordCheckDialog cardPasswordCheckDialog = new CardPasswordCheckDialog();
						cardPasswordCheckDialog.setBasketPanel(BasketPanel.this);
						cardPasswordCheckDialog.setModal(true);
						cardPasswordCheckDialog.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "등록된 카드가 없습니다");
							return;
						}
						jumunService.updateByJumunTypeIsNull(jumun_request,"카드결제",member_no);
						bob4JoMainFrame.changePanel(2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(paymentTypeIndex==1) {
					//현장결제
					try {
						jumunService.updateByJumunTypeIsNull(jumun_request,"현장결제",member_no);
						JOptionPane.showMessageDialog(null, "주문이 완료되었습니다");
						//주문목록
						bob4JoMainFrame.changePanel(2);
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		paymentBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		paymentBtn.setBounds(35, 556, 132, 23);
		add(paymentBtn);
		
		returnBtn = new JButton("돌아가기");
		
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bob4JoMainFrame.changePanel(0);
			}
		});
		
		returnBtn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		returnBtn.setBounds(237, 556, 132, 23);
		add(returnBtn);
		
		JLabel listLb = new JLabel("장바구니 목록");
		listLb.setForeground(new Color(0, 0, 0));
		listLb.setFont(new Font("함초롬돋움", Font.PLAIN, 11));
		listLb.setHorizontalAlignment(SwingConstants.CENTER);
		listLb.setBounds(24, 25, 368, 25);
		add(listLb);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(BasketPanel.class.getResource("/com/itwill/ui/장바구니.png")));
		lblNewLabel_1.setBounds(110, 49, 193, 140);
		add(lblNewLabel_1);
		
		//service객체 생성
		jumunService = new JumunService();

	}//바스켓 패널
	private void jumunListTable() {
		try {
			if(jumunService==null) {
				return;
			}
			List<Jumun> jumunList = jumunService.selectByJumunTypeIsNull(bob4JoMainFrame.loginMember.getMember_no());
			Vector jumunListVector = new Vector();
			for (Jumun jumun : jumunList) {
				Food food=jumunService.selectByFoodNo(jumun.getFood_no());
				Vector foodVector=new Vector();
				foodVector.add(food.getFood_name());
				foodVector.add(food.getFood_price());
				foodVector.add(jumun.getJumun_quantity());
				jumunListVector.add(foodVector);
			}
			Vector columnNames=new Vector();
			columnNames.add("음식명");
			columnNames.add("가격");
			columnNames.add("수량");
			
			DefaultTableModel defaultTableModel =
					new DefaultTableModel(jumunListVector, columnNames);
			basketTable.setModel(defaultTableModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//주문리스트테이블
	public void setBob4JoMainFrame(Bob4JoMainFrame bob4JoMainFrame) {
		this.bob4JoMainFrame=bob4JoMainFrame;		
	}
}
