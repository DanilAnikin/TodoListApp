package model;

public class Todo {

    public final int id;
    private static int counter = 0;
    public String title;
    public String dateCreation;

    public Todo(String title, String dateCreation) {
        this.title = title;
        this.dateCreation = dateCreation;
        id = counter++;
    }

    @Override
    public String toString() {
        return title + "\t" + dateCreation + "\n";
    }
}
