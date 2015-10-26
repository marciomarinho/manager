package manager.domain;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;

    @ManyToOne(fetch=FetchType.EAGER)
    private Project project;

    public Sprint() {
    }

    public Sprint(long id, String name, Date startDate, Date endDate, Project project) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
        return new Sprint(this.id, new String(this.name), (Date)this.startDate.clone(), (Date)this.endDate.clone(), cloneProject);
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
