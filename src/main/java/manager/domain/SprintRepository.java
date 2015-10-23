package manager.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SprintRepository extends CrudRepository<Sprint, Long> {
    List<Sprint> findByName(String name);
}
