package kapadokia.nyandoro.foodclient.utils;

import java.math.BigDecimal;
import java.util.HashMap;

import kapadokia.nyandoro.foodclient.model.Product;


public class Prices {

    private static final HashMap<String, BigDecimal> PRICES;
    static
    {
        PRICES = new HashMap<String, BigDecimal>();
        Products products = new Products();
        for(Product product : products.PRODUCTS){
            PRICES.put(String.valueOf(product.getSerial_number()), product.getPrice());
        }
    }



    public static HashMap<String, BigDecimal> getPrices(){
        return  PRICES;
    }
}
