package akademiaqa;

import com.microsoft.playwright.Page;
import common.BaseTest;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;

class AllBrowserTest extends BaseTest {         //public class

    @Test
    void should_open_supported_browsers_chromium() {

        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
    }

    @Test
    void should_open_supported_browsers_firefox() {

        page.navigate("https://www.whatismybrowser.com/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
    }
}
