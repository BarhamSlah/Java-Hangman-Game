import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

void main() {

    ArrayList<Character> arraylist = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    String filePath = "src/Clubs.txt";
ArrayList<String > Clubs = new ArrayList<>();


   try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
       String eachLine;

       while ((eachLine = bufferedReader.readLine()) != null) {
           if (!eachLine.trim().isEmpty()) {
               Clubs.add(eachLine.trim()); // Adds each club from the file into the ArrayList
           }
       }

   }catch (FileNotFoundException e){
        System.out.println("File not found");
   }catch (IOException e){
       System.out.println("Something went wrong");
   }catch (IllegalArgumentException e){
       System.out.println(e.getMessage());
   }

    Random random = new Random();
    String word = Clubs.get(random.nextInt(Clubs.size()));

    int wrongGuess = 0;


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
        char guess = scanner.next().charAt(0);

        if (word.indexOf(guess) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    arraylist.set(i, guess);
                }
            }

        } else {
            wrongGuess++;
        }
        System.out.println(hangmanArt(wrongGuess));
    } // while loop stop here

    if(arraylist.contains('_')){
        System.out.println("You lost the game");
        System.out.println("The word is " + word);
    }

    scanner.close();
}

static String hangmanArt(int wrongGuess) {

  return  switch (wrongGuess) {

      case 0 -> """
                  
                  
                  """;
      case 1 -> """
                   o
                  
                  """;
      case 2 -> """
                   o
                   |
                  """;
      case 3 -> """
                   o
                  /|
                  """;
      case 4 -> """
                   o
                  /|\\
                  """;
      case 5 -> """
                   o
                  /|\\
                  /
                  """;
      case 6 -> """
                   o
                  /|\\
                  / \\
                  """;
      default -> "";

  };

}