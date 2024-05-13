package net.cechacek.blaze;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Department")
@Getter
@Setter
public class DepartmentEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
