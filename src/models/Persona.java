package models;

public class Persona {
	//atributos
	
	private String nombre;
	private String apellidos;
	private String dni;
	private double sueldo;
	private CuentaCorriente cuenta;
	
	//constructor
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sueldo
	 */
	public Persona(String nombre, String apellidos, String dni, double sueldo, CuentaCorriente cuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.sueldo = sueldo;
		this.cuenta=cuenta;
	}
	
	//setters y getters
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public double getSueldo() {
		return sueldo;
	}
	
	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	//metodos
	
	public void cobrarSueldo()
	{
		this.cuenta.sumarCantidad(sueldo);
	}
	
	public void sacarPasta(double cantidad)
	{
		try {
			this.cuenta.restarCantidad(cantidad);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cambiarSueldo(double nuevoSueldo)
	{
		this.setSueldo(nuevoSueldo);
	}
	
	//toString
	
	@Override
	public String toString() {
		double saldoCuenta;
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sueldo=" + sueldo + ", saldoCuenta=" + (saldoCuenta=this.cuenta.getSaldo()) +"]";
	}
}
