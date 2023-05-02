package domain;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    //productID mapped to the Product object
    private final Map<String, Product> catalog;
    //productID mapped to its quantity
    private final Map<String, Integer> mapProductToQuantity;
    //productID mapped to its total purchase price and total quantity
    private final Map<String, List<Integer>> totalPriceAndQuantity;
    //productID mapped to its total order price and quantity
    private final Map<String, List<Integer>> totalOrderPriceAndQuantity;
    //productID mapped to number of times it has been ordered
    private final Map<String, Integer> numberOfOrders;
    //storing order reports


    public ProductRepository() {
        catalog = new HashMap<>();
        mapProductToQuantity = new HashMap<>();
        totalPriceAndQuantity = new HashMap<>();
        totalOrderPriceAndQuantity = new HashMap<>();
        numberOfOrders = new HashMap<>();
    }

    public Map<String, Product> getCatalog() {
        return catalog;
    }

    public Map<String, Integer> getMapProductToQuantity() {
        return mapProductToQuantity;
    }

    public Map<String, List<Integer>> getTotalPriceAndQuantity() {
        return totalPriceAndQuantity;
    }

    public Map<String, List<Integer>> getTotalOrderPriceAndQuantity() {
        return totalOrderPriceAndQuantity;
    }

    public Map<String, Integer> getNumberOfOrders() {
        return numberOfOrders;
    }
}
