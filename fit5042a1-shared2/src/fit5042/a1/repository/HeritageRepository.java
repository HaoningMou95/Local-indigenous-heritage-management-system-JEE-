/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.a1.repository;

import fit5042.a1.repository.entities.Customer;
import fit5042.a1.repository.entities.Heritage;
import fit5042.a1.repository.entities.Researcher;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author mouhaoning
 */
@Remote
public interface HeritageRepository {
    
    public void addHeritage(Heritage heritage);
    
    public void deleteHeritage(int heritageID);
    
    public void updateHeritage(Heritage heritage);

    public Heritage searchHeritageByID(int heritageID);
    
    public List<Heritage> getAllHeritages();
    
    public List<Researcher> getAllResearcher();
    
    Set<Heritage> searchHeritageByResearcher(Researcher researcher);
    
    public List<Heritage> searchByYear(int year);
    
    public Customer getAllUsers();
    
    public List<Researcher> searchResearcher(String name);
}
