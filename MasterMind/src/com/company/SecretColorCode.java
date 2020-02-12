package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretColorCode {
    private List<String> secretColorCode = new ArrayList<String>();
    private String[] colors = {"B", "G", "R", "Y"};
    private int codeLength;

    public SecretColorCode(int codeLength) {
        this.codeLength = codeLength;
        generateSecretColorCode();
    }

    private void generateSecretColorCode() {
        Random rand = new Random();
        for (int i = 0; i < codeLength; i++) {
            secretColorCode.add(colors[rand.nextInt(4)]);
        }
    }

    public List<String> getSecretColorCode() {
        return secretColorCode;
    }
}
