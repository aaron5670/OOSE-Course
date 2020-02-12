package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mastermind {
    List<String> userInput = new ArrayList<String>();
    List<String> randomColoursList = new ArrayList<String>();
    SecretColorCode secretColorCode;
    ScoreChecker scoreChecker;

    public Mastermind() {
        secretColorCode = new SecretColorCode(4);
        List<String> secretCode = secretColorCode.getSecretColorCode();
        scoreChecker = new ScoreChecker(secretCode);

        userInput(true);
    }

    public void userInput(boolean start) {
        if (start)
            System.out.println("Voer 4 kleuren in, een letter (B=blue, G=green, R=red, Y=yellow) per regel!");
        else
            System.out.println("Probeer nogmaals 4 kleuren:");

        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();

        if (!scoreChecker.isCorrect(userInput))
            userInput(false);
    }
}
