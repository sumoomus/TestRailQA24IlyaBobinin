package tests;

import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddedTestCasePage;
import pages.TestCaseInfoPage;

public class AddTestCaseTests extends BaseTest {
    @Test
    public void positiveAddTestCaseTest() {
        AddedTestCasePage addedTestCasePage = new AddedTestCasePage();
        TestCaseInfoPage testCaseInfoPage = new TestCaseInfoPage();
        TestCase actualTestCase = TestCase.builder()
                .setTitle("positive login test form")
                .setSection("Test Cases")
                .setTemplate("Test Case (Text)")
                .setType("Other")
                .setPriority("Major")
                .setEstimate("10 minutes")
                .setReferences("qwerty")
                .setAutomationType("None")
                .setPreconditions("Opened form login testrail")
                .setSteps("Fill email. Fill password. Click login")
                .setExpectedResult("Success")
                .build();
        String projectName = "IlyaBobininQA24";
        loginPage.logIn(EMAIL, PASSWORD);
        allProjectsPage.openProjectByName(projectName);
        projectPage.clickAddTestCasesLink();
        addTestCasePage.fillingOutTestCase(actualTestCase);
        addTestCasePage.clickAddTestCaseButton();
        Assert.assertTrue(addTestCasePage.isAddAnotherLinkDisplayed());
        TestCase expectedTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(expectedTestCase, actualTestCase);
    }
}
