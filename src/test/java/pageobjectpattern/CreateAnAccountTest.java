package pageobjectpattern;

import com.github.javafaker.Faker;
import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectpattern.dto.CreateAnAccountDTO;
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
                .enterFirstName(CreateAnAccountDTO.getDefaultCreateAnAccountDTO().getFirstNameText())
                .enterLastName(CreateAnAccountDTO.getDefaultCreateAnAccountDTO().getLastNameText())
                .enterPassword(CreateAnAccountDTO.getDefaultCreateAnAccountDTO().getPasswordText())
                .enterDateOfBirth("9", "3", "1991")
                .clickRegisterButton();

        assertThat(myAccountPage.getManageMyAccountSection().getLocators().accountCreatedMessage()).isVisible();
        assertThat(myAccountPage.getManageMyAccountSection().getLocators().myAccountLabel()).hasText("My account");
    }
}
