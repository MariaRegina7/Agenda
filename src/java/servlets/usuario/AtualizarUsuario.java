/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.usuario;

import banco_dados.ConexaoBancoDados;
import banco_dados.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.C_Usuario;

/**
 *
 * @author emmerson
 */
public class AtualizarUsuario extends HttpServlet {
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
        out.println("<title>Lalala</title>");
        out.println("<link href='clinica_medica.css' rel='stylesheet' type='text/css' />");
        out.println("</head>");
        out.println("<body class='FundoPagina'>");
        out.println("<p class='TituloAplicacao'>SGC - Sistema de Gestão de Clínicas 1.0 </p>");
        out.println("<p class='TituloPagina'>Cadastro de Usuarios </p>");
        
        try{
            ConexaoBancoDados conexao = new ConexaoBancoDados();
            Usuario usuario = new Usuario();
            
            C_Usuario c_usuarios = new C_Usuario(request.getParameter("nome"),
                    request.getParameter("login"),
                    request.getParameter("senha"));
            
            c_usuarios.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
        
            if(conexao.abrirConexao()){
                usuario.configurarConexao(conexao.obterConexao());
            
                if(usuario.alterarRegistro(c_usuarios)){
                    out.println("<h2>Dados do funcionário atualizados com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='menu_usuarios.html'>Voltar</a>");
                }else
                    out.println("<h2>Não foi possível atualizar os dados do funcionário!</h2>");
                
                conexao.fecharConexao();
            }else
                out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
        }catch(Exception erro){
            erro.printStackTrace();
            out.println("<h2>Erro do sistema: processo de atualização do funcionário</h2>");
        }
        out.println("<p class='RodapePagina'>Copyright(c) 2018 - Instituto Federal do Amazonas.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
