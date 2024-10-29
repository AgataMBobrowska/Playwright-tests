package basicpwactionslearn;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class dynamicControlsTest extends BaseTest {

    @Test
    void dynamicControlsTest() {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove")).click();
        PlaywrightAssertions.assertThat(page.locator("#checkbox")).not().isVisible();
        PlaywrightAssertions.assertThat(page.getByText("It's gone!")).isVisible();
    }

    @Test
    void dynamicControlsTest2 () {
        page.navigate("https://the-internet.herokuapp.com/dynamic_controls");
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isDisabled();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enable")).click();
        PlaywrightAssertions.assertThat(page.locator("#input-example input[type=text]")).isEnabled();
    }
}
