package data;

import model.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodosDatabase {
    private final ArrayList<Todo> todosList;
    private final Scanner scanner = new Scanner(System.in);

    public TodosDatabase() {
        todosList = new ArrayList<>();
    }

    public boolean add(Todo newTodo) {
        for (Todo todo : todosList) {
            if (newTodo.title.equalsIgnoreCase(todo.title)) {
                return false;
            }
        }
        todosList.add(newTodo);
        return true;
    }

    public void remove(Todo todo) {
        todosList.remove(todo);
    }

    public void showTodosList() {
        for (int i = 0; i < todosList.size(); i++) {
            Todo todo = todosList.get(i);
            System.out.println(i + 1 + ". " + todo.title);
        }
    }

    public void showDetailedTodo(Todo todo) {
        System.out.println(todo);
    }

    public Todo findTodo(String actionToPrint) {
        System.out.println("Введите заголовок записи, которую хотите " + actionToPrint + ".");
        String title = scanner.nextLine();
        for (Todo todo : todosList) {
            if (title.equalsIgnoreCase(todo.title)) {
                return todo;
            }
        }
        System.out.println("Записи с такими заголовком не найдено.");
        return null;
    }

}
