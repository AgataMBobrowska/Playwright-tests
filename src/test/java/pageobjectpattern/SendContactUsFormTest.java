package pageobjectpattern;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectpattern.pages.ContactUsPage;
import pageobjectpattern.pages.HomePage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SendContactUsFormTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/index.php");
    }

    @Test
    void should_show_error_while_sending_empty_form_test() {

        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickContactUsLink();
        contactUsPage.getContactUsFormSection().clickSendButton();
        assertThat(contactUsPage.getContactUsFormSection().getErrorMessage()).isVisible();
    }

    @Test
    void should_fill_and_send_contact_us_form_test() {
        ContactUsPage contactUsPage = homePage.getTopMenuSection().clickContactUsLink();

        contactUsPage.getContactUsFormSection().selectSubjectHeading("Webmaster")
        .enterEmailAddress("demo@demo.com")
        .enterOrderReference("12345")
        .selectFileToUpload("uploads/upload_text.txt")
        .enterMessage("Sample message")
        .clickSendButton();
        assertThat(contactUsPage.getContactUsFormSection().getConfirmationMessage()).isVisible();

    }
}
