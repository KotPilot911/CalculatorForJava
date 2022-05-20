import java.util.Scanner;

public class Calculator {
    static String result;
    static String number1;
    static String number2;
    static String operation;
    static int arabicNumber1;
    static int arabicNumber2;
    static int resultArabic;
    static boolean checkRoman;
    static boolean checkScanner;

    public static void calc(String input) throws Exception {
        resultArabic = switch (input) {
            case "+" -> (arabicNumber1 + arabicNumber2);
            case "-" -> (arabicNumber1 - arabicNumber2);
            case "*" -> (arabicNumber1 * arabicNumber2);
            case "/" -> (arabicNumber1 / arabicNumber2);
            default -> throw new Exception("Некорректная операция");
        };
        result = Integer.toString(resultArabic);

    }

    public static void main(String[] args) throws Exception {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите выражение");
            String expression = scanner.nextLine();
            String[] ParsedExpression = expression.split(" ");

            try {
                number1 = ParsedExpression[0];
                number2 = ParsedExpression[2];
                operation = ParsedExpression[1];
            } catch (Exception e3) {
                throw new Exception("строка не является математической операцией");
            }

            try {
                arabicNumber1 = Integer.parseInt(number1);
                arabicNumber2 = Integer.parseInt(number2);
            } catch (Exception e1) {
                checkRoman = true;
                try {
                    arabicNumber1 = Converter.romanToArabic(number1);
                    arabicNumber2 = Converter.romanToArabic(number2);
                } catch (Exception e2) {
                    throw new Exception("используются одновременно разные системы счисления");
                }
            }

            if (arabicNumber1 < 0 || arabicNumber1 > 10 || arabicNumber2 < 0 || arabicNumber2 > 10)
                throw new Exception("Запрещён ввод чисел меньше 0 либо больше 10");
            if (ParsedExpression.length > 3)
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

            calc(operation);

            if (!checkRoman) {
                System.out.println(result);
            } else {
                if (resultArabic > 0) System.out.println(Converter.arabicToRoman(resultArabic));
                else throw new Exception("в римской системе нет отрицательных чисел");
            }
        }while (!checkScanner);
    }
}
