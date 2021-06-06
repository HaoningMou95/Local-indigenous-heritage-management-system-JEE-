/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.mbeans;

import fit5042.a1.repository.HeritageRepository;
import fit5042.a1.repository.UserRepository;
import fit5042.a1.repository.entities.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mouhaoning
 */

@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {
    @EJB
    private HeritageRepository heritageRepository;
    
    Customer customer;

    public Customer getAllUsers() {
        try{
            return heritageRepository.getAllUsers();
        }catch(Exception e){
            System.out.println("something wrong");
        }
        
        return null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
    
    
    
}
