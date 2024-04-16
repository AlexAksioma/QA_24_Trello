package tests;

import manager.TestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{

//    @BeforeClass(alwaysRun = true)
//    public void loginWithData() {
//        app.getHelperUser().login(user.getEmail(), user.getPassword());
//    }

    @Test(groups = {"smoke"})
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar("src/test/resources/qa_blue.jpg");
        Assert.assertTrue(app.getHelperProfile().isElementPresent_popUpAvatarAdded(5));
    }
    @Test
    public void changeAvatarNegativeTest_wrongFileFormat(){
        app.getHelperProfile().changeAvatar("src/test/resources/test-plan_ieee-829.pdf");
        Assert.assertTrue(app.getHelperProfile()
                .isTextToBePresentInAttribute_format_invalid("alt","Could not load image, the format is invalid.",5));
    }

    @AfterMethod
    public void afterTestMethod(){
        if(app.getHelperProfile().isTextToBePresentInAttribute_format_invalid
                ("alt","Could not load image, the format is invalid.",5)){
            app.getHelperProfile().clickBtnCansel();
        }
        app.getHelperProfile().goToTrelloBoardsPage();
    }
}
