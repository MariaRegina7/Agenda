/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author emmerson
 */
public class Validacao {
    public boolean estaVazio(String strCampo){
        return ((strCampo.trim().equals("")) || (strCampo.length() == 0));
    }
    
    public boolean validaCPF(String strParmCPF){
        boolean blnRetorno = true;
        int intDigito1, intDigito2,intContador, intSoma, intPosicao;
        char chrDigito;
        String strDigito, strCPFNovo;
        boolean blnDigito1Valido, blnDigito2Valido;
        
        Conversao converter = new Conversao();
        
        String strCPF = converter.soDigito(strParmCPF);
        
        if(!(estaVazio(strParmCPF))){
            //calculo do primeiro digito
            intSoma = 0;
            intPosicao = 10;
            
            for(intContador = 0;intContador <= 8; intContador++){
                strDigito = "";
                chrDigito = strCPF.charAt(intContador);
                strDigito += chrDigito;
                intSoma += (Integer.parseInt(strDigito)*intPosicao);
                intPosicao--;
            }
            
            intDigito1 = 11 - (intSoma % 11);
            
            if(intDigito1 > 9)
                intDigito1 = 0;
            
            //Calculo do segundo digito
            strCPFNovo = strCPF.substring(0,9) + Integer.toString(intDigito1);
            intSoma = 0;
            intPosicao = 11;
            
            for(intContador = 0;intContador <= 9; intContador++){
                strDigito = "";
                chrDigito = strCPFNovo.charAt(intContador);
                strDigito += chrDigito;
                intSoma += (Integer.parseInt(strDigito)*intPosicao);
                intPosicao--;
            }
            
            intDigito2 = 11 - (intSoma % 11);
            
            if(intDigito2 > 9)
                intDigito2 = 0;
            
            //testa o primeiro digito
            strDigito = "";
            chrDigito = strCPF.charAt(9);
            strDigito += chrDigito;
            blnDigito1Valido = (intDigito1 == Integer.parseInt(strDigito));
            
            //testa o segundo digito
            strDigito = "";
            chrDigito = strCPF.charAt(10);
            strDigito += chrDigito;
            blnDigito2Valido = (intDigito2 == Integer.parseInt(strDigito));
            
            if((!blnDigito1Valido)|| (!blnDigito2Valido))
                blnRetorno = false;
        }else
            blnRetorno = false;
        
        return blnRetorno;
    }
    
}
