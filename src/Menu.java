public class Menu {

    private boolean appRunning;

    public Menu() {
        this.appRunning = true;
    }

    public boolean getRunning() {
        return this.appRunning;
    }

    public void setRunning(boolean appRunning) {
        this.appRunning = appRunning;
    }

    public Customer displayStartScreen(BookStore bookstore) {

        clearConsole();

        System.out.println("WELCOME TO THE BOOKSTORE");
        System.out.println();

        // select or create new customer
        System.out.println("1) Select existing customer");
        System.out.println("2) Create new customer");
        backOrQuitText(false);

        System.out.println();

        String userInput = System.console().readLine();

        Customer appCustomer = null;

        switch (userInput) {
            case "1":
                appCustomer = selectCustomer(bookstore);
                break;
            case "2":
                appCustomer = createCustomer(bookstore);
                break;
            case "q":
                setRunning(false);
                break;
            default:
                break;
        }

        return appCustomer;

    }

    public Customer createCustomer(BookStore bookstore) {

        clearConsole();

        System.out.println("Enter your name");
        System.out.println("");
        String name = System.console().readLine();

        clearConsole();

        System.out.println("Enter your email");
        System.out.println("");
        String email = System.console().readLine();

        String customerId = bookstore.getAllCustomers().size() + 1 + "";

        Customer customer = new Customer(customerId, name, email);

        return customer;
    }

    public Customer selectCustomer(BookStore bookstore) {

        clearConsole();

        System.out.println("SELECT A CUSTOMER BELOW");

        System.out.println();

        for (Customer customer : bookstore.getAllCustomers()) {
            System.out.println(customer.getCustomerId() + ") " + customer.getName());
        }
        backOrQuitText(false);

        System.out.println();

        String userInput = System.console().readLine();

        if (userInput.equals("q")) {
            setRunning(false);
            return null;
        }

        Customer appCustomer = null;

        for (Customer customer : bookstore.getAllCustomers()) {
            if (customer.getCustomerId().equals(userInput)) {
                appCustomer = customer;
                break;
            }
        }

        return appCustomer;

    }

    public void displayMainMenu(BookStore bookstore, Customer appCustomer) {

        clearConsole();

        System.out.println("WELCOME \u001B[36m" + appCustomer.getName() + "\u001B[0m!");
        System.out.println();

        // menu
        System.out.println("1) View all books        2) View all authors");
        System.out.println("3) View cart");
        backOrQuitText(false);

        System.out.println();

        String userInput = System.console().readLine();

        switch (userInput) {
            case "1":
                displayAllBooks(bookstore, appCustomer);
                break;
            case "2":
                displayAllAuthors(bookstore, appCustomer);
                break;
            case "3":
                displayCart(bookstore, appCustomer);
                break;
            case "q":
                setRunning(false);
                break;
            default:
                break;
        }

    }

    public void displayCart(BookStore bookstore, Customer appCustomer) {

        clearConsole();

        System.out.println("YOUR CART");
        System.out.println("SELECT A BOOK TO REMOVE IT FROM YOUR CART");

        System.out.println();

        // display all books in cart
        for (Book book : appCustomer.getCart()) {
            System.out.println(book.getBookInfo());
        }
        backOrQuitText(true);

        System.out.println();

        String userInput = System.console().readLine();

        if (userInput.equals("q")) {
            setRunning(false);
            return;
        }

        for (Book book : appCustomer.getCart()) {
            if (book.getBookId().equals(userInput)) {
                appCustomer.getCart().remove(book);
                break;
            }
        }

    }

    public void displayAllAuthors(BookStore bookstore, Customer appCustomer) {

        clearConsole();

        System.out.println("ALL AUTHORS");
        System.out.println("SELECT AN AUTHOR TO VIEW THEIR BOOKS");

        System.out.println();

        // display all authors
        for (Author author : bookstore.getAllAuthors()) {
            System.out.println(author.getAuthorId() + ") " + author.getName());
        }
        backOrQuitText(true);

        System.out.println();

        String userInput = System.console().readLine();

        if (userInput.equals("q")) {
            setRunning(false);
            return;
        }

        for (Author author : bookstore.getAllAuthors()) {
            if (author.getAuthorId().equals(userInput)) {
                displayAuthorBooks(author, bookstore, appCustomer);
                break;
            }
        }

    }

    public void displayAuthorBooks(Author author, BookStore bookstore, Customer appCustomer) {

        clearConsole();

        System.out.println("BOOKS BY " + author.getName());
        System.out.println("SELECT A BOOK TO ADD TO YOUR CART");

        System.out.println();

        // display all books by author
        for (Book book : bookstore.getAllBooks()) {
            if (book.getAuthor().equals(author.getName())) {
                System.out.println(book.getBookInfo());
            }
        }
        backOrQuitText(true);

        System.out.println();

        String userInput = System.console().readLine();

        if (userInput.equals("q")) {
            setRunning(false);
            return;
        }

        for (Book book : bookstore.getAllBooks()) {
            if (book.getBookId().equals(userInput)) {
                appCustomer.addToCart(book);
                break;
            }
        }

    }

    public void displayAllBooks(BookStore bookstore, Customer appCustomer) {

        clearConsole();

        System.out.println("ALL BOOKS");
        System.out.println("SELECT A BOOK TO ADD TO YOUR CART");

        System.out.println();

        // display all books
        for (Book book : bookstore.getAllBooks()) {
            System.out.println(book.getBookId() + ") " + book.getTitle() + " - " + book.getAuthor() + " - "
                    + book.getPrice() + " kr.");
        }
        backOrQuitText(true);

        System.out.println();

        String userInput = System.console().readLine();

        if (userInput.equals("q")) {
            setRunning(false);
            return;
        }

        for (Book book : bookstore.getAllBooks()) {
            if (book.getBookId().equals(userInput)) {
                appCustomer.addToCart(book);
                break;
            }
        }

    }

    public void backOrQuitText(boolean back) {
        System.out.println("");

        if (back) {
            System.out.println("\u001B[33mb) Back\u001B[0m       \u001B[31mq) Quit\u001B[0m");
            return;
        }

        System.out.println("\u001B[31mq) Quit\u001B[0m");

    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

}
