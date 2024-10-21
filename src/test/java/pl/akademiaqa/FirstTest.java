package pl.akademiaqa;
        import com.microsoft.playwright.Browser;
        import com.microsoft.playwright.BrowserType;
        import com.microsoft.playwright.Page;
        import com.microsoft.playwright.Playwright;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.Test;

        class FirstTest {       //public class (class available in the package

@Test
void should_return_correct_page_title() {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    Page page = browser.newPage();

    page.navigate("https://playwright.dev/");
    Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}