package Logic; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Subspace {  
	private int length;
	private int width;
	private int height;
	private boolean full;
	
	public Subspace() {
		
	}
	
	public Subspace(int length, int width, int height){
		setLength(length);
		setWidth(width);
		setHeight(height);
		setFull(false);
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

}
