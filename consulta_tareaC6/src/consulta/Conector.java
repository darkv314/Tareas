package consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Conector {
	// Atributos de la clase
	
	private static Connection con;
	private static Conector INSTANCE = null;
	
	// conector
	private Conector()
	{	 
	}
	
	
	private synchronized static void crearInstancia()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Conector();
			crearConexion();
		}
	}
	
	
	private static void crearConexion() 
	{
		String host = "127.0.0.1";
		String user = "ricardoT";
		String password = "trapizonda1";
		String dataBase = "cuarentena";
		try
		{
			//Importando la libreria de conexion mysql
			Class.forName("com.mysql.jdbc.Driver");
			String urlConection = "jdbc:mysql://"+host+"/"+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConection);
			System.out.println("Nice");
		}
		catch (Exception e)
		{
			System.out.println("Error al conectar a la base de datos");
			System.out.println(e);
		}
	}


	public static Conector getInstancia()
	{
		if (INSTANCE == null)
		{
			crearInstancia();
		}
		return INSTANCE;
	}
	
	public ArrayList<String> getPacientes() throws SQLException
	{
		ArrayList<String> listaNombres = new ArrayList<String>();
		PreparedStatement ps = con.prepareStatement("select nombres from persona where CI in(select personaID from paciente)");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			listaNombres.add(rs.getString("nombres"));
		}
		rs.close();
		return listaNombres;
	}
	public LinkedList<String> getDoctorConsulta() throws SQLException
	{
		LinkedList<String> listaDoctorConsulta = new LinkedList<>();
		PreparedStatement ps = con.prepareStatement("select consultorio.nro, persona.nombres from persona inner join doctor on doctor.personaID = persona.CI inner join consultorio on consultorio.ID = doctor.consultorioID");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			listaDoctorConsulta.add(rs.getString("nombres")+" "+rs.getString("nro"));
		}
		rs.close();
		return listaDoctorConsulta;
	}
}
