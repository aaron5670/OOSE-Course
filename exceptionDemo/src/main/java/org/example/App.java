package org.example;

import java.io.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            new App().readFile();
        } catch (MyExampleException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws MyExampleException {
        File file = new File("C:\\Users\\Aaron\\IdeaProjects\\DEADemos2020-fork\\exceptionDemo\\file.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String s = "";
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
           throw new MyExampleException("Er ging iets fout");
        } finally {
            System.out.println("Ik kom hier ALTIJD!!!");
        }
    }
}
