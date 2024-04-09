package tests;

import dataproviders.DataProviderBoard;
import helpers.RetryAnalyzer;
import manager.TestNGListener;
import models.BoardDto;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNGListener.class)

public class BoardsTests extends TestBase {

    @BeforeClass
    public void loginWithData() {
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test(dataProvider = "DP_createNewBoardPositiveTest", dataProviderClass = DataProviderBoard.class)
    public void createNewBoardPositiveTest(Method method, BoardDto boardDto) {
//        int i = new Random().nextInt(1000);
//        BoardDto boardDto = BoardDto.builder()
//                .boardTitle("qa24_"+i)
//                .build();
        logger.info("start test " + method.getName() + " board title --> " + boardDto.getBoardTitle());
        //String boardTitle = "qa24_"+i;
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDto.getBoardTitle()));
        //Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle("111"));
    }

    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle() {
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("   ")
                .build();
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isElementPresent_inputBoardTitle());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void deleteBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000);
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("qa24_" + i)
                .build();
        logger.info("start test " + method.getName() + " board title --> " + boardDto.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDto);
        app.getHelperBoards().clickBtnBoards();

        app.getHelperBoards().deleteBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards()
                .textToBePresentInElement_BoardDeleted("Board deleted.", 1));
    }

    @AfterMethod
    public void afterTest() {
        if (app.getHelperBoards().isElementPresent_boardTitle())
            app.getHelperBoards().clickBtnBoards();
        if (app.getHelperBoards().isElementPresent_inputBoardTitle())
            app.getHelperBoards().clickBtnCloseCreateBoardForm();
    }
}
