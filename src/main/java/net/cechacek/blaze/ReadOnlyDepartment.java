package net.cechacek.blaze;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(DepartmentEntity.class)
public interface ReadOnlyDepartment {

    @IdMapping
    Long getId();
    String getName();
}
