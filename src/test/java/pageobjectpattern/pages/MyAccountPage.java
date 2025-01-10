package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import pageobjectpattern.pages.sections.ManageMyAccountSection;

public class MyAccountPage extends BasePage {

    private ManageMyAccountSection manageMyAccountSection;

    public MyAccountPage(Page page){
        super(page);
        this.manageMyAccountSection = new ManageMyAccountSection(page);
    }
}
