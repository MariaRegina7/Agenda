/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author maria
 */
public class C_Contato {
    
    private String idContato, nome, cargo, empresa, dataAniversario, idUsuario;

    public C_Contato() {
    }

    public C_Contato(String idContato, String nome, String cargo, String empresa, String dataAniversario, String idUsuario) {
        this.idContato = idContato;
        this.nome = nome;
        this.cargo = cargo;
        this.empresa = empresa;
        this.dataAniversario = dataAniversario;
        this.idUsuario = idUsuario;
    }

    public C_Contato(int idContato, int idUsuario, String nome, String cargo, String empresa, Date dataAniversario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String getIdContato() {
        return idContato;
    }

    public void setIdContato(String idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}