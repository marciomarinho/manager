package manager;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import manager.domain.Sprint;
import manager.domain.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ProjectRepository repository;

    @Autowired
    SprintRepository sprintRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //TODO: Test stuff. Replace by http://flywaydb.org/ later.
        Project project1 = new Project("Project1", "Project Number #1");
        Sprint sp1 =  new Sprint("Sprint1", new Date(2015, 11, 01), new Date(2015, 11, 30), project1);
        Sprint sp2 =  new Sprint("Sprint2", new Date(2015, 12, 01), new Date(2015, 12, 31), project1);
        Sprint sp3 =  new Sprint("Sprint3", new Date(2016, 01, 01), new Date(2016, 04, 12), project1);
        project1.addSprint(sp1);
        project1.addSprint(sp2);
        project1.addSprint(sp3);

        repository.save(project1);
        repository.save(new Project("Project2", "Project Number #2"));
        repository.save(new Project("Project3", "Project Number #3"));
        repository.save(new Project("Project4", "Project Number #4"));
        repository.save(new Project("Project5", "Project Number #5"));

    }


}
