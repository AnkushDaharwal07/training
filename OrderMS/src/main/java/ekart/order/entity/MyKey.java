package ekart.order.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class MyKey implements Serializable{
	 
	@Column(name="ORDERID")
	int ORDERID;
	@Column(name="PRODID")
	int PRODID;
	public int getORDERID() {
		return ORDERID;
	}
	public void setORDERID(int oRDERID) {
		ORDERID = oRDERID;
	}
	public int getPRODID() {
		return PRODID;
	}
	public void setPRODID(int pRODID) {
		PRODID = pRODID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ORDERID;
		result = prime * result + PRODID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKey other = (MyKey) obj;
		if (ORDERID != other.ORDERID)
			return false;
		if (PRODID != other.PRODID)
			return false;
		return true;
	}
	
	

}
