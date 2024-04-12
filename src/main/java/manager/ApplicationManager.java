package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver driver;
    EventFiringWebDriver driver;
    HelperUser helperUser;
    HelperBoards helperBoards;

    HelperProfile helperProfile;

    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new EventFiringWebDriver(new ChromeDriver(options));
        driver.navigate().to("https://trello.com/");
        logger.info("start testing --- navigate to --> https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helperUser = new HelperUser(driver);
        helperBoards = new HelperBoards(driver);
        helperProfile = new HelperProfile(driver);
        driver.register(new WDListener());

    }

    public void stop(){
        logger.info("stop testing --- navigate to --> https://trello.com/");
        //driver.quit();
    }

    public HelperUser getHelperUser(){
        return helperUser;
    }

    public HelperBoards getHelperBoards(){
        return helperBoards;
    }

    public HelperProfile getHelperProfile(){
        return helperProfile;
    }

}
