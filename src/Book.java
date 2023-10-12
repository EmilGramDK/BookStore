public class Book implements BookInfo {
    private String bookId;
    private String title;
    private Author author;
    private double price;
    private int stock;

    public Book(String bookId, String title, Author author, double price, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + stock);
    }
}

interface BookInfo {
    String getTitle();

    String getAuthor();

    double getPrice();

    int getStock();

    void displayBookInfo();
}
