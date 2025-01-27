package basicpwactionslearn;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class pageTest extends BaseTest {

    @Test
    void pageTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions().setTimeout(3000)); //default 30 sec.
        page.navigate("https://the-internet.herokuapp.com/login", new Page.NavigateOptions().setWaitUntil(WaitUntilState.LOAD));

        // 1.DOMCONTENTLOADED - html is loaded, but css and js is not
        // 2. LOAD - html, css and js are loaded (DEFAULT)
        // 3. NETWORKIDLE - no additional requests in 500 ms

//          Page Options:
//        page.navigate("http://localhost:7080/", new Page.NavigateOptions().setReferer("https://onet.pl"));
//        page.reload();
//        page.goBack();
//        page.goForward();
//        page.click("", new Page.ClickOptions().setClickCount(10));
//        page.click("", new Page.ClickOptions().setButton(MouseButton.RIGHT));
//        page.click("", new Page.ClickOptions().setModifiers(Arrays.asList(KeyboardModifier.CONTROL, KeyboardModifier.ALT)));
//        page.dblclick("");
//        page.check("");
//        page.uncheck("");
    }
}
