import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {
    private static final String SEARCH = "Python-projects";
    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем гитхаб", () -> {
            open("https://github.com/Pro100Dima1?tab=repositories");
            attachment("Source", webdriver().driver().source());  // Напрямую сразу вызываем метод и прихраниваем аттач в отчет. Именно код страницы Source
        });

    }

    @Test
    public void testAnnotatedAttachments(){
        WebSteps webSteps = new WebSteps();

        webSteps.openUrl();
        webSteps.takeScreenshot(); // Вызываем аттач через аннотацию в другом классе. Прикрепили сам скрин
    }
}
