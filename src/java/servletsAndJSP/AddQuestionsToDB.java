/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletsAndJSP;

import ejb.AddSurveyQuestionToDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sunil
 */
@WebServlet(name = "AddQuestions", urlPatterns = {"/AddQuestions"})
public class AddQuestionsToDB extends HttpServlet {
    @EJB
    AddSurveyQuestionToDB addSurveyQuestionsToDB = new AddSurveyQuestionToDB();
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

        String surveyID = request.getParameter("surveyID");
        if (!(surveyID == null)) {
            int id = Integer.parseInt(surveyID);
            String question1 = request.getParameter("question1");
            String question2 = request.getParameter("question2");
            String question3 = request.getParameter("question3");
            
            String[] questions = new String[3];
            questions[0] = question1;
            questions[1] = question2;
            questions[2] = question3;
            addSurveyQuestionsToDB.setQuestions(questions);
            addSurveyQuestionsToDB.setSurveyID(id);
            addSurveyQuestionsToDB.addSurveyQuestionsIntoDB();
            if(addSurveyQuestionsToDB.isRecordAdded()){
                RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/ConfirmSurveyComplete.jsp");
                dispatcher.forward(request, response);
            }
        }

//        if (firstName == null || lastName == null || surveyName == null || firstName.length() == 0 || lastName.length() == 0 || surveyName.length() == 0) {
//            RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/SurveyDetails.jsp");
//            dispatcher.forward(request, response);
//        } else {
//            Survey surveyBean = new Survey();
//
//            //RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/survey.jsp");
//            //dispatcher.forward(request, response);
//            addNewSurveyBean.setFirstName(firstName);
//            addNewSurveyBean.setLastName(lastName);
//            addNewSurveyBean.setSurveyName(surveyName);
//            addNewSurveyBean.addSurveyIntoDB();
//            response.setContentType("text/html");
//
//            PrintWriter pw = response.getWriter();
//            if (addNewSurveyBean.isRecordAdded()) {
//                surveyBean.setFirstName(firstName);
//                surveyBean.setLastName(lastName);
//                surveyBean.setSurveyName(surveyName);
//                surveyBean.setRecentlyAddedSurvey(addNewSurveyBean.getRecentRecord());
//                HttpSession session = request.getSession(true);
//                session.setAttribute("surveyBean", surveyBean);
//                RequestDispatcher dispatcher = (RequestDispatcher) getServletContext().getRequestDispatcher("/AddQuestions.jsp");
//                dispatcher.forward(request, response);
//            }
//
//        }

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
        processRequest(request, response);
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
