package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.BasePage;

public class ContactUsFormSection extends BasePage {

    @Getter
    private Locator errorMessage;

    private Locator sendButton;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
