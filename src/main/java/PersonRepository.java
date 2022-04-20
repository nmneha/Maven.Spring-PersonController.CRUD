import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    void delete(Optional<Person> byId);

    void delete(Long id);
}
