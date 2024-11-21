package advancedpwactionslearn;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class videoTest extends BaseTest {

    @Test
    void videoTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.getByLabel("Username").fill("newuser");
        page.getByLabel("Password").fill("Password12345!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
