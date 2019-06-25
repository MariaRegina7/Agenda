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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.C_Usuario;

/**
 *
 * @author maria
 */
@WebServlet(name = "InserirUsuario", urlPatterns = {"/InserirUsuario"})
public class InserirUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();;
        response.setContentType("text/html;charset=UTF-8");


        try {
            ConexaoBancoDados conexao = new ConexaoBancoDados();

            Usuario usuario = new Usuario();

            C_Usuario c_usuario = new C_Usuario(request.getParameter("nome"),
                    request.getParameter("login"),
                    request.getParameter("senha"));

            usuario.inserirRegistro(c_usuario);

            if (conexao.abrirConexao()) {
                usuario.configurarConexao(conexao.obterConexao());

                if (usuario.inserirRegistro(c_usuario)) {
                    out.println("<h2>Usuário cadastrado com sucesso!</h2>");
                    out.println("<br><br><br><br>");
                    out.println("<a href='inserir_usuario+login.jsp'>Voltar</a>");
                } else {
                    out.println("<h2>Não foi possível cadastrar o usuário!</h2>");
                }

                conexao.fecharConexao();
            } else {
                out.println("<h2>Não foi possível estabelecer conexão com o banco de dados!</h2>");
            }

        } catch (Exception erro) {
            erro.printStackTrace();
            out.println("<h2>Erro do sistema: processo de cadastro de funcionário!</h2>");
        }
    }
}
