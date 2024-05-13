package net.cechacek.blaze;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

@EntityView(PersonEntity.class)
public interface ReadOnlyPerson {

    @IdMapping
    Long getId();
    String getName();
    ReadOnlyDepartment getDepartment();

    void setName(String name);
    void setDepartment(ReadOnlyDepartment department);

}
