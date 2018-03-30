package test.java;

import main.java.Searcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

public class TestForSearcher {


    @DisplayName("Test for checkForWord")
    @Test
    void testForCheckForWord() {
        assertTrue(Searcher.checkForWord("package"));
        assertFalse(Searcher.checkForWord(""));
        assertFalse(Searcher.checkForWord("wrong"));
        assertFalse(Searcher.checkForWord(null));
    }

    @DisplayName("Test for searchKeywords with zero words")
    @Test
    void testSearchKeywordsWithZero() {
        Searcher.searchKeywords("src\\main\\java\\resources\\zeroWords.txt");
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("src\\main\\java\\resources\\file.txt")))) {

            String file = bufferedReader.readLine();
            assertEquals("{}", file);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @DisplayName("Test for searchKeywords with five words")
    @Test
    void testSearchKeywordsWithFive() {
        Searcher.searchKeywords("src\\main\\java\\resources\\fiveWords.txt");
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("src\\main\\java\\resources\\file.txt")))) {

            String file = bufferedReader.readLine();
            assertEquals("{private=1, package=1, public=1, class=2}", file);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
