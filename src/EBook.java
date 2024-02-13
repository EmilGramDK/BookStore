public class EBook extends Book {
    private double fileSize; // size in MB

    public EBook(String bookId, String title, Author author, double price, double fileSize) {
        super(bookId, title, author, price);
        this.fileSize = fileSize;
    }

    @Override
    public String getBookInfo() {
        return super.getBookInfo() + " | (EBook ["+fileSize+"MB])";
    }

    public double getFileSize() {
        return fileSize;
    }

}
