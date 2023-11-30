package database.dbObjects;

public class Payment {
	Integer pay_id;
	String reservation_number;
	Double discount_pct;
	Integer pay_total;

	public Payment() {

	}
	public Payment(
			Integer pay_id,
			String reservation_number,
			Double discount_pct,
			Integer pay_total) {
		
		this.pay_id = pay_id;
		this.reservation_number = reservation_number;
		this.discount_pct = discount_pct;
		this.pay_total = pay_total;
	}

	public Integer getPay_id() {
		return pay_id;
	}

	public void setPay_id(Integer pay_id) {
		this.pay_id = pay_id;
	}

	public String getReservation_number() {
		return reservation_number;
	}

	public void setReservation_number(String reservation_number) {
		this.reservation_number = reservation_number;
	}

	public Double getDiscount_pct() {
		return discount_pct;
	}

	public void setDiscount_pct(Double discount_pct) {
		this.discount_pct = discount_pct;
	}

	public Integer getPay_total() {
		return pay_total;
	}

	public void setPay_total(Integer pay_total) {
		this.pay_total = pay_total;
	}
	
}