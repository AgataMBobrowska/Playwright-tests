package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobjectpattern.pages.BasePage;
import pageobjectpattern.pages.MyAccountPage;


public class CreateAnAccountFormSection extends BasePage {

    private Locator emailInput;

    private Locator createAnAccountButton;

    private Locator titleMr;

    private Locator titleMrs;

    private Locator firstName;

    private Locator lastName;

    private Locator providePassword;

    private Locator dayOfBirth;

    private Locator monthOfBirth;

    private Locator yearOfBirth;

 //   private Locator signUpForNewsletter;

    private Locator registerButton;

    public  CreateAnAccountFormSection(Page page) {
        super(page);
        this.emailInput = page.locator("input[id='email_create']");
        this.createAnAccountButton = page.locator("button[id='SubmitCreate']");
        this.titleMr = page.locator("input[id='id_gender1']");
        this.titleMrs = page.locator("input[id='id_gender2']");
        this.firstName = page.getByText("First name");          //div[class='required form-group form-error']
        this.lastName = page.getByText("Last name");
        this.providePassword = page.locator("input[type='password']");
        this.dayOfBirth = page.locator("#days");
        this.monthOfBirth  = page.locator("#months");
        this.yearOfBirth = page.locator("#years");
 //       this.signUpForNewsletter = page.locator("input[name='newsletter']");
        this.registerButton = page.locator("button[name='submitAccount']");
    }

    public CreateAnAccountFormSection enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    public CreateAnAccountFormSection clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return this;
    }

    public CreateAnAccountFormSection checkTitleMr() {
        titleMr.check();
        return this;
    }

    public CreateAnAccountFormSection checkTileMrs()  {
        titleMrs.check();
        return this;
    }

    public CreateAnAccountFormSection enterFirstName(String firstNameText) {
        firstName.fill(firstNameText);
        return this;
    }

    public CreateAnAccountFormSection enterLastName(String lastNameText) {
        lastName.fill(lastNameText);
        return this;
    }

    public CreateAnAccountFormSection enterPassword(String enterPassword) {
        providePassword.fill(enterPassword);
        return this;
    }

    public CreateAnAccountFormSection enterDateOfBirth(String day, String month, String year) {
        dayOfBirth.selectOption(day);
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        registerButton.click();
        return new MyAccountPage(page);
    }
}
