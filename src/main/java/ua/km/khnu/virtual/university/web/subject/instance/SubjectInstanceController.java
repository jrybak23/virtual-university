package ua.km.khnu.virtual.university.web.subject.instance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ua.km.khnu.virtual.university.model.SubjectInstance;
import ua.km.khnu.virtual.university.service.SubjectInstanceService;

import java.util.List;

/**
 * @author Igor Rybak
 */
@Controller
public class SubjectInstanceController {
    private final SubjectInstanceService subjectInstanceService;

    @Autowired
    public SubjectInstanceController(SubjectInstanceService subjectInstanceService) {
        this.subjectInstanceService = subjectInstanceService;
    }

    @ModelAttribute("groupId")
    public int groupId(@PathVariable int groupId) {
        return groupId;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/groups/{groupId}/subject-instances")
    public String getSubjectInstancesOfGroup(
            @PathVariable int groupId,
            @RequestParam("year") int year,
            @RequestParam("semester_number") int semesterNumber,
            Model model
    ) {
        List<SubjectInstance> subjectInstances = subjectInstanceService.getBySemester(groupId, year, semesterNumber);
        model.addAttribute("subjectInstances", subjectInstances);
        return "subject/instance/subject-instances-of-group";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/groups/{groupId}/delete-subject-instance/{subjectInstanceId}")
    public String deleteSubjectInstance(
            @PathVariable int subjectInstanceId,
            @PathVariable int groupId
    ) {
        subjectInstanceService.delete(subjectInstanceId);
        return "redirect:/groups/" + groupId + "/create-subject-instance";
    }
}
