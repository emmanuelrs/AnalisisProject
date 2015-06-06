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
	private ArrayList<Owner> ownersToDeliver = new ArrayList<Owner>();  
	private static ArrayList<String> paquetesEntregados = new ArrayList<String>();
	

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

	public static ArrayList<String> getPaquetesEntregados() {
		return paquetesEntregados;
	}

	public static void setPaquetesEntregados(ArrayList<String> paquetesEntregados) {
		Container.paquetesEntregados = paquetesEntregados;
	}

	public void setPackagesToDeliver(ArrayList<Packages> packagesToDeliver) {
		this.packagesToDeliver = packagesToDeliver;
	}

	public ArrayList<Owner> getOwnersToDeliver() {
		return ownersToDeliver;
	}

	public void setOwnersToDeliver(ArrayList<Owner> ownersToDeliver) {
		this.ownersToDeliver = ownersToDeliver;
	}
	
	public void determineOwners(){ 
		for(int i = 0; i < getPackagesToDeliver().size(); i++ ){ 
			ownersToDeliver.add(getPackagesToDeliver().get(i).getOwner());
		}
	}  
	

	public void organizeOwner(ArrayList<Owner> list){
		Collections.sort(list, new Comparator<Owner>() {
         	public int compare(Owner p1, Owner p2) {
            return Double.compare(p1.getStartAvailablity(),p2.getStartAvailablity());
        }
		}); 
    }
	
	public ArrayList<String> greedy(){   
		organizeOwner(ownersToDeliver);   
		int indice = 0; 
		paquetesEntregados.add(ownersToDeliver.get(0).getAddress());
		for(int i = 1; i< ownersToDeliver.size(); i++){ 
			if(ownersToDeliver.get(indice).getStartAvailablity() + ownersToDeliver.get(indice).getTravelTime() + ownersToDeliver.get(indice).getDispacheTime() <= ownersToDeliver.get(i).getStartAvailablity()){  
				paquetesEntregados.add(ownersToDeliver.get(i).getAddress()); 
				indice = i;
			} 
		}  
		if(paquetesEntregados.size() != ownersToDeliver.size()){ 
			System.out.println("La solución es parcial"); 
			return paquetesEntregados; 
		} 
		return paquetesEntregados;		
	}


	

}