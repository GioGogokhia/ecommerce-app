package consoleApp;

import store.Store;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader {
    private final Store store;
    private final Scanner scanner;

    private final String SAVE_PRODUCT = "save_product";
    private final String PURCHASE_PRODUCT = "purchase_product";
    private final String ORDER_PRODUCT = "order_product";
    private final String GET_QUANTITY_OF_PRODUCT = "get_quantity_of_product";
    private final String GET_AVERAGE_PRICE = "get_average_price";
    private final String GET_PRODUCT_PROFIT = "get_product_profit";
    private final String GET_FEWEST_PRODUCT = "get_fewest_product";
    private final String GET_MOST_POPULAR_PRODUCT = "get_most_popular_product";
    private final String EXIT_COMMAND = "exit";

    public ConsoleReader(Store store, InputStream inputStream) {
        this.store = store;
        scanner = new Scanner(inputStream);
    }

    public void start() {
        boolean messageIsNotExit = true;
        while (messageIsNotExit) {
            String message = scanner.next();
            switch (message) {
                case SAVE_PRODUCT: {
                    store.saveProduct(scanner.next(), scanner.next(), scanner.nextInt());
                    System.out.println("Saved the product successfully!");
                    break;
                }
                case PURCHASE_PRODUCT: {
                    store.purchaseProduct(scanner.next(), scanner.nextInt(), scanner.nextInt());
                    System.out.print("Purchased the product successfully!");
                    break;
                }
                case ORDER_PRODUCT: {
                    store.orderProduct(scanner.next(), scanner.nextInt());
                    System.out.println("Product ordered successfully!");
                    break;
                }
                case GET_QUANTITY_OF_PRODUCT: {
                    System.out.println(store.getQuantityOfProduct(scanner.next()));
                    break;
                }
                case GET_AVERAGE_PRICE: {
                    System.out.println(store.getAveragePrice(scanner.next()));
                    break;
                }
                case GET_PRODUCT_PROFIT: {
                    System.out.println(store.getProductProfit(scanner.next()));
                    break;
                }
                case GET_FEWEST_PRODUCT: {
                    System.out.println(store.getFewestProduct());
                    break;
                }
                case GET_MOST_POPULAR_PRODUCT: {
                    System.out.println(store.getMostPopularProduct());
                    break;
                }
                case EXIT_COMMAND: {
                    System.out.println("Goodbye!");
                    messageIsNotExit = false;
                    break;
                }
                default: {
                    System.out.println("Command " + message + " is not supported");
                }
            }
        }
    }
}
