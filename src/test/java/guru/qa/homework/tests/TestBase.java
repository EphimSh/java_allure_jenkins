package guru.qa.homework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.homework.config.CredentialsConfig;
import guru.qa.homework.helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class TestBase {
    @BeforeAll
    static void init() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        Configuration.pageLoadStrategy = "eager";

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "99.0");
        Configuration.browserSize = System.getProperty("browserSize", "1980х1080");
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com/");
        Configuration.remote = System.getProperty("remoteDriverUrl", "https://"+ config.login() +":"+config.password()+"@selenoid.autotests.cloud/wd/hub");
        System.out.println();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.attachScreenshot("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLog();
        Attach.addVideo();
    }
}
