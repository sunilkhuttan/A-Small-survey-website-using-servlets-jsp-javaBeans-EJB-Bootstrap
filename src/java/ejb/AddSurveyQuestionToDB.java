/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author sunil
 */
@Stateless
public class AddSurveyQuestionToDB {

    private String[] questions;// question1, question2, question3;
    private int surveyID;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/survey";
    private final String USERNAME = "root";
    private final String PASSWORD = "india123";
    private int questionsAdded = 0;
    private boolean recordAdded = false;

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }

    public boolean isRecordAdded() {
        return recordAdded;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public void addSurveyQuestionsIntoDB() {
        try {
            Date date = new Date();
            Class.forName(DRIVER).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement stmt = con.prepareStatement("insert into surveyquestions (surveyID, question, yes, no) values(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < questions.length; i++) {
                synchronized (this) {
                    stmt.setInt(1, surveyID);
                    stmt.setString(2, questions[i]);
                    stmt.setInt(3, 0);
                    stmt.setInt(4, 0);
                    stmt.executeUpdate();
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        //recentRecord = rs.getInt(1);
                        questionsAdded++;
                    }
                    recordAdded = true;
                }

            }
        }catch (SQLException e) {
            System.out.println("SQL EXCEPTION " + e);
        }catch (InstantiationException ex) {
            ex.printStackTrace();
        }catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
