<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="white" class="bi bi-box-arrow-right float-right" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
            <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
          </svg>
        <title>Home</title>    
        <style>
            body{
                background-color: black;
            }
            .card{
                background-color: black;
                box-shadow: 0px 0px 15px 0 #0033ff;
            }
            a:hover{
                text-decoration: none;
            }
            .card:hover{
                background-color: #040a54;
                box-shadow: 0px 0px 150px #010530;
            }
        </style>
    </head>
    <body style="color: white;">
    <%   
     response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");   
     response.setHeader("pragma", "no-cache");   
     response.setDateHeader("Expires", 0);  
     response.setHeader("Expires", "0"); 
    %>
        <div class="container-fluid">
        <div class="row">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="display-3 font-weight-bold" style="text-align: center;">
                    ADMV Banking Services
                </div>
            </div>
                <div class="col-2">
                    
                        <a href="/logout" class="float-right" style="font-size: larger; color: white;">
                            <i class="bi bi-box-arrow-right"></i>Log Out</a>
                        
                </div>
            </div>        
                <div class="row">
                    <div class="col-2"></div>
                    <div class="col display-4" > 
                        Which Operation would you like to perform?
                        
                    </div>
                </div> 
                <div class="row" style="margin-top: 5%; margin-left: 15%;margin-right: 10%;">
                    <div class="col-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" style="border-bottom: 2px white;" src="/img/L.png" alt="Card image cap">
                                <div class="card-body" style="text-align:center;">
                                    <h5 class="card-title" >Get Loan Details</h5>
                                    <p class="card-text">Click here to get loan details based on loanId</p>
                                    <a href="/getLoanInfo" class="btn btn-primary">Click Here!</a>
                                </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="/img/C.png" alt="Card image cap"> 
                                <div class="card-body" style="text-align:center">
                                    <h5 class="card-title">Save Collateral</h5>
                                    <p class="card-text">Click here to save the collateral for a particular loan request</p>
                                    <a href="/saveCollateral" style="left: 50%; right: 50%;" class="btn btn-primary">Click Here!</a>
                                </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="/img/R.png" alt="Card image cap"/>
                                <div class="card-body" style="text-align:center">
                                    <h5 class="card-title">Calculate Risk</h5>
                                    <p class="card-text">Click here to check the risk associated with a particular loan</p>
                                    <a href="/getRiskOfCollateral" class="btn btn-primary">Click Here</a>
                                </div>
                        </div>
                    </div>
                </div>
        </div>
    </body>
</html>