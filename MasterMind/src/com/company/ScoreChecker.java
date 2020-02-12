package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreChecker {
    List<String> secretCode;

    public ScoreChecker(List<String> secretCode) {
//        this.secretCode = secretCode;
        this.secretCode = new ArrayList<>(Arrays.asList("B", "R", "B", "Y"));
        System.out.println(this.secretCode);
    }

    public boolean isCorrect(String userInput) {
        List<String> userInputList = new ArrayList<String>(Arrays.asList(userInput.split("")));
        List<String> secretCodeListCopy = secretCode;
        System.out.println(userInputList);

        if (secretCode.equals(userInputList)) {
            System.out.println("You’ve found the secret code. Congrats!");
            return true;
        }else {
            int rightPosition = 0;
            int wrongPosition = 0;

            for (int i = 0; i < secretCode.size(); i++) {
                if (userInputList.get(i).equals(secretCode.get(i))) {
                    rightPosition++;
                    secretCodeListCopy.set(i, "UNSET");
                }
            }

            for (int i = 0; i < secretCode.size(); i++) {
                if (userInputList.contains(secretCodeListCopy.get(i))) {
                    System.out.println(userInputList.get(i));
                    wrongPosition++;
                }
            }

            System.out.println("Right colour right position = " + rightPosition);
            System.out.println("Right colour wrong position = " + wrongPosition);
            return false;
        }
    }
}
