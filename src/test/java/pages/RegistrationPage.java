package pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.address().fullAddress();

    @Step("Open registration form")
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Step("Fill form with data")
    public void fillForm() {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("a@a.com");
        $(".custom-control-label").shouldHave(text("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("3");
        $(".react-datepicker__year-select").selectOptionByValue("2007");
        $x("//*[@class='react-datepicker__day react-datepicker__day--017']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[text()='Music']").click();
        $x("//input[@type='file']").uploadFile(new File("src/test/resources/download.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#submit").scrollTo();
        $x("//div[text()='Select State']").click();
        $("#react-select-3-option-2").click();
        $x("//div[text()='Select City']").click();
        $("#react-select-4-option-1").click();
    }

    @Step("Submit data")
    public void submitData() {
        $("#submit").click();
    }

    //Well, actually it's a bad practice to add assertions into test methods.. Let's say I did it for the science!
    @Step("Verify that form was successfully submitted")
    public void verifySubmition() {
        $x("//td[text()='Student Name']").parent().shouldHave(text(firstName + " " + lastName));
        $x("//td[text()='a@a.com']").shouldBe(visible);
        $x("//td[text()='Mobile']").parent().shouldHave(text(phoneNumber));
        $x("//td[text()='Male']").shouldBe(visible);
        $x("//td[text()='17 April,2007']").shouldBe(visible);
        $x("//td[text()='English']").shouldBe(visible);
        $x("//td[text()='Music']").shouldBe(visible);
        $x("//td[text()='download.jpg']").shouldBe(visible);
        $x("//td[text()='Address']").parent().shouldHave(text(currentAddress));
        $x("//td[text()='Haryana Panipat']").shouldBe(visible);
    }
}
