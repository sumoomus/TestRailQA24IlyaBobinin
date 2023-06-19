package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTestCasePage extends BasePage {
    private final String acceptAndNextButtonId = "accept_and_next";
    private final String titleInputId = "title";
    private final String preconditionsInputId = "custom_preconds_display";
    private final String stepsInputId = "custom_steps_display";
    private final String expectedResultInputId = "custom_expected_display";
    private final By sectionDropdownLocator = By.xpath("//span[text() = 'Test Cases']");
    private final By templateDropdownLocator = By.xpath("//span[text() = 'Test Case (Text)']");
    private final String typeDropdownId = "type_id";
    private final By priorityDropdownLocator = By.xpath("//div[@id = 'priority_id_chzn']");
    private final By estimateInputLocator = By.cssSelector("input[name = estimate]");
    private final String referencesInputId = "refs";
    private final String automationTypeDropdownId = "custom_automation_type_chzn";
    private final String addTestCaseButtonId = "accept";
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isAcceptAndNextButtonDisplayed() {
        return driver.findElement(By.id(acceptAndNextButtonId)).isDisplayed();
    }

    @Step
    public void fillingOutTestCase(TestCase testCase) {
        new Input(driver, titleInputId).setValue(testCase.getTitle());
        new Dropdown(driver, sectionDropdownLocator).selectOptionByText(testCase.getSection(), false);
        new Dropdown(driver, templateDropdownLocator).selectOptionByText(testCase.getTemplate(), false);
        new Dropdown(driver, typeDropdownId).selectOptionByText(testCase.getType(), false);
        new Dropdown(driver, priorityDropdownLocator).selectOptionByText(testCase.getPriority(), false);
        new Input(driver, estimateInputLocator).setValue(testCase.getEstimate());
        new Input(driver, referencesInputId).setValue(testCase.getReferences());
        new Dropdown(driver, automationTypeDropdownId).selectOptionByText(testCase.getAutomationType(), false);
        new Input(driver, preconditionsInputId).setValue(testCase.getPreconditions());
        new Input(driver, stepsInputId).setValue(testCase.getSteps());
        new Input(driver, expectedResultInputId).setValue(testCase.getExpectedResult());
    }

    @Step
    public void clickAddTestCaseButton() {
        new Button(driver, addTestCaseButtonId).click();
    }

    @Step
    public boolean isAddAnotherLinkDisplayed() {
        new Button(driver, addTestCaseButtonId).click();
        return false;
    }

}
