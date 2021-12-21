package trainingproject.qaguru;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class HW_4 {

    @Test
    void shouldGithub() {
        //открыть github.com
        open("https://github.com/");
        //Ввести в строку поиска "selenide", нажать enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //открыть первый результат вывода
        Selenide.$$(".repo-list li").first().$("a").click();
        //перейти на вкладку wiki
        $("#wiki-tab").click();
        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").click();
        $("#wiki-pages-filter").setValue("so");
        // Открыть страницу SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // Проверить, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));


    }
}