import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HangmanTest {
    public Hangman obj;

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating object...");
        obj = new Hangman();
    }

    @Test
    public void test1() {

        // Act: execute the method you are testing
        String actual = obj.welcome();

        // Assert: check whether the actual result is equal to the expected result
        String expected = "H A N G M A N";
        Assertions.assertEquals(expected, actual); //Go and check for us
    }
}