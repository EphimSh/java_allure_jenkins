package guru.qa.homework.pages.component.calendar;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTextCaseInsensitive;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


    private final SelenideElement datePicker = $("#dateOfBirth-wrapper");


    public CalendarComponent setDate(String day, String month, String year) {

        datePicker.$$("[class*='year-select'] option").find(text(year)).click();
        datePicker.$("div[class*='month']").$(byTextCaseInsensitive(month)).click();
        //here we need change first letter of our month 👇 to uppercase
        datePicker.$$(" [aria-label*='" + (month.substring(0, 1).toUpperCase() + month.substring(1)) + "'] ")
                .findBy(text(day)).click();
        return this;
    }
}
