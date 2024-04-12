package manager;

import models.BoardDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoards extends HelperBase {
    public HelperBoards(WebDriver driver) {
        super(driver);
    }

    By btnCreateNewBoard = By.cssSelector("li[data-testid='create-board-tile']");
    By inputBoardTitle = By.cssSelector("input[data-testid='create-board-title-input']");
    By btnCreateSubmit = By.cssSelector("button[data-testid='create-board-submit-button']");
    By boardTitle = By.cssSelector("h1[data-testid='board-name-display']");
    By btnBoards = By.cssSelector("a[data-testid='open-boards-link']");
    By btnCloseCreateBoardForm = By.cssSelector("button[data-testid='popover-close']");

    //=========================================================
    By btnDots = By.cssSelector("button[aria-label='Show menu']");
    By btnCloseBoard = By.cssSelector("a[class='board-menu-navigation-item-link " +
            "board-menu-navigation-item-link-v2 js-close-board']");
    By btnCloseSubmit = By.cssSelector("input[value='Close']");
    By btnDeleteBoard = By.cssSelector("button[data-testid='close-board-delete-board-button']");
    By btnDeleteConfirm = By.cssSelector("button[data-testid='close-board-delete-board-confirm-button']");
    //=========================================================================
    By popUpBoardDeleted = By.cssSelector("span[class='QMKgZFIlTLiEJN']");

    public void createNewBoard(BoardDto boardDto) {
        clickBase(btnCreateNewBoard);
        typeBase(inputBoardTitle, boardDto.getBoardTitle());
        //pause(3);
        //clickBase(btnCreateSubmit);
        clickBaseWait(btnCreateSubmit, 5);
    }

    public void deleteBoard(BoardDto boardDto) {
        clickBoardTitle(boardDto.getBoardTitle());
        //pause(3);
        //clickBase(btnDots);
        clickBaseWait(btnDots, 10);
        clickBase(btnCloseBoard);
        clickBase(btnCloseSubmit);
        clickBase(btnDeleteBoard);
        clickBase(btnDeleteConfirm);
    }

    private void clickBoardTitle(String boardTitle) {
        String xPathBoardTitle = "//div[@title='" + boardTitle + "']";
        //clickBase(By.xpath(xPathBoardTitle));
        clickBaseWait(By.xpath(xPathBoardTitle), 10);
    }

    public boolean isTextInElementEquals_boardTitle(String text) {
        return isTextInElementEquals(boardTitle, text);
    }

    public void clickBtnBoards() {
        clickBase(btnBoards);
    }

    public void clickBtnCloseCreateBoardForm() {
        clickBase(btnCloseCreateBoardForm);
    }

    public boolean isElementPresent_inputBoardTitle() {
        return isElementPresent(inputBoardTitle);
    }

    public boolean isElementPresent_boardTitle() {
        return isElementPresent(boardTitle);
    }

    public boolean textToBePresentInElement_BoardDeleted(String text, int time) {
        return textToBePresentInElement(popUpBoardDeleted, text, time);
    }
}
