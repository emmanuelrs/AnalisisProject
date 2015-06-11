/**
 * 
 */
package Logic;

/**
 * @author emmanuelrosales
 *
 */
public class Owner {

	private String ownerName;
	private int startAvailablity;
	private int endAvailablity;
	private String address;  
	private int dispacheTime = 1; 
	private int travelTime = 1; 

	public Owner(String pName, int pStart, int pEnd, String pAddress) {
		// TODO Auto-generated constructor stub
		
		setOwnerName(pName);
		setStartAvailablity(pStart);
		setEndAvailablity(pEnd);
		setAddress(pAddress);
		
	}
	
	
	public Owner(){
		
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getStartAvailablity() {
		return startAvailablity;
	}

	public void setStartAvailablity(int startAvailablity) {
		this.startAvailablity = startAvailablity;
	}

	public int getEndAvailablity() {
		return endAvailablity;
	}

	public void setEndAvailablity(int endAvailablity) {
		this.endAvailablity = endAvailablity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} 
	
	public int getDispacheTime() {
		return dispacheTime;
	}

	public void setDispacheTime(int dispacheTime) {
		this.dispacheTime = dispacheTime;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(int travelTime) {
		this.travelTime = travelTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + dispacheTime;
		result = prime * result + endAvailablity;
		result = prime * result
				+ ((ownerName == null) ? 0 : ownerName.hashCode());
		result = prime * result + startAvailablity;
		result = prime * result + travelTime;
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
		Owner other = (Owner) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dispacheTime != other.dispacheTime)
			return false;
		if (endAvailablity != other.endAvailablity)
			return false;
		if (ownerName == null) {
			if (other.ownerName != null)
				return false;
		} else if (!ownerName.equals(other.ownerName))
			return false;
		if (startAvailablity != other.startAvailablity)
			return false;
		if (travelTime != other.travelTime)
			return false;
		return true;
	}

}
