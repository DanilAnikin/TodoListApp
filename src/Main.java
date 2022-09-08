import data.TodosDatabase;
import handler.ChoiceProvider;
import handler.TodosHandler;
import model.Todo;

public class Main {
    private static final ChoiceProvider choiceProvider = new ChoiceProvider();
    private static final TodosHandler todosHandler = new TodosHandler();
    private static final TodosDatabase todosDatabase = new TodosDatabase();

    public static void main(String[] args) {
        System.out.println("Привет!");
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("""
                    1 - добавить запись
                    2 - удалить запись
                    3 - редактировать запись
                    4 - посмотреть конкретную запись
                    5 - посмотреть список всех записей
                    6 - завершить работу программы"""

            );
            byte actionChoice = choiceProvider.provide(1, 6);
            if (actionChoice == 6) {
                break;
            } else if (actionChoice == 1) {
                System.out.println("Выберите тип записи:");
                System.out.println("""
                        1 - с заголовком
                        2 - с заголовком и текстом
                        3 - с заголовком и картинкой
                        4 - с заголовком, текстом и картинкой"""

                );
                byte todoType = choiceProvider.provide(1, 4);
                Todo todo = todosHandler.create(todoType);
                boolean isTodoAdded = todosDatabase.add(todo);
                if (isTodoAdded) {
                    System.out.println("Запись была успешно добавлена.");
                    continue;
                }
                System.out.println("Запись с таким заголовком уже существует.");
            } else if (actionChoice == 2) {
                Todo todoToRemove = todosDatabase.findTodo("удалить");
                if (todoToRemove == null) {
                    continue;
                }
                todosDatabase.remove(todoToRemove);
                System.out.println("Запись была успешно удалена.");
            } else if (actionChoice == 3) {
                Todo todoToUpdate = todosDatabase.findTodo("отредактировать");
                if (todoToUpdate == null) {
                    continue;
                }
                todosHandler.update(todoToUpdate);
                System.out.println("Запись была успешно отредактирована.");
            } else if (actionChoice == 4) {
                Todo todoToShow = todosDatabase.findTodo("посмотреть");
                if (todoToShow == null) {
                    continue;
                }
                todosDatabase.showDetailedTodo(todoToShow);
            } else {
                todosDatabase.showTodosList();
            }
        }
    }
}
