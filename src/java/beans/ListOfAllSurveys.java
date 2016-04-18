/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author sunil
 */
public class ListOfAllSurveys implements Serializable{
     private HashMap<Integer, String> surveys;

    public HashMap<Integer, String> getSurveys() {
        return surveys;
    }

    public void setSurveys(HashMap<Integer, String> surveys) {
        this.surveys = surveys;
    }
    
    
     
}
