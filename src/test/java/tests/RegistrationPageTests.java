package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationPageTests {
    RegistrationPage registrationPage;

    @Test
    void fillingFormWithDataTest () {
        registrationPage = new RegistrationPage();

        registrationPage.openPage();
        registrationPage.fillForm();
        registrationPage.submitData();
        registrationPage.verifySubmition();
    }
}
