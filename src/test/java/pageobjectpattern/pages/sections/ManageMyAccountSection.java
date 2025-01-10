package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pageobjectpattern.pages.BasePage;

public class ManageMyAccountSection extends BasePage {

    private Locator accountCreatedMessage;

    private Locator myAccountLabel;

    public ManageMyAccountSection(Page page){
        super(page);
        this.accountCreatedMessage = page.getByText("Your account has been created");
        this.myAccountLabel = page.locator("h1[class=page-heading");
    }
}
