/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository;

import fit5042.a1.repository.entities.Customer;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author mouhaoning
 */
@Remote
public interface UserRepository {
    
    public Customer getAllUsers();
    
}
