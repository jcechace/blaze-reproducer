package net.cechacek.blaze;

import com.blazebit.persistence.view.EntityViewManager;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
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
    DepartmentService departmentService;

    @Inject
    EntityViewManager evm;

    @Test
    @Order(1)
    public void test() {
        var dep = evm.create(Department.class);
        dep.setName("departmentA");
        departmentService.create(dep);
        var ref = evm.convert(dep, ReadOnlyDepartment.class);

        var person  = evm.create(Person.class);
        person.setName("TomTester");
        person.setDepartment(ref);
        personService.create(person);


        System.out.println();
    }

    @Test
    @Order(10)
    public void test10() {
        var dep = evm.create(Department.class);
        dep.setName("departmentB");
        departmentService.create(dep);

        var ref = evm.convert(dep, ReadOnlyDepartment.class);

        var person = personService.findById(1L);
        person.setDepartment(ref);
        personService.update(person);
    }

    @Test
    @Order(20)
    public void test20() {
        personService.delete(1L);
        var dep = departmentService.findById(1L);
        Assertions.assertThat(dep).isNotNull();
    }

    @Test
    @Order(30)
    public void test30() {
        System.out.println();
    }
}
