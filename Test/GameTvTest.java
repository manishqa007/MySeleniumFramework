package Demo.bluestack.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Demo.bluestack.GetPageObject.TestSessionInitiator;

public class GameTvTest {
	TestSessionInitiator test;
    String url ="https://www.game.tv/";
//	WebDriver driver;
	@BeforeClass
    public void start_test_Session() {
        test = new TestSessionInitiator();
        test.initPage();
    }
	
	@Test(priority=1)
	public void launchUrl() {
		test.launchUrl(url);
	}
	
	@Test(priority=2)
	public void fetchTounramentData() throws InterruptedException {
		Thread.sleep(8000);
		test.gameDetailPage.getGameData();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,15000)");
	}
	
}
