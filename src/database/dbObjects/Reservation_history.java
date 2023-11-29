package database.dbObjects;

public class Reservation_history {
   Integer reservation_history_id;
   String reservation_number;
   Integer room_number;
   String reservation_start;
   String reservation_end;
   String event_time;
   String r_or_c;
   String customer_email;
   
   
   public Reservation_history(
         Integer Reservation_history_id, 
         String reservation_number, 
         String customer_email, 
         Integer room_number,
         String reservation_start, 
         String reservation_end,
         String event_time,
         String r_or_c
         ) {
      this.reservation_history_id = Reservation_history_id;
      this.reservation_number = reservation_number;
      this.customer_email = customer_email;
      this.room_number = room_number;
      this.reservation_start = reservation_start;
      this.reservation_end = reservation_end;
   }
   public Integer getReservation_history_id() {
      return reservation_history_id;
   }
   public void setReservation_history_id(Integer reservation_history_id) {
      this.reservation_history_id = reservation_history_id;
   }
   public String getReservation_number() {
      return reservation_number;
   }
   public void setReservation_number(String reservation_number) {
      this.reservation_number = reservation_number;
   }
   public Integer getRoom_number() {
      return room_number;
   }
   public void setRoom_number(Integer room_number) {
      this.room_number = room_number;
   }
   public String getReservation_start() {
      return reservation_start;
   }
   public void setReservation_start(String reservation_start) {
      this.reservation_start = reservation_start;
   }
   public String getReservation_end() {
      return reservation_end;
   }
   public void setReservation_end(String reservation_end) {
      this.reservation_end = reservation_end;
   }
   public String getEvent_time() {
      return event_time;
   }
   public void setEvent_time(String event_time) {
      this.event_time = event_time;
   }
   public String getR_or_c() {
      return r_or_c;
   }
   public void setR_or_c(String r_or_c) {
      this.r_or_c = r_or_c;
   }
   
}