/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author emmerson
 */
public class Conversao {
    public Date StringToDate(String strData){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");
        
        try{
            Date dtData = new Date(formatoData.parse(strData).getTime());
            
            return dtData;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }
    
    public String DataInvertida(Date dtData){
        if(dtData != null){
            int intDia, intMes, intAno;
            String strData;
            Calendar calendario = Calendar.getInstance();
            
            calendario.setTime(dtData);
            
            intDia = calendario.get(Calendar.DAY_OF_MONTH);
            intMes = calendario.get(Calendar.MONTH)+1;
            intAno = calendario.get(Calendar.YEAR);
            
            strData = intAno+"-"+intMes+"-"+intDia;
            
            return strData;
        }else
            return null;
    }
    
    public String DateToString(Date dtData){
        String strData;
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            strData = formatoData.format(dtData);
            
            return strData;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }
    
    public int DiaData(Date dtData){
        if(dtData != null){
            int intDia;            
            Calendar calendario = Calendar.getInstance();
            
            calendario.setTime(dtData);
            
            intDia = calendario.get(Calendar.DAY_OF_MONTH);
                        
            return intDia;
        }else
            return 0;
    }
    
    public int MesData(Date dtData){
        if(dtData != null){
            int intMes;            
            Calendar calendario = Calendar.getInstance();
            
            calendario.setTime(dtData);
            
            intMes = calendario.get(Calendar.MONTH)+1;
                        
            return intMes;
        }else
            return 0;
    }
    
     public int AnoData(Date dtData){
        if(dtData != null){
            int intAno;            
            Calendar calendario = Calendar.getInstance();
            
            calendario.setTime(dtData);
            
            intAno = calendario.get(Calendar.YEAR);
                        
            return intAno;
        }else
            return 0;
    }
     
    public String soDigito(String strValor){
        int intTamanho = strValor.length();
        String strValidacao = "0123456789";
        String strNovoValor = "";
        char chrDigito;
        int intContador;
        
        for(intContador = 0;intContador < intTamanho; intContador++){
            chrDigito = strValor.charAt(intContador);
            
            if(strValidacao.indexOf(chrDigito) != -1)
                strNovoValor = strNovoValor + chrDigito;
        }
        return(strNovoValor);
    }
}
