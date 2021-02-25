package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageTests extends TestBase {
    RegistrationPage registrationPage;

    @Test
    @DisplayName("Filling form with data test")
    @Tags({@Tag("positive")})
    void fillingFormWithDataTest() {
        registrationPage = new RegistrationPage();

        registrationPage.openPage();
        registrationPage.fillForm();
        registrationPage.submitData();
        registrationPage.verifySubmition(); //yep, do not put assertions into test methods
    }

    @Test
    @DisplayName("Just random failed test on purpose")
    @Tags({@Tag("failed")})
    void fillingFormFailedTest() {
        registrationPage = new RegistrationPage();

        registrationPage.openPage();
        registrationPage.fillForm();
        registrationPage.verifySubmition();
    }
}
