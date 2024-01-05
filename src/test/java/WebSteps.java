import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for {REPO}")
    public void searchForRepo(String REPO) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(REPO);
        $("#query-builder-test").submit();

    }

    @Step("Click on repo link {REPO}")
    public void clickRepo(String REPO) {
        $(linkText(REPO)).click();

    }

    @Step("Click to issue-tab")
    public void clickIssue() {
        $("#issues-tab").click();

    }

    @Step("Check if an issue exist {issue}")
    public void checkByIssueName(String ISSUE) {
        $(withText(StepTests.ISSUE)).should(Condition.exist);

    }


}
