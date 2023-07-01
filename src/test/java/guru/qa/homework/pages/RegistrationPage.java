package guru.qa.homework.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import guru.qa.homework.pages.component.calendar.CalendarComponent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userMobNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsContainer = $("#subjectsContainer"),
            uploadPictureBTN = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            stateDropDown = $("#state"),
            cityDropDown = $("#city"),
            submitButton = $("#submit"),
            tableResponsive = $(".table-responsive");


    private final ElementsCollection hobbiesList = $$("#hobbiesWrapper [class*='custom-checkbox']");


    @Step("Open main page")
    public RegistrationPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Set firstname {name}")
    public RegistrationPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Set lastname {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Set email {email}")
    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Select gender {gender}")
    public RegistrationPage selectGender(String gender) {
        genderWrapper.$(byTextCaseInsensitive(gender)).click();
        return this;
    }

    @Step("Set mobile number: {tenDigitsMobileNumber}")
    public RegistrationPage setUserMobNumber(String tenDigitsMobileNumber) {
        userMobNumber.setValue(tenDigitsMobileNumber);
        return this;
    }

    @Step("Set subject: {subject}")
    public RegistrationPage subjectSet(String subject) {
        subjectsContainer.click();
        subjectsContainer.$("#subjectsInput").setValue(subject).sendKeys(Keys.ARROW_DOWN);
        subjectsContainer.$("#subjectsInput").pressEnter();
        return this;
    }

    @Step("Pick a hobby: {hobby}")
    public RegistrationPage pickHobbies(String hobby) {
        List<String> hobbies = new ArrayList<>(Arrays.asList(hobby.split("\\s*,\\s*")));
        for (String h : hobbies) {
            hobbiesList.find(text(h)).click();
        }
        return this;

    }

    @Step("Upload a picture: {filePath}")
    public RegistrationPage uploadPicture(String filePath) {
        uploadPictureBTN.uploadFile(new File(filePath));
        return this;
    }

    @Step("Set address {address}")
    public RegistrationPage setCurrentAddress(String address) {
        currentAddressField.setValue(address);
        return this;
    }

    @Step("Select state {state} and city {city}")
    public RegistrationPage selectStateAndCity(String state, String city) {
        stateDropDown.click();
        $(byText(state)).click();
        $(byText(state)).click();
        cityDropDown.click();
        cityDropDown.$(byText(city)).click();
        return this;
    }

    @Step("Press submit button")
    public RegistrationPage pressSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Set date of birth: {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Verification: {key} and {value}")
    public RegistrationPage formVerificationWindow(String key, String value) {
        tableResponsive.$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }

    @Attachment(value = "input_data_verification_window", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
