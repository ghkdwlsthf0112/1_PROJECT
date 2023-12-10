package gui.layout.main.admin_window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.ReservationHistoryDao;
import database.dbObjects.Reservation;
import database.dbObjects.Reservation_history;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import image.getImages;

public class AdminReservationHistory extends JFrame {
	static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/adminimage.png");

	List<Reservation_history> lists = new ArrayList<>();
	List<Object[]> obLists = new ArrayList<>();
	String[] columnNames = { "예약번호", "고객이메일", "객실", "체크인", "체크아웃", "취소여부" };
	public JButton b1 = new PrevBtn();
	public JButton b2 = new HomeBtn();

	public AdminReservationHistory() {
		setTitle("관리자페이지");
		setLayout(null);

		JLabel label = new JLabel();
		label.setBounds(0, 0, 768, 1024);
		label.setIcon(mainImage);
		add(label);

		// 예약 리스트 받아오기
		lists = new ReservationHistoryDao().getReservstions();
		try {
			obLists = new ReservationHistoryDao().getReservationsObject();
		} catch (ParseException e) {
			e.printStackTrace();
		}

//		Reservation[] resList = new Reservation[lists.size()];
		DefaultTableModel model = new DefaultTableModel();
		JPanel reservationInfo = new JPanel(new BorderLayout());
		JTable table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDragEnabled(false);
		table.setFont(new Font("나눔고딕", Font.BOLD, 11));
		JScrollPane jscp1 = new JScrollPane(table);
		jscp1.setBounds(0, 0, 650, 465);
		table.setEnabled(false);
		jscp1.setViewportView(table);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		jscp1.setBorder(BorderFactory.createEmptyBorder());
		jscp1.getViewport().setBackground(Color.WHITE);
		jscp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		reservationInfo.add(jscp1, BorderLayout.CENTER);

		for (String cl : columnNames) {
			model.addColumn(cl);
		}

		for (Object[] ob : obLists) {
			model.addRow(ob);
		}

		table.getColumn("예약번호").setPreferredWidth(70);

		table.getColumn("고객이메일").setPreferredWidth(200);

		table.getColumn("객실").setPreferredWidth(40);
		table.getColumn("객실").setCellRenderer(dtcr);

		table.getColumn("체크인").setPreferredWidth(60);

		table.getColumn("체크아웃").setPreferredWidth(60);

		table.getColumn("취소여부").setPreferredWidth(20);
		table.getColumn("취소여부").setCellRenderer(dtcr);

		reservationInfo.setBounds(60, 305, 645, 465);
		reservationInfo.setBackground(new Color(0, 0, 0, 0));
		label.add(reservationInfo);

		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		label.add(b1);

		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		label.add(b2);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}

	private void addInfoLable(JLabel l, List<Reservation> lists) throws ParseException {

		for (Reservation list : lists) {

			// 오늘날짜 yyyy-MM-dd로 생성
			String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));

			// yyyy-MM-dd 포맷 설정
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// 비교할 date와 today를데이터 포맷으로 변경
			Date date = new Date(dateFormat.parse(list.getReservation_end()).getTime());
			Date today = new Date(dateFormat.parse(todayfm).getTime());

			// compareTo메서드를 통한 날짜비교
			int compare = date.compareTo(today);
			String isPass;
			// 조건문
			if (compare > 0) {
				isPass = "N";
				System.out.println("date가 today보다 큽니다.(date > today)");
			} else if (compare < 0) {
				isPass = "Y";
				System.out.println("today가 date보다 큽니다.(date < today)");
			} else {
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
			// 버튼
			l.add(new JButton("체크아웃"));

		}
	}

	private void addInfoLable(JPanel l, List<Reservation> lists, int i) throws ParseException {
		// 오늘날짜 yyyy-MM-dd로 생성
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));

		// yyyy-MM-dd 포맷 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// 비교할 date와 today를데이터 포맷으로 변경
		Date date = new Date(dateFormat.parse(lists.get(i).getReservation_end()).getTime());
		Date today = new Date(dateFormat.parse(todayfm).getTime());

		// compareTo메서드를 통한 날짜비교
		int compare = date.compareTo(today);
		String isPass;
		// 조건문
		if (compare > 0) {
			isPass = "N";
		} else if (compare < 0) {
			isPass = "Y";
		} else {
			isPass = "C";
		}

		JLabel reNum = new JLabel(lists.get(i).getReservation_number());
		reNum.setPreferredSize(new Dimension(100, 30));
		reNum.setHorizontalAlignment(JLabel.LEFT);
		l.add(reNum);
		JLabel email = new JLabel(lists.get(i).getCustomer_email());
		email.setPreferredSize(new Dimension(200, 30));
		l.add(email);
		JLabel roomNum = new JLabel(lists.get(i).getRoom_number().toString());
		roomNum.setPreferredSize(new Dimension(60, 30));
		roomNum.setHorizontalAlignment(JLabel.CENTER);
		l.add(roomNum);

		JLabel start = new JLabel(lists.get(i).getReservation_start());
		start.setPreferredSize(new Dimension(100, 30));
		start.setHorizontalAlignment(JLabel.CENTER);

//		start.setForeground(Color.WHITE);
		l.add(start);
		JLabel end = new JLabel(lists.get(i).getReservation_end());
		end.setPreferredSize(new Dimension(100, 30));
		end.setHorizontalAlignment(JLabel.CENTER);

		l.add(end);
		JLabel chkpass = new JLabel(isPass);
		chkpass.setPreferredSize(new Dimension(40, 30));
		chkpass.setHorizontalAlignment(JLabel.CENTER);

		l.add(chkpass);
		// 버튼
		JButton chkout = new JButton("체크아웃");
		chkout.setPreferredSize(new Dimension(30, 30));
		l.add(chkout);

	}

}
