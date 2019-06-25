/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.meiocontato;

import servlets.contato.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(name = "ExcluirContato", urlPatterns = {"/ExcluirContato"})
public class ExcluirMeioContato extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        out.println("<title>SGC - Versão 1.0</title>");
        out.println("<link href='clinica_medica.css' rel='stylesheet' type='text/css' />");
        out.println("</head>");
        out.println("<body class='FundoPagina'>");
        out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestão de Clínicas 1.0 </p>");
        out.println("<p class='TituloPagina'>Cadastro de Funcionários </p>");
        
        try{
            ConexaoBancoDados conexao = new ConexaoBancoDados();
            MeioContato meioContato = new MeioContato();
            
            if(conexao.abrirConexao()){
                meioContato.configurarConexao(conexao.obterConexao());
                
                if(meioContato.excluirRegistro(Integer.parseInt(request.getParameter("idMeioContato")))){
                    out.println("<h2>Registro do funcionário excluído com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='#'>Fechar</a>");                    
                }else
                    out.println("<h2>Não foi possível excluir o registro do funcionário!</h2>");                    
                conexao.fecharConexao();
            }else
                out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");                    
               
        }catch(Exception erro){
            erro.printStackTrace();
            out.println("<h2>Erro do sistema:processo de exclusão do funcionário!</h2>");
        }
        out.println("<p class='RodapePagina'>Copyright(c) 2018 - Intituto Federal do Amazonas.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}