package net.cechacek.blaze;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.UpdatableEntityView;

@EntityView(PersonEntity.class)
@CreatableEntityView
@UpdatableEntityView
public interface Person {

    @IdMapping
    Long getId();
    String getName();
}
