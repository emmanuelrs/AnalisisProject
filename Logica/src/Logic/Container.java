/**
 * 
 */
package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author emmanuelrosales
 *
 */
public class Container {

	/**
	 * 
	 */
	
	private int containerLength;
	private int containerWidth;
	private int containerHeight;
	private int volume; 
	private ArrayList<Packages> packagesToDeliver = new ArrayList<Packages>();   
	private ArrayList<Packages> otherPackages = new ArrayList<Packages>();  
	private ArrayList<Packages> paquetesEntregados = new ArrayList<Packages>();
	

	public Container(int pLength, int pWidth, int pHeight) {
		// TODO Auto-generated constructor stub
		setContainerLength(pLength);
		setContainerWidth(pWidth);
		setContainerHeight(pHeight);	
	}
	
	public Container() {
		// TODO Auto-generated constructor stub
		
		// Si no se quiere poner un tamaÑo especifico se crea uno
		// con medidas default
		
		setContainerLength(36);
		setContainerWidth(24);
		setContainerHeight(24);	
		setVolume(getContainerLength() * getContainerWidth() * getContainerHeight());
	}

	
	
	public void organizeOwner(ArrayList<Packages> list){
		Collections.sort(list, new Comparator<Packages>() {
         	public int compare(Packages p1, Packages p2) {
            return Double.compare(p1.getOwner().getStartAvailablity(), p2.getOwner().getStartAvailablity());
        }
		}); 
    }
	
	public ArrayList<Packages> greedy(int amount){   
		organizeOwner(packagesToDeliver);   
		int indice = 0; 
		Owner firstOwner = new Owner();
		Owner secondOwner = new Owner();
		paquetesEntregados.add(packagesToDeliver.get(0));
		
		for(int i = 1; i < packagesToDeliver.size(); i++){ 
			firstOwner = packagesToDeliver.get(indice).getOwner();
			secondOwner = packagesToDeliver.get(i).getOwner();
			if(firstOwner.getStartAvailablity() + firstOwner.getTravelTime() + firstOwner.getDispacheTime() <= secondOwner.getStartAvailablity() || firstOwner.equals(secondOwner)){  
				paquetesEntregados.add(packagesToDeliver.get(i)); 
				indice = i;
			} else {
				otherPackages.add(packagesToDeliver.get(i));
			}
		}  
		if(paquetesEntregados.size() == amount){ 
			System.out.println("Todos los paquetes se pueden entregar."); 
			System.out.println("--------------------------------");
			System.out.println("Paquetes a entregar: " + paquetesEntregados.size());
			return paquetesEntregados; 
		} else if (paquetesEntregados.size() != amount && paquetesEntregados.size() != 0) {
			System.out.println("Se pueden entregar algunos paquetes.");
			System.out.println("--------------------------------");
			System.out.println("Paquetes a entregar: " + paquetesEntregados.size());
			System.out.println("--------------------------------");
			System.out.println("Paquetes que no se pueden entregar: " + otherPackages.size());
			return paquetesEntregados;
		} else {
			System.out.println("No se puede entregar ningun paquete.");
			return null;		
		}
	
	}
	
	public void addPackages(ArrayList<Packages> listOfPackages){
		listOfPackages.addAll(otherPackages);
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

	public ArrayList<Packages> getPackagesToDeliver() {
		return packagesToDeliver;
	}

	public ArrayList<Packages> getPaquetesEntregados() {
		return paquetesEntregados;
	}

	public void setPaquetesEntregados(ArrayList<Packages> paquetesEntregados) {
		this.paquetesEntregados = paquetesEntregados;
	}

	public void setPackagesToDeliver(ArrayList<Packages> packagesToDeliver) {
		this.packagesToDeliver = packagesToDeliver;
	}

	public ArrayList<Packages> getOwnersToDeliver() {
		return otherPackages;
	}

	public void setOwnersToDeliver(ArrayList<Packages> ownersToDeliver) {
		this.otherPackages = ownersToDeliver;
	}

}