package actions;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import database.CustomerDao;

public class EmailSend {

//	public EmailSend() {
//		Properties props = System.getProperties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//
//		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//
//		Session session = Session.getInstance(props, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("rlaxogud4637@gmail.com", "gfdh pqhz dmoh pctw");
//			}
//		});
//
//		String receiver = "haru4637@naver.com"; // 메일 받을 주소
//		String title = "자바로 보내는 메일!";
//		String content = "<h2 style='color:blue'>델루나호텔 예약정보입니다</h2><br/>" + "<h2 style='color:blue'>고객님의 예약 정보는</h2>";
//		Message message = new MimeMessage(session);
//		try {
//			message.setFrom(new InternetAddress("rlaxogud4637@gmail.com", "관리자", "utf-8"));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
//			message.setSubject(title);
//			message.setContent(content, "text/html; charset=utf-8");
//
//			Transport.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public EmailSend() {
		
	}

	public void EmailSend(String name, String phoneNum) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("EZNHotelDeluna@gmail.com", "gfdh pqhz dmoh pctw");
			}
		});
		CustomerDao cdao = new CustomerDao();
		List<String> getlist = cdao.getIdList(name, phoneNum);
		String sc = "";
		if (getlist.size() > 0) {
			for (int i = 0; i < getlist.size(); i++) {
				sc += (String) getlist.get(i) + " ";
			}
		}
		String receiver = sc; // 메일 받을 주소
		String title = name+"님의 델루나 호텔 아이디를 알려드립니다";
		String content = "<h2>고객님의 아이디(이메일)는 </h2><br/>" + 
		"<h2 style='color:blue'>"+sc+"</h2>"+"<h2>입니다</h2>";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("EZNHotelDeluna@gmail.com", "HotelDeluna", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void pwd_Email(String name, String email, String randPwd) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("EZNHotelDeluna@gmail.com", "gfdh pqhz dmoh pctw");
			}
		});
		
		String receiver = email; // 메일 받을 주소
		String title = name+"님의 델루나호텔 임시비밀번호 입니다";
		String content = "<h2>"+name+"고객님의 비밀번호는</h2><br/>" + "<h2 style='color:blue'>"+randPwd+"</h2>입니다";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("EZNHotelDeluna@gmail.com", "HotelDeluna", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ReservationSend(String reservationNum, String name, String roomNO ,String checkIn, String checkOut, String useDay, String payMoney ) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("EZNHotelDeluna@gmail.com", "gfdh pqhz dmoh pctw");
			}
		});
		
		String receiver = "haru4637@naver.com"; // 메일 받을 주소
		String title = name + "님의 델루나호텔 예약정보 입니다";
		String content = 
				"회원님이 예약하신 델루나호텔 예약정보 입니다</br>"+
				name+"고객님의 예약번호는"+reservationNum+"입니다</br>"+
				"방번호 : " +roomNO+"호</br>"+
				"체크인 날짜: " +checkIn+"일</br>"+
				"체크아웃 날짜는 "+checkOut+"일 </br>"+
				"사용기간: " +useDay+ "일</br>"+
				"결제하신금액: " +payMoney+ "원 입니다";
				
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("EZNHotelDeluna@gmail.com", "HotelDeluna", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//public static void main(String[] args) {
		//new EmailSend();
	//}

}