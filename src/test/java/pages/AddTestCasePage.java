package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddTestCasePage extends BasePage {
    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    private String acceptAndNextButtonId = "accept_and_next";
    private String titleInputId = "title";
    private String preconditionsInputId = "custom_preconds_display";
    private String stepsInputId = "custom_steps_display";
    private String expectedResultInputId = "custom_expected_display";
    private By sectionDropdownLocator = By.id("section_id_chzn");
    private By templateDropdownLocator = By.id("template_id_chzn");
    private String typeDropdownId = "type_id_chzn";
    private By priorityDropdownLocator = By.xpath("//div[@id = 'priority_id_chzn']");
    private By estimateInputLocator = By.cssSelector("input[name = estimate]");
    private String referencesInputId = "refs";
    private String automationTypeDropdownId = "custom_automation_type_chzn";
    private String addTestCaseButtonId = "accept";

    @Step
    public boolean isAcceptAndNextButtonDisplayed() {
        return driver.findElement(By.id(acceptAndNextButtonId)).isDisplayed();
    }

    @Step
    public void fillingOutTestCase(TestCase testCase) {
        log.info(String.format("Filling out testCase = %s", testCase));
        new Input(driver, titleInputId).setValue(testCase.getTitle());
        new Dropdown(driver, sectionDropdownLocator).selectOptionByText(testCase.getSection().toString(), false);
        new Dropdown(driver, templateDropdownLocator).selectOptionByText(testCase.getTemplate(), false);
        new Dropdown(driver, typeDropdownId).selectOptionByText(testCase.getType(), false);
        new Dropdown(driver, priorityDropdownLocator).selectOptionByText(testCase.getPriority().toString(), false);
        new Input(driver, estimateInputLocator).setValue(testCase.getEstimate());
        new Input(driver, referencesInputId).setValue(testCase.getReferences());
        new Dropdown(driver, automationTypeDropdownId).selectOptionByText(testCase.getAutomationType(), false);
        new Input(driver, preconditionsInputId).setValue(testCase.getPreconditions());
        new Input(driver, stepsInputId).setValue(testCase.getSteps());
        new Input(driver, expectedResultInputId).setValue(testCase.getExpectedResult());
    }

    @Step
    public void clickAddTestCaseButton() {
        log.info("Clicking addTestCaseButton");
        new Button(driver, addTestCaseButtonId).click();
    }

}