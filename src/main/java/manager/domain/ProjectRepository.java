package manager.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByName(String name);
    List<Project> findByDescription(String description);
}
