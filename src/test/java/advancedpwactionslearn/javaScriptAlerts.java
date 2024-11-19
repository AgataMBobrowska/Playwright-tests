package advancedpwactionslearn;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;

public class javaScriptAlerts extends BaseTest {

    @Test
    void dialogAlert() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

        //handler before click
        page.onDialog(dialog -> {
                    page.waitForTimeout(3000);
                    dialog.accept();
                });

        page.locator("text=Click for JS Alert").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You successfully clicked an alert");
    }

    @Test
    void dialogConfirm() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

//        Handler before click
//        More than one action "onceDialog"
        page.onceDialog(dialog -> {
                    page.waitForTimeout(3000);
                    dialog.accept();
                });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Ok");

        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.dismiss();
        });

        page.locator("text=Click for JS Confirm").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You clicked: Cancel");
    }

    @Test
    void dialogPrompt() {
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onceDialog(dialog -> {
            page.waitForTimeout(3000);
            dialog.accept("Prompt text Test");
        });
        page.locator("text=Click for JS Prompt").click();
        PlaywrightAssertions.assertThat(page.locator("#result")).hasText("You entered: Prompt text Test");
    }
}
