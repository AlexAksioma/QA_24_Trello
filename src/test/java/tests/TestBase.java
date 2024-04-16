package tests;

import manager.ApplicationManager;
import models.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    UserDto user = new UserDto("aksiomamedved@gmail.com","AlexMed123!");

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        logger.info("login with email --> "+user.getEmail()+" password --> "+user.getPassword());
        app.init();
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

}
