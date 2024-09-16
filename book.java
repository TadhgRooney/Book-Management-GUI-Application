

public class book { // This is the book class

    // These are the attributes of the book class
    private String bookName; // Attribute to store the name of the book
    private String bookLike; // Attribute to store what the reader liked about the book
    private String bookLearn; // Attribute to store what the reader learned from the book
    private String bookThoughts; // Attribute to store any other thoughts about the book
    private String bookAuthor; // Attribute to store the author of the book


    // This is the constructor for the book class
    public book (String bookName, String bookLike, String bookLearn, String bookThoughts, String bookAuthor) {
        this.bookName = bookName; // Assign the value of bookName parameter to the bookName attribute
        this.bookLike = bookLike; // Assign the value of bookLike parameter to the bookLike attribute
        this.bookLearn = bookLearn; // Assign the value of bookLearn parameter to the bookLearn attribute
        this.bookThoughts = bookThoughts; // Assign the value of bookThoughts parameter to the bookThoughts attribute
        this.bookAuthor = bookAuthor; // Assign the value of bookAuthor parameter to the bookAuthor attribute
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // This is the getter for the bookName attribute
    public String getBookName() {
        return bookName; // Return the value of the bookName attribute
    }

    // This is the setter for the bookName attribute
    public void setBookName(String bookName) {
        this.bookName = bookName; // Set the value of the bookName attribute to the given parameter value
    }

    // This is the getter for the bookLike attribute
    public String getBookLike() {
        return bookLike; // Return the value of the bookLike attribute
    }

    // This is the setter for the bookLike attribute
    public void setBookLike(String bookLike) {
        this.bookLike = bookLike; // Set the value of the bookLike attribute to the given parameter value
    }

    // This is the getter for the bookLearn attribute
    public String getBookLearn() {
        return bookLearn; // Return the value of the bookLearn attribute
    }

    // This is the setter for the bookLearn attribute
    public void setBookLearn(String bookLearn) {
        this.bookLearn = bookLearn; // Set the value of the bookLearn attribute to the given parameter value
    }

    // This is the getter for the bookThoughts attribute
    public String getBookThoughts() {
        return bookThoughts; // Return the value of the bookThoughts attribute
    }

    // This is the setter for the bookThoughts attribute
    public void setBookThoughts(String bookThoughts) {
        this.bookThoughts = bookThoughts; // Set the value of the bookThoughts attribute to the given parameter value
    }

    // This is the toString method for the book class
    public String toString() {
        return "Book Name: " + bookName + "Book Author: " + bookAuthor + "\n" + "What I liked: " + bookLike + "\n" + "What I learned: " + bookLearn + "\n" + "Other thoughts: " + bookThoughts; // Return a string representation of the book object
    }
    
}
