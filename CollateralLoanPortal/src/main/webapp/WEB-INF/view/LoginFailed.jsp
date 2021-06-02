<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>
            Login-ADMV Bank
        </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            html { 
            /* background: url('dollar.jpeg') no-repeat center center fixed;  */
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            background-color: black;
            }
            body{
                background-color: transparent;
            }
            .container{
                font-family: 'Gill Sans', 'Gill Sans MT', 'Calibri', 'Trebuchet MS', sans-serif;
            }
        </style>
    <body> 
     <%
     response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    %>
        <div class="container" style="text-align: center;">
            
            <div style="margin-top: 12%; margin-bottom:2%;">
                <img src="/img/User.png" style="margin: auto; height: 15%; width: 15%;" alt="user image"/>
            </div>

    <form class="form form-horizontal" method=POST>
        <div class="form-group">    
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="input-group input-group-lg mb-3">
                        <div class="input-group-prepend">
                          <span class="input-group-text" id="basic-addon1">@</span>
                        </div>
                        <input type="text" name="userid" class="form-control" placeholder="Username" >
                    </div>
                <div class="col-3"></div>
            </div>
            </div>
            <div class="form-group">    
                <div class="row">
                    <div class="col-3"></div>
                        <div class="col-6">
                            <div class="input-group input-group-lg mb-3">
                                <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">**</span>
                                </div>
                                <input type="password" name="upassword" class="form-control" placeholder="Password">
                            </div>
                    <div class="col-3"></div>
                </div> 
                </div>
                <div class="form-group">    
               <div class="row">
                    <div class="col-4"></div>
                        <div class="col-4">
                            <button class="btn btn-primary" style="padding: 20px; width: 100%;" type="submit">Login</button>                                                </div>
                        <div class="col-4"></div>
                    </div>
                </div>
            </form>
            <div class="text-danger"><h6>${err}</h6></div>
        </div>
    </body>
</html>