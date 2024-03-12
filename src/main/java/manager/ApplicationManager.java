package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;

    public void init(){
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
    }

    public void stop(){
        driver.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }

}
