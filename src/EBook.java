public class EBook extends Book {
    private double fileSize; // size in MB

    public EBook(String bookId, String title, Author author, double price, int stock, double fileSize) {
        super(bookId, title, author, price, stock);
        this.fileSize = fileSize;
    }

    @Override
    public String getBookInfo() {
        return super.getBookInfo() + " - File Size: " + fileSize + " MB";
    }

    public double getFileSize() {
        return fileSize;
    }

}
