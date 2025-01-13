package pageobjectpattern;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjectpattern.pages.CreateAnAccountPage;
import pageobjectpattern.pages.HomePage;
import pageobjectpattern.pages.MyAccountPage;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

public class CreateAnAccountTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/index.php");

        // 1. wchodzimy, llikamy sign in
        // 2. wypełniamy formularz z danymi do konta (Utworzć klase z DTO, przekazać dto)
        // 3. sprawdź czy przeniesiono cię na stronę z danymi
    }

    @Test
    void should_create_an_account_test() {
        CreateAnAccountPage createAnAccountPage = homePage.getTopMenuSection().clickSignInLink();

        createAnAccountPage.getCreateAnAccountFormSection()
                .enterEmail("demo234567@demo.com")
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