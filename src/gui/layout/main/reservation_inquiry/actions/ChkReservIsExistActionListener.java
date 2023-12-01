package gui.layout.main.reservation_inquiry.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.ReservationDao;
import gui.layout.main.reservation_inquiry.ReservationChkIn;
import gui.layout.main.reservation_inquiry.ReservationChkInNow;
import gui.layout.main.reservation_inquiry.ReservationInfo;
import gui.layout.main.reservation_inquiry.ReservationInquiryLayout;

public class ChkReservIsExistActionListener implements ActionListener{
	JButton ReservationOkBtn;
	JFrame mainFrame;
	JTextField displayField;
	JOptionPane info = new JOptionPane();
	
	
//	if (e.getSource() == btn) {
//        int re = JOptionPane.showConfirmDialog(this, "취소하시겠습니까?", " ", JOptionPane.YES_NO_OPTION,
//              JOptionPane.QUESTION_MESSAGE);
//        if (re == JOptionPane.YES_OPTION) {// 예 버튼을 클릭하면 취소 처리
//           dispose();// 현재창을 닫기
//        }
//     } // 취소 버튼 클릭시
	
//	// 메세지 경고
//	   public static void messageBox(Object obj, String message) {
//	      JOptionPane.showMessageDialog((Component) obj, message);
//	   }// messageBox()
//	
	
//	messageBox(this, "아이디를 입력한 뒤 중복확인을 해주세요.");
	ReservationDao reservationDao = new ReservationDao();
	@Override
	   public void actionPerformed(ActionEvent e) {
	      if(e.getSource() == ReservationOkBtn) {
	         System.out.println(displayField.getText());
	         
	         // 예약 번호
	         String reservationNumber = displayField.getText();
	         // 체크인 시작 날짜 
	         if(reservationDao.getChkInStartDate(reservationNumber)==null) {
	        	 info.showMessageDialog(mainFrame, "확인되는 예약이 없습니다.", "Message",JOptionPane.INFORMATION_MESSAGE );
	         } else {
	        	 String chkInStartDate = reservationDao.getChkInStartDate(reservationNumber);
	        	 // 현재 날짜 가져오기
	        	 String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(LocalDateTime.now());
	        	 
	        	 // 예약 시작 날짜와 현재 날짜 비교
	        	 if (chkInStartDate.equals(currentDate)) {
	        		 if (reservationDao.chkReservation(displayField.getText()) == 1 && mainFrame.getTitle().equals("예약확인")) {
	        			 new ReservationInfo(reservationDao.getReservstion(displayField.getText()));
	        			 mainFrame.dispose();
	        		 } else if (reservationDao.chkReservation(displayField.getText()) == 1 && mainFrame.getTitle().equals("예약체크인")) {
	        			 new ReservationChkIn(reservationDao.getReservstion(displayField.getText()));
	        			 mainFrame.dispose();
	        		 } else {
	        			 info.showMessageDialog(mainFrame, "확인되는 예약이 없습니다.", "Message",JOptionPane.INFORMATION_MESSAGE );
	        		 }
	        	 } else {
	        		 info.showMessageDialog(mainFrame, "당일 외에는 체크인이 불가능합니다.", "Message",JOptionPane.INFORMATION_MESSAGE );
	        	 }
	  
	         }
	         
	         
	      }
	   }
	
	public ChkReservIsExistActionListener(ReservationInquiryLayout mainFrame) {
		this.ReservationOkBtn = mainFrame.b3;
		this.mainFrame = mainFrame;
		this.displayField = mainFrame.displayField;
	}
	
	public ChkReservIsExistActionListener(ReservationChkInNow mainFrame) {
		this.ReservationOkBtn = mainFrame.b3;
		this.mainFrame = mainFrame;
		this.displayField = mainFrame.displayField;
	}
	
	
}
