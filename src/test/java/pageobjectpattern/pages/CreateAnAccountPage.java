package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.CreateAnAccountFormSection;

public class CreateAnAccountPage extends BasePage{

    @Getter
    private CreateAnAccountFormSection createAnAccountFormSection;

    public CreateAnAccountFormSection(Page page){
        super(page);
        this.createAnAccountFormSection = new CreateAnAccountFormSection(page);
    }
}
