package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver driver;
    HelperUser helperUser;
    HelperBoards helperBoards;

    public void init(){
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        logger.info("start testing --- navigate to --> https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        helperUser = new HelperUser(driver);
        helperBoards = new HelperBoards(driver);
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

}
