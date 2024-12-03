package automationpractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class contactUsFormTest extends BaseTest {

    @Test
    void contact_us_form_no_credentials_test() {
        page.navigate("http://www.automationpractice.pl/index.php");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.locator("#submitMessage").click();
        assertThat(page.getByText("Invalid email address")).isVisible();
        page.locator("#center_column").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/empty-credentials")));

    }

    @Test
    void contact_us_form_with_proper_credentials() {
        page.navigate("http://www.automationpractice.pl/index.php");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us")).click();
        page.selectOption("#id_contact", "2");
        page.locator("#email").fill("demouser@akademiaqa.pl");
        page.locator("input[class='form-control grey']").fill("ABC123");
        page.setInputFiles("#fileUpload", Paths.get("uploads/upload_text.txt"));
        page.locator("textarea[class='form-control']").fill("Test message");
        page.locator("#submitMessage").click();
        assertThat(page.getByText("Your message has been successfully sent to our team.")).isVisible();
    }
}
