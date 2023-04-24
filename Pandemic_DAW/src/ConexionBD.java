

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Scanner;

public class ConexionBD {

	String USER = "DAW_PNDC22_23_DAMO";
	String PWD = "DM123";
	// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
	String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = conectarBaseDatos();
		
		//System.out.println(con);


		if (con != null) {
			System.out.println("DentroIF");
			insertarPersona(con);
			select(con);
			con.close();
		}
		

	}

	private static Connection conectarBaseDatos() {
		Connection con = null;
		String USER = "DAW_PNDC22_23_DAMO";
		String PWD = "DM123";
		// Si estáis desde casa, la url será oracle.ilerna.com y no 192.168.3.26
		String URL = "jdbc:oracle:thin:@192.168.3.26:1521:xe";

		System.out.println("Intentando conectarse a la base de datos");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
			System.out.println("Conectados a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		//System.out.println("Conectados a la base de datos");

		return con;
	}

	private static void select(Connection con) {
		String sql = "SELECT p.* FROM PERSONA p";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); 	 	

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String dni = rs.getString("DNI");
					String nombre = rs.getString("NOMBRE");
					String calle = rs.getString("CALLE");
					String ciudad = rs.getString("CIUDAD");
					String pais = rs.getString("PAIS");

/*
					Struct domicilio = (Struct) rs.getObject("DOMICILIO");
					Object[] valoresDireccion = domicilio.getAttributes();
					String calle = (String) valoresDireccion[0];
					String ciudad = (String) valoresDireccion[1];
					String pais = (String) valoresDireccion[2];

/*
					Direccion direccion = new Direccion(calle,ciudad,pais);
					Persona persona = new Persona(dni, nombre, direccion);*/
					
					NuevaPersona persona = new NuevaPersona(dni, nombre, calle, ciudad, pais);

					System.out.println(persona.toString());

				}
			} else {
				System.out.println("No he encontrado nada");
			}
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void insertarPersona(Connection con) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Introduce tu DNI");
		String dni = scanner.nextLine();
		
		System.out.println("Introduce tu nombre");
		String nombre = scanner.nextLine();
		
		
		System.out.println("Introduce tu calle");
		String calle = scanner.nextLine();
		
		System.out.println("Introduce tu ciudad");
		String ciudad = scanner.nextLine();
		
		System.out.println("Introduce tu pais");
		String pais = scanner.nextLine();
		
		String sql = "INSERT INTO PERSONA VALUES('" + dni + "', '" + nombre +"', '" + calle + "', '" + ciudad + "', '" + pais + "')";
		//System.out.println(sql);

		try {
			Statement st = con.createStatement();
			st.execute(sql);
			
			System.out.println("Persona registrada correctamente");
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
		
		scanner.close();
		

	}

}
