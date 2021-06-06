package fit5042.a1.repository;

import fit5042.a1.repository.entities.Customer;
import fit5042.a1.repository.entities.Heritage;
import fit5042.a1.repository.entities.Researcher;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mouhaoning
 */
@Stateless
public class HeritageRepositoryImp implements HeritageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addHeritage(Heritage heritage) {
        List<Heritage> heritages = entityManager.createNamedQuery(Heritage.GET_ALL_QUERY_NAME).getResultList();
        heritage.setHeritageID(heritages.get(0).getHeritageID() + 1);
        entityManager.persist(heritage);
    }

    @Override
    public void deleteHeritage(int heritageID) {
        Heritage heritage = this.searchHeritageByID(heritageID);

        if (heritage != null) {
            entityManager.remove(heritage);
        }
    }

    @Override
    public void updateHeritage(Heritage heritage) {
        try {
            entityManager.merge(heritage);
        } catch (Exception e) {
            System.out.println("something wrong");
        }
    }

    @Override
    public Heritage searchHeritageByID(int heritageID) {
        Heritage heritage = entityManager.find(Heritage.class, heritageID);

        return heritage;

    }

    @Override
    public List<Heritage> getAllHeritages() {
        try {
            return entityManager.createNamedQuery(Heritage.GET_ALL_QUERY_NAME).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Researcher> getAllResearcher() {
        return entityManager.createNamedQuery(Researcher.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Heritage> searchHeritageByResearcher(Researcher researcher) {
        researcher = entityManager.find(Researcher.class, researcher.getResearcherID());
        researcher.getHeritages().size();
        entityManager.refresh(researcher);

        return researcher.getHeritages();
    }

    @Override
    public List<Heritage> searchByYear(int year) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Heritage.class);
        Root<Heritage> h = query.from(Heritage.class);
        
        query.select(h).where(builder.le(h.get("years").as(Integer.class), year));
        List<Heritage> lh = entityManager.createQuery(query).getResultList();
        
        return lh;
    }

    @Override
    public Customer getAllUsers() {
        try{
            Customer customer = (Customer)entityManager.createNamedQuery(Customer.Get_ALL_QUERY_NAME).getResultList().get(0);
            System.out.println("KKKKKK" + customer.getCustomerEmail());

            return customer;
        }catch(Exception e){
            System.out.println("something is wrong");
        }
        
        return null;
    }

//    @Override
//    public List<Researcher> searchResearcher(String name) {
//        
//    }

    @Override
    public List<Researcher> searchResearcher(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
