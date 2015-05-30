/**
 * 
 */
package Logic;

/**
 * @author emmanuelrosales
 *
 */
public class Owner {

	/**
	 * 
	 */
	
	private String ownerName;
	private int startAvailablity;
	private int endAvailablity;
	private String address;
	
	public Owner(String pName, int pStart, int pEnd, String pAddress) {
		// TODO Auto-generated constructor stub
		
		setOwnerName(pName);
		setStartAvailablity(pStart);
		setEndAvailablity(pEnd);
		setAddress(pAddress);
		
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

	

}
