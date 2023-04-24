

import ConexionBD.Override;
import ConexionBD.String;

public class NuevaPersona {

	private String dni;
	private String nombre;
	private String calle;
	private String ciudad;
	private String pais;
	
	
	public NuevaPersona(String dni, String nombre, String calle, String ciudad, String pais) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getCalle() {
		return calle;
	}

	
	public String getCiudad() {
		return ciudad;
	}
	
	
	public String getPais() {
		return pais;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", calle=" + calle + ", ciudad=" + ciudad + ", pais=" + pais+ " ]";
	}


}
