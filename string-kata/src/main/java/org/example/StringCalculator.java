package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.equals(""))
            return 0;

        List<String> sumString = new ArrayList<String>(Arrays.asList(numbers.split(",|\n")));

        int total = 0;

        for (String s : sumString) {
            if (Integer.parseInt(s) <= 1000)
                total = Integer.parseInt(s) + total;
        }

        return total;
    }
}
