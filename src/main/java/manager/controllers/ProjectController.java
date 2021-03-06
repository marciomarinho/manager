package manager.controllers;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import manager.domain.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                         Model model) {
        Project project = repository.findOne(id);
        model.addAttribute("project", project);
        return "projects/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("project[id]") long id,
                         @RequestParam("project[name]") String name,
                         @RequestParam("project[description]") String description,
                         Model model) {
        Project project = repository.findOne(id);
        project.setName(name);
        project.setDescription(description);
        repository.save(project);
        model.addAttribute("projects", repository.findAll());
        return "projects/list";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        repository.delete(id);
        return new ModelAndView("redirect:/projects");
    }

    @RequestMapping(value = "/{id}/sprints", method = RequestMethod.GET)
    public String sprints(@PathVariable long id, Model model) {
        Project project = repository.findOne(id);
        model.addAttribute("project", project);
        return "projects/sprints/list";
    }



}
