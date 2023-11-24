package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TextBoxPage {
private SelenideElement
    pageTitleLocator = $(".main-header"),
    userNameInput = $("#userName"),
    userEmailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    submitButton = $("#submit");

private final String PAGE_TITLE = "Text Box";
public TextBoxPage openPageAndVerifyTitle() {
    open("/text-box");
    pageTitleLocator.shouldHave(text(PAGE_TITLE));
    webdriver().shouldHave(url("https://demoqa.com" + "/text-box"));
    return this;
}
public TextBoxPage setUserName(String value) {
    userNameInput.sendKeys(value);
    return this;
}
public TextBoxPage setEmail(String value) {
    userEmailInput.sendKeys(value);
    return this;
}
public TextBoxPage setCurrentAddress(String value) {
    currentAddressInput.sendKeys(value);
    return this;
}
public TextBoxPage setPermanentAddress(String value) {
    permanentAddressInput.sendKeys(value);
    return this;
}
public TextBoxPage checkTheSubmitButtonIsVisible() {
    submitButton.shouldBe(visible);
    return this;
}
}
