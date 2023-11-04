import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {
    public static String firstName = "Mary";
    public static String lastName = "Poppins";
    public static String email = "mary.poppins@pochta.ru";
    public static String userNumber = "1234567890";
    public static String currentAddress = "Vladivostok 2000";
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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(userNumber);
        //setting date in calendar
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--019:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Maths").pressEnter();
        //ticking check-box
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("shrek.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Jaipur").pressEnter();
        $("#submit").click();
        //check for equality
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Mary Poppins"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("19 March,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("shrek.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));

        }
    @AfterAll
    public static void clearAll() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
        closeWebDriver();

    }
}
