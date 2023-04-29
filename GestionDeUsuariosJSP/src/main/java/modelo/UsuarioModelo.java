package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioModelo {

	public ArrayList<Usuario> usuarios() {
		String sql = "SELECT * FROM usuarios";

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement st = Conexion.con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Usuario usuario;
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setContrasena(rs.getString(3));
				usuario.setFecha_nac(rs.getDate(4));

				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	public void crearUsuario(Usuario usuario) {
		try {
			PreparedStatement crearUsuario = Conexion.con
					.prepareStatement("INSERT INTO usuarios (nombre, contrasena, fecha_nac) VALUES (?,?,?)");
			crearUsuario.setString(1, usuario.getNombre());
			crearUsuario.setString(2, usuario.getContrasena());
			crearUsuario.setDate(3, new Date(usuario.getFecha_nac().getTime()));
			crearUsuario.execute();
		} catch (SQLException e) {
			System.out.println("Error: no se ha podido registrar el usuario");
		}
	}

	public void eliminarUsuario(int id) {

		String st = "delete from usuarios where id=?";

		try {
			PreparedStatement pst = Conexion.con.prepareStatement(st);
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void modificarUsuario(Usuario usuario) {

		Conexion.conectar();

		String st = "UPDATE usuarios SET nombre = ?, contrasena=?, fecha_nac=? WHERE id = ?";

		try {
			PreparedStatement pst = Conexion.con.prepareStatement(st);

			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			pst.setDate(3, new Date(usuario.getFecha_nac().getTime()));
			pst.setInt(4, usuario.getId());

			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Conexion.cerrar();

	}

	public static Usuario cargarUsuario(String id) {

		Conexion.conectar();

		Usuario usuario = new Usuario();

		try {
			String st = "SELECT * FROM usuarios WHERE id = ?";

			PreparedStatement pst = Conexion.con.prepareStatement(st);

			pst.setString(1, id);

			ResultSet result = pst.executeQuery();
			result.next();

			usuario.setId(result.getInt("id"));
			usuario.setNombre(result.getString("Nombre"));
			usuario.setContrasena(result.getString("Contrasena"));
			usuario.setFecha_nac(result.getDate("fecha_nac"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		Conexion.cerrar();
		return usuario;
	}
}
