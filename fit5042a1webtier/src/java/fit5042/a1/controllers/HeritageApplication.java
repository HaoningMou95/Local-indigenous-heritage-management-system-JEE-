package fit5042.a1.controllers;

import fit5042.a1.mbeans.HeritageManagedBean;
import java.util.ArrayList;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.a1.repository.entities.Heritage;
import java.util.List;

/**
 *
 * @author mouhaoning
 */
@Named(value = "heritageApplication")
@ApplicationScoped

public class HeritageApplication {

    @ManagedProperty(value = "#{heritageManagedBean}")
    HeritageManagedBean heritageManagedBean;

    private static final ArrayList<Heritage> heritages = new ArrayList<>();

    private boolean showForm = true;
    private int researcherId;
    private int years;
    private String researcherName;

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }
    
    

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
    

    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public HeritageApplication() throws Exception {
        
        
        ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
        heritageManagedBean = (HeritageManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(eLContext, null, "heritageManagedBean");
        
        if (heritages != null && heritages.size() > 0){
            
        }else{
            updateHeritageList();
        }

    }

    public ArrayList<Heritage> getHeritages() {
        return heritages;
    }

    public void setHeritages(ArrayList<Heritage> newHeritages) {
//        this.heritages = newHeritages;
    }

    public void updateHeritageList() {
        if (heritages != null && heritages.size() > 0) {

        } else {
            heritages.clear();
            List<Heritage> heritagelist = heritageManagedBean.getAllHeritages();
            for (Heritage heritage : heritagelist) {
//                System.out.println(heritage.toString());
                heritages.add(heritage);
            }
            setHeritages(heritages);
        }
    }

    public void searchHeritageByID(int heritageId) {
        heritages.clear();
        heritages.add(heritageManagedBean.searchHeritageById(heritageId));
    }
    
    public void searchPropertyByResearcherId(int researcherId){
        heritages.clear();
        
        for (fit5042.a1.repository.entities.Heritage heritage : heritageManagedBean.searchHeritageByResearcherId(researcherId)) {
            heritages.add(heritage);
        }
        
        setHeritages(heritages);
    }

    public void searchHeritagesByYears(int year){
        heritages.clear();
        for (fit5042.a1.repository.entities.Heritage heritage : heritageManagedBean.searchHeritagesByYears(year)) {
            heritages.add(heritage);
        }
        
        setHeritages(heritages);
    }
    
    public void searchAll() {
        heritages.clear();

        for (fit5042.a1.repository.entities.Heritage heritage : heritageManagedBean.getAllHeritages()) {
            heritages.add(heritage);
        }

        setHeritages(heritages);
    }
}
