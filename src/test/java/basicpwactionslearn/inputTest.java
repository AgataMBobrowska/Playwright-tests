package basicpwactionslearn;

import common.BaseTest;
import org.junit.jupiter.api.Test;

public class inputTest extends BaseTest {

    @Test
    void inputTest() {
        page.navigate("https://the-internet.herokuapp.com/login");
        page.fill("#username", "agata");        // types in the text at once
        page.type("#password", "12345xyz");       // each letter one by one


        //page.fill("", "value", new Page.FillOptions().setForce(true));
    }


}

