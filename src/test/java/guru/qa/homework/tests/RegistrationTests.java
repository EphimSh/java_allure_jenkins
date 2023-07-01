package guru.qa.homework.tests;

import guru.qa.homework.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static guru.qa.homework.utils.RandomUtils.*;

public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    public static String imgFilePath = "src/test/resources/haha.jpg";
    private static String imgFileName = imgFilePath.substring(imgFilePath.lastIndexOf("/") + 1);

    @Test
    @Feature("Registration form for automation practice")
    @Story("Successful registration")
    @Owner("EphimSh")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "automation-practice-form", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Successful registration form test")
    void mySuccessfulRegistrationFormTest(){

        String firstname = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomGender(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                day = String.valueOf(faker.random().nextInt(1,28)),
                month = getRandomMonth(),
                year = String.valueOf(getRandomInt(1900, 2100)),
                subject = getRandomSubject(),
                hobby = getRandomHobby(),
                address = faker.address().fullAddress(),
                state = getRandomState(),
                city = getRandomCity();




        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmail(userEmail)
                .selectGender(gender)
                .setUserMobNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .subjectSet(subject)
                .pickHobbies(hobby)
                .uploadPicture(imgFilePath)
                .setCurrentAddress(address)
                .selectStateAndCity(state, city)
                .pressSubmitButton();


        registrationPage
                .formVerificationWindow("Student Name", firstname + " " + lastName)
                .formVerificationWindow("Student Email", userEmail)
                .formVerificationWindow("Gender", gender)
                .formVerificationWindow("Mobile", userNumber)
                .formVerificationWindow("Date of Birth", day + " " + month +"," + year)
                .formVerificationWindow("Subjects", subject)
                .formVerificationWindow("Hobbies", hobby)
                .formVerificationWindow("Picture", imgFileName)
                .formVerificationWindow("Address", address)
                .formVerificationWindow("State and City", state + " " + city);
        registrationPage.attachScreenshot();
    }
}
