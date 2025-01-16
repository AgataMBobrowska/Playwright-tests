package pageobjectpattern;

import com.github.javafaker.Faker;
import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectpattern.pages.CreateAnAccountPage;
import pageobjectpattern.pages.HomePage;
import pageobjectpattern.pages.MyAccountPage;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAnAccountTest extends BaseTest {

    private HomePage homePage;

    private Faker faker;

    @BeforeEach
    void beforeEach() {
        faker = new Faker();
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/index.php");

    }

    @Test
    void should_create_an_account_test() {
        CreateAnAccountPage createAnAccountPage = homePage.getTopMenuSection().clickSignInLink();

        createAnAccountPage.getCreateAnAccountFormSection()
                .enterEmail(faker.internet().emailAddress())
                .clickCreateAnAccountButton();

        MyAccountPage myAccountPage = createAnAccountPage.getCreateAnAccountFormSection()
                .checkTitleMr()
                .enterFirstName("John")
                .enterLastName("Harrison")
                .enterPassword("QWE09876")
                .enterDateOfBirth("10","08", "1976")
                .clickRegisterButton();

        assertThat(myAccountPage.getManageMyAccountSection().getAccountCreatedMessage()).isVisible();
        assertThat(myAccountPage.getManageMyAccountSection().getMyAccountLabel()).hasText("My account");
    }
}
