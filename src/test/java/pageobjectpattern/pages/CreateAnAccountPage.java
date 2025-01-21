package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.CreateAccountFormSection;

@Getter
public class CreateAnAccountPage extends BasePage {

    private CreateAccountFormSection createAnAccountFormSection;

    public CreateAnAccountPage(Page page){
        super(page);
        this.createAnAccountFormSection = new CreateAccountFormSection(page);
    }
}
