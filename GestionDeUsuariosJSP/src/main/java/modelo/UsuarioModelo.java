package modelo;

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
				u = new Usuario(0, sql);
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
 
		return usuarios;
	}

}
