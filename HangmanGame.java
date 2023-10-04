import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;
import java.io.Console;  
import java.util.ArrayList;

class HangmanJavaGame {
    public static void main (String[] args) throws Exception{
        String gamePhrase = pickPhrase();
        int incorrectGuesses = 0;
        ArrayList<String> incorrectlyGuessed = new ArrayList<String>();
    

        while (incorrectGuesses != 12) {
            hangman(incorrectGuesses);
            phraseUI(gamePhrase);
            System.out.println();
        
            //Print lives remaining
            if (incorrectGuesses == 6) {
                String resetTextColor = "\033[0m"; 
                String redTextColor = "\033[0;31m";       
                System.out.println(redTextColor+"One man is hanged, one life remaining."+resetTextColor);
            } else {
                int numberOfGuesses;   
                if (incorrectGuesses < 6) {
                    numberOfGuesses = 6 - incorrectGuesses;
                } else {    
                    numberOfGuesses = 12 - incorrectGuesses;
                }
                System.out.println("You have " + numberOfGuesses + " guesses remaining.");
            }

            //Print the incorrect guesses
            if (incorrectGuesses > 0) {
                printIncorrectlyGuessed(incorrectlyGuessed);
            }
    
            //Index: 0-Updated gamePhrase, 1-incorrectGuesses, 2-Guess
            String[] roundResults = gameRound(gamePhrase, incorrectGuesses, incorrectlyGuessed);
            
            //Update the variables after the round  
            gamePhrase = roundResults[0];
            incorrectGuesses = Integer.parseInt(roundResults[1]);
            
            if (roundResults[2] != null) {
                incorrectlyGuessed.add(roundResults[2]);
            }
    }  

    //If the hangman is incomplete
    hangman(incorrectGuesses);
    System.out.println("You lost. You couldn't guess the phrase in time...");
    System.out.println("The phrase was: " + gamePhrase.toUpperCase());    
  }
  
    public static String pickPhrase() throws Exception{
        BufferedReader fileReader = new BufferedReader(new FileReader("phrases.txt"));
        int numberOfPhrases = 20;
        int randomNumber = (int)((Math.random() * (numberOfPhrases - 1)) + 1);
        String phrase = "";

        //Pick a random phrase to use
        for (int i = 1; i <= randomNumber; i++) {
            phrase = fileReader.readLine();
        }
        
        fileReader.close();

        phrase = phrase.toLowerCase();
        return phrase;
    }

    public static void phraseUI(String phrase) {
        String phraseText = "Phrase: ";
    
        for (String character : phrase.split("")) {
            if (Character.isUpperCase(character.charAt(0))) {
                phraseText += character;
            }
            else if (character.equals(" ")) {
                phraseText += " ";
            } else {
                phraseText += "_";
            }
            phraseText += " ";
        } 

        System.out.println(phraseText);

        if (!phraseText.contains("_")) {
            System.out.println("You won the game of Hangman!!!");
            System.exit(0);
        }
    }

    public static void hangman(int incorrect) {
        String[][] hangmanStages = {{"  +---+", "  |   |", "      |", "      |", "      |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", "      |", "      |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", "  |   |", "      |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", " /|   |", "      |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", " /|\\  |", "      |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", " /|\\  |", " /    |", "      |", "========="}, {"  +---+", "  |   |", "  O   |", " /|\\  |", " / \\  |", "      |", "========="}}; 

        if (incorrect > 6) {
            incorrect -= 6;
        }
        
        String[] hangmanCurrentStage = hangmanStages[incorrect];

        for (String part : hangmanCurrentStage) {
            System.out.println(part);
        } 
    }

    public static String[] gameRound(String phrase, Integer incorrectTries, ArrayList<String> incorrectGuesses) throws Exception{
        Console consoleInputScanner = System.console();  
        String[] splitPhrase = phrase.split(" ");

        //Text colors
        String resetTextColor = "\033[0m"; 
        String redTextColor = "\033[0;31m";     

        //Ask user to guess
        String guess = "";

        //Ask user to guess, if an already guessed, ask again
        while (true) {
            System.out.println();
            System.out.print("Guess a letter or word: ");
            guess = consoleInputScanner.readLine().trim().toLowerCase(); 

            if (phrase.contains(guess.toUpperCase())) {
                System.out.println("You already guessed this...");
            } else if (!incorrectGuesses.contains(guess)) {
                break;
            } else {
                System.out.println("You already incorrectly guessed this...");
            }
        }
        
        String uppercaseGuess = guess.toUpperCase(); 

        //If in the phrase, change it
        String newPhrase = "";
        boolean correctGuess = false; 
    
        for (String word : splitPhrase) {
            //Check if the the word is equal to the guess, if the guess is a word itself
            if (guess.length() > 1) {
                if (word.toLowerCase().equals(guess)) {
                    word = word.toUpperCase();
                    correctGuess = true;
                }
            //Check if the guess is a letter in the word, if the guess is a letter itself
            } else if (word.toLowerCase().contains(guess)) {
                word = word.replace(guess, uppercaseGuess);
                correctGuess = true;
            }
        newPhrase += word + " ";  
        }
        
        newPhrase = newPhrase.trim();
    
        //Look if the user is right or not
        if (!correctGuess) {
            incorrectTries ++;
            System.out.println("Your guess was " + redTextColor + "Incorrect." + resetTextColor);
            System.out.print("Press Enter to continue.");
            consoleInputScanner.readLine();
        } else {
            guess = null;
        }

        System.out.print("\033[H\033[2J");  
        System.out.flush();  

        String[] results = {newPhrase, Integer.toString(incorrectTries), guess}; 
            
        return results;
    }

    public static void printIncorrectlyGuessed(ArrayList<String> incorrectGuessesList) {
        String printGuesses = "Incorrect Guesses: ";
        for (int i = 0; i < incorrectGuessesList.size()-1; i++) {
            printGuesses += incorrectGuessesList.get(i) + ", ";
        }
    
        printGuesses += incorrectGuessesList.get(incorrectGuessesList.size()-1);
        System.out.println(printGuesses);
    
    }
}
