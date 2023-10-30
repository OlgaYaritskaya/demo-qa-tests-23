import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {
    public static String _firstName = "Mary";
    public static String _lastName = "Poppins";
    public static String _email = "mary.poppins@pochta.ru";
    @BeforeAll
    public static void configureTests(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl ="https://demoqa.com";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //closing ads and footer
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(_firstName);
        $("#lastName").setValue(_lastName);
        $("#userEmail").setValue(_email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        //setting date in calendar
        $("#dateOfBirthInput").setValue("selenide");
        $(".react-datepicker__year-select").click();
        $(byValue("1999")).click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        //ticking check-box
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("shrek.png");
        $("#currentAddress").setValue("Vladivostok 2000");
        $("#state").click();
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Jaipur").pressEnter();
        $("#submit").click();
        //check for equality
        $(".table-responsive").shouldHave(text("Mary Poppins"));
        $(".table-responsive").shouldHave(text("mary.poppins@pochta.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("19 March,1999"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("shrek.png"));
        $(".table-responsive").shouldHave(text("Vladivostok 2000"));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));
    }
    @AfterAll
    public static void clearAll() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
        closeWebDriver();

    }
}
