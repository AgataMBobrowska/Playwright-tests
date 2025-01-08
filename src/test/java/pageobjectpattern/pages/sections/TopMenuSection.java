package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobjectpattern.pages.BasePage;
import pageobjectpattern.pages.ContactUsPage;
import pageobjectpattern.pages.CreateAnAccountPage;

public class  TopMenuSection extends BasePage {

    private Locator contactUsLink;

    private Locator signInLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
        signInLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in"));
    }

    public ContactUsPage clickContactUsLink(){
        contactUsLink.click();
        return new ContactUsPage(page);
    }

    public CreateAnAccountPage clickSignInLink() {
       signInLink.click();
       return new CreateAnAccountPage(page);
    }
}
