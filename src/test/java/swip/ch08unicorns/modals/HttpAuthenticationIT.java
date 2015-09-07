package swip.ch08unicorns.modals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import swip.ch07managingwebdriver.Config;
import swip.ch07managingwebdriver.SeleniumWebDriverRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SeleniumWebDriverRunner.class)
@Config(exclude = {"browserName=safari", "browserName=htmlunit", "browserName=chrome", "browserName=phantomjs"})
public class HttpAuthenticationIT {
    @Inject
    private WebDriver driver;

    @Test
    public void authViaUrl() throws Exception {
        driver.get("http://admin:secret@localhost:8080/auth.html");

        assertEquals("You Are Logged In", driver.findElement(By.tagName("h1")).getText());
    }
}
