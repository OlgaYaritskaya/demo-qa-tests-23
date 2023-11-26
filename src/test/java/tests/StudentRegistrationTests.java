package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegFormPage;
import data.UserData;
import pages.components.ResultTableComponent;

public class StudentRegistrationTests extends BaseTest {
    @Test
    @DisplayName("Пользователь успешно зарегистрирован")
    void successfullUserRegistrationTest() {
        StudentRegFormPage studentRegFormPage = new StudentRegFormPage();
        UserData userData = new UserData();
        ResultTableComponent resultTable = new ResultTableComponent();

        studentRegFormPage
                .openPageAndVerifyTitle()
                .removeAdsAndFooter()
                .setFirstAndLastName(userData.firstName, userData.lastName)
                .setEmail(userData.email)
                .setGender(userData.gender)
                .setMobile(userData.mobile)
                .setSubject(userData.subject)
                .setDateOfBirth(userData.year, userData.month, userData.day)
                .setHobby(userData.hobby)
                .uploadPicture("shrek.png")
                .setCurrentAddress(userData.address)
                .setState(userData.state)
                .setCity(userData.city)
                .submit();

        resultTable
                .checkResult("Student Name", userData.firstName + " " + userData.lastName)
                .checkResult("Student Email", userData.email)
                .checkResult("Gender", userData.gender)
                .checkResult("Mobile", userData.mobile)
                .checkResult("Date of Birth", userData.day + " " + userData.month + "," + userData.year)
                .checkResult("Subjects", userData.subject)
                .checkResult("Hobbies", userData.hobby)
                .checkResult("Picture", "shrek.png")
                .checkResult("Address", userData.address)
                .checkResult("State and City", userData.state + " " + userData.city);
    }

    @Test
    @DisplayName("Заполнены только обязательные поля")
    void onlyMandatoryFieldsAreFilledInTest() {
        StudentRegFormPage studentRegFormPage = new StudentRegFormPage();
        UserData userData = new UserData();
        ResultTableComponent resultTable = new ResultTableComponent();

        studentRegFormPage
                .openPageAndVerifyTitle()
                .removeAdsAndFooter()
                .setFirstAndLastName(userData.firstName, userData.lastName)
                .setEmail(userData.email)
                .setGender(userData.gender)
                .setMobile(userData.mobile)
                .submit();

        resultTable
                .checkResult("Student Name", userData.firstName + " " + userData.lastName)
                .checkResult("Student Email", userData.email)
                .checkResult("Gender", userData.gender);
    }

    @Test
    @DisplayName("Какая-то негативная проверка ")
    @Tag("Negative")
    void invalidFileTypeUploadTest() {
        StudentRegFormPage studentRegFormPage = new StudentRegFormPage();
        UserData userData = new UserData();
        studentRegFormPage
                .openPageAndVerifyTitle()
                .removeAdsAndFooter()
                .setFirstAndLastName(userData.firstName, userData.lastName)
                .setMobile(userData.mobile)
                .setEmail("pochta@pochta")
                .setGender(userData.gender)
                .submit();

        studentRegFormPage.verifyTheEmailFieldIsRed();
    }
}
