package manager.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch=FetchType.EAGER)
    private Project project;

    public Sprint() {
    }


    public Sprint(long id, String name, LocalDate startDate, LocalDate endDate, Project project) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long removeFromProject() {
        this.project.removeSprint(this);
        return this.project.getId();
    }

    @Override
    public Sprint clone() {
        Project cloneProject = new Project(this.project.getName(), this.project.getDescription());
        return new Sprint(this.id, new String(this.name),
                LocalDate.of(this.startDate.getYear(),this.startDate.getMonth(), this.startDate.getDayOfMonth()),
                LocalDate.of(this.endDate.getYear(),this.endDate.getMonth(), this.endDate.getDayOfMonth()), cloneProject);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }



}
