<%-- 
    Document   : display
    Created on : 12/04/2016, 10:10:10 PM
    Author     : sunil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class ="grad">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display </title>
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
                        <li class="active"><a href="AddQuestions.jsp">Add Questions<span class="sr-only">(current)</span></a></li>
                        <li><a href="Instructions.jsp">Instructions</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="row body-cont">
            <jsp:useBean id="surveyBean" class="beans.Survey" scope="session" />
            <center>
            <div class="confirmation">
                <h2 class="title">Hi <jsp:getProperty name="surveyBean" property="firstName" />, Your survey has been Created. Enter your Questions below and click on submit</h2>
            </div>
            </center>
            <form class="form form-horizontal" name="addQuestions" action="AddQuestions" method="POST" >    
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-3 padd-100px" >
                            <h3  class="col-lg-2 control-label" >Question1: </h3>
                        </div>
                        <div class="col-lg-9">
                            <textarea class="form-control" placeholder="Write your first survey here" type="text" name="question1" rows="3"></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-3 padd-100px" >
                            <h3  class="col-lg-2 control-label" >Question2: </h3>
                        </div>
                        <div class="col-lg-9">
                            <textarea class="form-control" placeholder="Write your first survey here" type="text" name="question2" rows="3"></textarea>
                        </div>
                    </div>
                </div>
               
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-3 padd-100px" >
                            <h3  class="col-lg-2 control-label" >Question3: </h3>
                        </div>
                        <div class="col-lg-9">
                            <textarea class="form-control" placeholder="Write your first survey here" type="text" name="question3" rows="3"></textarea>
                        </div>
                    </div>
                </div>
                <%
                    int var = surveyBean.getRecentlyAddedSurveyID();
                %>
                <input type="hidden" name="surveyID" value= <%=var%>>
                <button type="submit" value="submit"  class="btn btn-default q-submit">Submit</button>
            </form>
        </div>
    </body>
</html>
