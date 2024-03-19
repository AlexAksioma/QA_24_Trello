package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoards extends HelperBase{
    public HelperBoards(WebDriver driver) {
        super(driver);
    }
    By btnCreateNewBoard = By.cssSelector("li[data-testid='create-board-tile']");
    By inputBoardTitle = By.cssSelector("input[data-testid='create-board-title-input']");
    By btnCreateSubmit = By.cssSelector("button[data-testid='create-board-submit-button']");
    By boardTitle = By.cssSelector("h1[data-testid='board-name-display']");
    By btnBoards = By.cssSelector("a[data-testid='open-boards-link']");
    By btnCloseCreateBoardForm = By.cssSelector("button[data-testid='popover-close']");

    public void createNewBoard(String boardTitle) {
        clickBase(btnCreateNewBoard);
        typeBase(inputBoardTitle, boardTitle);
        pause(3);
        clickBase(btnCreateSubmit);
    }

    public boolean isTextInElementEquals_boardTitle(String text) {
        return isTextInElementEquals(boardTitle, text);
    }

    public void clickBtnBoards(){
        clickBase(btnBoards);
    }
    public void clickBtnCloseCreateBoardForm(){
        clickBase(btnCloseCreateBoardForm);
    }

    public boolean isElementPresent_inputBoardTitle(){
        return isElementPresent(inputBoardTitle);
    }

    public boolean isElementPresent_boardTitle() {
        return isElementPresent(boardTitle);
    }
}
