package net.cechacek.blaze;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Person")
@Getter
@Setter
public class PersonEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
