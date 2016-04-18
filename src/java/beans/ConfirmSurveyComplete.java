/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author sunil
 */
public class ConfirmSurveyComplete implements Serializable{
    private String firstName;
    private String lastName;
    private String surveyName;
    private int recentlyAddedSurveyID;

    public String getFirstName() {
        return firstName;
    }

    public int getRecentlyAddedSurveyID() {
        return recentlyAddedSurveyID;
    }

    public void setRecentlyAddedSurvey(int recentlyAddedSurvey) {
        this.recentlyAddedSurveyID = recentlyAddedSurvey;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }
    
}
