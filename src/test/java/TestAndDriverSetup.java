import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;


public class TestAndDriverSetup {

    protected WebDriver webDriver;

    @BeforeMethod
    protected final void setUp() {
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    private void quitDriver() {
        if (this.webDriver != null) {
            this.webDriver.quit();
        }
    }
}