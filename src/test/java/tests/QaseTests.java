package tests;

import adapters.BaseAdapter;
import adapters.ProjectAdapter;
import adapters.SuiteAdapter;
import com.google.gson.Gson;
import objects.Project;
import objects.TestSuit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QaseTests {

    @Test
    public void getProjectTest(){
    new BaseAdapter().get("/project");
    }

    @Test
    public void createProjectTest(){
        Project project = Project.builder()
                .code("QA08NBDEMO")
                .title("OA08DEMOTITLE")
                .description("Test project")
                .build();
        new ProjectAdapter().create(project);
    }

    @Test
    public void createSuiteTest(){
        TestSuit testSuit = TestSuit.builder()
                .title("Smoke test")
                .description("This is smoke test suite")
                .precondition("This is precondition")
                .build();
        new SuiteAdapter().create("QA08NBDEMO", testSuit);
    }

    @Test
    public void createSuite2Test(){
        TestSuit testSuit = TestSuit.builder()
                .title("Smoke test2")
                .description("This is smoke test suite")
                .precondition("This is precondition")
                .build();
       boolean status = new SuiteAdapter().createDemo("QA08NBDEMO", testSuit).path("status");
        Assert.assertTrue(status);
    }

    @Test
    public void deleteSuiteTest(){
        TestSuit testSuit = TestSuit.builder()
                .title("Smoke test3")
                .description("This is smoke test suite")
                .precondition("This is precondition")
                .build();
        int id = new SuiteAdapter().createDemo("QA08NBDEMO", testSuit).path("result.id");
        boolean status = new SuiteAdapter().delete("QA08NBDEMO", id);
        Assert.assertTrue(status);
    }

}