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
import model.C_Endereco;

/**
 *
 * @author maria
 */
public class Endereco {

    private Connection conBanco;
    private PreparedStatement psComando;
    private ResultSet rsRegistros;
    private C_Endereco c_endereco = new C_Endereco();

    public void configurarConexao(Connection conBanco) {
        this.conBanco = conBanco;
    }

    public boolean inserirRegistro(C_Endereco c_endereco) {
        String strComandoSQL;

        try {
            strComandoSQL = "INSERT INTO endereco(idEndereco , endereco, numero, complemento, bairro, cidade, uf, tipoEndereco, idContato)"
                    + "VALUES('" + c_endereco.getEndereco() + "', "
                    + "'" + c_endereco.getNumero() + "', "
                    + "'" + c_endereco.getComplemento() + "')"
                    + "'" + c_endereco.getBairro() + "')"
                    + "'" + c_endereco.getCidade() + "')"
                    + "'" + c_endereco.getUf() + "')"
                    + "'" + c_endereco.getTipoEndereco() + "')"
                    + "'" + c_endereco.getIdContato() + "')";
            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();
            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean alterarRegistro(C_Endereco c_endereco) {
        String strComandoSQL;

        try {

            strComandoSQL = "UPDATE endereco SET endereco = '" + c_endereco.getEndereco() + "',"
                    + "numero = '" + c_endereco.getNumero() + "',"
                    + "complemento = '" + c_endereco.getComplemento() + "' "
                    + "bairro = '" + c_endereco.getBairro() + "' "
                    + "cidade = '" + c_endereco.getCidade() + "' "
                    + "uf = '" + c_endereco.getUf() + "' "
                    + "tipoEndereco = '" + c_endereco.getTipoEndereco() + "' "
                    + "idContato = '" + c_endereco.getIdContato() + "' "
                    + "WHERE idEndereco = " + c_endereco.getIdEndereco();

            psComando = conBanco.prepareStatement(strComandoSQL);
            psComando.executeUpdate();

            return true;
        } catch (Exception erro) {
            erro.printStackTrace();
            return false;
        }
    }

    public boolean excluirRegistro(int idEndereco) {
        String strComandoSQL;

        try {
            strComandoSQL = "DELETE FROM endereco WHERE idEndereco = " + idEndereco;

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
            strComandoSQL = "SELECT * FROM endereco";

            psComando = conBanco.prepareStatement(strComandoSQL);
            rsRegistros = psComando.executeQuery();

            return rsRegistros;
        } catch (Exception erro) {
            erro.printStackTrace();
            return null;
        }
    }

}