import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTests {


    public static final String REPO = "Kachanok/qa_guru_allure_hw";
    public static final String ISSUE = "TestIssue";

    @Test
    public void lambdaStepTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search for repo" + REPO, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").submit();
        });
        step("Click on repo link" + REPO, () -> {
            $(linkText(REPO)).click();
        });
        step("Click to issue-tab", () -> {
            $("#issues-tab").click();
        });
        step("Check if an issue exist" + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });

    }

    @Test
    public void annotatedStepTest(){
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openMainPage();
        steps.searchForRepo(REPO);
        steps.clickRepo(REPO);
        steps.clickIssue();
        steps.checkByIssueName(ISSUE);


    }
}
