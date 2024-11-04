package basicpwactionslearn;


import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class tableUser {
    private String firstName;

    private String lastName;

    private String email;

    private String due;

    private String website;

    private Locator action;

    public tableUser(String firstName, String lastName, String email, String website, String due, Locator action) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.website = website;
        this.due = due;
        this.action = action;
    }
}
