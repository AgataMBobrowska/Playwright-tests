package pageobjectpattern;

import common.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import pageobjectpattern.pages.HomePage;

public class CreateAnAccount extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate("http://www.automationpractice.pl/index.php");

        // 1. wchodzimy, llikamy sign in
        // 2. wypełniamy formularz z danymi do konta (Utworzć klase z DTO, przekazać dto)
        // 3. sprawdź czy przeniesiono cię na stronę z danymi
    }
}