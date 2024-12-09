package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.sections.ContactUsFormSection;


public class ContactUsPage {

    @Getter
    private ContactUsFormSection contactUsFormSection;

    public ContactUsPage(Page page) {
        this.contactUsFormSection = new ContactUsFormSection(page);
    }
}
