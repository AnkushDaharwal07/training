package ekart.order.dto;

import java.sql.Date;

import ekart.order.entity.Order;

public class OrderDTO {

	int ORDERID;

	int BUYERID;

	double AMOUNT;
	
	Date date;

	String ADDRESS;

	String STATUS;


	public OrderDTO() {
		super();
	}

	public OrderDTO(int ORDERID,int BUYERID,double AMOUNT,Date date,String ADDRESS,String STATUS) {
		this();
		this.ORDERID = ORDERID;
		this.BUYERID = BUYERID;
		this.AMOUNT = AMOUNT;
		this.date = date;
		this.ADDRESS=ADDRESS;
		this.STATUS=STATUS;
	}


	public int getORDERID() {
		return ORDERID;
	}

	public void setORDERID(int oRDERID) {
		ORDERID = oRDERID;
	}

	public int getBUYERID() {
		return BUYERID;
	}

	public void setBUYERID(int bUYERID) {
		BUYERID = bUYERID;
	}

	public double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}

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

	// Converts Entity into DTO
	public static OrderDTO valueOf(Order order) {
		OrderDTO ordersDTO = new OrderDTO();
		ordersDTO.setORDERID(order.getORDERID());
		ordersDTO.setBUYERID(order.getBUYERID());
		ordersDTO.setAMOUNT(order.getAMOUNT());
		ordersDTO.setDate(order.getDate());
		ordersDTO.setADDRESS(order.getADDRESS());
		ordersDTO.setSTATUS(order.getSTATUS());
		return ordersDTO;
	}
	
	public Order createOrder() {
		Order order = new Order();
		order.setORDERID(this.getORDERID());
		order.setBUYERID(this.getBUYERID());
		order.setAMOUNT(this.getAMOUNT());
		order.setDate(this.getDate());
		order.setADDRESS(this.getADDRESS());
		order.setSTATUS(this.getSTATUS());
		return order;
	}

	@Override
	public String toString() {
		return "OrderDTO [ORDERID=" + ORDERID + ", BUYERID=" + BUYERID + ", AMOUNT=" + AMOUNT + ", date=" + date
				+ ", ADDRESS=" + ADDRESS + ", STATUS=" + STATUS + "]";
	}

}
