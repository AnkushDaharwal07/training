package ekart.order.dto;

import java.sql.Date;

import ekart.order.entity.Order;

public class AddOrderDTO {

	int BUYERID;
	
	int SELLERID;

	int QUANTITY;

	Date date;

	String ADDRESS;

	String STATUS;


	public AddOrderDTO() {
		super();
	}

	public AddOrderDTO(int BUYERID,Date date,String ADDRESS,String STATUS,int SELLERID,int QUANTITY) {
		this();
		this.BUYERID = BUYERID;
		this.date = date;
		this.ADDRESS=ADDRESS;
		this.STATUS=STATUS;
		this.ADDRESS=ADDRESS;
		this.QUANTITY=QUANTITY;
	}


	;

	public int getBUYERID() {
		return BUYERID;
	}

	public void setBUYERID(int bUYERID) {
		BUYERID = bUYERID;
	}

;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public int getSELLERID() {
		return SELLERID;
	}

	public void setSELLERID(int sELLERID) {
		SELLERID = sELLERID;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}

	@Override
	public String toString() {
		return "AddOrderDTO [BUYERID=" + BUYERID + ", SELLERID=" + SELLERID + ", QUANTITY=" + QUANTITY + ", date="
				+ date + ", ADDRESS=" + ADDRESS + ", STATUS=" + STATUS + "]";
	}

}
