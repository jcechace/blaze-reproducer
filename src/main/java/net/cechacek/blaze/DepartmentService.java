package net.cechacek.blaze;

import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class DepartmentService {

    @Inject
    EntityManager em;
    @Inject
    EntityViewManager evm;
    @Inject
    CriteriaBuilderFactory cbf;

    public Department create(Department department) {
        evm.save(em, department);
        return department;
    }

   public void delete(Long id) {
        evm.remove(em, Department.class,  id);
   }

    public Department findById(Long id) {
        return evm.find(em, Department.class, id);
    }
}
