import java.util.ArrayList;
import java.util.List;

public class Customer implements CustomerInfo {
    private String customerId;
    private String name;
    private String email;
    private List<Book> cart;

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.cart = new ArrayList<>();
    }

    public Customer createCustomer(String customerId, String name, String email) {
        return new Customer(customerId, name, email);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getCart() {
        return cart;
    }

    public void addToCart(Book book) {
        cart.add(book);
    }
}

interface CustomerInfo {
    String getCustomerId();

    String getName();

    String getEmail();

    List<Book> getCart();

    void addToCart(Book book);
}
