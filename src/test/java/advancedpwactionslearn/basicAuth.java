package advancedpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class basicAuth extends BaseTest {

    @Test
    void basicAuthTest() {
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        assertThat(page.getByText("Congratulations! You must have the proper credentials.")).isVisible();
    }
}
