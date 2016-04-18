/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAndJSP;

import beans.Survey;
import ejb.AddNewSurveyToDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
@WebServlet(name = "CreateNewSurvey", urlPatterns = {"/CreateNewSurvey"})
public class CreateNewSurvey extends HttpServlet {

    @EJB
    private AddNewSurveyToDB addNewSurveyBean;

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
        doPost(request, response);
        //processRequest(request, response);
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
        //processRequest(request, response);
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String surveyName = request.getParameter("surveyName");
        System.out.println(firstName + " " + lastName);

        if (firstName == null || lastName == null || surveyName == null || firstName.length() == 0 || lastName.length() == 0 || surveyName.length() == 0) {
            RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/SurveyDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            Survey surveyBean = new Survey();
            addNewSurveyBean.setFirstName(firstName);
            addNewSurveyBean.setLastName(lastName);
            addNewSurveyBean.setSurveyName(surveyName);
            addNewSurveyBean.addSurveyIntoDB();
            response.setContentType("text/html");

            PrintWriter pw = response.getWriter();
            if (addNewSurveyBean.isRecordAdded()) {
                surveyBean.setFirstName(firstName);
                surveyBean.setLastName(lastName);
                surveyBean.setSurveyName(surveyName);
                surveyBean.setRecentlyAddedSurvey(addNewSurveyBean.getRecentRecord());
                HttpSession session = request.getSession(true);
                session.setAttribute("surveyBean", surveyBean);               
                RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/AddQuestions.jsp");
                dispatcher.forward(request, response);
            }

        }
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
