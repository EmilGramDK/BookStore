public class PaperBook extends Book {
    private int stock;

    public PaperBook(String bookId, String title, Author author, double price, int stock) {
        super(bookId, title, author, price);
        this.stock = stock;
    }

    @Override
    public String getBookInfo() {
        return super.getBookInfo() + " | (PaperBook [" + stock + " in stock])";
    }

    public int getStock() {
        return stock;
    }
}
