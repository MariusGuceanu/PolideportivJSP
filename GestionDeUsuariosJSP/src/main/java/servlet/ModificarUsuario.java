package servlet;

import java.io.IOException;
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
@WebServlet("/ModificarUsaurio")
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

		request.getRequestDispatcher("ModificarForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		UsuarioModelo um = new UsuarioModelo();
		Conexion.conectar();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");

		
		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		usuario.setNombre(nombre);
		
		um.modificarUsuario(usuario);
			
		Conexion.cerrar();


		}
	}


