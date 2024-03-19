package tests;

import manager.ApplicationManager;
import models.UserDto;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    UserDto user = new UserDto("aksiomamedved@gmail.com","AlexMed123!");

    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        //app.stop();
    }

}
