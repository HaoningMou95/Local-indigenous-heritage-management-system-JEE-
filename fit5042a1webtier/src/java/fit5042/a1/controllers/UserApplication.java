/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.controllers;

import fit5042.a1.mbeans.UserManagedBean;
import fit5042.a1.repository.entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author mouhaoning
 */
@Named(value = "userApplication")
@ApplicationScoped
public class UserApplication {
    
    @ManagedProperty(value = "#{userManagedBean}")
    UserManagedBean userManagedBean;
    
    private static final Customer customer = new Customer();
    
    private String customerName;
    private String customerEmail;
    private int phoneNo;

    public UserApplication() throws Exception {
        
        ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
        userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(eLContext, null, "userManagedBean");
        
       
        if (customer != null){
            
        }else{
            updateUser();
        }

    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomers(Customer customer){
//        this.customers = customers;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    
//    public void searchAll(){
//        customer = userManagedBean.getAllUsers();
//    }
    
    public void updateUser(){
        if (customer != null){
            
        }else{
            
            Customer customerProfile = userManagedBean.getAllUsers();
            
            setCustomers(customerProfile);
        }
    }
}
