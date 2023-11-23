import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

    //Task1
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите символ");
        char symbol = scanner.next().charAt(0);
        int counter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == symbol) {
                System.out.println(i);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Совпадений не найдено");
        } else {
            System.out.println("Кол-во совпадений = " + counter);
        }
    }

    //Task2
    public static void task2() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            stringBuilder.append(String.valueOf(random.nextInt(9) + 1));
        }
        String randomNum = stringBuilder.toString();
        System.out.println(randomNum);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер позиции с 1 до 1000");
        int n = scanner.nextInt();
        if (n > 0 && n <= 1000) {
            System.out.println(randomNum.charAt(n - 1));
        } else {
            System.out.println("вы вышли за пределы диапазона");
        }
    }

    //Task3
    public static void task3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение");
        String string = scanner.nextLine();
        String[] words = string.split(" ");
        int wordCounter = 0;
        int lengthCounter = 0;

        for (int i = 0; i < words.length; i++) {
            wordCounter++;
            lengthCounter += words[i].length();
        }

        System.out.println("Средняя длина слова в предложении = " + lengthCounter / wordCounter);
    }
}