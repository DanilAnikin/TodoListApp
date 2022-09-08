package model;

public class ImageTodo extends Todo {
    public String imageURL;

    public ImageTodo(String title, String dateCreation, String imageURL) {
        super(title, dateCreation);
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return title + "\t" + dateCreation + "\n" + imageURL + "\n";
    }
}
