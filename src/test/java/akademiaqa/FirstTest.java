package akademiaqa;
        import common.BaseTest;
        import org.assertj.core.api.Assertions;
        import org.junit.jupiter.api.Test;


class FirstTest extends BaseTest {       //public class (class available in the package

@Test
void should_return_correct_page_title() {

    page.navigate("https://playwright.dev/");
    Assertions.assertThat(page.title()).isEqualTo("Fast and reliable end-to-end testing for modern web apps | Playwright");
    }
}