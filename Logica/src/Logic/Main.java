
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
		Individual individual;
		ArrayList<Owner> ownerList = new ArrayList<Owner>();
		ArrayList<Packages> listOfPackages = new ArrayList<Packages>();
		
		ownerList.add(new Owner("Persona", 7, 12, "Escazu"));
		ownerList.add(new Owner("Alguien", 9, 18, "San Jose Centro"));
		ownerList.add(new Owner("Otro", 15, 23, "Tres Rios"));
		ownerList.add(new Owner("Alguien mas", 17, 21, "Moravia"));
		
		for(int i = 0; i < 5; i++){
			Owner owner;
			int length = random.nextInt(truck.getContainerLength() - 1) + 1; 
			int width = random.nextInt(truck.getContainerWidth() - 1) + 1;
			int height = random.nextInt(truck.getContainerHeight() - 1) + 1;
			int number = random.nextInt(ownerList.size());
			int deliveryLimit = random.nextInt(1);
			
			owner = ownerList.get(number);
			listOfPackages.add(new Packages(length, width, height, deliveryLimit, owner));			
		}
		
		Population population = new Population(listOfPackages);
		population.generatePopulation(15, listOfPackages.size(), true, truck);
		
		for(int i = 0; i < listOfPackages.size(); i++){
			System.out.println(listOfPackages.get(i).getVolume());
		}
		
		System.out.println("---------------------------------");
		System.out.println("volume: " + truck.getVolume());
		
		int i = 0;
		while(i < 20){
			population.generatePopulation(15, listOfPackages.size(), false, truck);
			i++;
		}
		System.out.println(population.returnBestCandidate().getChromosome());
		System.out.println(population.returnBestCandidate().getFitness());
	}
	
}