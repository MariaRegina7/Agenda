/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.C_MeioContato;

/**
 *
 * @author maria
 */


public class MeioContato {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
    private C_MeioContato c_meioContato = new C_MeioContato();

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_MeioContato c_meioContato) {
        String strComandoSQL;

        try {
            strComandoSQL = "INSERT INTO meioContato(idMeioContato , tipoContato, conteudo, idContato)"
                    + "VALUES('" + c_meioContato.getTipoContato() + "', "
                    + "'" + c_meioContato.getConteudo() + "', "
                    + "'" + c_meioContato.getIdContato() + "')";
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean alterarRegistro(C_MeioContato c_meioContato) {
        String strComandoSQL;

        try {

            strComandoSQL = "UPDATE endereco SET meioContato = '" + c_meioContato.getTipoContato() + "',"
                    + "numero = '" + c_meioContato.getConteudo() + "',"
                    + "complemento = '" + c_meioContato.getIdContato() + "' "
                    + "WHERE idMeioContato = " + c_meioContato.getIdMeioContato();

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean excluirRegistro(int idMeioContato) {
        String strComandoSQL;

        try {
            strComandoSQL = "DELETE FROM meioContato WHERE idMeioContato = " + idMeioContato;

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
            strComandoSQL = "SELECT * FROM meioContato";

            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();

            return rsRegistros;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }
}