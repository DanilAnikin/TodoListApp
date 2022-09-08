package model;

public class TextTodo extends Todo {
    public String text;

    public TextTodo(String title, String dateCreation, String text) {
        super(title, dateCreation);
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\t" + dateCreation + "\n" + text + "\n";
    }
}
