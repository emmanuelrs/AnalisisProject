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
		double p_length = length;
		double p_width = width;
		double p_height = height; 
		
		for(int i = 0; i < list.size(); i++){
			
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
