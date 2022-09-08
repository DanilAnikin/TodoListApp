package model;

public class TextImageTodo extends Todo {
    public String imageURL;
    public String text;

    public TextImageTodo(String title, String dateCreation, String text, String imageURL) {
        super(title, dateCreation);
        this.text = text;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return title + "\t" + dateCreation + "\n" + text + "\n" + imageURL + "\n";
    }
}
