package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class DostavkaIOplataPage {
    public final String RETURN_PAGE = "/oplata-i-dostavka/return/";
    private SelenideElement regionMoscowLink = $("[href='#collapse-content-Moscow']");
    private SelenideElement returnOptionsButton = $(".delivery__side-menu");

    public DostavkaIOplataPage openAndVerifyPage() {
        open("/oplata-i-dostavka/");
        webdriver().shouldHave(url("https://sport-marafon.ru" + "/oplata-i-dostavka/"));
        return this;
    }

    public ReturnInstructionsPage navigateTo(String value){
        returnOptionsButton.click();
        webdriver().shouldHave(url("'https://sport-marafon.ru'" + value));
        return new ReturnInstructionsPage();
    }

}
