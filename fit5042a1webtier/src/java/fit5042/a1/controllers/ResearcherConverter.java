/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.controllers;


import fit5042.a1.mbeans.HeritageManagedBean;
import java.util.List;
import javax.el.ELContext;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.convert.Converter;

import javax.faces.convert.FacesConverter;
import fit5042.a1.repository.entities.Researcher;
import javax.faces.context.FacesContext;
/**
 *
 * @author mouhaoning
 */
@FacesConverter(forClass = Researcher.class, value="researcher")
public class ResearcherConverter implements Converter{
    
    @ManagedProperty(value = "#{heritageManagedBean}")
    HeritageManagedBean heritageManagedBean;
    
    public List<Researcher> researcherDB;
    
    public ResearcherConverter(){
        try{
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            heritageManagedBean = (HeritageManagedBean) FacesContext.getCurrentInstance().getApplication()
                    .getELResolver().getValue(elContext, null, "heritageManagedBean");

            researcherDB = heritageManagedBean.getAllResearcher(); 
        }catch(Exception e){
            System.out.println("something wrong");
        }
    }
    
    public Researcher getAsObject(FacesContext facesContext, UIComponent component, String submittedValue){
        if(submittedValue.trim().equals("")){
            return null;
        }else{
            try{
                int number = Integer.parseInt(submittedValue);
                
                for (Researcher r : researcherDB){
                    if(r.getResearcherID() == number){
                        System.out.println("BBBBBBBB"+r.getResearcherID()+"researcher Name"+r.getResearcherName());
                        return r;
                    }
                }
            }catch(Exception e){
                System.out.println("something wrong");
            }
        }
        
        return null;
    }
    
    public String getAsString(FacesContext facesContext, UIComponent component, Object value){
        if(value == null || value.equals("")){
            return "";
        }else{
            String id = String.valueOf(((Researcher)value).getResearcherID());
            System.out.println("DDDDDDDDD"+id);
            return id;
        }
    }
}
