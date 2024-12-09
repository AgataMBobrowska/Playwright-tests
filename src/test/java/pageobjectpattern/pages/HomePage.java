package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.TopMenuSection;

public class HomePage {

    @Getter
    private TopMenuSection topMenuSection;

    public HomePage(Page page) {
        this.topMenuSection = new TopMenuSection(page);
    }
}
