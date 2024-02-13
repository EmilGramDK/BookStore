// This is the abstract class for the Book object.
public abstract class Book implements BookInfo {
    private String bookId;
    private String title;
    private Author author;
    private double price;

    public Book(String bookId, String title, Author author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getBookInfo() {
        return bookId + ") " + title + " - " + author.getName() + " - " + price + " kr.";
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author.getName();
    }

    public double getPrice() {
        return price;
    }
}
