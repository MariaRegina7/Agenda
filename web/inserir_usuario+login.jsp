<%-- 
    Document   : novo_usuario
    Created on : 23/06/2019, 23:28:10
    Author     : maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        <title>Cadastro Usuario</title>
        <link rel="stylesheet" href="css/cadastro_login.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

    </head>
    <body>
        <div class="signup-form">	
            <form action="InserirUsuario" method="post">
                <h2>Criar conta</h2>

                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" class="form-control" name="nome" placeholder="Nome" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
                        <input type="text" class="form-control" name="login" placeholder="Login" required="required">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                        <input type="text" class="form-control" name="senha" placeholder="Senha" required="required">
                    </div>
                </div>
                   
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block btn-lg">Cadastrar</button>
                </div>
            </form>
            <div class="text-center">Já tem uma conta? 
                <a href="#myModal" data-toggle="modal">Login</a>
            </div>
        </div>

        <!-- Modal HTML -->
        <div id="myModal" class="modal fade">
            <div class="modal-dialog modal-login">
                <div class="modal-content">
                    <div class="modal-header">			
                        <h4 class="modal-title">Login</h4>	
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form action="Login" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" name="login" placeholder="Login" required="required">		
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="senha" placeholder="Password" required="required">	
                            </div>        
                            <div class="form-group">
                                <a class="btn btn-primary btnCadastrar" href="visao_geral.jsp" role="button">Login</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>     
    </body>
</html>                            