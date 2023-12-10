package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ReturnInstructionsPage {
    private final SelenideElement TITLE = $(".h1");
    private final SelenideElement EXCHANGE_GOODS_QUERY =
            $("[href*='medialibrary/sport-marafon_exchange-edit.pdf']");
    private final SelenideElement REFUND_GOODS_QUERY =
            $("[href*='/upload/medialibrary/sport-marafon_return-edit']");

    public ReturnInstructionsPage verifyUrl() {
        webdriver().shouldHave(url("https://sport-marafon.ru" + "/oplata-i-dostavka/return"));
        return this;
    }

    public ReturnInstructionsPage verifyTitle(String value) {
        TITLE.shouldHave(Condition.text(value));
        return this;
    }

    public ReturnInstructionsPage shouldContainRefundAndExchangeRequestSamples() {
        EXCHANGE_GOODS_QUERY.shouldBe(Condition.visible);
        REFUND_GOODS_QUERY.shouldBe(Condition.visible);
        return this;
    }

}
