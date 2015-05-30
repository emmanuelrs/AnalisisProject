/**
 * 
 */
package Logic;

/**
 * @author emmanuelrosales
 *
 */
public class Container {

	/**
	 * 
	 */
	
	private double containerLength;
	private double containerWidth;
	private double containerHeight;
	
	public Container(double pLength, double pWidth, double pHeight) {
		// TODO Auto-generated constructor stub
		setContainerLength(pLength);
		setContainerWidth(pWidth);
		setContainerHeight(pHeight);	
	}
	
	public Container() {
		// TODO Auto-generated constructor stub
		
		// Si no se quiere poner un tamaÑo especifico se crea uno
		// con medidas default
		
		setContainerLength(12);
		setContainerWidth(3);
		setContainerHeight(4);	
	}
	
	public double getContainerLength() {
		return containerLength;
	}

	public void setContainerLength(double containerLength) {
		this.containerLength = containerLength;
	}

	public double getContainerWidth() {
		return containerWidth;
	}

	public void setContainerWidth(double containerWidth) {
		this.containerWidth = containerWidth;
	}

	public double getContainerHeight() {
		return containerHeight;
	}

	public void setContainerHeight(double containerHeight) {
		this.containerHeight = containerHeight;
	}

	

}
