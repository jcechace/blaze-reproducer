package net.cechacek.blaze;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.UpdatableEntityView;
import com.blazebit.persistence.view.UpdatableMapping;

@EntityView(PersonEntity.class)
@CreatableEntityView
@UpdatableEntityView
public interface Person {

    @IdMapping
    Long getId();
    String getName();
    ReadOnlyDepartment getDepartment();

    void setName(String name);
    void setDepartment(ReadOnlyDepartment department);

}
