
public class App {

    static Menu menu = new Menu();
    static Customer appCustomer = null;
    static BookStore bookstore = new BookStore();

    public static void main(String[] args) {

        // generate test data
        bookstore.generateTestData();

        // run the app until the user quits
        while (menu.getRunning()) {

            // if no customer is selected, display the start screen
            if (appCustomer == null) {
                appCustomer = menu.displayStartScreen(bookstore);
                bookstore.addCustomer(appCustomer);
                continue;
            }

            // display the main menu
            menu.displayMainMenu(bookstore, appCustomer);

        }

    }

}