package basicpwactionslearn;

import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class dropdownTest extends BaseTest {

    @Test
    void dropdownTest() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");
        page.selectOption("#dropdown", "Option 2");

    }

    @Test
    void dropdownTestMultiple() {
        page.navigate("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        page.getByRole(AriaRole.LISTBOX).selectOption(new String[] {"ms2", "ms3"});
        page.waitForTimeout(3000);
    }
}
