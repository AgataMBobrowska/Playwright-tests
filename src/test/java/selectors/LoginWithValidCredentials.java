package selectors;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginWithValidCredentials extends BaseTest {

    @Test
    void should_login_with_valid_credentials() {

        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username","tomsmith");                      // # = id
        page.fill("#password", "SuperSecretPassword!");         // # = id
        page.click("#login button");
        PlaywrightAssertions.assertThat(page.locator("text=You logged into a secure area!")).isVisible();       //assertions - build-in wait
    }
}
