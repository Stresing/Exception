import java.util.Scanner;
public class work2 {
    public static void main(String[] args) {
         /*  Задание №1
             Реализуйте метод, который запрашивает у пользователя ввод дробного числа
            (типа float), и возвращает введенное значение. Ввод текста вместо числа не
             должно приводить к падению приложения, вместо этого, необходимо повторно
             запросить у пользователя ввод данных.
         */

        System.out.println(getFloat());
    }

    public static Float getFloat() {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.print("Введите дробное число: ");
                Float entryNum = Float.parseFloat(scanner.nextLine());
                return  entryNum;
            } catch (Exception e) {
                System.out.println("Ошибка типа введённых данных");
                return getFloat();
            }
        }
    }

}