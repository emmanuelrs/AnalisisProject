package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Individual {
	private ArrayList<Integer> chromosome;
	private int fitness;
	
	/* Generates an individual based on the size of the solution
	 * set inserted through
	 */
	public Individual(){
		this.chromosome = new ArrayList<Integer>();
	}
	
	public void generateChromosome(int chromosomeSize){
		int number;
		Random random = new Random();
		number = random.nextInt(5);
		for	(int i = 0; i < chromosomeSize/2; i++){
			int bit = 0;
			if(random.nextInt(5) == number){
				bit = 1;
			}
			chromosome.add(bit);
		}
		for	(int i = chromosomeSize/2; i < chromosomeSize; i++){
			int bit = 1;
			if(random.nextInt(5) == number){
				bit = 0;
			}
			chromosome.add(bit);
			Collections.shuffle(chromosome);
		}
	}
	
	public void calculateFitness(ArrayList<Packages> list, double length, double width, double height){
		int counter = 0;
		double A_length = length;
		double A_width = width;
		double A_height = height;  
		double D_length = length;
		double D_width = width;
		double D_height = height;  
		double R_length = length;
		double R_width = width;
		double R_height = height; 
	
		for(int i = 0; i < chromosome.size(); i++){
			if(chromosome.get(i) == 1){ 
				if(A_length > 0 && A_length != length ){  
					//recorer todas las cajas y ver si caben en las dimensiones del subespacio de Arriba 
					// si cabe alguna counter++ 
					// siempre se cambian a 0 sin importar si se puede meter una caja o no
					A_length = 0;
					A_width = 0;
					A_height = 0;  
				}  
				
				else if(D_length > 0 && D_length != length ){  
					//recorer todas las cajas y ver si caben en las dimensiones del subespacio de la derecha 
					// si cabe alguna counter++ 
					// siempre se cambian a 0 sin importar si se puede meter una caja o no
					D_length = 0;
					D_width = 0;
					D_height = 0;  
				} 
				
				else {  
					//mete la caja mas grande y hace "update" a los subespacios
					A_length = list.get(i).getPackageLength();
					A_width = list.get(i).getPackageWidth();
					A_height -= list.get(i).getPackageHeight();  
					
					D_length = list.get(i).getPackageLength(); 
					D_width -= list.get(i).getPackageWidth(); 
					D_height = list.get(i).getPackageHeight(); 
					
					R_length -= list.get(i).getPackageLength(); 
					R_width  = list.get(i).getPackageWidth(); 
					R_height = list.get(i).getPackageHeight();  
					
				}
				

				
			}else {
					counter = 0;
				}
			}
			
		this.fitness = counter;
	
}

	private ArrayList<Integer> createRange(int start, int end){
		ArrayList<Integer> range = new ArrayList<Integer>();
		for (int i = 0; i < start; i++){
			range.add(i);
		}
		return range;
	}
	
	public void setChromosome(ArrayList<Integer> chromosome) {
		this.chromosome = chromosome;
	}

	public ArrayList<Integer> getChromosome() {
		return chromosome;
	}

	public int getFitness() {
		return fitness;
	}

}
