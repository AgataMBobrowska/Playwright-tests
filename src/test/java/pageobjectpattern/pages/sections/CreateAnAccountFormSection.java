package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.xml.sax.Locator;
import pageobjectpattern.pages.BasePage;

@Getter
public class CreateAnAccountFormSection extends BasePage {

    private Locator title;

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
        this.title = page.locator("input[id='id_gender1']");
        this.firstName = page.getByText("First name");          //div[class='required form-group form-error']
        this.lastName = page.getByText("Last name");
        this.password = page.locator("input[type='password']");
        this.dayOfBirth = page.locator("select[id='days']");
        this.monthOfBirth  = page.locator("select[name='months']");
        this.yearOfBirth = page.locator("select[name= 'years']");
        this.signUpForNewsletter = page.locator("input[name='newsletter']");
        this.registerButton = page.locator("button[name='submitAccount']");

    }

    public CreateAnAccountFormSection clickTitle() {
        title.click();
        return this;
    }

}
