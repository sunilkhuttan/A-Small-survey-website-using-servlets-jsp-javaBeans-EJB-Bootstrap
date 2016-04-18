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
import java.util.HashMap;
import javax.ejb.Stateless;

/**
 *
 * @author sunil
 */
@Stateless
public class GetCurrentSurveysFromDB {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/survey";
    private final String USERNAME = "root";
    private final String PASSWORD = "india123";
    private HashMap<Integer, String> surveys = new HashMap<Integer, String>();

    public HashMap<Integer, String> getSurveys() {
        return surveys;
    }

    public void getAllSurveys() {
        try {
            Class.forName(DRIVER).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement stmt = con.prepareStatement("select * from surveys;");
            synchronized (this) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String surveyName = rs.getString(4);
                    //surveys.put(id, surveyName);
                    System.out.println("ID " + id);
                    surveys.put(id, surveyName);
                    
                }
                rs.close();
            }
            con.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("SQL EXCEPTION " + e);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }
}
