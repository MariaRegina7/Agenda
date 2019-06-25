/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.contato;

import banco_dados.ConexaoBancoDados;
import banco_dados.Contato;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.C_Contato;

/**
 *
 * @author maria
 */
@WebServlet(name = "ListarContato", urlPatterns = {"/ListarContato"})
public class PesquisarContato extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PesquisarContato</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarContato at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ResultSet rsRegistro;
        String strContato;
        int idContato;
        
        strContato = request.getParameter("strFuncionario");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        
        // EDITAR ESTE HEADER
        out.println("<title>Pesquisar Usuário</title>");
        out.println("");
        // EDITAR ESTE HEAD
        
        out.println("</head>");
        out.println("<body>");
        
        // EDITAR SAÍDAS E DIRECIONAMENTO DE RESULTADOS
        try{
            ConexaoBancoDados conexao = new ConexaoBancoDados();
            Contato contato = new Contato();
            
            if(conexao.abrirConexao()){
                contato.configurarConexao(conexao.obterConexao());
                
                idContato = contato.localizarRegistro(strContato.toUpperCase());
               
                if (idContato != 0) {
                    rsRegistro = contato.lerRegistro(idContato);
                    
                    out.println("Contato: " + rsRegistro.getString("nome"));
                } else {
                    out.println("<h2>Contato não encontrado!</h2>");
                }
                
                conexao.fecharConexao();
            }else{
                out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
            }
            
        }catch(Exception erro){
            erro.printStackTrace();
            out.println("<h2>Erro do sistema: processo de exclusão de contato!</h2>");
        }
        
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}