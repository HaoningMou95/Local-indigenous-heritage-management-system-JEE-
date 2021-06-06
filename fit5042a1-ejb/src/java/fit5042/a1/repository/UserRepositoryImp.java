/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository;

import fit5042.a1.repository.entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mouhaoning
 */
public class UserRepositoryImp implements UserRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer getAllUsers() {
        try{
            return (Customer)entityManager.createNamedQuery(Customer.Get_ALL_QUERY_NAME).getResultList().get(0);
        }catch(Exception e){
            System.out.println("something is wrong");
        }
        
        return null;
    }
    
}
