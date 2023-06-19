package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddTestRunPageTests extends BaseTest{

    @Test
    public void checkSelectSpecificRadioTest(){
        String projectName = "IlyaBobininQA24";
        loginPage.logIn(EMAIL, PASSWORD);
        allProjectsPage.openProjectByName(projectName);
        projectPage.clickAddTestRunsButton();
        addTestRunPage.checkSelectSpecificRadio();
        Assert.assertTrue(addTestRunPage.isSelectSpecificRadioChecked());
        Assert.assertFalse(addTestRunPage.isIncludeAllRadioUnchecked());


    }
}
