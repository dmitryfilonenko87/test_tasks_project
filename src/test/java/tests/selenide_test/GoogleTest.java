package tests.selenide_test;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {

    final private static String NAME = "Dima";
    final private static String FULLNAME = "Dmitry";

    @Test
    public void searchByName() {
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue(NAME).pressEnter();
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldHave(text(NAME));
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldNotHave(text(FULLNAME));
    }

    @Test
    public void searchByFullName() {
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue(FULLNAME).pressEnter();
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldHave(text(FULLNAME));
        $x("//h3[(@class='LC20lb MBeuO DKV0Md')]").shouldNotHave(text(NAME));
    }

    @Test
    public void checkMouseCursor() {
        open("https://www.google.com/");
        $x("//input[@name='q']").getAttribute("title").equals("Поиск");
        $x("//input[@name='q']").hover();
    }

    @Test
    public void checkMouseClick() {
        open("https://www.google.com/");
        $x("//input[@name='q']").setValue("Google").pressEnter();
        $x("//img[@class='jfN4p']").click();
        $x("//img[@class='lnXdpd']").shouldBe(Condition.visible);
        $x("//img[@class='jfN4p']").shouldNotBe(Condition.visible);
    }
}
