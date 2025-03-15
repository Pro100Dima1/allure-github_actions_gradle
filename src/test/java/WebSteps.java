import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем github")
    public void openUrl() {
        open("https://github.com/Pro100Dima1?tab=repositories");
    }

    @Step("Пишем в поиск Python и жмем ентер {repo}")
    public void inputProjectNameIntoSearhcfield(String repo) {
        $("#your-repos-filter").sendKeys(repo);
        $("#your-repos-filter").submit();
    }

    @Step("Проверяем наличие проекта с именем {repo}")
    public void serchPythonProject(String repo) {
        $(linkText(repo)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
