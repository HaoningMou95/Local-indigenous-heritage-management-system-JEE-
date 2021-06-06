/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.a1.repository.entities.Heritage;
import javax.el.ELContext;
import fit5042.a1.repository.entities.Researcher;
/**
 *
 * @author mouhaoning
 */
@Named(value = "heritageController")
@RequestScoped
public class HeritageController {
    
    static @ManagedProperty(value = "#{heritageApplication}")
    HeritageApplication heritageApplication;
    
    private int heritageID;
    private String heritageName;
    private String heritageDescri;
    
    private Researcher researcher;

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    
    

    public int getHeritageID() {
        return heritageID;
    }

    public String getHeritageName() {
        return heritageName;
    }

    public void setHeritageName(String heritageName) {
        this.heritageName = heritageName;
    }

    public String getHeritageDescri() {
        return heritageDescri;
    }

    public void setHeritageDescri(String heritageDescri) {
        this.heritageDescri = heritageDescri;
    }

    public void setHeritageID(int heritageID) {
        this.heritageID = heritageID;
    }
    
    private fit5042.a1.repository.entities.Heritage heritage;
    
    public HeritageController() throws Exception
    {
        heritageID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("heritageID"));
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        heritageApplication = (HeritageApplication) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "heritageApplication");
        
        heritage = getHeritage();
    }
    
    public Heritage getHeritage() throws Exception
    {
        Heritage newHeritage = new Heritage();
        if(heritage == null){
            newHeritage = heritageApplication.getHeritages().get(--heritageID);
            System.out.println("HHHHHHHH" + newHeritage.getResearcher().getResearcherName());
            return newHeritage;
        }
            
        
        return heritage;
    }
}
