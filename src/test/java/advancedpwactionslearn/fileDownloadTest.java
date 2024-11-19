package advancedpwactionslearn;

import com.microsoft.playwright.Download;
import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

public class fileDownloadTest extends BaseTest {

    @Test
    void fileDownloadWithHandler() {
        page.navigate("https://the-internet.herokuapp.com/download");

        //handler
        page.onDownload(download -> download.saveAs(Paths.get("downloads/Some_data.txt")));
        page.getByText("Some_data.txt").click();
    }

    @Test
    void fileDownloadWithSave() {
        page.navigate("https://the-internet.herokuapp.com/download");

        //Click
        Download download = page.waitForDownload(() -> page.getByText("Some_data.txt").click());

        //Save
        download.saveAs(Paths.get("downloads/Some_data1.txt"));
    }
}
