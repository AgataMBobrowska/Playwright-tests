package advancedpwactionslearn;

import com.microsoft.playwright.*;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class windowsHandlingTest extends BaseTest {

    private Playwright pw = Playwright.create();

    private Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

    @Test
    void should_open_multiple_browsers() {
        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.locator("#passwd").fill("123456");
        page.locator("#SubmitLogin").click();

        BrowserContext browserContext1 = browser.newContext();
        Page page1 = browserContext1.newPage();

        page1.navigate("http://www.automationpractice.pl/index.php");
        page1.locator("a[title=Women]").click();

        page.waitForTimeout(5000);
    }
}
