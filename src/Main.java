import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
        task8();
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
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение");
        String string = scanner.nextLine().toLowerCase();
        String[] words = string.split("\\W+");
        int wordCounter = 0;
        int lengthCounter = 0;

        for (int i = 0; i < words.length; i++) {
            wordCounter++;
            lengthCounter += words[i].length();
        }
        System.out.println("Counter = " + wordCounter);
        System.out.println("Средняя длина слова в предложении = " + lengthCounter / wordCounter);
    }

    //Task4
    public static void task4() {
        String[] vowels = new String[]{"a", "i", "o", "u", "y", "e"};
        String[] consonants = new String[]{"q", "w", "r", "t", "p", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение. Используйте латинские буквы");
        String string = scanner.nextLine().toLowerCase();
        String[] words = string.split("\\W+");

        for (String word : words) {
            boolean isVowels = false;
            boolean isConsonants = false;
            for (String vowel : vowels) {
                if (word.startsWith(vowel)) {
                    isVowels = true;
                    break;
                }
            }
            for (String consonant : consonants) {
                if (word.endsWith(consonant)) {
                    isConsonants = true;
                    break;
                }
            }
            if(isVowels && isConsonants){
                System.out.println(word);
            }
        }
    }

    //Task5
    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение. Слова могут быть разделены только пробелами или двоеточием");
        String string = scanner.nextLine();
        String[] words = string.split("[ :]");
        int counter = 0;
        for (String word : words) {
            if (word.length() % 2 == 0) {
                counter++;
            }
        }
        System.out.println("В предложении " + counter + " слов с четным кол-вом букв");
    }

    //Task6
    public static void task6(){
        String s1 = "4";
        String s2 = "13";
        int counter = 0;

        for (int i = 0; i < 100_000; i++) {
            if(String.valueOf(i).contains(s1) || String.valueOf(i).contains(s2)){
                counter++;
            }
        }

        System.out.println("Будет исключено " + counter + " номеров");

    }

    //Task7
    public static void task7(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение.");

        String s = scanner.nextLine();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))){
                if (Character.isLowerCase(s.charAt(i))){
                    output.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    output.append(Character.toLowerCase(s.charAt(i)));
                }
            } else if(Character.isDigit(s.charAt(i))){
                output.append("_");
            } else {
                output.append(s.charAt(i));
            }
        }

        System.out.println(output);
    }

    //Task8
    public static void task8(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название переменной.");

        String s = scanner.next();
        StringBuilder output = new StringBuilder();

        if(isJavaAndC(s)){
            System.out.println("Название " + s + " имеет смешанный тип (подходит для обоих языков)");
        }
        else if(isC(s)){
            String regex = "_";
            String[] strings = split(s, regex);

            output.append(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                for (int i1 = 0; i1 < strings[i].length(); i1++) {
                    if(i1 == 0){
                        output.append(Character.toUpperCase(strings[i].charAt(i1)));
                    } else {
                        output.append(strings[i].charAt(i1));
                    }
                }
            }
            System.out.println(output);
        }

        else if(isJava(s)){
            String regex = "(?=[A-Z])";
            String add = "_";
            String[] strings = split(s, regex);

            output.append(strings[0]);

            for (int i = 1; i < strings.length; i++) {
                output.append(add);
                for (int i1 = 0; i1 < strings[i].length(); i1++) {
                    if(i1 == 0){
                        output.append(Character.toLowerCase(strings[i].charAt(i1)));
                    } else {
                        output.append(strings[i].charAt(i1));
                    }
                }
            }
            System.out.println(output);

        }
        else {
            System.out.println("неверный формат");
        }
    }

    //С++ - только маленькие буквы, слова разделены нижним подчеркиванием
    public static boolean isC(String string){
        String regEx = "^[a-z]+(_[a-z]+)+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    //JavaAndC - в названии только одно слово с маленькой буквы
    public static boolean isJavaAndC(String string){
        String regEx = "^[a-z]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }

    //Java - первое слово - маленькие буквы, каждое следующееслово - с большой буквы, без пробелов
    public static boolean isJava(String string){
        String regEx = "^[a-z]+([A-Z][a-z]+)+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);

        return matcher.find();
    }
    public static String[] split(String resource,String regex){
        return resource.split(regex);
    }

}