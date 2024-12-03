package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class ContactUsFormSection {

    private Page page;

    @Getter
    private Locator errorMessage;

    private Locator sendButton;

    public ContactUsFormSection(Page page) {
        this.page = page;
        this.sendButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
    }

    public void clickSendButton() {
        sendButton.click();
    }
}
