package net.cechacek.blaze;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.UpdatableEntityView;

@EntityView(DepartmentEntity.class)
@CreatableEntityView
@UpdatableEntityView
public interface Department {

    @IdMapping
    Long getId();
    String getName();
    void setName(String name);
}
