package org.example;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 2000;

    public static void main(String[] args) {
        PrimeTestingApp app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        NumberUnderTest numberUnderTest = new NumberUnderTest();

        PrimeTester tester = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);

        Thread thread1 = new Thread(() -> tester.startTesting());
        Thread thread2 = new Thread(() -> tester.startTesting());
        Thread thread3 = new Thread(() -> tester.startTesting());
        Thread thread4 = new Thread(() -> tester.startTesting());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

//        tester.startTesting();
    }
}
