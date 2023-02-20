//
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        System.out.println(welcome());
        System.out.println(playGame());
    }
    public static String welcome() {
        return "H A N G M A N";
    }
    public static String playGame() {
        try {
            Random rand = new Random(); // Random generator
            Scanner scan = new Scanner(System.in); // Scanner to get value from player
            while (true) { // Initial loop for Infinity play

                int w = rand.nextInt(10); // length of the word to be generated is selected at random
                char[] arr = new char[w]; // array to save the user's word
                for (int i = 0; i < w; i++) { // generate int from 0-26 and use it as letter number
                    arr[i] = (char) ('a' + rand.nextInt('z' - 'a'));
                }

                char[] res = new char[w]; // array for the result and initialize with _ for printing
                for (int i = 0; i < w; i++)
                    res[i] = '_';
                char[] missed = new char[7]; // keep the count of letter missed
                int lengthMissWord = 0; //length of missed words
                while ( lengthMissWord < 7) { //loop2
                    System.out.println("+---+\n|\n|\n|\n===");
                    System.out.print("Missed letters:"); // print missed letters
                    for (int i = 0; i < lengthMissWord; i++)
                        System.out.print(missed[i]);
                    System.out.println();

                    for (int i = 0; i < w; i++) { // printing the letters filled and needed
                        if (arr[i] == res[i])
                            System.out.print(arr[i]);
                        else
                            System.out.print("_");
                    }

                    System.out.println();
                    int flag = 0;
                    while (true) { // loop for same vales repetition
                        System.out.println("Guess a letter");
                        char c = scan.next().charAt(0);
                        for (int i = 0; i < w; i++) { // check for already entered values
                            if (c == res[i]) {
                                System.out.println("You have already guessed that letter. Choose again.");
                                continue;
                            }
                        }

                        for (int i = 0; i < w; i++) { // matching the values entered
                            if (arr[i] == c) {
                                flag = 1;
                                res[i] = c;
                            }
                        }

                        if (flag == 0) // condition if the letter is not in word
                            missed[lengthMissWord++] = c;
                        break;
                    }
                    int flag2 = 1;
                    for (int i = 0; i < w; i++) // checking if all the letters are guessed
                        if (arr[i] != res[i]) {
                            flag2 = 0;
                            break;
                        }
                    if (flag2 == 1) { // The player won by guessing all the letter
                        System.out.print("Yes! The secret word is ");
                        for (int i = 0; i < w; i++)
                            System.out.print(arr[i]);
                        System.out.println("! You have won!");
                        break;
                    }
                }
                if (lengthMissWord == 7) { // checking the condition for loop2 if it breaks due to success or limit
                    System.out.println("You have loss");
                    break;
                } else {
                    System.out.println("Do you want to play again? (yes or no)"); // Ask for new name
                    char ch = scan.next().charAt(0);
                    if (ch == 'n')
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid entry");
        }
        return "Thank you for playing!";
    }
}



