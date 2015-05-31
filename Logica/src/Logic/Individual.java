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
	
	public void calculateFitness(ArrayList<Packages> list, int length, int width, int height){
		int counter = 0;
		int p_length = length;
		int p_width = width;
		int p_height = height;
		Subspace subspace_remaining = new Subspace();
		Subspace subspace_right = new Subspace();
		Subspace subspace_up = new Subspace();
		boolean firstPackage = false;
		for(int i = 0; i < chromosome.size(); i++){
			if(chromosome.get(i) == 1 && !firstPackage){
				subspace_remaining = new Subspace(p_length-list.get(i).getPackageLength(), p_width, p_height);
				subspace_right = new Subspace(p_length, p_width-list.get(i).getPackageWidth(),p_height);
				subspace_up = new Subspace(p_length, p_width,p_height-list.get(i).getPackageHeight());
				counter++;
				firstPackage = true;
			} else if (chromosome.get(i) == 1){
				if(subspace_remaining.getLength() - list.get(i).getPackageLength() >= 0  && 
						subspace_remaining.getWidth() - list.get(i).getPackageWidth() >= 0 && 
						subspace_remaining.getHeight() - list.get(i).getPackageHeight() >= 0 && !subspace_remaining.isFull()){
					subspace_remaining.setFull(true);
					counter++;
				} else if(subspace_right.getLength() - list.get(i).getPackageLength() >= 0  && 
						subspace_right.getWidth() - list.get(i).getPackageWidth() >= 0 && 
						subspace_right.getHeight() - list.get(i).getPackageHeight() >= 0 && !subspace_remaining.isFull()){
					subspace_right.setFull(true);
					counter++;
				} else if(subspace_up.getLength() - list.get(i).getPackageLength() >= 0  && 
						subspace_up.getWidth() - list.get(i).getPackageWidth() >= 0 && 
						subspace_up.getHeight() - list.get(i).getPackageHeight() >= 0 && !subspace_remaining.isFull()){
					subspace_up.setFull(true);
					counter++;
				} else {
					counter = 0;
				}
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
