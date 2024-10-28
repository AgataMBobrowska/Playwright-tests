package basicpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;

public class textTest extends BaseTest {
    @Test
    void textTest() {
        page.navigate("https://the-internet.herokuapp.com/login");

        // 1. innerHTML() - tags + text
        System.out.println(page.innerHTML("#content"));

        // 2. innerText() - text only
        System.out.println(page.innerText("#content"));

        // 3. textContent() - only text, visible and not visible
        System.out.println(page.textContent("#content"));

        // 4. .getAttribute() - html attributes
        System.out.println(page.getAttribute("div img", "alt"));
    }
}
