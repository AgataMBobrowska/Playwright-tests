package basicpwactionslearn;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import common.BaseTest;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    void should_return_list_of_users() {

        page.navigate("https://the-internet.herokuapp.com/tables");
        List<Locator> trs =  page.locator("table#table1 tbody tr").all();

        List<tableUser> users = trs.stream()
                .map(tr -> {
                    List<Locator> tds = tr.getByRole(AriaRole.CELL).all();
                    String lastName = tds.get(0).innerText();
                    String firstName = tds.get(1).innerText();
                    String email = tds.get(2).innerText();
                    String due = tds.get(3).innerText();
                    String website = tds.get(4).innerText();
                    Locator action = tds.get(5);

                    return new tableUser(firstName, lastName, email, due, website, action);

                }).collect(Collectors.toList());

        tableUser frank = users.stream()
                .filter(user -> user.getFirstName().startsWith("Frank"))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("User not found"));

        frank.getAction().getByText("edit").click();
    }
}
