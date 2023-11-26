package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import data.UserData;

public class TextBoxTests extends BaseTest {
    @Test
    @DisplayName("Поля формы можно заполнить")
    void formFieldsCanBeFilledInTest() {
        TextBoxPage textBoxPage = new TextBoxPage();
        UserData userData = new UserData();

        textBoxPage
                .openPageAndVerifyTitle()
                .setUserName(userData.firstName + userData.lastName)
                .setEmail(userData.email)
                .setCurrentAddress(userData.address)
                .setPermanentAddress(userData.address)
                .checkTheSubmitButtonIsVisible();

    }
}
