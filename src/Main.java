import java.util.Scanner;
import java.util.ArrayList;

void main() {

    ArrayList<Character> arraylist = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int wrongGuess = 0;
    String word = "BUG";

    for (int i = 0; i < word.length(); i++) {
        arraylist.add('_');
    }

    while (wrongGuess < 6) {

        System.out.print("The word is ");
        for (Character c : arraylist) {
            System.out.print(c + " ");
        }

        if(!arraylist.contains('_')){
            System.out.println("\nwon the game");
            break;
        }

        System.out.println();

        System.out.print("Guess the letter ");
        char guess = scanner.next().toUpperCase().charAt(0);

        if (word.indexOf(guess) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    arraylist.set(i, guess);
                }
            }
        } else {
            wrongGuess++;
        }

    } // while loop stop here

    if(arraylist.contains('_')){
        System.out.println("You lost the game");
        System.out.println("The word is " + word);
    }




    scanner.close();
}