import java.util.Date;
import java.util.List;

public class Order implements OrderInfo {
    private String orderId;
    private Customer customer;
    private List<Book> items;
    private Date orderDate;

    public Order(String orderId, Customer customer, List<Book> items) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.orderDate = new Date(); // Automatically set the order date to the current date
    }

    // Getters for the fields
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Book> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Book book : items) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
}

interface OrderInfo {
    String getOrderId();
    Customer getCustomer();
    List<Book> getItems();
    Date getOrderDate();
    double getTotalPrice();
}
 