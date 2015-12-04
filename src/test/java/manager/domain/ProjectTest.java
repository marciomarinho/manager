package manager.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ProjectTest {

    private Project project;
    private Sprint s1;
    private Sprint s2;
    private Sprint s3;

    @Before
    public void setup() {
        project = new Project("ProjectX", "Project 1X");
        s1 =  new Sprint(1,"S1", LocalDate.of(2015, 11, 01), LocalDate.of(2015, 11, 30), project);
        s2 =  new Sprint(2,"S2", LocalDate.of(2015, 12, 01), LocalDate.of(2015, 12, 31), project);
        s3 =  new Sprint(3,"S3", LocalDate.of(2016, 01, 01), LocalDate.of(2016, 04, 12), project);
        project.addSprint(s1);
        project.addSprint(s2);
        project.addSprint(s3);
    }

    @Test
    public void testAddSprint() {
        project.addSprint(new Sprint(4,"S4", LocalDate.of(2016, 01, 01), LocalDate.of(2016, 04, 12), project));
        assertThat(project.countSprints(), is(4));
    }

    @Test
    public void testRemoveSprint() {
        project.removeSprint(s2);
        assertThat(project.countSprints(), is(2));
    }

    @Test(expected=UnsupportedOperationException.class)
    public void testTryToModifySprintList() {
        List<Sprint> sprints = project.allSprints();
        sprints.add(new Sprint(4,"S4", LocalDate.of(2016, 01, 01), LocalDate.of(2016, 04, 12), project));
        assertThat(project.countSprints(), is(3));
    }

    public void testTryToModifySprint() {
        List<Sprint> sprints = project.allSprints();
        Sprint toModify = sprints.get(0);

        toModify.setName("XPTO");
        toModify.setStartDate(LocalDate.now());
        toModify.setEndDate(LocalDate.now());
        toModify.setProject(new Project("ProjectZ", "Project 99ZZ"));

        Sprint toAssert = sprints.get(0);

        assertThat(toAssert.getName(), is("Sprint1"));
        assertThat(toAssert.getStartDate(), is(LocalDate.of(2015, 11, 01)));
        assertThat(toAssert.getEndDate(), is(LocalDate.of(2015, 11, 30)));
        assertThat(toAssert.getProject(), is(project));
    }

}
