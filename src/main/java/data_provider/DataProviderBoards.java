package data_provider;

import dto.Board;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static utils.RandomUtils.*;

public class DataProviderBoards {
    @DataProvider
    public Board[] newBoardDP(){
        Board board1 = Board.builder().boardTitle(generateString(6)).build();
        Board board2 = Board.builder().boardTitle(generateString(5)).build();
        Board board3 = Board.builder().boardTitle(generateString(4)).build();
        return new Board[]{board1,board2,board3};
    }

    @DataProvider
    public Iterator<Board> newBoardFileDP(){
        List<Board> boardsList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/board_file_dp.csv"));
            try {
                String line = bufferedReader.readLine();
                while (line != null){
                    boardsList.add(Board.builder().boardTitle(line).build());
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return boardsList.listIterator();
    }

}
