package basicpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class dataTablesTest extends BaseTest {

    @Test
    void should_return_all_text_from_table() {

        page.navigate("https://the-internet.herokuapp.com/tables");
        List<String> strings = page.locator("table#table1 td").allInnerTexts();

        strings.stream()
                .map(String::trim)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
