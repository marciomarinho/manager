package manager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL})
    private List<Sprint> sprints;

    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        sprints = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sprint> allSprints() {
        return Collections.unmodifiableList(sprints.stream().map(item -> item.clone()).collect(Collectors.toList()));
    }

    public void addSprint(Sprint sprint) {
        this.sprints.add(sprint);
    }

    public int countSprints() {
        return this.sprints.size();
    }

    public void removeSprint(Sprint sprint) {
        this.sprints.remove(sprint);
    }

    @Override
    public String toString() {
        return String.format(
                "Project[id=%d, name='%s', description='%s']",
                id, name, description);
    }

}
