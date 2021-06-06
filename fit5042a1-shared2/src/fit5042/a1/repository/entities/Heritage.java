/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author mouhaoning
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Heritage.GET_ALL_QUERY_NAME, query = "SELECT h FROM Heritage h ORDER BY h.heritageID desc")})
public class Heritage implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "Heritage.getAll";
    
    private int heritageID;
    private String heritageName;
    private String herigateDescrip;
    private int years;
    
    private Researcher researcher;
    
    private Set<String> tags;
    
    public Heritage() {
        this.tags = new HashSet<>();
    }
    
    
    @ElementCollection
    @CollectionTable(name = "tag")
    @Column(name = "value")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
    
    
    public Heritage(int heritageID, String heritageName, String herigateDescrip, int years, Researcher researcher, Set<String> tags) {
        this.heritageID = heritageID;
        this.heritageName = heritageName;
        this.herigateDescrip = herigateDescrip;
        this.years = years;
        this.researcher = researcher;
        this.tags = tags;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "heritage_id")
    public int getHeritageID() {
        return heritageID;
    }

    @ManyToOne
    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public void setHeritageID(int heritageID) {
        this.heritageID = heritageID;
    }
    
    @Column(name = "heritage_name")
    public String getHeritageName() {
        return heritageName;
    }

    public void setHeritageName(String heritageName) {
        this.heritageName = heritageName;
    }
    
    @Column(name = "heritage_descrip")
    public String getHerigateDescrip() {
        return herigateDescrip;
    }

    public void setHerigateDescrip(String herigateDescrip) {
        this.herigateDescrip = herigateDescrip;
    }
    
    @Column(name = "heritage_years")
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
    

    @Override
    public String toString() {
        return "Heritage{" + "heritageID=" + heritageID + ", heritageName=" + heritageName + ", herigateDescrip=" + herigateDescrip + ", researcher=" + researcher + '}';
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.heritageID;
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
        final Heritage other = (Heritage) obj;
        if (this.heritageID != other.heritageID) {
            return false;
        }
        return true;
    }
    
}
