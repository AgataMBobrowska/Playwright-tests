package pageobjectpattern.pages.sections;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import pageobjectpattern.pages.BasePage;

import java.nio.file.Paths;

@Getter
public class ContactUsFormSection extends BasePage {

    private Locator errorMessage;

    private Locator sendButton;

    private Locator subjectHeading;

    private Locator emailAddressInput;

    private Locator orderReferenceInput;

    private Locator fileUploadInput;

    private Locator messageText;

    private Locator confirmationMessage;

    public ContactUsFormSection(Page page) {
        super(page);
        this.sendButton = page.locator("#submitMessage");
        this.errorMessage = page.getByText("Invalid email address.");
        this.sendButton = page.locator("#submitMessage");
        this.subjectHeading =  page.locator("#id_contact");
        this.emailAddressInput = page.getByLabel("Email address");
        this.orderReferenceInput = page.locator("input[class='form-control grey']");
        this.fileUploadInput = page.locator("#fileUpload");
        this.messageText = page.locator("textarea[class='form-control']");
        this.confirmationMessage = page.getByText("Your message has been successfully sent to our team.");
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void selectSubjectHeading(String option) {subjectHeading.selectOption(option);}

    public void enterEmailAddress(String email) { emailAddressInput.fill(email);}

    public void enterOrderReference(String orderReference) {orderReferenceInput.fill(orderReference);}

    public void selectFileToUpload(String filePath) {fileUploadInput.setInputFiles(Paths.get(filePath)); }

    public void enterMessage(String message) { messageText.fill(message);}


}
