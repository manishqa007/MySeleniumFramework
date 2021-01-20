package Demo.bluestack.Keywords;

import org.openqa.selenium.WebDriver;

import Demo.bluestack.GetPageObject.GetPage;

public class GameDetailPageAction extends GetPage{

	public GameDetailPageAction(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
//	Name of the game
//	2. game detail page URL
//	3. status code for each page URL
//	4. Total number of tournaments for that game
	
	public void getGameData(){
		scrollBy("10000");
	}
}
