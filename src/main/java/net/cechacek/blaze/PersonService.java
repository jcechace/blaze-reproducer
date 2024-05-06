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

    // Doesn't work
    public Person create(Person person) {
        evm.save(em, person);
        return person;
    }

    // Works
    public PersonEntity create(PersonEntity personEntity) {
        em.persist(personEntity);
        return personEntity;
    }

}
