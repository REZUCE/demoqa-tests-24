package guru.qa;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestFirstHomeWorkTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager"; // waiting load site page
        Configuration.holdBrowserOpen = true; // don t close browser
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vladimir");
        $("#lastName").setValue("Lisicyn");
        $("#userEmail").setValue("test@test.ru");
        $x("//*[@for='gender-radio-1']").click();
        $("#userNumber").setValue("9773183546");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("May");
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//*[@for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFile(new File("src/test/data/lis.jpg"));
        $("#currentAddress").setValue("street test 24");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter().pressEnter();
//        $("#submit").click();

        $(".table tbody tr:nth-child(1)").shouldHave(text("Vladimir Lisicyn"));
        $(".table tbody tr:nth-child(2)").shouldHave(text("test@test.ru"));
        $(".table tbody tr:nth-child(3)").shouldHave(text("Male"));
        $(".table tbody tr:nth-child(4)").shouldHave(text("9773183546"));
        $(".table tbody tr:nth-child(5)").shouldHave(text("1 May,2004"));
        $(".table tbody tr:nth-child(6)").shouldHave(text("Maths"));
        $(".table tbody tr:nth-child(7)").shouldHave(text("Reading"));
        $(".table tbody tr:nth-child(8)").shouldHave(text("lis.jpg"));
        $(".table tbody tr:nth-child(9)").shouldHave(text("street test 24"));
        $(".table tbody tr:nth-child(10)").shouldHave(text("NCR Noida"));
    }
}
