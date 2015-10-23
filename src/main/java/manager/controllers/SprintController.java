package manager.controllers;

import manager.domain.Sprint;
import manager.domain.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sprints")
public class SprintController {

    @Autowired
    SprintRepository repository;

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable long id) {
        Sprint sprint = repository.findOne(id);
        long projectId = sprint.getProject().getId();
        repository.delete(id);
        return new ModelAndView("redirect:/projects/" + projectId + "/sprints");
    }

}
