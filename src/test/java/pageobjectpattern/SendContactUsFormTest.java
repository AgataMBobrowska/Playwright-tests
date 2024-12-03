package pageobjectpattern;

import common.BaseTest;
import org.junit.jupiter.api.Test;
import pageobjectpattern.pages.ContactUsPage;
import pageobjectpattern.pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendContactUsFormTest extends BaseTest {

    @Test
    void should_show_error_while_sending_empty_form_test() {
        page.navigate("http://www.automationpractice.pl/index.php");
        HomePage homePage = new HomePage(page);
        ContactUsPage contactUsPage = new ContactUsPage(page);

        homePage.getTopMenuSection().clickContactUsLink();
        contactUsPage.getContactUsFormSection().clickSendButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }
}
