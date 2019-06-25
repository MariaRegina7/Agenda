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
import model.C_Contato;


/**
 *
 * @author maria
 */
public class Contato {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
    private C_Contato c_contato = new C_Contato();

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_Contato c_contato) {
        String strComandoSQL;

        try {
            strComandoSQL = "INSERT INTO contato(idContato, nome, cargo, empresa, dataAniversario, idUsuario)"
                    + "VALUES('" + c_contato.getNome() + "', "
                    + "'" + c_contato.getCargo() + "', "
                    + "'" + c_contato.getEmpresa() + "')"
                    + "'" + c_contato.getDataAniversario() + "')"
                    + "'" + c_contato.getIdUsuario() + "')";
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean alterarRegistro(C_Contato c_contato) {
        String strComandoSQL;

        try {

            strComandoSQL = "UPDATE contato SET nome = '" + c_contato.getNome() + "',"
                    + "cargo = '" + c_contato.getCargo() + "',"
                    + "empresa = '" + c_contato.getEmpresa() + "' "
                    + "dataAniversario = '" + c_contato.getDataAniversario() + "' "
                    + "WHERE idContato = " + c_contato.getIdContato();

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean excluirRegistro(int idContato) {
        String strComandoSQL;

        try {
            strComandoSQL = "DELETE FROM contato WHERE idContato = " + idContato;

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
            strComandoSQL = "SELECT * FROM contato";

            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();

            return rsRegistros;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

}