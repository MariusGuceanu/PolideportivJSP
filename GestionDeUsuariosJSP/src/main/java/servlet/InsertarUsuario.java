package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conexion;
import modelo.Usuario;
import modelo.UsuarioModelo;

/**
 * Servlet implementation class InsertarUsuario
 */
@WebServlet("/InsertarUsuario")
public class InsertarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		request.getRequestDispatcher("InsertarForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		UsuarioModelo um = new UsuarioModelo();
		Conexion.conectar();
		
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		Date fecha_nac = null;
		try {
			fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_nac"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		usuario.setFecha_nac(fecha_nac);

		um.crearUsuario(usuario);
		
		Conexion.cerrar();
	}

}
