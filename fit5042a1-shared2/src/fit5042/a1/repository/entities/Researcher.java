/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mouhaoning
 */
@Entity
@Table(name = "Researcher")
@NamedQueries({
    @NamedQuery(name = Researcher.GET_ALL_QUERY_NAME, query = "select r from Researcher r")
})
public class Researcher implements Serializable{
    private int researcherID;
    private String researcherName;
    private Set<Heritage> heritages;
    public static final String GET_ALL_QUERY_NAME = "Researcher.getall";
    
    public Researcher(){
        
    }

    public Researcher(int researcherID, String researcherName) {
        this.researcherID = researcherID;
        this.researcherName = researcherName;
        this.heritages = new HashSet<>();
    }

    @Id
    @GeneratedValue
    @Column(name = "Researcher_id")
    public int getResearcherID() {
        return researcherID;
    }

    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }
    
    @Column(name = "Researcher_Name")
    public String getResearcherName() {
        System.out.println("YYYYYYY"+this.researcherName);
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }
    
    @OneToMany(mappedBy = "researcher")
    public Set<Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(Set<Heritage> heritages) {
        this.heritages = heritages;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.researcherID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Researcher other = (Researcher) obj;
        if (this.researcherID != other.researcherID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Researcher{" + "researcherID=" + researcherID + ", researcherName=" + researcherName + ", heritages=" + heritages + '}';
    }
    
    
}
