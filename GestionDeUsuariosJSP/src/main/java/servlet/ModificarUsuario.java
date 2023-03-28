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
 * Servlet implementation class ModificarUsaurio
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UsuarioModelo um = new UsuarioModelo();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		String a = request.getParameter("fecha_nac");
		Date fecha_nac = null;
		try {
			fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(a);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		Conexion.conectar();


		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		usuario.setFecha_nac(fecha_nac);
		
		um.modificarUsuario(usuario);
		
		request.setAttribute("usuarios", usuario);
		
		Conexion.cerrar();

		request.getRequestDispatcher("ModificarForm.jsp").forward(request, response);


		}
	}


