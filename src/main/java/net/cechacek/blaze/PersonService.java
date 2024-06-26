package net.cechacek.blaze;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class PersonService {

    @Inject
    EntityManager em;
    @Inject
    EntityViewManager evm;
    @Inject
    CriteriaBuilderFactory cbf;

    public Person create(Person person) {
        evm.save(em, person);
        return person;
    }

   public void delete(Long id) {
        evm.remove(em, Person.class,  id);
   }

   public Person findById(Long id) {
        return evm.find(em, Person.class, id);
   }

    public Person update(Person person) {
        evm.save(em, person);
        return person;
    }
}
