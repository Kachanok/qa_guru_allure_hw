import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for {repo}")
    public void searchForRepo(String repo) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();

    }

    @Step("Click on repo link {repo}")
    public void clickRepo(String repo) {
        $(linkText(repo)).click();

    }

    @Step("Click to issue-tab")
    public void clickIssue() {
        $("#issues-tab").click();

    }

    @Step("Check if an issue exist {issue}")
    public void checkByIssueName(String issue) {
        $(withText(StepTests.issue)).should(Condition.exist);

    }


}
