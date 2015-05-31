package emmanuelrosales.packagesapp;

/**
 * Created by emmanuelrosales on 5/31/15.
 */
public class Truck {

    private int containerLength;
    private int containerWidth;
    private int containerHeight;
    private int volume;

    public Truck(int pLength, int pWidth, int pHeight){
        setContainerLength(pLength);
        setContainerWidth(pWidth);
        setContainerHeight(pHeight);
        setVolume(getContainerLength() * getContainerWidth() * getContainerHeight());

    }
    public Truck() {
        // TODO Auto-generated constructor stub

        // Si no se quiere poner un tamaÑo especifico se crea uno
        // con medidas default

        setContainerLength(12);
        setContainerWidth(6);
        setContainerHeight(6);
        setVolume(getContainerLength() * getContainerWidth() * getContainerHeight());
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getContainerLength() {
        return containerLength;
    }

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



}
