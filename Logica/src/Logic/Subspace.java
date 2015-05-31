package Logic; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Subspace {  
	private double length;
	private double width;
	private double height;
	private String name;
	
	public Subspace(double length, double width, double height, String name){
		setLength(length/4);
		setWidth(width/4);
		setHeight(height/4);
		setName(name);
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setName(String name) {
		this.name = name;
	}

}
