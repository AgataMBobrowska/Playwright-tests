package pageobjectpattern;

import com.github.javafaker.Faker;
import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectpattern.dto.CreateAccountDTO;
import pageobjectpattern.pages.CreateAnAccountPage;
import pageobjectpattern.pages.HomePage;
import pageobjectpattern.pages.MyAccountPage;
import java.lang.String;

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
                .enterFirstName(CreateAccountDTO.getDefaultCreateAnAccountDTO().getFirstNameText())
                .enterLastName(CreateAccountDTO.getDefaultCreateAnAccountDTO().getLastNameText())
                .enterPassword(CreateAccountDTO.getDefaultCreateAnAccountDTO().getPasswordText())
                .enterDateOfBirth(
                        CreateAccountDTO.getDefaultCreateAnAccountDTO().getBirthDate().getDayOfMonth(),
                        CreateAccountDTO.getDefaultCreateAnAccountDTO().getBirthDate().getMonthValue(),
                        CreateAccountDTO.getDefaultCreateAnAccountDTO().getBirthDate().getYear()
                )
                .clickRegisterButton();

        assertThat(myAccountPage.getManageMyAccountSection().getLocators().accountCreatedMessage()).isVisible();
        assertThat(myAccountPage.getManageMyAccountSection().getLocators().myAccountLabel()).hasText("My account");
    }
}
