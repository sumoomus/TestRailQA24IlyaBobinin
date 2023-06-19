package tests;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProjectPage;

public class AddTestCaseTests extends BaseTest {
    @Test
    public void positiveAddTestCaseTest() {
        TestCase actualTestCase = new TestCase();
        actualTestCase.setTitle("pozitive test form Login");
        actualTestCase.setSection("Test Cases");
        actualTestCase.setTemplate("Test Case (Text)");
        actualTestCase.setType("Other");
        actualTestCase.setPriority("Critical");
        actualTestCase.setEstimate("10 minutes");
        actualTestCase.setReferences("qwe");
        actualTestCase.setAutomationType("None");
        actualTestCase.setPreconditions("opened form");
        actualTestCase.setSteps("fill email. fill password. click login");
        actualTestCase.setExpectedResult("success");
        String projectName = "IlyaBobininQA24";
        loginPage.logIn(EMAIL, PASSWORD);
        allProjectsPage.openProjectByName(projectName);
        projectPage.clickAddTestCasesLink();
        addTestCasePage.fillingOutTestCase(actualTestCase);
        addTestCasePage.clickAddTestCaseButton();
        Assert.assertTrue(addTestCasePage.isAddAnotherLinkDisplayed());
        TestCase expectedTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(expectedTestCase,actualTestCase);


    }
}
