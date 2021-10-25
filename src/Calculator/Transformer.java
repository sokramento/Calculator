package Calculator;

public class Transformer {
    static int[] numbers = {1, 4, 5, 9, 10, 50, 100};
    static String[] letters = {"I", "IV", "V", "IX", "X", "L", "C"};

    public static void main(String[] args) {
        arabToRim (26);
    }

    public static String arabToRim(int number) {
        String romanValue = "";
        int N = number;
        while (N > 0) {
            for (int i = 0; i < numbers.length; i++) {
                if (N < numbers[i]) {
                    N -= numbers[i - 1];
                    romanValue += letters[i - 1];
                    break;
                }
            }
        }
        return romanValue;
    }

    public static int rimToArab(String letter) throws Exception {
        switch (letter) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception("Вы ввели неподходящее значение. Перезапустите программу.");
        }
    }
}
