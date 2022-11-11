package sbpTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    public BaseStep baseStep;
    private static final String baseUrl = "https://idemo.bspb.ru";
    private static final SelenideElement logoImg = $x("//img[@id='logo']");

    @BeforeAll
    static void beforeAll(){
        Configuration.timeout = 3000;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("listenerAllure",new AllureSelenide().screenshots(true).savePageSource(false));
    };

    @BeforeEach
    public void beforeEach(){
        open(baseUrl);
        logoImg.shouldBe(visible);
        baseStep = new BaseStep();
        baseStep.authorization();
    };

    @AfterAll
    static void after() {
        closeWebDriver();
    }
}
