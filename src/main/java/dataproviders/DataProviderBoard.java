package dataproviders;

import models.BoardDto;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderBoard {

    @DataProvider
    public Iterator<BoardDto[]> DP_createNewBoardPositiveTest() {
        List<BoardDto[]> list = new ArrayList<>();
        int i = new Random().nextInt(1000);
        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_" + i).build()});
//        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_2").build()});
//        list.add(new BoardDto[]{BoardDto.builder().boardTitle("DP_QA24_3").build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<BoardDto[]> DPFile_createNewBoardPositiveTest() {
        List<BoardDto[]> list = new ArrayList<>();
        String path = "src/test/resources/board_titles.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String line = bufferedReader.readLine(); //title1,owner1,name1
            while(line != null){
                String [] splitArray = line.split(","); //title1[0] owner1[1] name1[2]
                list.add(new BoardDto[]{BoardDto.builder().boardTitle(splitArray[0]).build()});
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
