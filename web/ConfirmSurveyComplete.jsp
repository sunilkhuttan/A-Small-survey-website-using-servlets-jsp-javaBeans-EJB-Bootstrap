<%-- 
    Document   : ConfirmSurveyComplete
    Created on : 16/04/2016, 11:04:55 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class ="grad">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Survey or Participate in Survey </title>
        <link rel="stylesheet" type="text/css" href="bootstrap.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
         <nav class="navbar navbar-default">
            <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href= "index.jsp">HOME</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="NewSurvey.jsp">Create New Survey</a></li>
                        <li ><a href="AddQuestions.jsp">Add Questions<span class="sr-only">(current)</span></a></li>                       
                        <li><a href="Instructions.jsp">Instructions</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <center>
        <div class="row body-cont">
            <div class="confirmation">
                <h2 class="title" >Your Survey and questions has been add and your survey is active now.</h2>
            </div>
            <div class = "row create-part">
                <div class="col-md-3">
                </div>
                <div class="col-md-6">
                    <button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='index.jsp'" >Go to Home</button>
                    <button type="button" class="btn btn-default btn-lg btn-block" onclick="window.location.href='NewSurvey.jsp'" >Add another Survey</button>
                </div>
                <div class="col-md-3">
                </div>
             </div>
        </div>
        </center>
    </body>
</html>
