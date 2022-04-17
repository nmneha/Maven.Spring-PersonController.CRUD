import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/people")
    public Person createPerson(@RequestBody Person p) {
        return personRepository.save(p);
    }

//    @GetMapping("/people/{id}")
//    public Person getPerson(@PathVariable("id") Long id) {
//        return personRepository.findOne(id);
//    }

//    @GetMapping("/people")
//    public List<Person> getPersonList(List<Person> personList) {
//        List<Person> people = new ArrayList<>(personList);
//        return personRepository.findAll(people);
//    }
//
//    @PutMapping("/people/{id}")
//    public Person updatePerson(@PathVariable("id") Long id) {
//        Person p = personRepository.findOne(id);
//        return personRepository.save(p);
//    }

    @DeleteMapping("/people/{id}")
    public void DeletePerson(@PathVariable("id") Long id) {
        personRepository.delete(personRepository.findById(id));
    }


}
