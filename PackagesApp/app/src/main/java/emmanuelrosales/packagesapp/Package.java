package emmanuelrosales.packagesapp;

/**
 * Created by Emmanuel on 02-Jun-15.
 */
public class Package {

    /**
     *
     */

    private int packageLength;
    private int packageWidth;
    private int packageHeight;
    private int volume;
    private int diasEntrega;
    private String nombre; // Descripción breve del paquete.
    private Owner Owner;


    public Package(int aPackageLength, int aPackageWidth, int aPackageHeight, int aDiasEntrega, Owner pOwner) {
        // TODO Auto-generated constructor stub

        setPackageLength(aPackageLength);
        setPackageWidth(aPackageWidth);
        setPackageHeight(aPackageHeight);
        setDiasEntrega(aDiasEntrega);
        setOwner(pOwner);
        setNombre("Paquete");
        volume = returnVolume();

    }

    public int returnVolume(){
        return getPackageLength() * getPackageWidth() * getPackageHeight();

    }

    public int getPackageLength() {
        return packageLength;
    }

    public int getPackageWidth() {
        return packageWidth;
    }

    public int getPackageHeight() {
        return packageHeight;
    }

    public int getVolume() {
        return volume;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public String getNombre() {
        return nombre;
    }

    public Owner getOwner() {
        return Owner;
    }

    public void setPackageLength(int packageLength) {
        this.packageLength = packageLength;
    }

    public void setPackageWidth(int packageWidth) {
        this.packageWidth = packageWidth;
    }

    public void setPackageHeight(int packageHeight) {
        this.packageHeight = packageHeight;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOwner(Owner owner) {
        Owner = owner;
    }



}