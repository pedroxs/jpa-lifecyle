package demo.domain;

import demo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void testLifecycle() {
        personRepository.save(new Person("John", "Smith"));

        List<Person> persons = personRepository.findAll();

        System.out.println(persons.get(0));
        assertNotEquals("Should have one", 0, persons.size());
    }

    @Test
    public void testLifecycleBatch() throws Exception {
        List<Person> persons = Arrays.asList(new Person("John", "Smith"), new Person("Super", "Mario"));

        personRepository.save(persons);
        assertNotEquals("Should have one", 0, personRepository.findAll().size());

        personRepository.delete(personRepository.findAll().get(0));

        personRepository.deleteAllInBatch();
        assertEquals("Should have none", 0, personRepository.findAll().size());
    }
}