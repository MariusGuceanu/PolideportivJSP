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

			Usuario u;
			while (rs.next()) {
			 	u = new Usuario();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setContrasena(rs.getString(3));
				u.setFecha_nac(rs.getDate(4));
				
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return usuarios;
	}
	
	public void crearUsuario(Usuario usuario) {
		try {
			PreparedStatement crearUsuario = Conexion.con.prepareStatement(
					"INSERT INTO usuarios (nombre, contrasena, fecha_nac) VALUES (?,?,?)");
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

		public void modificarUsuario(Usuario usuario) {

			String st = "UPDATE usuarios SET nombre = ?, contrasena=?, fecha_nac=? WHERE id = ?";
		
		try {
			PreparedStatement pst = Conexion.con.prepareStatement(st);
			
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			pst.setDate(3,new Date(usuario.getFecha_nac().getTime()));
			pst.setInt(4, usuario.getId());
			
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
