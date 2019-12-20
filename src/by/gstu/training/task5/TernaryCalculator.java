package by.gstu.training.task5;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class with descriptions of ternary calculating and printing functions
 */
public class TernaryCalculator {

    private final ArrayList<String> list;
    private final int length;

    public TernaryCalculator(ArrayList<String> list, int length) {
        this.list = list;
        this.length = length;
    }

    /**
     * Start the separate thread that performs addition operation
     */
    public void addition() {
        new Addition(list, length).start();
    }

    /**
     * Start the separate thread that performs subtraction operation
     */
    public void subtraction() {
        new Subtraction(list, length).start();
    }

    /**
     * Start the separate thread that performs printing to console operation
     */
    public void print() {
        new Printer(list).start();
    }
}

/**
 * Class with addition logic
 */
class Addition extends Thread {

    private final ArrayList<String> list;
    private final int length;

    public Addition(ArrayList<String> list, int length) {
        this.list = list;
        this.length = length;
    }

    /**
     * Runs the separate thread, which adds into list description
     * of addition two random decimal integers with converting them into ternary numeral system
     */
    @Override
    public void run() {
        while (list.size() < length) {

            synchronized (list) {
                Random random = new Random();
                int firstNumber = random.nextInt((100)) + 1;
                int secondNumber = random.nextInt((100)) + 1;
                list.add("Результат сложения числа " + firstNumber + " с числом " + secondNumber
                        + " в троичной системе: " + NumberConverter.toTernary(firstNumber + secondNumber));
            }
        }
    }
}

/**
 * Class with subtraction logic
 */
class Subtraction extends Thread {
    private final ArrayList<String> list;
    private final int length;

    public Subtraction(ArrayList<String> list, int length) {
        this.list = list;
        this.length = length;
    }

    /**
     * Runs the separate thread, which adds into list description
     * of subtraction two random decimal integers with converting them into ternary numeral system
     */
    @Override
    public void run() {
        while (list.size() < length) {
            synchronized (list) {
                Random random = new Random();
                int firstNumber = random.nextInt((100)) + 1;
                int secondNumber = random.nextInt((100)) + 1;
                list.add("Результат вычитания из числа " + firstNumber + " числа " + secondNumber
                        + " в троичной системе: " + NumberConverter.toTernary(firstNumber - secondNumber));
            }
        }
    }
}

/**
 * Class with printing to console method
 */
class Printer extends Thread {

    private final ArrayList<String> list;

    public Printer(ArrayList<String> list) {
        this.list = list;
    }

    /**
     * Runs the separate thread, which prints to console list content with
     * 100 ms delay
     */
    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            try {
                Thread.sleep(1000);
                System.out.println(list.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}