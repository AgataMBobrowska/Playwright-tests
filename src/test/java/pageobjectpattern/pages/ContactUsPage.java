package pageobjectpattern.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class ContactUsPage {

    private Page page;

    private Locator sendButton;

    @Getter
    private Locator errorMessage;

    public ContactUsPage(Page page) {
        this.page = page;
        this.sendButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
    }

    public void clickSendButton() {
        sendButton.click();
    }


}
