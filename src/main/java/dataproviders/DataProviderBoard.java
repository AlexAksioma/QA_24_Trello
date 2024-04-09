package dataproviders;

import models.BoardDto;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderBoard {

    @DataProvider
    public Iterator<BoardDto[]> DP_createNewBoardPositiveTest(){
        List<BoardDto[]> list = new ArrayList<>();
        int i = new Random().nextInt(1000);
        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_"+i).build()});
//        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_2").build()});
//        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_3").build()});
        return list.iterator();
    }
}
