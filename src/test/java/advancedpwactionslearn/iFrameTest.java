package advancedpwactionslearn;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class iFrameTest extends BaseTest {

    @Test
    void should_provide_text_to_the_iframe() {
        page.navigate("https://the-internet.herokuapp.com/iframe");
        //if there is no name use the "frameLocator"
        page.frameLocator("#mce_0_ifr").locator("#tinymce").fill("Demo test");
    }

    @Test
    void should_get_text_from_nested_table() {
        page.navigate("https://the-internet.herokuapp.com/nested_frames");
        PlaywrightAssertions.assertThat(page.frame("frame-middle").locator("#content")).hasText("MIDDLE");
    }
}
