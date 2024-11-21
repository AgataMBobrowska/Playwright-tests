package advancedpwactionslearn;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class tracingTest extends BaseTest {

    @Test
    void tracingTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "jannowak");
        page.fill("#password", "password123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }
}
