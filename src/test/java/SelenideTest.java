import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    @DisplayName("Простой selenide тест на проверку названия issue в репозитории через web-интерфейс")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("Kachanok/qa_guru_allure_hw");
        $("#query-builder-test").submit();
        $(linkText("Kachanok/qa_guru_allure_hw")).click();
        $("#issues-tab").click();
        $(withText("TestIssue")).should(Condition.exist);

    }
}
