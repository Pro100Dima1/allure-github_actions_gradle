import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LablesTest {

    @Test
    @Feature("allure-gradle")
    @Story("Проверка гитхаба")
    @Owner("Pro100Dima")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https//testing.github.com")
    @DisplayName("Проверка статических лейблов")
    public void testStaticLables() {

    }

    @DisplayName("Проверка деплоя")
    @Test
    public void testDynamicLables(){
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
