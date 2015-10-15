package manager;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//public class Application extends SpringBootServletInitializer {
//
//    @Autowired
//    ProjectRepository repository;
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }
//
//    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Application.class, args);
//    }
//
//}

public class Application implements CommandLineRunner {

    @Autowired
    ProjectRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // save a couple of Projects
        repository.save(new Project("Payroll", "Enterprise Payroll System"));
        repository.save(new Project("BAU", "Business as Usual Project"));
        repository.save(new Project("Website 1", "Master website"));
        repository.save(new Project("Fast Courier", "Door to door courier online app"));
        repository.save(new Project("Easy Invoicing", "Invoicing and personal accounting"));

        // fetch all Projects
        System.out.println("Projects found with findAll():");
        System.out.println("-------------------------------");
        for (Project Project : repository.findAll()) {
            System.out.println(Project);
        }
        System.out.println();

        // fetch an individual Project by ID
        Project Project = repository.findOne(1L);
        System.out.println("Project found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Project);
        System.out.println();
    }


}
