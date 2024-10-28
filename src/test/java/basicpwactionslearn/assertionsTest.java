package basicpwactionslearn;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class assertionsTest extends BaseTest {

    @Test
    void assertionsTest() {
        page.navigate("https://the-internet.herokuapp.com/checkboxes");

        Locator firstCheckbox = page.getByRole(AriaRole.CHECKBOX).first();
        PlaywrightAssertions.assertThat(firstCheckbox).not().isChecked();
        firstCheckbox.check();
        PlaywrightAssertions.assertThat(firstCheckbox).isChecked();
    }
}
