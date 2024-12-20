package advancedpwactionslearn;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class javaScriptTest extends BaseTest {

    @Test
    void evaluateTest() {
        page.navigate("https://the-internet.herokuapp.com/");
        String window = (String) page.evaluate("() => window.origin");
        System.out.println("WindowInfo: " + window);
    }

    @Test
    void evaluateOnSelectorTest () {
        page.navigate("https://the-internet.herokuapp.com");
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).isVisible();
        page.evalOnSelector("h1[class=heading]", "e => e.remove()");
        page.waitForTimeout(2000);
        PlaywrightAssertions.assertThat(page.locator("h1[class=heading]")).not().isVisible();
    }

    @Test
    void evalOnSelectorAllTest () {
        page.navigate("https://the-internet.herokuapp.com");
        Integer numberOfLinks = (Integer) page.evalOnSelectorAll("ul li", "e => e.length");
        Assertions.assertThat(numberOfLinks).isEqualTo(44);
    }
}
