package ekart.order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MyKey implements Serializable{
	 
	@Column(name="ORDERID")
	int oRDERID;
	@Column(name="PRODID")
	int PRODID;
	public int getORDERID() {
		return oRDERID;
	}
	public void setORDERID(int oRDERID) {
		this.oRDERID = oRDERID;
	}
	public int getPRODID() {
		return PRODID;
	}
	public void setPRODID(int pRODID) {
		PRODID = pRODID;
	}
	
	

}
