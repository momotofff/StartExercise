import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Calculator {
    static final Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    static final List<String> list = new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));

    private static String castMethod(String s, String s1, char c) throws Exception {
        int number1 = 0;
        int number2 = 0;
        int result;
        String res;

        switch (s) {
            case "I" -> number1 = 1;
            case "II" -> number1 = 2;
            case "III" -> number1 = 3;
            case "IV" -> number1 = 4;
            case "V" -> number1 = 5;
            case "VI" -> number1 = 6;
            case "VII" -> number1 = 7;
            case "VIII" -> number1 = 8;
            case "IX" -> number1 = 9;
            case "X" -> number1 = 10;}

        switch (s1) {
            case "I" -> number2 = 1;
            case "II" -> number2 = 2;
            case "III" -> number2 = 3;
            case "IV" -> number2 = 4;
            case "V" -> number2 = 5;
            case "VI" -> number2 = 6;
            case "VII" -> number2 = 7;
            case "VIII" -> number2 = 8;
            case "IX" -> number2 = 9;
            case "X" -> number2 = 10;}

        if (number2 > number1 && c == '-')
        {
            throw new Exception("");
        }
        else
            result = operationMethod(number1, number2, c);

        if (result > 10)
            if (result % 10 > 0)
                res = "X" + list.get(result % 10 - 1);
            else
                res = "X" + "X";
        else
            res = list.get(result - 1);

        return res;

    }

    private static int operationMethod(int firstNumber, int secondNumber, char c)
    {
        int result = switch (c) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;};

        return result;
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber;
        int secondNumber;

        while (true)
        {
            String[] text = reader.readLine().split("\\s");

            if (text.length != 3)
                throw new Exception("");

            char c = text[1].charAt(0);

            try
            {
                firstNumber = Integer.parseInt(text[0]);
                secondNumber = Integer.parseInt(text[2]);

                if (set.contains(firstNumber) && set.contains(secondNumber))
                    System.out.println(operationMethod(firstNumber, secondNumber, c));
            }
            catch (Exception e)
            {
                if (list.contains(text[0]) && list.contains(text[2]))
                    System.out.println(castMethod(text[0], text[2], c));
                else
                    throw new Exception();
            }
        }
    }
}



