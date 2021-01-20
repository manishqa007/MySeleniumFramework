package Demo.bluestack.GetPageObject;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetPage {
	WebDriver driver;

	public void logMessage(String string) {
		System.out.println(string);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected void hover(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform();
		logMessage("Hovered on element:" + element);
	}

	public void clickUsingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			executor.executeScript("arguments[0].click();", element);
		} catch (StaleElementReferenceException sre) {
			System.out.println("Stale Exeception handled.");
			hardWait(1);
			executor.executeScript("arguments[0].click();", element);
		}
	}

	public void click() {

	}

	public void waitForPageToLoadCompletely(String pageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	protected void scrollBy(String num) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + num + ")");
	}

	protected void scrollDown(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, -100000)");
		hardWait(5);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		hardWait(1);
		jse.executeScript("window.scrollBy(0,-350)");
		hardWait(5);
	}

	protected void scrollDownWithGivenDimension(int dimValue) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + dimValue + ")");
		hardWait(5);
	}

	protected void scroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void navigateBack() {
		driver.navigate().back();
		logMessage("Page has navigated back in the browser's history");
	}

	public void navigateForward() {
		driver.navigate().forward();
		logMessage("Page has navigated forward in the browser's history");
	}

}
