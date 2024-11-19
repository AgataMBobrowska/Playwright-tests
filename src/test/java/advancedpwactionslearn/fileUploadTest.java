package advancedpwactionslearn;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import common.BaseTest;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileUploadTest extends BaseTest {

    @Test
    void fileUploadTest() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.setInputFiles("#file-upload", Paths.get("uploads/upload_text.txt"));
        page.setInputFiles("#file-upload", new Path[0]);
        page.setInputFiles("#file-upload", Paths.get("uploads/Some_data2.txt"));
        page.locator("#file-submit").click();
        PlaywrightAssertions.assertThat(page.getByText("File Uploaded!")).isVisible();
    }
}
