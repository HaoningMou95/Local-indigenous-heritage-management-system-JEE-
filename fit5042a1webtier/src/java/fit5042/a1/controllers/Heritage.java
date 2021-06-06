/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.controllers;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import fit5042.a1.repository.entities.Researcher;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mouhaoning
 */
@RequestScoped
@Named(value = "heritage")

public class Heritage implements Serializable {

    private int heritageID;
    private String heritageName;
    private String herigateDescrip;
    private int years;

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    private Researcher researcher;

    private int researcherID;
    private String researcherName;

    private HashSet<String> tags;

    public Heritage() {

    }

    public Heritage(int heritageID, String heritageName, String herigateDescrip, Researcher researcher, Set<String> tags) {
        this.heritageID = heritageID;
        this.heritageName = heritageName;
        this.herigateDescrip = herigateDescrip;
        this.researcher = researcher;
        this.tags = (HashSet<String>) tags;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    

    public int getResearcherID() {
        return researcherID;
    }

    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    public int getHeritageID() {
        return heritageID;
    }

    public void setHeritageID(int heritageID) {
        this.heritageID = heritageID;
    }

    public String getHeritageName() {
        return heritageName;
    }

    public void setHeritageName(String heritageName) {
        this.heritageName = heritageName;
    }

    public String getHerigateDescrip() {
        return herigateDescrip;
    }

    public void setHerigateDescrip(String herigateDescrip) {
        this.herigateDescrip = herigateDescrip;
    }

}
