import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {


    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person p) {
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personRepository.findById(id).get(), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getPersonList(List<Long> ids) {
        return new ResponseEntity<>((List<Person>) personRepository.findAll(), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, String firstName, String lastName) {
       Person p = new Person(firstName, lastName, id);
        if (personRepository.existsById(id)) {
           return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        }
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
        personRepository.delete(personRepository.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
