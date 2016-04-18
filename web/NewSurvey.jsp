<%-- 
    Document   : NewSurvey
    Created on : 12/04/2016, 9:56:21 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class ="grad">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Create New Survey</title>
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
                        <li class="active" ><a href="NewSurvey.jsp">Create New Survey</a></li>
                        <li ><a href="AddQuestions.jsp">Add Questions<span class="sr-only">(current)</span></a></li>                       
                        <li><a href="Instructions.jsp">Instructions</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        
        <div class="row body-cont">
            <center>
            <div class="confirmation">
                <h2 class="title" >Create New Survey: Enter your first name, last name and survey description</h2>
            </div>
            </center>
            <form class="form form-horizontal" name="newSurvey" action="CreateNewSurvey" method="POST">
                <div class="form-group">
                    
                    <h3 for="exampleInputEmail1" class="col-lg-2 control-label" >First Name: </h3>
                    <input type="text" class="form-control input-col" name="first" placeholder="First Name">
                    
                </div>
                <div class="form-group">
                    <h3 for="exampleInputPassword1" class="col-lg-2 control-label">Last Name: </h3>
                    <input type="text" class="form-control input-col" name="last" placeholder="Last Name">
                </div>
                <div class="form-group">
                    <h3 for="exampleInputPassword1" class="col-lg-2 control-label">Survey Name:</h3>
                    <input type="text" class="form-control input-col" name="surveyName" placeholder="Survey Description">
                </div>
               
                <button type="submit" class="btn btn-default s-submit" value="submit" > Submit</button>

            </form>
            
        </div>
            
    </body>
</html>
