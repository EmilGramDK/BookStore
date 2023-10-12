import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private List<Book> books;
    private List<Author> authors;
    private List<Customer> customers;
    private List<Order> orders;

    public BookStore() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void generateTestData() {

        // create test authors
        Author author1 = new Author("1", "H.C. Andersen");
        Author author2 = new Author("2", "J.K. Rowling");

        // create test books
        Book book1 = new Book("1", "The Little Mermaid", author1, 199, 10);
        Book book2 = new Book("2", "The Ugly Duckling", author1, 99, 20);
        Book book3 = new Book("3", "Harry Potter", author2, 299, 5);

        // create test customers
        Customer customer1 = new Customer("1", "Emil Gram", "emil@gram.dk");

        // add test data to the bookstore
        addAuthor(author1);
        addAuthor(author2);
        addBook(book1);
        addBook(book2);
        addBook(book3);
        addCustomer(customer1);

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void placeOrder(Customer customer, List<Book> items) {
        Order order = new Order("ORDER" + (orders.size() + 1), customer, items);
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
