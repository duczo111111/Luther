package saucelab.setup;
import com.microsoft.playwright.*;

public class Launcher {
	private Browser browser;
	private Page page;
	public Launcher() {
		Playwright playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
	}
	public Page getpage() {
		return page;
	}
}
