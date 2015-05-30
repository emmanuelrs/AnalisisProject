
package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


public class Main {

	/**
	 * 
	 */
	public static void main(String[] args) {
		Random random = new Random();
		Container truck = new Container();
		ArrayList<Owner> ownerList = new ArrayList<Owner>();
		ArrayList<Packages> listOfPackages = new ArrayList<Packages>();
		
		ownerList.add(new Owner("Persona", 7, 12, "Escazu"));
		ownerList.add(new Owner("Alguien", 9, 18, "San Jose Centro"));
		ownerList.add(new Owner("Otro", 15, 23, "Tres Rios"));
		ownerList.add(new Owner("Alguien mas", 17, 21, "Moravia"));
		
		for(int i = 0; i < 5; i++){
			Owner owner;
			double length = 1 + (truck.getContainerLength() - 1) * random.nextDouble(); 
			double width =  1 + (truck.getContainerWidth() - 1) * random.nextDouble();
			double height = 1 + (truck.getContainerHeight() - 1) * random.nextDouble();
			int number = random.nextInt(ownerList.size());
			int deliveryLimit = random.nextInt(1);
			
			owner = ownerList.get(number);
			listOfPackages.add(new Packages(length, width, height, deliveryLimit, owner));			
		}

		
		for(int i = 0; i < listOfPackages.size(); i++){
			System.out.println(listOfPackages.get(i).getVolume());
		}
		
		
		System.out.println("--------------------------------");
		
		for(int i = 0; i < listOfPackages.size(); i++){
			System.out.println(listOfPackages.get(i).getVolume());
		}
	}
	
}