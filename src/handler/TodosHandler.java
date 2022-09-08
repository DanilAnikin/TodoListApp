package handler;

import model.ImageTodo;
import model.TextImageTodo;
import model.TextTodo;
import model.Todo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TodosHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final ChoiceProvider choiceProvider = new ChoiceProvider();

    public Todo create(byte todoType) {
        String currentDate = getCurrentDate();
        System.out.print("Введите заголовок: ");
        String title = scanner.nextLine();
        if (todoType == 1) {
            return new Todo(title, currentDate);
        } else if (todoType == 2) {
            System.out.print("Введите текст: ");
            String text = scanner.nextLine();
            return new TextTodo(title, currentDate, text);
        } else if (todoType == 3) {
            System.out.print("Введите URL картинки: ");
            String url = scanner.next();
            return new ImageTodo(title, currentDate, url);
        } else {
            System.out.print("Введите текст: ");
            String text = scanner.nextLine();
            System.out.print("Введите URL картинки: ");
            String url = scanner.next();
            return new TextImageTodo(title, currentDate, text, url);
        }
    }

    public void update(Todo todo) {
        if (shouldChangeField("заголовок")) {
            System.out.print("Введите новый заголовок: ");
            todo.title = scanner.nextLine();
        }

        if (todo instanceof TextTodo) {
            if (shouldChangeField("текс")) {
                System.out.println("Введите новый текст:");
                ((TextTodo) todo).text = scanner.nextLine();
            }
        } else if (todo instanceof ImageTodo) {
            if (shouldChangeField("картинку")) {
                System.out.println("Введите URL новой картинки: ");
                ((ImageTodo) todo).imageURL = scanner.next();
            }
        } else if (todo instanceof TextImageTodo) {
            if (shouldChangeField("текс")) {
                System.out.println("Введите новый текст:");
                ((TextImageTodo) todo).text = scanner.nextLine();
            }
            if (shouldChangeField("картинку")) {
                System.out.println("Введите URL новой картинки: ");
                ((TextImageTodo) todo).imageURL = scanner.next();
            }
        }
        todo.dateCreation = getCurrentDate();
    }

    private String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd | HH:mm");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    private boolean shouldChangeField(String fieldName) {
        System.out.println("Изменить " + fieldName + "?");
        System.out.println("1 - да\n2 - нет");
        byte editChoice = choiceProvider.provide(1, 2);
        return editChoice == 1;
    }
}
