package Controller;

/********************    IMPORTS   *************************/

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JB;

@WebServlet(urlPatterns = { "/servletcontrol", "/main", "/insert" })
public class servletcontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JB usuario = new JB();

	public servletcontrol() {
		super();
		// TODO Auto-generated constructor stub
	}

	/******************** PRINCIPAL FUNÇAO DO SERVLET ****************/

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if (action.equals("/main")) {
			usuarios(request, response);

		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		/************************************/
		/* PARA TESTAR A CONEXÃO */
		// dao.testeConexao();

	}

	// LISTAR USUARIO

	protected void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// CRIAÇÃO DE UM BOJETO QUE IRARECEBER OS DADOS DO JAVABENS
		ArrayList<JB> lista = dao.listaUsuarios();
		
		
		// TESTE DE RECEBIMENTO DE DADOS
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getID());
			System.out.println(lista.get(i).getNOME());
			System.out.println(lista.get(i).getEMAIL());
			System.out.println(lista.get(i).getSENHA());
			System.out.println(lista.get(i).getTELEFONE());
			
		}
	}
	

	// NOVO CONTATO
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TESTE DE RECEBIMENTO DOS DADOS

		/*
		 * System.out.println(request.getParameter("NOME"));
		 * System.out.println(request.getParameter("EMAIL"));
		 * System.out.println(request.getParameter("SENHA"));
		 * System.out.println(request.getParameter("TELEFONE"));
		 */

		// SETAR AS VARIAVEIS DA JB(JAVABEANS)
		usuario.setNOME(request.getParameter("NOME"));
		usuario.setEMAIL(request.getParameter("EMAIL"));
		usuario.setSENHA(request.getParameter("SENHA"));
		usuario.setTELEFONE(request.getParameter("TELEFONE"));

		// TRAZER O METODO inserirUsuario PASSANDO O OBJETO USUARIO
		dao.inserirUsuario(usuario);
		// REDIRECIONAR PARA O DOCUMENTO Usuarios.jsp
		response.sendRedirect("main");1

	}
	
	
	
	/***************************************************************************************/
	/*************** ESTRUTURA PARA REMOVER DADOS DO MYSQL *********************************/
 


	  public void remover (int ID) { 
		  
		 try {
	  
	  Connection con = conectar(); String sql = "DELETE  FROM usuarios WHERE = ?";
	  PreparedStatement statement = con.prepareStatement(sql);
	  
	  statement.setInt(1, ID); statement.execute(); connection.close();
	 
	 
		} catch (Exception e) { System.out.println(e); }
	 
	  }
	  
	 

	/***************************************************************************/
	/**************** METODO PARA ATUALIZAR DADOS DO MYSQL**********************/

	

	 public void atualizar(JB usuarios) {

		String sql = "UPDATE usuarios SET NOME='PEDRO' WHERE EMAIL=Pedrogks17@gmail.com";
		try {
			Connection con = DriverManager.getConnection(url, "root", "root123");
			PreparedStatement atualizar = con.prepareStatement(sql);
			atualizar.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	


	
	/***************************************************************************************/
	/*************** ESTRUTURA PARA REMOVER DADOS DO MYSQL *********************************/
 

	/*
	 * public void remover (int ID) { try {
	 * 
	 * Connection con = conectar(); String sql = "DELETE  FROM usuarios WHERE = ?";
	 * PreparedStatement statement = con.prepareStatement(sql);
	 * 
	 * statement.setInt(1, ID); statement.execute(); connection.close();
	 * 
	 * 
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 */

	/***************************************************************************/
	/**************** METODO PARA ATUALIZAR DADOS DO MYSQL**********************/

	

	/* public void atualizar(JB usuarios) {

		String sql = "UPDATE usuarios SET NOME='PEDRO' WHERE EMAIL=Pedrogks17@gmail.com";
		try {
			Connection con = DriverManager.getConnection(url, "root", "root123");
			PreparedStatement atualizar = con.prepareStatement(sql);
			atualizar.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	*/



}
