package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    List<String> words = List.of("dupa1", "dupa2", "dupa3", "dupa4", "dupa5", "dupa6", "dupa7" );
    String word;
    char[] userWord;
    int lives = 3;
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wisielec");

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');


        
        while (!gameEnded()){
            System.out.println(userWord);
            System.out.println();
            System.out.println("Podaj literę");
            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);

            
        }

    scanner.close();
    }

    private void checkLetter(char letter) {
        boolean check = false;
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                userWord[i] = letter;
                check = true;
            }
            }
        if (!check) {
            lives--;
            System.out.println("Nie ma takiej litery, żyćko -1 zostało ci " + lives + " żyć");
        }
        }



    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}
