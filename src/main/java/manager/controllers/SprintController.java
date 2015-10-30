package manager.controllers;

import manager.domain.Project;
import manager.domain.ProjectRepository;
import manager.domain.Sprint;
import manager.domain.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class SprintController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SprintRepository sprintRepository;

    @RequestMapping("/projects/{id}/sprints/new")
    public String newSprint(@PathVariable long id, Model model) {
        model.addAttribute("projectId", id);
        return "projects/sprints/new";
    }

    @RequestMapping(value = "/projects/sprints/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("sprint[name]") String name,
                         @RequestParam("sprint[startDate]") Date startDate,
                         @RequestParam("sprint[endDate]") Date endDate,
                         @RequestParam("project[id]") long projectId) {

        Project project = projectRepository.findOne(projectId);
        Sprint sprint = new Sprint(0, name, startDate, endDate, project);
        project.addSprint(sprint);
        sprintRepository.save(sprint);

        return new ModelAndView("redirect:/projects/" + projectId + "/sprints");

    }

    @RequestMapping(value = "/projects/sprints/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        Sprint sprint = sprintRepository.findOne(id);
        long projectId = sprint.removeFromProject();
        sprintRepository.delete(id);
        return new ModelAndView("redirect:/projects/" + projectId + "/sprints");
    }

}
