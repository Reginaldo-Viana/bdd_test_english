package hooks;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import page.Browser;


public class TestHooks {
private static WebDriver driver;
    private static boolean isBrowserRunning = false;


    @Before
    public void setUp() {
        if (!isBrowserRunning) {
            driver = Browser.getDriver();
            isBrowserRunning = true;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                    isBrowserRunning = false;
                }
            }));
        }
    }
}