package gui.layout.paymentWindow.check_totalpay_window;

import java.text.ParseException;
import java.time.LocalDate;

import database.ReservationDao;
import database.dbObjects.Payment;

public class Pt {
	 public static boolean isWithinRange(String date, String startDate, String endDate) throws ParseException {
	       if(date.length() != 10 || startDate.length() != 10 || endDate.length() != 10){
	           return false;
	       }        
	   	       
	       LocalDate localdate = LocalDate.parse(date);
	       LocalDate startLocalDate = LocalDate.parse(startDate);
	       LocalDate endLocalDate = LocalDate.parse(endDate);
	       endLocalDate = endLocalDate.plusDays(1); // endDate는 포함하지 않으므로 +1일을 해줘야함.
	       
	       return ( ! localdate.isBefore( startLocalDate ) ) && ( localdate.isBefore( endLocalDate ) );
	   }
	 
	public static void main(String[] args) {
		try {
			System.out.println(isWithinRange("2023-11-28", "2023-11-29", "2023-12-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
