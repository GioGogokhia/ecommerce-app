package consoleApp;

import store.Store;

public class StoreApp {
    public static void main(String[] args) {
        Store store = new Store();

        ConsoleReader consoleReader = new ConsoleReader(store, System.in);
        consoleReader.start();
    }
}
