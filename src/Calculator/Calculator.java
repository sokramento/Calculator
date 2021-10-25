package Calculator;

import java.util.Scanner;

public class Calculator {
    public Scanner input;
    public String[] array1;
    Transformer tr = new Transformer();
    boolean isRomanA = false;
    boolean isRomanB = false;

    private int getIntA() throws Exception {
        int a;
        try {
             a = Integer.parseInt(array1[0]);
        } catch (NumberFormatException n) {
            isRomanA = true;
            String a1 = array1[0];
            int a2 = tr.rimToArab(a1);
            return a2;
        }
        if (a < 1 || a > 10) {
            throw new Exception("Вы ввели неподходящее значение. Перезапустите программу.");
        } else {
            return a;
        }
    }

    private int getIntB() throws Exception {
        int b;
        try {
            b = Integer.parseInt(array1[2]);
        } catch (NumberFormatException n) {
            isRomanB = true;
            String b1 = array1[2];
            int b2 = tr.rimToArab(b1);
            return b2;
        }
        if (b < 1 || b > 10) {
            throw new Exception("Вы ввели неподходящее значение. Перезапустите программу.");
        } else {
            return b;
        }
    }

    private char getZnak() throws Exception {
        String znakS = array1[1];
        char znakCh = znakS.charAt(0);
        if (znakS.length() > 1) {
            throw new Exception("Вы ввели некорректное число знаков. Перезапустите программу.");
        }
        return znakCh;
    }

    private int calc(int num1, char operation, int num2) throws Exception {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new Exception("Введена неверная операция. Пожалуйста, повторите ввод.");
        }
    }

    public void operation() throws Exception {
        System.out.println("Пожалуйста, введите ваши данные, используя +, -, *, /");
        input = new Scanner(System.in);
        array1 = input.nextLine().split(" ");
        int num1 = getIntA();
        char znak = getZnak();
        int num2 = getIntB();
        int result = calc(num1, znak, num2);
        if (isRomanA!=isRomanB) {
            throw new Exception("Невозможно применить операцию с разными системами счисления.");
        }
        if (isRomanA) {
            if (result <= 0) {
                throw new Exception("Римская система счислений не имеет значений меньше единицы.");
            }
            String s = tr.arabToRim(result);
            System.out.println("Результат операции: " + s);
        } else {
            System.out.println("Результат операции: " + result);

        }
    }
}


