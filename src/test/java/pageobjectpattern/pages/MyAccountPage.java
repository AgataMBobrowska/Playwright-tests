package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.ManageMyAccountSection;

@Getter
public class MyAccountPage extends BasePage {

    private ManageMyAccountSection manageMyAccountSection;

    public MyAccountPage(Page page){
        super(page);
        this.manageMyAccountSection = new ManageMyAccountSection(page);
    }
}
