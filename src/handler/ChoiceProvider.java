package handler;

import java.util.Scanner;

public class ChoiceProvider {
    private final Scanner scanner = new Scanner(System.in);

    public byte provide(int from, int to) {
        String input;
        byte value;
        while (true) {
            System.out.print("Ваш выбор: ");
            input = scanner.next();

            try {
                value = Byte.parseByte(input);
            } catch (NumberFormatException ex) {
                System.out.println("Неверный формат ввода. Введите целое число.");
                continue;
            }

            if (value >= from && value <= to) {
                return value;
            }
            System.out.println("Введите число от " + from + " до " + to);
        }
    }
}
