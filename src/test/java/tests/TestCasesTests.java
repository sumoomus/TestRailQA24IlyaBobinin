package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTests extends BaseTest {

    @Test
    public void checkCheckBoxChooseAllTest() {
        String projectName = "IlyaBobininQA24";
        loginPage.logIn(EMAIL, PASSWORD);
        allProjectsPage.openProjectByName(projectName);
        projectPage.clickTestCasesButton();
        testCasesPage.checkCheckboxChooseAll();
        Assert.assertTrue(testCasesPage.isCheckboxChecked());

    }

    @Test
    public void uncheckCheckboxChooseAllTest() {
        String projectName = "IlyaBobininQA24";
        loginPage.logIn(EMAIL, PASSWORD);
        allProjectsPage.openProjectByName(projectName);
        projectPage.clickTestCasesButton();
        testCasesPage.checkCheckboxChooseAll();
        testCasesPage.uncheckCheckbox();
        Assert.assertFalse(testCasesPage.isCheckboxChecked());

    }
}
