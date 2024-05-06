package net.cechacek.blaze;

import com.blazebit.persistence.view.EntityViewManager;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Map;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonTest {

    @Inject
    PersonService personService;

    @Inject
    EntityViewManager evm;

    @Test
    @Order(1)
    // This doesn't work
    public void test() {
        var person  = new PersonBuilder.Init(Map.of())
                .withName("TomTester")
                .build();
        personService.create(person);
        System.out.println();
    }

    @Test
    @Order(20)
    // This does
    public void test20() {
        var person = new PersonEntity();
        person.setName("JerryTester");
        personService.create(person);
    }

    @Test
    @Order(30)
    public void test30() {
        System.out.println();
    }
}
