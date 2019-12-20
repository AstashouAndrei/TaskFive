package by.gstu.training.task5;

import java.util.ArrayList;

/**
 * Class for running application
 */
public class Runner {
    public static void main(String[] args) {
        /*
        Вариант 9. Троичный калькулятор.
        Реализованные функции: сложение (addition), вычитание (subtraction).
         */
        ArrayList<String> list = new ArrayList<String>();
        new TernaryCalculator(list, 20).addition();
        new TernaryCalculator(list, 20).subtraction();
        new TernaryCalculator(list, 20).print();


    }
}
