import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.GithubRepoPage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssueTestAllureStepsAnnotation {

    GithubRepoPage githubRepoPage = new GithubRepoPage();

    @BeforeEach
    void prediction() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void issueAllureStepsAnnotanionTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        githubRepoPage
                .openGithub()
                .searchFill("sbarvin/qa_quru_homework6")
                .searchSubmit()
                .findLink("Issues");
    }
}
