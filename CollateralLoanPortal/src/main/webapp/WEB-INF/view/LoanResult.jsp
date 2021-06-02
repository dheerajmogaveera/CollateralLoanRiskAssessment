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

          <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="white" style="margin-bottom: 0%;" class="bi bi-house float-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
            <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
          </svg>
          <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
          <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
          <link href='https://css.gg/arrow-left-r.css' rel='stylesheet'>
            <path fill-rule="evenodd" d="M8.354 1.646a.5.5 0 0 1 0 .708L2.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
            <path fill-rule="evenodd" d="M12.354 1.646a.5.5 0 0 1 0 .708L6.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"/>
          </svg>
          
          <title>
            Loan Result
        </title>
        <style>
            body{
                background-color: black;
            }
            a{
                color:white;
            }
            a:hover{
                color:white;
                text-decoration: none;
            }
            .fix{
                position: fixed;
                bottom: 0px;
                left: 0px;
            }  
                 
            /* <h1 class="display-1" style="color: white;">Fetch Loan Details</h1> */
            th,td{
                margin:30px 30px 30px 30px;
                padding: 15px;
                border-bottom: 2px solid #050817;
                color: white;
                width: 2%;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                text-align: center;
                font-size: larger;
                background-color: #000936;
            }

            td:hover{
                background-color: teal;
            }

            th{
                font-size: x-large;
                font-weight: bolder;
            }
            td{
                font-family: monospace;
                font-size: x-large;
            }
            table{
                margin: auto;
            }

        </style>
    </head>
    <body>
     <%
     response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
    %>
        <div class="row">
            <div class="col-2">
                    <a href="/home" class="float-left" style="font-size: larger;">
                        <i class="bi bi-house"></i>Home</a>
            </div>
            <div class="col-8">
                <h1 class="display-2" style="color: white; text-align: center;">Fetched Loan Details</h1> 
            </div>
            <div class="col-2">
                <a href="/logout" class="float-right" style="font-size: larger;">
                    <i class="bi bi-box-arrow-right"></i>Log Out</a>
                </div>
            </div>
            
            <div class="container" style="margin-top: 2%;">
                <div class="row" >
                    <div class="col">
                        <table>
                            <tr>
                                <th scope="col">
                                    Paramters
                                </th>
                                <th scope="col">
                                    Values
                                </th>
                            </tr>
                            <tr>
                                <td>
                                    Loan Id
                                </td>
                                <td>
                                    ${Loan.loanId}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Principle Amount
                                </td>
                                <td>
                                    ${Loan.loanPrincipal}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Tenure
                                </td>
                                <td>
                                    ${Loan.tenureYear}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Interest(%)
                                </td>
                                <td>
                                    ${Loan.interest}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Customer Id
                                </td>
                                <td>
                                    ${Customer.customerId}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Customer Name
                                </td>
                                <td>
                                    ${Customer.customerName}
                                </td>
                            </tr> 
                             <tr>
                                <td>
                                    Collateral Type
                                </td>
                                <td>
                                    ${Loan.type}
                                </td>
                            </tr>       
                            <tr>
                                <td>
                                    Loan Product Name
                                </td>
                                <td>
                                    ${Loan.loanType}
                                </td>
                            </tr>          
                        </table>
                    </div>
                </div>         
            </div>
            <br>
            <div class="container-fluid">
                <div class="row" style="">
                    <div class="col float-left">
                        <div class="fix">
                            <a href="/getLoanInfo" style="font-size: larger;">
                            <i class="gg-arrow-left-r"></i>
                            Back</a>
                        </div>
                    </div>
                </div>
            </div>    
    </body>
</html>