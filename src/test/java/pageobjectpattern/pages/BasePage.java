package pageobjectpattern.pages;

import com.microsoft.playwright.Page;
import common.BaseTest;

public class BasePage {

    protected Page page;

    public BasePage (Page page) {
        this.page = page;
    }
}
