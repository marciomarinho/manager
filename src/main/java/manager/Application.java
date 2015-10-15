package manager;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProjectRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Project("Project1", "Project Number #1"));
        repository.save(new Project("Project2", "Project Number #2"));
        repository.save(new Project("Project3", "Project Number #3"));
        repository.save(new Project("Project4", "Project Number #4"));
        repository.save(new Project("Project5", "Project Number #5"));
    }


}
