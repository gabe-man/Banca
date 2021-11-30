package models;

public class CuentaCorriente {
	//atributos
	private String numeroCuenta;
	private double saldo;
	Persona titular;
	
	//constructor
	
	/**
	 * @param numeroCuenta
	 * @param titular
	 */
	public CuentaCorriente(String numeroCuenta, Persona titular) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo=0;
		this.titular = titular;
	}
	
	//getters y setters
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public Persona getTitular() {
		return titular;
	}
	
	//metodos
	/**
	 * Suma cualquier cantidad al saldo de la cuenta corriente
	 * @param cantidad cantidad a añadir
	 */
	public void sumarCantidad(double cantidad)
	{
		this.saldo+=cantidad;
	}
	
	/**
	 * Resta cualquiercantidad al saldo de la cuenta corriente 
	 * siempre y cuando sea posible.
	 * @param cantidad cantidad a restar
	 * @throws Exception Caso en el que no se puede retirar tanto dinero
	 */
	public void restarCantidad(double cantidad) throws Exception
	{
		if(this.saldo-cantidad>=0)
		{
			this.saldo-=cantidad;
		}
		else
		{
			throw new Exception("No hay suficiente saldo en la cuenta");
		}
	}
	
	//toString
	
	@Override
	public String toString() {
		return "CuentaCorriente [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}
	
	
	
	
	
}
