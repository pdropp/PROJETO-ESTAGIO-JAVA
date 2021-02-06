package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// MODULO DE CONEXÃO
	// PARÂMETROS DE CONEXÃO

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/cadastro?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "root123";

	// METODO DE CONEXÃO
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRIAÇÃO DO CURD **/
	public void inserirUsuario(JB usuarios) {
		String create = "Insert into usuarios (NOME,EMAIL,SENHA,TELEFONE) values (?,?,?,?)";
		try {
			// ABRIR CONEXAO COM BANCO
			Connection con = conectar();
			// PREPARAR PARA A INSTRUÇÃO
			PreparedStatement pst = con.prepareStatement(create);

			// SUBSTITUIR PARAMETROS DE DADOS
			pst.setString(1, usuarios.getNOME());
			pst.setString(2, usuarios.getEMAIL());
			pst.setString(3, usuarios.getSENHA());
			pst.setString(4, usuarios.getTELEFONE());
			// EXECUTAR QUERY
			pst.executeUpdate();
			// ENCERRAMENTO DA CONEXÃO COM O BANCO DE DADOS
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// ** LISTAGEM DO BANCO DE DADOS **//

	public ArrayList<JB> listaUsuarios() {
		// CRIAÇAO DE UM OBJETO PARA TER ACESSO A CLASSE JB

		ArrayList<JB> usuarios = new ArrayList<>();

		String read = "Select * from usuarios order by NOME";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			// O LAÇO ABAIXO SERÁ EXECUTADO ENQUANTO HOUVER CONTATOS
			while (rs.next()) {
		
				
				// VARIAVEIS QUE RECEBEM OS DADOS DO BANCO
				String ID = rs.getString(1);
				String NOME = rs.getString(2);
				String EMAIL = rs.getString(3);
				String SENHA = rs.getString(4);
				String TELEFONE = rs.getString(5);
			
				// ENCHENDO O ARRAYLIST
				usuarios.add(new JB(ID, NOME, EMAIL, SENHA, TELEFONE));
			}
			con.close();
			return usuarios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		

	}

	// TESTAR A CONEXAO COM O SERVIDOR MYSQL

	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */
}
