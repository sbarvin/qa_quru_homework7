package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubRepoPage {

    //locstors
    private final SelenideElement searchInput = $(".header-search-input");

    //actions
    @Step("Открыть главную страницу github")
    public GithubRepoPage openGithub() {
        open("https://github.com");
        return this;
    }

    @Step("В поле Поиск вбить запрос {text}")
    public GithubRepoPage searchFill(String text) {
        searchInput.click();
        searchInput.sendKeys(text);
        return this;
    }

    @Step("Нажать на поиск")
    public GithubRepoPage searchSubmit() {
        searchInput.submit();
        return this;
    }

    @Step("Проверить наличие вкладки {text}")
    public GithubRepoPage findLink(String text) {
        $(By.partialLinkText(text)).should(Condition.visible);
        return this;
    }

}
