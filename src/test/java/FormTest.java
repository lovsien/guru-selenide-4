import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @Test
    void submitCompletedFormSuccessfullyTest() {
        open("https://demoqa.com/automation-practice-form");
        $("div.practice-form-wrapper h5").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue("Tanya");
        $("#lastName").setValue("Garbaruk");

        $("#userEmail").setValue("test@email.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2000");
        $(".react-datepicker__month-select").selectOptionContainingText("May");
        $(".react-datepicker__day--004").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("[for=hobbies-checkbox-2]").click();

        File photo = new File("src/test/resources/profile_photo.jpg");
        $("#uploadPicture").uploadFile(photo);

        $("#currentAddress").setValue("Lorem ipsum dolor");

        $("#state").scrollTo();
        $$(".css-1wy0on6").get(1).click();
        $("#react-select-3-option-0").click();

        $$(".css-1wy0on6").get(2).click();
        $("#react-select-4-option-0").click();

        $("#submit").shouldBe(visible).click();
    }
}
