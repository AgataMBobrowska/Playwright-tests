package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.CreateAnAccountFormSection;

@Getter
public class CreateAnAccountPage extends BasePage {

    private CreateAnAccountFormSection createAnAccountFormSection;

    public CreateAnAccountPage(Page page){
        super(page);
        this.createAnAccountFormSection = new CreateAnAccountFormSection(page);
    }
}
