package basicpwactionslearn;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class dynamicallyLoadedPageElementsTest extends BaseTest {

    @Test
    void dynamicallyLoadedPageElementsTest1() {

        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/1");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(text).isVisible();

    }

    @Test
    void dynamicallyLoadedPageElementsTest2() {

        page.navigate("https://the-internet.herokuapp.com/dynamic_loading/2");
        Locator text = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Hello World!"));
        PlaywrightAssertions.assertThat(text).not().isVisible();

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();
        PlaywrightAssertions.assertThat(text).isVisible();

    }
}
