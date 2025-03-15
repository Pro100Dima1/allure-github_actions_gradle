import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String SEARCH = "Python-projects";
    @Test
    public void testLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем гитхаб", () -> {
            open("https://github.com/Pro100Dima1?tab=repositories");
        });
        step("Пишем в поиск Python и жмем ентер", () -> {
            $("#your-repos-filter").sendKeys(SEARCH);
            $("#your-repos-filter").submit();
        });
        step("Проверяем наличие проекта с именем " + SEARCH, () -> {
            $(linkText(SEARCH)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedSteps(){
        WebSteps webSteps = new WebSteps();

        webSteps.openUrl();
        webSteps.inputProjectNameIntoSearhcfield(SEARCH);
        webSteps.serchPythonProject(SEARCH);
    }
}
