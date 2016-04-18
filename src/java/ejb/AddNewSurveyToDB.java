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
import javax.ejb.EJB;
import javax.ejb.Stateless;

//import ejb.ConnectToDB;

/**
 *
 * @author sunil
 */
@Stateless
public class AddNewSurveyToDB {
    //@EJB ConnectToDB connectionDetails;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstName, lastName, surveyName;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/survey";
    private final String USERNAME = "root";
    private final String PASSWORD = "india123";
    private boolean recordAdded = false;
    private int recentRecord;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println("First Name is: " + firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println("Last Name is: " + lastName);
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isRecordAdded() {
        return recordAdded;
    }

    public int getRecentRecord() {
        return recentRecord;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void addSurveyIntoDB() {
        try {
            Date date = new Date();
            Class.forName(DRIVER).newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement stmt = con.prepareStatement("insert into surveys (ownerFirstName, ownerLastName, surveyName, createdOn) values(?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            synchronized (this) {
                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, surveyName);
                stmt.setDate(4, new java.sql.Date(date.getTime()));
                stmt.executeUpdate(); 
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()){
                   recentRecord = rs.getInt(1);
                }
                recordAdded = true;
            }

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
