package tests.selenide_test;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static enums.Constant.Name.*;

public class GoogleSearchTest {

    @Test
    public void searchByName() {
        //check the output list contains NAME and doesn't contains FULL_NAME
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue(NAME).pressEnter();
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldHave(text(NAME));
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldNotHave(text(FULL_NAME));
    }

    @Test
    public void searchByFullName() {
        //check the output list contains FULL_NAME and doesn't contains NAME
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue(FULL_NAME).pressEnter();
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldHave(text(FULL_NAME));
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldNotHave(text(NAME));
    }

    @Test
    public void checkMouseCursor() {
        //check the clue with text "Поиск" after hover the cursor on the input field
        open("https://www.google.com/");
        $x("//input[@name='q']").getAttribute("title").equals("Поиск");
        $x("//input[@name='q']").hover();
    }

    @Test
    public void checkMouseClick() {
        //check return to the previous page after click on the logo in the upper left side
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue("Google").pressEnter();
        $x("//img[@class='jfN4p']").click();
        $x("//img[@class='lnXdpd']").shouldBe(Condition.visible);
        $x("//img[@class='jfN4p']").shouldNotBe(Condition.visible);
    }
}
