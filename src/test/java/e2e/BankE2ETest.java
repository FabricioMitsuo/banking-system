package e2e;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class BankE2ETest {
  static Playwright playwright;
  static Browser browser;

  @BeforeAll
  static void setup() {
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
  }

  @Test
  void signupAndLoginFlow() {
    BrowserContext context = browser.newContext();
    Page page = context.newPage();
    page.navigate("http://localhost:8080/");
  }

  @AfterAll
  static void tearDown() {
    browser.close();
    playwright.close();
  }
}
