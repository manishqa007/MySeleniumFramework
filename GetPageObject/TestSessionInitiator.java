package Demo.bluestack.GetPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Demo.bluestack.Keywords.GameTvHomePageAction;
import Demo.bluestack.Keywords.GameDetailPageAction;

public class TestSessionInitiator {
	public static WebDriver driver;
	
	public void launchUrl(String url) {
		System.setProperty("webdriver.chrome.driver","C://Users//manishpatel//Downloads//chromedriver//chromedriver.exe");
		if(driver==null)
		driver = new ChromeDriver();
		
		driver.get(url);
		System.out.println("Url launched");
		driver.manage().window().maximize();	
	}
	
	public Demo.bluestack.Keywords.GameTvHomePageAction gameTvHomePage;
	public Demo.bluestack.Keywords.GameDetailPageAction gameDetailPage;
	
	public void initPage() {
		gameTvHomePage = new GameTvHomePageAction(driver);
		gameDetailPage = new GameDetailPageAction(driver);
	}
}

