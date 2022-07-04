import java.io.*;
import java.util.*;

public class Calculator
{
    static List<String> numbers;
    private static int castMethod(String s) throws Exception
    {
        numbers = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        return switch (s)
        {
            case "I" -> numbers.indexOf("I");
            case "II" -> numbers.indexOf("II");
            case "III" -> numbers.indexOf("III");
            case "IV" -> numbers.indexOf("IV");
            case "V" -> numbers.indexOf("V");
            case "VI" -> numbers.indexOf("VI");
            case "VII" -> numbers.indexOf("VII");
            case "VIII" -> numbers.indexOf("VIII");
            case "IX" -> numbers.indexOf("IX");
            case "X" -> numbers.indexOf("X");
            default -> throw new Exception();
        };
    }

    private static int operationMethod(int firstNumber, int secondNumber, char c)
    {
        return switch (c)
        {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
        };
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] text = reader.readLine().split("\\s");

        if (text.length != 3)
            throw new Exception("");

        char c = text[1].charAt(0);
        int firstNumber;
        int secondNumber;

        try
        {
            firstNumber = Integer.parseInt(text[0]);
            secondNumber = Integer.parseInt(text[2]);
            System.out.println(operationMethod(firstNumber, secondNumber, c));
        }
        catch (Exception e)
        {
            int number1 = castMethod(text[0]) + 1;
            int number2 = castMethod(text[2]) + 1;
            StringBuilder builder = new StringBuilder();

            if (number2 >= number1 && c == '-')
            {
                throw new Exception("");
            }

            int result = operationMethod(number1, number2, c);

            if (result > 10)
            {
                builder.append(String.valueOf(numbers.get(9)).repeat(result / 10));

                if (result % 10 == 0)
                    System.out.println(builder);
                else
                    System.out.println(builder.append(numbers.get(result % 10 - 1)));
            }

            else
                System.out.println(numbers.get(result - 1));
        }
    }
}




