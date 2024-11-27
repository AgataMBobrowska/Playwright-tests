package advancedpwactionslearn;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class tracingTest extends BaseTest {


    //local tracing: mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args=”show-trace traces/trace.zip”

    @Test
    void tracingTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        page.getByText("Form Authentication").click();
        page.fill("#username", "jannowak");
        page.fill("#password", "password123");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        //after test: go to https://trace.playwright.dev/ and load trace files
    }
}
