package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.xml.sax.Locator;
import pageobjectpattern.pages.BasePage;

@Getter
public class CreateAnAccountFormSection extends BasePage {

    private Locator emailInput;

    private Locator createAnAccountButton;

    private Locator titleMr;

    private Locator titleMrs;

    private Locator firstName;

    private Locator lastName;

    private Locator password;

    private Locator dayOfBirth;

    private Locator monthOfBirth;

    private Locator yearOfBirth;

    private Locator signUpForNewsletter;

    private Locator registerButton;

    public  CreateAnAccountFormSection(Page page) {
        super(page);
        this.emailInput = page.locator("input[id='email_create']")
        this.createAnAccountButton = page.locator("button[id='SubmitCreate']")
        this.titleMr = page.locator("input[id='id_gender1']");
        this.titleMrs = page.locator("input[id='id_gender2']");
        this.firstName = page.getByText("First name");          //div[class='required form-group form-error']
        this.lastName = page.getByText("Last name");
        this.password = page.locator("input[type='password']");
        this.dayOfBirth = page.locator("select[id='days']");
        this.monthOfBirth  = page.locator("select[name='months']");
        this.yearOfBirth = page.locator("select[name= 'years']");
        this.signUpForNewsletter = page.locator("input[name='newsletter']");
        this.registerButton = page.locator("button[name='submitAccount']");

    }

    public CreateAnAccountFormSection enterEmail(String email) {
        emailInput.(email);
        return this;
    }

}
