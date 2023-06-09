package modelo;

import java.util.Date;

public class Usuario {

	private int id;
	private String nombre;
	private String contrasena;
	private Date fecha_nac;

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Usuario(int id, String nombre, String contrasena, Date fecha_nac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.fecha_nac = fecha_nac;
	}

	public Usuario() {
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}

}
