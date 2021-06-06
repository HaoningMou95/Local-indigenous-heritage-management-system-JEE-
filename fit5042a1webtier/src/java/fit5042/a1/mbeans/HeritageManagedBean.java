/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.mbeans;

import fit5042.a1.repository.HeritageRepository;
import fit5042.a1.repository.entities.Heritage;
import fit5042.a1.repository.UserRepository;
import fit5042.a1.repository.entities.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fit5042.a1.repository.entities.Researcher;
import java.io.Serializable;
import java.util.Set;
import javax.el.ELContext;
import fit5042.a1.controllers.HeritageApplication;
import java.util.ArrayList;

/**
 *
 * @author mouhaoning
 */
@ManagedBean(name = "heritageManagedBean")
@SessionScoped
public class HeritageManagedBean implements Serializable {

    @EJB
    private HeritageRepository heritageRepository;
    
    private boolean showForm = true;
    HeritageApplication app;

    private int searchById;
    private String name;
    private int heritageId;
    private int researcherId;
    private int years;
    private int reseacherName;
    
    private Researcher researcher;

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }
    

    public boolean isShowForm() {
        return showForm;
    }

    public void setShowForm(boolean showForm) {
        this.showForm = showForm;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getReseacherName() {
        return reseacherName;
    }

    public void setReseacherName(int reseacherName) {
        this.reseacherName = reseacherName;
    }

    
    
    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public int getSearchById() {
        return searchById;
    }

    public void setSearchById(int searchById) {
        this.searchById = searchById;
    }

    private int getHeritageId() {
        return heritageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeritageManagedBean() {
        this.name = "Assignment FIT5042";
    }

    public String returnResult(){
        return "result";
    }
    
    public List<Heritage> getAllHeritages() {
        try {
            List<Heritage> heritages = heritageRepository.getAllHeritages();
            return heritages;
        } catch (Exception e) {
            System.out.println("something wrong");
        }
        return null;
    }

    public ArrayList<Heritage> searchHeritageByResearcherId(int researcherId) {
        ArrayList<Heritage> heritages = new ArrayList<>();
        try {
//            for (Researcher researcher : heritageRepository.getAllResearcher()) {
//                if (researcher.getResearcherID() == researcherId) {
//                    return heritageRepository.searchHeritageByResearcher(researcher);
//                }

            for (Heritage heritage : heritageRepository.getAllHeritages()) {
                if (heritage.getResearcher().getResearcherID() == researcherId) {
                    heritages.add(heritage);
                }
            }

            return heritages;
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        return null;
    }

    public void initApp() {
        ELContext context = FacesContext.getCurrentInstance().getELContext();

        app = (HeritageApplication) FacesContext.getCurrentInstance()
                .getApplication().getELResolver().getValue(context, null, "heritageApplication");

    }

    public void addHeritage(fit5042.a1.controllers.Heritage localHeritage) {
        Heritage heritage = covertHeritageToEntity(localHeritage);
        initApp();

        try {
            heritageRepository.addHeritage(heritage);

            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Heritage has been added succesfully"));
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        showForm = true;
    }

    public List<Researcher> getAllResearcher() {
        try {
            return heritageRepository.getAllResearcher();
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        return null;
    }

    public Researcher searchResearcher(String name){
        try{
            for (fit5042.a1.repository.entities.Researcher r: heritageRepository.getAllResearcher()){
                if (r.getResearcherName().contains(name))
                {
                    System.out.println("QQQQQ" + r.getResearcherName());
                    researcher = r;
                    return r;
                }
                    
            }
        }catch(Exception e){
            System.out.println("something wrong");
        }
        
        return null;
    }
    
    public Heritage searchHeritageById(int heritageID) {
        try {
            Heritage heritage = heritageRepository.searchHeritageByID(heritageID);
            return heritage;
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        return null;
    }

    public void deleteHeritage(int heritageId) {
        try {
            heritageRepository.deleteHeritage(heritageId);
            initApp();
            app.searchAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property has been deleted succesfully"));
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        showForm = true;
    }

    public void updateHeritage(Heritage heritage) {
        try {
            String name = heritage.getHeritageName();
            String descrip = heritage.getHerigateDescrip();
            Researcher researcher = heritage.getResearcher();
            heritage.setHerigateDescrip(descrip);
            heritage.setHeritageName(name);

            heritageRepository.updateHeritage(heritage);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("updated sucefully"));
        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }

    public Set<Heritage> searchPropertyByResearcherId(int researcherId) {
        try {
            for (Researcher researcher : heritageRepository.getAllResearcher()) {
                if (researcher.getResearcherID() == researcherId) {
                    return heritageRepository.searchHeritageByResearcher(researcher);
                }
            }
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        return null;
    }

    public Heritage covertHeritageToEntity(fit5042.a1.controllers.Heritage localEntity) {
        try {
            Heritage heritage = new Heritage();
            String heritageName = localEntity.getHeritageName();
            String herigateDescrip = localEntity.getHerigateDescrip();

            heritage.setHeritageName(heritageName);
            heritage.setHerigateDescrip(herigateDescrip);
            heritage.setResearcher(localEntity.getResearcher());

            return heritage;
        } catch (Exception e) {
        }

        return null;
    }
    
    public List<Heritage> searchHeritagesByYears(int year){
        try{
            return heritageRepository.searchByYear(year);
        }catch(Exception e){
            System.out.println("some thing wrong");
        }
        
        return null;
    }
    
    public Customer getAllCustomer(){
        
        return heritageRepository.getAllUsers();
    }
}
