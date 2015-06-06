package emmanuelrosales.packagesapp;

/**
 * Created by emmanuelrosales on 5/31/15.
 */
public class Truck {

    private int containerLength;
    private int containerWidth;
    private int containerHeight;
    private int volume;
    private int idTruck;
    private static int counter = 0;



    public Truck(int pLength, int pWidth, int pHeight){

        counter++;
        setContainerLength(pLength);
        setContainerWidth(pWidth);
        setContainerHeight(pHeight);
        setVolume(getContainerLength() * getContainerWidth() * getContainerHeight());
        setIdTruck(counter);

    }

    public int getVolume(){return volume;}

    public void setVolume(int volume){this.volume = volume;}

    public int getContainerLength(){return containerLength;}

    public int getContainerWidth() {
        return containerWidth;
    }

    public int getContainerHeight() {
        return containerHeight;
    }

    public void setContainerLength(int containerLength) {
        this.containerLength = containerLength;
    }

    public void setContainerWidth(int containerWidth) {
        this.containerWidth = containerWidth;
    }

    public void setContainerHeight(int containerHeight) {
        this.containerHeight = containerHeight;
    }

    public void setIdTruck(int idTruck) {this.idTruck = idTruck;}

    public int getIdTruck() { return idTruck; }
}
