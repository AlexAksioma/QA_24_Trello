package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperProfile extends HelperBase{
    public HelperProfile(WebDriver driver) {
        super(driver);
    }
    By btnAccount = By.xpath("//button[@data-testid='header-member-menu-button']");
    By btnManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    By btnProfilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");
    By btnChangeProfilePhoto = By.xpath("//button[@data-testid='change-avatar']");
    By btnUploadPhoto = By.xpath("//input[@id='image-input']");

    By btnUpload = By.xpath("//button[@type='submit']");
    By popUpAvatarAdded = By.xpath("//span[@class='css-oxh4dz']");
    By imgWithText = By.xpath("//img[@id='drag-zone-image']");

    By btnCansel = By.xpath("//span[text()='Cancel']/..");


    public void changeAvatar(String filePath){
        clickBaseWait(btnAccount, 3);
        clickBaseWait(btnManageAccount, 3);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String s: tabs) {
            System.out.println("--> "+s);
        }
        driver.switchTo().window(tabs.get(1));
        clickBase(btnProfilePhoto);
        clickBase(btnChangeProfilePhoto);
        //clickBase(btnUploadPhoto);

        File file = new File(filePath);
        String path = file.getAbsolutePath();
        System.out.println("path file --> "+path);
        WebElement element = driver.findElement(btnUploadPhoto);
        element.sendKeys(path);
        clickBaseWait(btnUpload, 5);
    }

    public boolean isElementPresent_popUpAvatarAdded(int time){
        return textToBePresentInElement(popUpAvatarAdded, "Avatar added", time);
    }
    public boolean isTextToBePresentInAttribute_format_invalid(String attribute, String text, int time){
        return textToBePresentInAttribute(imgWithText,attribute,text,time);
    }

    public void clickBtnCansel() {
        clickBaseWait(btnCansel, 5);
    }

    public void goToTrelloBoardsPage() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
}
