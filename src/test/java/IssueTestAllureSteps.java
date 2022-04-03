import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueTestAllureSteps {

    @BeforeEach
    void prediction() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void issueAllureStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу github", () -> {
            open("https://github.com");
        });

        step("В поле Поиск вбить запрос", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("sbarvin/qa_quru_homework6");
        });

        step("Нажать на поиск", () -> {
            $(".header-search-input").submit();
        });

        step("Проверить наличие вкладки Issues", () -> {
            $(By.partialLinkText("Issues")).should(Condition.visible);
        });

    }
}
