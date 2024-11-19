package advancedpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;

public class shadowDOMTest extends BaseTest {

    //Works only if the shadow root is >open<

    @Test
    void shadowDOMTest() {
        page.navigate("https://the-internet.herokuapp.com/shadowdom");
        System.out.println(page.locator("span[slot=my-text]").innerText());

    }
}
