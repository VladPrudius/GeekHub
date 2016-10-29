import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int numberIntTwo, b, v;
        int a = 0;
        String str = new String();
        String valid = new String("098");
        String validationString = "0123456789";

        while (true) {
            System.out.println("Важно, номер должен начинаться с символов ( 098 )");
            System.out.println("Введите телефонный номер: ");
            str = scan.nextLine();

            char[] massChar = str.toCharArray();
            if (massChar.length > 10) {
                System.out.println("Error lenght");
            }

            for (char c : massChar) {
                if (validationString.indexOf(c) == -1) {
                    System.out.println("Error Symbols");
                }
            }

            if (!(str.regionMatches(0, valid, 0, 3))) {
                System.out.println("Error index");
            }

            for (int i = 0; i < massChar.length; i++) {
                a += Character.getNumericValue(massChar[i]);
            }

            b = a % 10;
            v = a / 10;
            numberIntTwo = v + b;

            System.out.println("Сумма чисел суммы чисел номера ровна: " + numberIntTwo);
            if (numberIntTwo == 1) {
                System.out.println("Один");
            }
            if (numberIntTwo == 2) {
                System.out.println("Два");
            }
            if (numberIntTwo == 3) {
                System.out.println("Три");
            }
            if (numberIntTwo == 4) {
                System.out.println("Четыре");
            }
            if (numberIntTwo == 5) {
                System.out.println("Пять");
            }
            if (numberIntTwo == 6) {
                System.out.println("Шесть");
            }
            if (numberIntTwo == 7) {
                System.out.println("Семь");
            }
            if (numberIntTwo == 8) {
                System.out.println("Восемь");
            }
            if (numberIntTwo == 9) {
                System.out.println("Девять");
            }

            numberIntTwo = 0;
        }
    }
}
