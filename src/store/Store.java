package store;

import domain.Product;
import domain.ProductRepository;

import java.util.*;

public class Store {
    ProductRepository productRepository;

    public Store(){
        productRepository = new ProductRepository();
    }

    public void saveProduct(String productID, String productName, int price) {
        if (productRepository.getCatalog().containsKey(productID)) {
            // Product already exists, update the existing product
            Product existingProduct = productRepository.getCatalog().get(productID);
            /* In pdf it says that save_product modifies the price, but I add the possibility to change the
            name as well, otherwise I don't see a purpose of having product's name as a parameter */
            existingProduct.setName(productName);
            existingProduct.setPrice(price);
        } else {
            // Product does not exist, create a new product and add it to the productRepository.getCatalog()
            Product newProduct = new Product(productID, productName, price);
            productRepository.getCatalog().put(productID, newProduct);

            //registering new product in all the maps
            productRepository.getTotalPriceAndQuantity().put(productID, List.of(0,0));
            productRepository.getMapProductToQuantity().put(productID, 0);
            productRepository.getTotalOrderPriceAndQuantity().put(productID, List.of(0,0));
            productRepository.getNumberOfOrders().put(productID, 0);
        }
    }

    public void purchaseProduct(String productID, int quantity, int price){
        productRepository.getMapProductToQuantity().put(productID, productRepository.getMapProductToQuantity()
                .get(productID) + quantity);
        //store total amount of purchase price and quantity for the method getAveragePrice
        productRepository.getTotalPriceAndQuantity().put(productID, List.of(
                productRepository.getTotalPriceAndQuantity().get(productID).get(0) + (price * quantity),
                productRepository.getTotalPriceAndQuantity().get(productID).get(1) + quantity));
    }

    public void orderProduct(String productID, int quantity){
        productRepository.getMapProductToQuantity().put(productID, productRepository.getMapProductToQuantity()
                .get(productID) - quantity);
        //store how many times the product has been ordered for method getMostPopularProduct
        productRepository.getNumberOfOrders().put(productID,
                productRepository.getNumberOfOrders().get(productID) + quantity);
        //store total amount of order price and quantity for the method etProductProfit
        productRepository.getTotalOrderPriceAndQuantity().put(productID, List.of(
                productRepository.getTotalOrderPriceAndQuantity().get(productID).get(0) +
                        (productRepository.getCatalog().get(productID).getPrice()) * quantity,
                productRepository.getTotalOrderPriceAndQuantity().get(productID).get(1) +
                        quantity));
    }

    public Integer getQuantityOfProduct(String productID){
        return productRepository.getMapProductToQuantity().get(productID);
    }

    public Integer getAveragePrice(String productID){
        int price = productRepository.getTotalPriceAndQuantity().get(productID).get(0);
        int quantity = productRepository.getTotalPriceAndQuantity().get(productID).get(1);
        return price/quantity;
    }

    public Integer getProductProfit(String productID){
        int orderQuantity = productRepository.getTotalOrderPriceAndQuantity().get(productID).get(1);
        int averageOrderPrice = productRepository.getTotalOrderPriceAndQuantity().get(productID).get(0)/orderQuantity;
        int averagePurchasePrice = getAveragePrice(productID);
        return  (averageOrderPrice - averagePurchasePrice) * orderQuantity;
    }

    public String getFewestProduct(){
        //get ID of the product and then return its name
        String productID = Collections.min(productRepository.getMapProductToQuantity().entrySet(),
                Map.Entry.comparingByValue()).getKey();
        return productRepository.getCatalog().get(productID).getName();
    }

    public String getMostPopularProduct(){
        //get ID of the product and then return its name
        String productID = Collections.max(productRepository.getNumberOfOrders().entrySet(),
                Map.Entry.comparingByValue()).getKey();
        return productRepository.getCatalog().get(productID).getName();
    }
}