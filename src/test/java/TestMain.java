import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "4 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 4, 5, 14, 15, 16, 17, 6, 13, 20, 19, 18, 7, 12, 11, 10, 9, 8};
        int[] actual = Arrays.stream(outContent.toString().replaceAll("[\n, \r]", "")
                .replaceAll("[\t]", " ")
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "3 3";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 8, 9, 4, 7, 6, 5};
        int[] actual = Arrays.stream(outContent.toString().replaceAll("[\n, \r]", "")
                .replaceAll("[\t]", " ")
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "2 2";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 4, 3};
        int[] actual = Arrays.stream(outContent.toString().replaceAll("[\n, \r]", "")
                .replaceAll("[\t]", " ")
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "3 9";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 21, 22, 23, 24, 25, 26, 27, 10,
                19, 18, 17, 16, 15, 14, 13, 12, 11};
        int[] actual = Arrays.stream(outContent.toString().replaceAll("[\n, \r]", "")
                .replaceAll("[\t]", " ")
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "6 9";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 26, 27, 28, 29,
                30, 31, 32, 33, 10, 25, 44, 45, 46, 47, 48, 49, 34, 11, 24, 43,
                54, 53, 52, 51, 50, 35, 12, 23, 42, 41, 40, 39, 38, 37, 36, 13,
                22, 21, 20, 19, 18, 17, 16, 15, 14};
        int[] actual = Arrays.stream(outContent.toString().replaceAll("[\n, \r]", "")
                .replaceAll("[\t]", " ")
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        assertArrayEquals(expected, actual);
    }
}