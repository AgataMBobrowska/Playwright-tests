package selectors;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginWithInvalidUsername extends BaseTest {

    @Test
    void should_not_login_with_invalid_username() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("Username").click();
        page.getByLabel("Username").fill("jankowalski");
        page.getByLabel("Password").click();
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login")).click();
        PlaywrightAssertions.assertThat(page.getByText("Your username is invalid!"));
     }
}