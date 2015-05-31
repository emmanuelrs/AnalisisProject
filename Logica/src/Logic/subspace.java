package Logic; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class subspace {  
	public ArrayList<Packages> createList(){ 
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

	
	
		return listOfPackages; 
	}

	public ArrayList<Packages> sortArray(ArrayList<Packages> list){
		  Collections.sort(list, new Comparator<Packages>() {
		          public int compare(Packages p1, Packages p2) {
		            return Double.compare(p2.getVolume(),p1.getVolume());
		        }

		    });  
		  
		  
			
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i).getVolume());
			}
			System.out.println("--------------------------------");
		  return list;
		 } 

}
