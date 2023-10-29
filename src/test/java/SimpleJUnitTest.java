import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {
    @BeforeAll
    public static void configureTests(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl ="https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //closing ads and footer
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Mary");
        $("#lastName").setValue("Poppins");
        $("#userEmail").setValue("mary.poppins@pochta.ru");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");

        //setting date in calendar
        $("#dateOfBirthInput").setValue("selenide");
        $(".react-datepicker__year-select").click();
        $(byValue("1999")).click();
        $(".react-datepicker__month-select").click();
        $(byValue("2")).click();
        $(".react-datepicker__day--019").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        //ticking check-box
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/shrek.png"));
        $("#currentAddress").setValue("Vladivostok 2000");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Jaipur").pressEnter();
        $("#submit").click();

        //check for equality
        $(".table-responsive").shouldHave(
                text("Mary Poppins"),
                text("mary.poppins@pochta.ru"),
                text("Female"),
                text("1234567890"),
                text("19 March,1999"),
                text("Sports"),
                text("shrek.png"),
                text("Vladivostok 2000"),
                text("Rajasthan Jaipur")
                );
    }
    @AfterAll
    public static void clearAll() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
        closeWebDriver();

    }
}
