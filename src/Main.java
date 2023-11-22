import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        task1();
    }
    //Task1
    public static void task1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите символ");
        char symbol = scanner.next().charAt(0);
        int counter = 0;

        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == symbol){
                System.out.println(i);
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Совпадений не найдено");
        } else {
            System.out.println("Кол-во совпадений = " + counter);
        }

    }
}