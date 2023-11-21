package gui.layout.main.admin_window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.AdminDao;
import database.reservation.Reservation;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class AdminLayout extends JFrame{
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/adminimage.png");
	static ImageIcon backImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/back_white.png");
	static ImageIcon homeImage = new getImages().getImageIcon(40, 40, "src/image/icon_image/btn/home_white.png");
	List<Reservation> lists = new ArrayList<>();
	String[] columnNames = {"예약번호","고객이메일","예약호실","예약시작일","예약종료일","사용기간경과","강제체크아웃"};
	public JButton b1 = new PrevBtn(backImage);
	public JButton b2 = new HomeBtn(homeImage);
	

	public AdminLayout() {
		setTitle("관리자페이지");
		setLayout(null);
		
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		add(Label);
		
		lists = new AdminDao().getReservstion();
		Reservation[] resList = new Reservation[lists.size()];
		
//		DefaultTableModel model = new DefaultTableModel();
//		List<Object[]> obLists = new ArrayList<>();
//		obLists = new AdminDao().getColumnNames();
//		for(String cl : columnNames) {
//			model.addColumn(cl);
//		}
//		for(Object[] ob : obLists) {
//			model.addRow(ob);
//		}
//		JTable reservationInfo = new JTable(model);
//		JScrollPane jscp1 = new JScrollPane(reservationInfo);
//
//		reservationInfo.getColumn("예약번호").setPreferredWidth(50);
//		reservationInfo.getColumn("고객이메일").setPreferredWidth(200);
//		reservationInfo.getColumn("예약호실").setPreferredWidth(50);
//		reservationInfo.getColumn("예약시작일").setPreferredWidth(70);
//		reservationInfo.getColumn("예약종료일").setPreferredWidth(70);
//		reservationInfo.getColumn("사용기간경과").setPreferredWidth(20);
//		reservationInfo.getColumn("강제체크아웃").setPreferredWidth(20);


		JPanel reservationInfo = new JPanel(new GridLayout(15,0));
		JScrollPane jscp1 = new JScrollPane(reservationInfo);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		for(int i = 0 ; i < lists.size() ; i++) {
			JPanel infoLabel = new JPanel(gbl);
//			infoLabel.setBorder(BorderFactory.createEmptyBorder(2 , 0 , 0 , 0));
			infoLabel.setLayout(gbl);
			try {
				addInfoLable(infoLabel,lists,i);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			reservationInfo.add(infoLabel);
		}
		
		
		
		
		reservationInfo.setBounds(50, 300, 650, 470);
		reservationInfo.setBackground(new Color(0,0,0,0));
		Label.add(reservationInfo);
		
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
				
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
				
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setVisible(true);
		setResizable(false);
	}
	
	public void addInfoLable(JLabel l, List<Reservation> lists) throws ParseException {
		
		
			for(Reservation list : lists) {
	
			//오늘날짜 yyyy-MM-dd로 생성
			String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
			 
			//yyyy-MM-dd 포맷 설정
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 
			//비교할 date와 today를데이터 포맷으로 변경
			Date date = new Date(dateFormat.parse(list.getReservation_end()).getTime()); 
			Date today = new Date(dateFormat.parse(todayfm).getTime());
			 
			//compareTo메서드를 통한 날짜비교
			int compare = date.compareTo(today); 
			String isPass;
			//조건문
			if(compare > 0) {
				isPass = "N";
			  System.out.println("date가 today보다 큽니다.(date > today)");
			}else if(compare < 0) {
				isPass = "Y";
			  System.out.println("today가 date보다 큽니다.(date < today)");
			}else {
				isPass = "C";
			  System.out.println("today와 date가 같습니다.(date = today)");
			}
			
			JLabel reNum = new JLabel(list.getReservation_number());
			reNum.setForeground(Color.WHITE);
			l.add(reNum);
			JLabel email = new JLabel(list.getCustomer_email());
			email.setForeground(Color.WHITE);
			l.add(email);
			JLabel roomNum = new JLabel(list.getRoom_number().toString());
			roomNum.setForeground(Color.WHITE);
			l.add(roomNum);
			JLabel start = new JLabel(list.getReservation_start());
			start.setForeground(Color.WHITE);
			l.add(start);
			JLabel end = new JLabel(list.getReservation_end());
			end.setForeground(Color.WHITE);
			l.add(end);
			JLabel chkpass = new JLabel(isPass);
			chkpass.setForeground(Color.WHITE);
			l.add(chkpass);
			//버튼
			l.add(new JButton("체크아웃"));
			
		}
	}
	
	public void addInfoLable(JPanel l, List<Reservation> lists , int i ) throws ParseException {
		//오늘날짜 yyyy-MM-dd로 생성
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		 
		//yyyy-MM-dd 포맷 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
		//비교할 date와 today를데이터 포맷으로 변경
		Date date = new Date(dateFormat.parse(lists.get(i).getReservation_end()).getTime()); 
		Date today = new Date(dateFormat.parse(todayfm).getTime());
		 
		//compareTo메서드를 통한 날짜비교
		int compare = date.compareTo(today); 
		String isPass;
		//조건문
		if(compare > 0) {
			isPass = "N";
		}else if(compare < 0) {
			isPass = "Y";
		}else {
			isPass = "C";
		}
		
		JLabel reNum = new JLabel(lists.get(i).getReservation_number());
//		reNum.setForeground(Color.WHITE);
		reNum.setPreferredSize(new Dimension(100,30));
		reNum.setHorizontalAlignment(JLabel.LEFT);
		l.add(reNum);
		JLabel email = new JLabel(lists.get(i).getCustomer_email());
		email.setPreferredSize(new Dimension(200,30));
//		email.setForeground(Color.WHITE);
		l.add(email);
		JLabel roomNum = new JLabel(lists.get(i).getRoom_number().toString());
//		roomNum.setForeground(Color.WHITE);
		roomNum.setPreferredSize(new Dimension(60,30));
		roomNum.setHorizontalAlignment(JLabel.CENTER);
		l.add(roomNum);
		
		JLabel start = new JLabel(lists.get(i).getReservation_start());
		start.setPreferredSize(new Dimension(100,30));
		start.setHorizontalAlignment(JLabel.CENTER);

//		start.setForeground(Color.WHITE);
		l.add(start);
		JLabel end = new JLabel(lists.get(i).getReservation_end());
		end.setPreferredSize(new Dimension(100,30));
		end.setHorizontalAlignment(JLabel.CENTER);

//		end.setForeground(Color.WHITE);
		l.add(end);
		JLabel chkpass = new JLabel(isPass);
		chkpass.setPreferredSize(new Dimension(40,30));
		chkpass.setHorizontalAlignment(JLabel.CENTER);

//		chkpass.setForeground(Color.WHITE);
		l.add(chkpass);
		//버튼
		JButton chkout = new JButton("체크아웃");
		chkout.setPreferredSize(new Dimension(30,30));
		l.add(chkout);
	
}
	
	
	public static void main(String[] args) {
		new AdminLayout();
	}
}


