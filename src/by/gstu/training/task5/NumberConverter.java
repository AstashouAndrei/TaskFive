package by.gstu.training.task5;

/**
 * Class with methods converting numbers from decimal to other numeral system
 */

public class NumberConverter {

    /**
     * Returns number converted into ternary
     *
     * @param number number in decimal
     * @return ternary number
     */
    public static int toTernary(int number) {

        StringBuilder builder = new StringBuilder();
        boolean isNegative = false;

        if (number == 0) {
            throw new IllegalArgumentException("Can't convert 0 into ternary");
        } else if (number < 0) {
            number = -number;
            isNegative = true;
        }

        while (number > 0) {
            builder.append(number % 3);
            number /= 3;
        }
        builder.reverse();

        if (isNegative) {
            builder.insert(0, "-");
        }

        return Integer.parseInt(builder.toString());
    }
}
