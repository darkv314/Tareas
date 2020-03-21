package consulta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {

	public static void main(String[] args) 
	{
		System.out.println("Conectando");
		Conector instancia = Conector.getInstancia();
		
		// Ejercicio 3
		
		try
		{
			System.out.println("Nombre de los pacientes");
			ArrayList<String> listNombres = instancia.getPacientes();
			for(String nombre:listNombres)
			{
				System.out.println(nombre);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		// Ejercicio 4
		
		try
		{
			System.out.println("Doctor Consultorio");
			LinkedList<String> listNombres = instancia.getDoctorConsulta();
			for(String consulta: listNombres)
			{
				System.out.println(consulta);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
