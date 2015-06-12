package emmanuelrosales.packagesapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    private ArrayList<DeliveryPackage> packagesToDeliver = new ArrayList<DeliveryPackage>();
    private ArrayList<DeliveryPackage> otherPackages = new ArrayList<DeliveryPackage>();
    private ArrayList<DeliveryPackage> possibleDeliveries = new ArrayList<DeliveryPackage>();



    public Truck(int pLength, int pWidth, int pHeight){

        counter++;
        setContainerLength(pLength);
        setContainerWidth(pWidth);
        setContainerHeight(pHeight);
        setVolume(getContainerLength() * getContainerWidth() * getContainerHeight());
        setIdTruck(counter);

    }

    public void organizeOwner(ArrayList<DeliveryPackage> list){
        Collections.sort(list, new Comparator<DeliveryPackage>() {
            public int compare(DeliveryPackage p1, DeliveryPackage p2) {
                return Double.compare(p1.getOwner().getStartAvailablity(), p2.getOwner().getStartAvailablity());
            }
        });
    }

    public ArrayList<DeliveryPackage> greedy(int amount){
        organizeOwner(packagesToDeliver);
        int indice = 0;
        Owner firstOwner = new Owner();
        Owner secondOwner = new Owner();
        possibleDeliveries.add(packagesToDeliver.get(0));

        for(int i = 1; i < packagesToDeliver.size(); i++){
            firstOwner = packagesToDeliver.get(indice).getOwner();
            secondOwner = packagesToDeliver.get(i).getOwner();
            if(firstOwner.getStartAvailablity() + firstOwner.getTravelTime() + firstOwner.getDispacheTime() <= secondOwner.getStartAvailablity() || firstOwner.equals(secondOwner)){
                possibleDeliveries.add(packagesToDeliver.get(i));
                packagesToDeliver.get(i).setTruckNumber(getIdTruck());
                indice = i;
            } else {
                otherPackages.add(packagesToDeliver.get(i));
            }
        }
        if(possibleDeliveries.size() == amount){
            System.out.println("Todos los paquetes se pueden entregar.");
            System.out.println("--------------------------------");
            System.out.println("Paquetes a entregar: " + possibleDeliveries.size());
            return possibleDeliveries;
        } else if (possibleDeliveries.size() != amount && possibleDeliveries.size() != 0) {
            System.out.println("Se pueden entregar algunos paquetes.");
            System.out.println("--------------------------------");
            System.out.println("Paquetes a entregar: " + possibleDeliveries.size());
            System.out.println("--------------------------------");
            System.out.println("Paquetes que no se pueden entregar: " + otherPackages.size());
            return possibleDeliveries;
        } else {
            System.out.println("No se puede entregar ningun paquete.");
            return null;
        }

    }

    public void addPackages(ArrayList<DeliveryPackage> listOfPackages){
        listOfPackages.addAll(otherPackages);
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

    public void setIdTruck(int idTruck) {this.idTruck = idTruck;
    }

    public int getIdTruck() { return idTruck;
    }
    public ArrayList<DeliveryPackage> getPackagesToDeliver() {
        return packagesToDeliver;
    }

    public ArrayList<DeliveryPackage> getOtherPackages() {
        return otherPackages;
    }

    public ArrayList<DeliveryPackage> getPossibleDeliveries() {
        return possibleDeliveries;
    }
    public void setPackagesToDeliver(ArrayList<DeliveryPackage> packagesToDeliver) {
        this.packagesToDeliver = packagesToDeliver;
    }

    public void setOtherPackages(ArrayList<DeliveryPackage> otherPackages) {
        this.otherPackages = otherPackages;
    }

    public void setPossibleDeliveries(ArrayList<DeliveryPackage> possibleDeliveries) {
        this.possibleDeliveries = possibleDeliveries;
    }
}
