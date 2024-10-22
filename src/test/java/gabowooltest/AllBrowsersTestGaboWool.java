package gabowooltest;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class AllBrowsersTestGaboWool extends BaseTestGaboWool {

    @Test
    void should_open_all_browsers_chromium() {
        page.navigate("https://www.gabowool.pl/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/chromium.png")));
    }

    @Test
    void should_open_all_bowsers_firefox() {
        page.navigate("https://www.gabowool.pl/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/firefox.png")));
    }
}
