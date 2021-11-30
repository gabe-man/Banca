package mainapp;

import models.Persona;

import models.CuentaCorriente;

import java.util.Scanner;

import java.util.ArrayList;

public class MainApp {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Persona> personas=new ArrayList<Persona>();
		ArrayList<CuentaCorriente> cuentas=new ArrayList<CuentaCorriente>();
		int i=1;
		
		int opc;
		int opc2;
		Persona elecc;
		do {
			opc=menuPrinc();
			elecc=logicaPrinc(opc, personas, cuentas, i);
			if(opc==1)
			{
				i++;
			}
			if (opc==2)
			{
				do {
					opc2=menuElegir();
					logicaSecund(opc2, elecc);
				} while (opc2 != 5);
			}
		} while (opc!=4);
		
	}
	
	public static int menuPrinc()
	{
		System.out.println("1. Añadir persona\n2. Elegir persona\n3. Borrar persona\n4. Salir");
		int opc=Integer.parseInt(sc.nextLine());
		while(opc<1 || opc>4)
		{
			System.out.println("Error.opcion no valida. Intentelo de nuevo");
			System.out.println("1. Añadir persona\n2. Elegir persona\n3. Borrar persona\n4. Salir");
			opc=Integer.parseInt(sc.nextLine());
		}
		return opc;
	}
	
	public static int menuElegir()
	{
		System.out.println("1. Cobrar sueldo\n2. Sacar pasta\n3. Subir sueldo\n4. Mostrar detalles de la persona\n5. Volver atrás");
		int opc=Integer.parseInt(sc.nextLine());
		while(opc<1 || opc>5)
		{
			System.out.println("Error.opcion no valida. Intentelo de nuevo");
			System.out.println("1. Cobrar sueldo\n2. Sacar pasta\n3. Subir sueldo\n4. Mostrar detalles de la persona\n5. Volver atrás");
			opc=Integer.parseInt(sc.nextLine());
		}
		return opc;
	}
	
	public static Persona logicaPrinc(int opc,  ArrayList<Persona> personas, ArrayList<CuentaCorriente> cuentas, int  i)
	{
		int elecc=1;
		switch (opc) {
		case 1:
			System.out.println("Introduzca su nombre");
			String nombre=sc.nextLine();
			System.out.println("Introduzca sus apellidos");
			String apellido=sc.nextLine();
			System.out.println("Introduzca su DNI");
			String dni=sc.nextLine();
			System.out.println("Introduzca su sueldo");
			double sueldo=Double.parseDouble(sc.nextLine());
			personas.add(new Persona(nombre, apellido, dni, sueldo, null));
			cuentas.add(new CuentaCorriente(String.valueOf(i), personas.get(i-1)));
			personas.get(i-1).setCuenta(cuentas.get(i-1));
			break;
		
		case 2:
			for (int j = 0; j < personas.size(); j++) {
				System.out.println((j+1) + "- " + personas.get(j).getDni() + " " + personas.get(j).getNombre());
			}
			System.out.println("¿Cual desea elegir?");
			elecc=Integer.parseInt(sc.nextLine());
			while (elecc < 1 || elecc>personas.size())
			{
				System.out.println("No existe ese cliente. Pruebe otra vez.");
				for (int j = 0; j < personas.size(); j++) {
					System.out.println((j+1) + "- " + personas.get(j).getDni() + " " + personas.get(j).getNombre());
				}
				System.out.println("¿Cual desea elegir?");
				elecc=Integer.parseInt(sc.nextLine());
			}
			System.out.println("Has elegido a " + personas.get(elecc-1).getNombre());
			break;
			
		case 3:
			for (int j = 0; j < personas.size(); j++) {
				System.out.println((j+1) + "- " + personas.get(j).getDni() + " " + personas.get(j).getNombre());
			}
			System.out.println("¿Cual desea borrar?");
			int elecc2=Integer.parseInt(sc.nextLine());
			while (elecc2 < 1 || elecc2>personas.size())
			{
				System.out.println("No existe ese cliente. Pruebe otra vez.");
				for (int j = 0; j < personas.size(); j++) {
					System.out.println((j+1) + "- " + personas.get(j).getDni() + " " + personas.get(j).getNombre());
				}
				System.out.println("¿Cual desea borrar?");
				elecc2=Integer.parseInt(sc.nextLine());
			}
			personas.remove(elecc2-1);
			System.out.println("Esta persona ha sido borrada con exito.");
			break;
		
		case 4:
			System.out.println("Gracias por usar nuestros servicios");
			break;
			
		default:
			break;
		}
		return personas.get(elecc-1);
	}
	
	public static void logicaSecund(int opc, Persona persona)
	{
		double pasta;
		double nuevoSueldo;
		switch (opc) {
		case 1:
			persona.cobrarSueldo();
			break;
		case 2:
			System.out.println("¿Cuanto dinero quiere retirar?");
			pasta=Double.parseDouble(sc.nextLine());
			persona.sacarPasta(pasta);
			break;
		case 3:
			System.out.println("¿Cual es su nuevo sueldo?");
			nuevoSueldo=Double.parseDouble(sc.nextLine());
			persona.cambiarSueldo(nuevoSueldo);
			break;
		case 4:
			System.out.println(persona);
			break;
		case 5:
			break;
		default:
			break;
		}
	}

}
