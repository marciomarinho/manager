package manager.controllers;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("projects", repository.findAll());
        return "projects/list";
    }

    @RequestMapping("/new")
    public String newProject() {
        return "projects/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("project[name]") String name,
                         @RequestParam("project[description]") String description,
                         Model model) {
        repository.save(new Project(name, description));
        model.addAttribute("projects", repository.findAll());
        return "projects/list";
    }

}
