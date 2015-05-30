/**
 * 
 */
package Logic;

/**
 * @author emmanuelrosales
 *
 */
public class Packages {

	/**
	 * 
	 */
	
	private double packageLength;
	private double packageWidth;
	private double packageHeight;
	private int diasEntrega;
	private String nombre; // Descripción breve del paquete.
	private Owner Owner;
	
	
	public Packages(double aPackageLength, double aPackageWidth, double aPackageHeight, int aDiasEntrega, Owner pOwner) {
		// TODO Auto-generated constructor stub
		
		setPackageLength(aPackageLength);
		setPackageWidth(aPackageWidth);
		setPackageHeight(aPackageHeight);
		setDiasEntrega(aDiasEntrega);
		setOwner(pOwner);
		
	}

	public int getDiasEntrega() {
		return diasEntrega;
	}

	public void setDiasEntrega(int diasEntrega) {
		
		// Si el valor de diasEntrega es igual a 0, el paquete no tiene 
		// restricción de entrega
		
		this.diasEntrega = diasEntrega;
	}

	public double getPackageLength() {
		return packageLength;
	}

	public void setPackageLength(double packageLength) {
		this.packageLength = packageLength;
	}

	public double getPackageWidth() {
		return packageWidth;
	}

	public void setPackageWidth(double packageWidth) {
		this.packageWidth = packageWidth;
	}

	public double getPackageHeight() {
		return packageHeight;
	}

	public void setPackageHeight(double packageHeight) {
		this.packageHeight = packageHeight;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Owner getOwner() {
		return Owner;
	}

	public void setOwner(Owner owner) {
		Owner = owner;
	}


}
