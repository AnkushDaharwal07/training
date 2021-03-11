package ekart.order.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class Order {

	@Id
	@GeneratedValue
	int ORDERID;
	@Column(nullable = false)
	int BUYERID;
	@Column(nullable = false)
	double AMOUNT;
	Date date;
	@Column(nullable = false, length = 100)
	String ADDRESS;
	@Column(nullable = false, length = 60)
	String STATUS;

	public Order() {
		super();
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



}
