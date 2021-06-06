/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author mouhaoning
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Customer.Get_ALL_QUERY_NAME, query = "select c FROM Customer c")
})
public class Customer implements Serializable{
    
    public static final String Get_ALL_QUERY_NAME = "Customer.getAll";
    
    private int customerID;
    private String customerName;
    private String customerEmail;
//    private Date dob;
    private int phoneNo;
    
    public Customer()
    {
        
    }
    
    public Customer(int customerID, String customerName, String customerEmail, int phoneNo) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
//        this.dob = dob;
        this.phoneNo = phoneNo;
    }
    
    
//    @Column(name = "customer_dob")
//    public Date getDob() {
//        return dob;
//    }
//
//    public void setDob(Date dob) {
//        this.dob = dob;
//    }

    @Column(name = "customer_phoneNo")
    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @Column(name = "customer_Email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    
}
