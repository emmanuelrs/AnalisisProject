package emmanuelrosales.packagesapp;

/**
 * Created by Miuyin on 5/31/15.
 * Class that has all the attributes and functions of Owner
 */
public class Owner {
    private String ownerName;
    private int startAvailablity;
    private int endAvailablity;
    private String address;
    private int dispacheTime = 1;
    private int travelTime ;

    // Constructor
    public Owner(String pName, int pStart, int pEnd, String pAddress, int pTravelTime) {
        // TODO Auto-generated constructor stub

        setOwnerName(pName);
        setStartAvailablity(pStart);
        setEndAvailablity(pEnd);
        setAddress(pAddress);
        setTravelTime(pTravelTime);

    }

    public Owner(){

    }

    // Setters and getters
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

}
