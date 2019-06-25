/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.C_Usuario;

/**
 *
 * @author maria
 */
public class Usuario {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
    private C_Usuario c_usuario = new C_Usuario();

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_Usuario c_usuario) {
        String strComandoSQL;

        try {
            strComandoSQL = "INSERT INTO usuario(nome, login, senha)"
                    + "VALUES('" + c_usuario.getNome() + "', "
                    + "'" + c_usuario.getLogin() + "', "
                    + "'" + c_usuario.getSenha() + "')";
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean alterarRegistro(C_Usuario c_usuario) {

        String strComandoSQL;

        try {

            strComandoSQL = "UPDATE usuario SET nome = '" + c_usuario.getNome() + "',"
                    + "login = '" + c_usuario.getLogin() + "',"
                    + "senha = '" + c_usuario.getSenha() + "' "
                    + "WHERE idUsuario = " + c_usuario.getIdUsuario();

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean excluirRegistro(int idUsuario) {
        String strComandoSQL;

        try {
            strComandoSQL = "DELETE FROM usuario WHERE idUsuario = " + idUsuario;

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public ResultSet listarRegistros() {
        String strComandoSQL;

        try {
            strComandoSQL = "SELECT * FROM usuario";

            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();

            return rsRegistros;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

    public boolean login(String login, String senha) throws SQLException {
        String strComandoSQL;
        int count=0;
        strComandoSQL = "SELECT * FROM Usuario WHERE login = " + login + " AND senha = " + senha;
        psComando = conBanco.prepareStatement(strComandoSQL);
        rsRegistros = psComando.executeQuery();
        while (rsRegistros.next()) {
            count++;
        }
        if(count>0)
            return true;
        else
            return false;
    }

    public int localizarPorNome(String nome) {
        int intId = 0;
        String strComandoSQL;

        try {

            strComandoSQL = "SELECT idUsuario FROM Usuario WHERE nome LIKE '%" + nome + "%'";

            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();
            rsRegistros.next();

            intId = rsRegistros.getInt("idUsuario");
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        return intId;
    }
}
