package gui.layout.main.reservation_inquiry;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import actions.FloorGuideBtnActionListener;
import actions.HomeBtnActionListener;
import actions.PrevBtnActionListener;
import database.AdminDao;
import database.dbObjects.Reservation;
import gui.buttons.FloorGuideBtn;
import gui.buttons.HomeBtn;
import gui.buttons.PrevBtn;
import gui.layout.main.reservation_inquiry.actions.CencelReservationActionListener;
import gui.layout.main.reservation_inquiry.buttons.CancelReservationBtn;
import gui.layout.main.reservation_inquiry.buttons.ResChkOkBtn;
import image.getImages;

public class ReservationInfo extends JFrame{
	final static ImageIcon mainImage = new getImages().getImageIcon(768, 1024, "src/image/background_image/ex1.png");
	
	public Reservation reservstion;
	public JButton b1 = new PrevBtn();
	public JButton b2 = new HomeBtn();
	public JButton b3 = new FloorGuideBtn();
	public JButton b4 = new CancelReservationBtn();
	public JButton b5 = new ResChkOkBtn();

	public ReservationInfo(Reservation reservstion) {
		setLayout(null);
		this.reservstion = reservstion;
		JLabel Label = new JLabel();
		Label.setBounds(0, 0, 768, 1024);
		Label.setIcon(mainImage);
		
		JLabel resNum = new JLabel(reservstion.getReservation_number());
		resNum.setBounds(300, 262, 300, 100);
		resNum.setFont(new Font("굴림", Font.BOLD, 35));
		add(resNum);
		
		JLabel resRoomNum = new JLabel(reservstion.getRoom_number().toString()+"호");
		resRoomNum.setBounds(300, 350, 300, 100);
		resRoomNum.setFont(new Font("굴림", Font.BOLD, 35));
		add(resRoomNum);
		
		JLabel resStartDate = new JLabel(reservstion.getReservation_start());
		resStartDate.setBounds(300, 438, 300, 100);
		resStartDate.setFont(new Font("굴림", Font.BOLD, 35));
		add(resStartDate);
		
		JLabel resEndDate = new JLabel(reservstion.getReservation_end());
		resEndDate.setBounds(300, 526, 300, 100);
		resEndDate.setFont(new Font("굴림", Font.BOLD, 35));
		add(resEndDate);
		
		// 뒤로가기 버튼
		b1.addActionListener(new PrevBtnActionListener(this));
		Label.add(b1);
		
		// 홈 버튼
		b2.addActionListener(new HomeBtnActionListener(this));
		Label.add(b2);
		
		// 안내 버튼
		b3.addActionListener(new FloorGuideBtnActionListener(this));
		Label.add(b3);
		
		// 예약 취소 버튼 => 취소 엑션 달아줘야함
		b4.addActionListener(new CencelReservationActionListener(this));
		Label.add(b4);
		
		// 확인 버튼
		b5.addActionListener(new HomeBtnActionListener(this));
		Label.add(b5);

		
		add(Label);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setSize(768, 1024);
		setUndecorated(true);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args) {
		AdminDao admindao = new AdminDao();

		Reservation reservstion = admindao.getReservstion("111111");
		new ReservationInfo(reservstion);
	}
	
}
