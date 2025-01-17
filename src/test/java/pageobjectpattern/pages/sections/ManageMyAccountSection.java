package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.BasePage;
import pageobjectpattern.pages.locators.ManageMyAccountSectionLocators;

@Getter
public class ManageMyAccountSection extends BasePage {

    private ManageMyAccountSectionLocators locators;

    public ManageMyAccountSection(Page page){
        super(page);
        this.locators = new ManageMyAccountSectionLocators(page);
    }
}
