package manager.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

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
        s1 =  new Sprint("S1", new Date(2015, 11, 01), new Date(2015, 11, 30), project);
        s2 =  new Sprint("S2", new Date(2015, 12, 01), new Date(2015, 12, 31), project);
        s3 =  new Sprint("S3", new Date(2016, 01, 01), new Date(2016, 04, 12), project);
        project.addSprint(s1);
        project.addSprint(s2);
        project.addSprint(s3);
    }

    @Test
    public void testAddSprint() {
        project.addSprint(new Sprint("S4", new Date(2016, 01, 01), new Date(2016, 04, 12), project));
        assertThat(project.countSprints(), is(4));
    }

    @Test
    public void testRemoveSprint() {
        project.removeSprint(s2);
        assertThat(project.countSprints(), is(2));
    }

}
