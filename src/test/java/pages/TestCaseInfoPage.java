package pages;

import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestCaseInfoPage extends BasePage {
    public TestCaseInfoPage(WebDriver driver) {
        super(driver);
    }

    public TestCase getTestCaseInfo() {
        TestCase testCase = TestCase.builder()

                .setTitle(driver.findElement(By.cssSelector(".content-header-title.page_title")).getText())
                .setSection(driver.findElement(By.xpath("//div[@class = 'content-breadcrumb']")).getText())
                .setType(driver.findElement(By.id("cell_type_id")).getText().substring(4))
                .setPriority(driver.findElement(By.id("cell_priority_id")).getText().substring(8))
                .setEstimate(driver.findElement(By.id("cell_estimate")).getText().substring(8))
                .setReferences(driver.findElement(By.id("cell_refs")).getText().substring(10))
                .setAutomationType(driver.findElement(By.id("cell_custom_automation_type")).getText().substring(15))
                .setPreconditions(driver.findElement
                        (By.xpath("//span[@class =  'field-title-inner' and text() = 'Preconditions']/parent::div/following-sibling::div[@class='field-content'][1]//p")).getText())
                .setSteps(driver.findElement
                        (By.xpath("//span[@class='field-title-inner' and text() = 'Steps']/parent::div/following-sibling::div[@class='field-content'][1]//p")).getText())
                .setExpectedResult(driver.findElement
                        (By.xpath("//span[@class='field-title-inner' and text() = 'Expected Result']/parent::div/following-sibling::div[@class='field-content'][1]//p")).getText()).build();
        return testCase;


    }
}