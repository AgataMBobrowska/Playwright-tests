package advancedpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class multipleFileUploadTest extends BaseTest {

    @Test
    void multipleFileUploadTest () {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("uploads/Some_data2.txt"),
                Paths.get("uploads/upload_text.txt")
        });
    }
}
