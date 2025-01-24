package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobjectpattern.pages.BasePage;
import pageobjectpattern.pages.MyAccountPage;

import java.time.Month;


public class CreateAccountFormSection extends BasePage {

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

    private Locator signUpForNewsletter;

    private Locator registerButton;

    public CreateAccountFormSection(Page page) {
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
        this.signUpForNewsletter = page.locator("input[name='newsletter']");
        this.registerButton = page.locator("button[name='submitAccount']");
    }

    public CreateAccountFormSection enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    public CreateAccountFormSection clickCreateAnAccountButton() {
        createAnAccountButton.click();
        return this;
    }

    public CreateAccountFormSection checkTitleMr() {
        titleMr.check();
        return this;
    }

    public CreateAccountFormSection checkTileMrs()  {
        titleMrs.check();
        return this;
    }

    public CreateAccountFormSection enterFirstName(String firstNameText) {
        firstName.fill(firstNameText);
        return this;
    }

    public CreateAccountFormSection enterLastName(String lastNameText) {
        lastName.fill(lastNameText);
        return this;
    }

    public CreateAccountFormSection enterPassword(String enterPassword) {
        providePassword.fill(enterPassword);
        return this;
    }

    public CreateAccountFormSection enterDateOfBirth(int day, int month, int year) {
        dayOfBirth.selectOption(String.valueOf(day));
        monthOfBirth.selectOption(String.valueOf(month));
        yearOfBirth.selectOption(String.valueOf(year));
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        registerButton.click();
        return new MyAccountPage(page);
    }
}
