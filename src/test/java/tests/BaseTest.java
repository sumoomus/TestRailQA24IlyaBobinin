package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.InvokedListener;

import java.time.Duration;

@Listeners({InvokedListener.class})
public abstract class BaseTest {
    private final static String URL = "https://ibqa24.testrail.io/";
    protected final static String EMAIL = "cummbin0@gmail.com";
    protected final static String PASSWORD = "L@malover7";
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AllProjectsPage allProjectsPage;
    protected AddTestCasePage addTestCasePage;
    protected ProjectPage projectPage;
    protected TestCasesPage testCasesPage;
    protected AddTestRunPage addTestRunPage;
    protected TestCaseInfoPage testCaseInfoPage;

    @Parameters({"browserName"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext context) throws Exception {
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        } else {
            throw new Exception("Unsupported browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        allProjectsPage = new AllProjectsPage(driver);
        projectPage = new ProjectPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        testCasesPage = new TestCasesPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        testCaseInfoPage = new TestCaseInfoPage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
}