/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author maria
 */
public class C_MeioContato {

    private int idMeioContato, idContato;
    private String tipoContato, conteudo;
    
    public C_MeioContato(){
    }

    public C_MeioContato(int idMeioContato, int idContato, String tipoContato, String conteudo) {
        this.idMeioContato = idMeioContato;
        this.idContato = idContato;
        this.tipoContato = tipoContato;
        this.conteudo = conteudo;
    }

    public int getIdMeioContato() {
        return idMeioContato;
    }

    public void setIdMeioContato(int idMeioContato) {
        this.idMeioContato = idMeioContato;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}