package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pageobjectpattern.pages.BasePage;
import pageobjectpattern.pages.ContactUsPage;

public class TopMenuSection extends BasePage {

    private Locator contactUsLink;

    public TopMenuSection(Page page) {
        super(page);
        this.contactUsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact us"));
    }

    public ContactUsPage clickContactUsLink(){
        contactUsLink.click();
        return new ContactUsPage(page);
    }
}
