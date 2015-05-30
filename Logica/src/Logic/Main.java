/**
 * 
 */
package Logic;

import java.util.ArrayList;

/**
 * @author emmanuelrosales
 *
 */
public class Main { 
	static ArrayList<Packages> paquetesOrdenados = new ArrayList<Packages>(); 


	public static void ordenarP(ArrayList<Packages> sinOrdenar) {
		// TODO Auto-generated constructor stub 
		double mayor = sinOrdenar.get(0).returnVolumne();   
		int indexMayor = 0; 
		while(sinOrdenar.size() > 0){ 
			for(int i = 0; i < sinOrdenar.size(); i++ ){ 
				if(sinOrdenar.get(i).returnVolumne() > mayor){ 
					mayor = sinOrdenar.get(i).returnVolumne();  
					indexMayor = i; 
				}    
				paquetesOrdenados.add(sinOrdenar.get(indexMayor)); 
				System.out.println(sinOrdenar.get(indexMayor).returnVolumne());
				sinOrdenar.remove(indexMayor);
			} 
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Container contenedor1 = new Container();  
		Owner owner1 = new Owner("Emmanuel", 4, 15, "Atenas");
		Packages paquete1 = new Packages(1, 2, 1, 0, owner1); 
		Packages paquete2 = new Packages(3, 2, 2, 1, owner1); 
		Packages paquete3 = new Packages(2, 1, 1, 0, owner1); 
		Packages paquete4 = new Packages(2, 2, 2, 1, owner1); 
		Packages paquete5 = new Packages(1, 1, 1, 0, owner1); 
		ArrayList<Packages> paquetes = new ArrayList(); 
		paquetes.add(paquete1);  
		paquetes.add(paquete2);  
		paquetes.add(paquete3);  
		paquetes.add(paquete4);  
		paquetes.add(paquete5);   
		ordenarP(paquetes); 
		for(int i = 0; i < paquetesOrdenados.size(); i++){ 
			System.out.println(paquetesOrdenados.get(i).returnVolumne());
		}
		

	}

}
