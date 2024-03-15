package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        String email = "aksiomamedved@gmail.com";
        String password = "AlexMed123!";
        app.getHelperUser().login(email, password);
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());
    }
}
