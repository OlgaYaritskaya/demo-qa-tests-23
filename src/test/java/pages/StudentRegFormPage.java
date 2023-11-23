package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class StudentRegFormPage {
    CalendarComponent calendar = new CalendarComponent();
    private final String PAGE_TITLE = "Student Registration Form";
    private SelenideElement
            pageTitleLocator = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            subjectsInput = $("#subjectsInput"),
            pictureUploadButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateDropDown = $("#state").$("#react-select-3-input"),
            cityDropDown = $("#city").$("#react-select-4-input"),
            submitButton = $("#submit");

    public StudentRegFormPage openPageAndVerifyTitle() {
        open("/automation-practice-form");
        pageTitleLocator.shouldHave(text(PAGE_TITLE));
        webdriver().shouldHave(url("https://demoqa.com" + "/automation-practice-form"));
        return this;
    }

    public StudentRegFormPage removeAdsAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove");
        return this;
    }

    public StudentRegFormPage setFirstAndLastName(String value1, String value2) {
        firstNameInput.sendKeys(value1);
        lastNameInput.sendKeys(value2);
        return this;
    }

    public StudentRegFormPage setEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    public StudentRegFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public StudentRegFormPage setMobile(String value) {
        mobileInput.sendKeys(value);
        return this;
    }

    public StudentRegFormPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public StudentRegFormPage setHobby(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public StudentRegFormPage setDateOfBirth(String year, String month, String day) {
        calendar.SetDate(year, month, day);
        return this;
    }

    public StudentRegFormPage uploadPicture(String value) {
        pictureUploadButton.uploadFromClasspath(value);
        return this;
    }

    public StudentRegFormPage setCurrentAddress(String value) {
        addressInput.sendKeys(value);
        return this;
    }

    public StudentRegFormPage setState(String value) {
        stateDropDown.setValue(value).pressEnter();
        return this;
    }

    public StudentRegFormPage setCity(String value) {
        cityDropDown.setValue(value).pressEnter();
        return this;
    }
    public StudentRegFormPage submit() {
        submitButton.click();
        return this;
    }
}
