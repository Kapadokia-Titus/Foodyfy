package kapadokia.nyandoro.foodclient.utils;

import java.math.BigDecimal;
import java.util.HashMap;

import kapadokia.nyandoro.foodclient.R;
import kapadokia.nyandoro.foodclient.model.Product;


public class Products {

    public Product[] PRODUCTS = {BIRIANI, KUKU, MISHIKAKI, WHITE_MUG, RED_MUG, BLACK_HAT, BLUE_HAT, WHITE_HAT, ORANGE_HAT,
            WHITE_SHIRT_MALE, WHITE_SHIRT_FEMALE, BLACK_SHIRT_FEMALE, BLACK_SHIRT_MALE, GREY_FIDGET_SPINNER, GREEN_FIDGET_SPINNER, ICELAND_PICTURE
            , ICEY_COAST_PICTURE, HAVASU_FALLS_PICTURE, FRANCE_MOUNTAINS_PICTURE, GREEN_HILLS_PICTURE};


    public HashMap<String, Product> PRODUCT_MAP = new HashMap<>();

    public Products() {
        for(Product product : PRODUCTS){
            PRODUCT_MAP.put(String.valueOf(product.getSerial_number()), product);
        }

    }

    public static final Product BIRIANI = new Product("Biriani", "Biriani bora kuliko biriani yoyote ile inchini " +
            "and matching any red furniture.", R.drawable.biriani, new BigDecimal(10.99), new BigDecimal(9.50), 161,
            new BigDecimal(4.5), 1515611);

    public static final Product KUKU = new Product("Kuku Fry", "Kuku fry with salad and ketchup " +
            "and matching any Yellow furniture.", R.drawable.kuku, new BigDecimal(11.99), new BigDecimal(0), 6,
            new BigDecimal(5), 7725277);

    public static final Product MISHIKAKI = new Product("Blue Coffee Mug", "Blue Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.mishikaki, new BigDecimal(5.99), new BigDecimal(0), 66, new BigDecimal(3.5), 2141515);

    public static final Product WHITE_MUG = new Product("White Coffee Mug", "White Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.nyama, new BigDecimal(6.99), new BigDecimal(0), 7, new BigDecimal(4), 9704833);

    public static final Product RED_MUG = new Product("Red Coffee Mug Red", "Red Coffee Mug for drinking coffee. 100% ceramic.",
            R.drawable.biriani_nyama, new BigDecimal(8.99), new BigDecimal(0), 157, new BigDecimal(4.5), 9377376);

    public static final Product BLACK_HAT = new Product("Black Baseball Hat", "Black Baseball Hat made of 100% authentic " +
            "baseball hat material.",
            R.drawable.samaki, new BigDecimal(20.99), new BigDecimal(0), 121, new BigDecimal(3.5), 6626622);

    public static final Product BLUE_HAT = new Product("Blue Baseball Hat", "Blue Baseball Hat made of 100% authentic " +
            "baseball hat material.",
            R.drawable.burger, new BigDecimal(22.99), new BigDecimal(0), 67, new BigDecimal(4.5), 7837367);

    public static final Product WHITE_HAT = new Product("White Baseball Hat", "White Baseball Hat made of 100% authentic " +
            "baseball hat material.",
            R.drawable.burger_two_food, new BigDecimal(18.99), new BigDecimal(15.99), 88, new BigDecimal(2.5), 7695085);

    public static final Product ORANGE_HAT = new Product("Orange Baseball Hat", "Orange Baseball Hat made of 100% authentic " +
            "baseball hat material.",
            R.drawable.breakfast, new BigDecimal(23.99), new BigDecimal(0), 23, new BigDecimal(4), 9084728);

    public static final Product WHITE_SHIRT_FEMALE = new Product("White Shirt", "White T-Shirt made of 100% cotton. Made for " +
            "females.", R.drawable.fastfood, new BigDecimal(25.99), new BigDecimal(0), 98, new BigDecimal(5)
            , 7265405);

    public static final Product WHITE_SHIRT_MALE = new Product("White Shirt", "White T-Shirt made of 100% cotton. Made for " +
            "males.", R.drawable.birianinyama, new BigDecimal(26.99), new BigDecimal(0), 11, new BigDecimal(3)
            , 9575721);

    public static final Product BLACK_SHIRT_FEMALE = new Product("Black Shirt", "Black T-Shirt made of 100% cotton. Made for " +
            "females.", R.drawable.fast_food, new BigDecimal(25.99), new BigDecimal(0), 51, new BigDecimal(4.5)
            , 5776336);

    public static final Product BLACK_SHIRT_MALE = new Product("Black Shirt", "Black T-Shirt made of 100% cotton. Made for " +
            "males.", R.drawable.fast_food, new BigDecimal(26.99), new BigDecimal(0), 616, new BigDecimal(5)
            , 1408483);

    public static final Product GREY_FIDGET_SPINNER = new Product("Grey Fidget Spinner", "Grey Fidget Spinner. High quality" +
            " bearing for long spin time. Light and portable.", R.drawable.fruits, new BigDecimal(100), new BigDecimal(59.99)
            , 37, new BigDecimal(4.5), 8830303);

    public static final Product GREEN_FIDGET_SPINNER = new Product("Green Fidget Spinner", "Green Fidget Spinner. High quality" +
            " bearing for long spin time. Light and portable.", R.drawable.hambugger, new BigDecimal(100), new BigDecimal(0)
            , 3, new BigDecimal(4), 9082727);

    public static final Product ICELAND_PICTURE = new Product("Picture of Water in Iceland", "Beautiful picture of Iceland and its " +
            "cold waters.", R.drawable.diabetic_food, new BigDecimal(189.50), new BigDecimal(100), 43,
            new BigDecimal(4.8), 6638393);

    public static final Product FRANCE_MOUNTAINS_PICTURE = new Product("Picture of the Mountains in France", "Here is an incredible picture" +
            " of the mountains in France.", R.drawable.hotdog, new BigDecimal(356), new BigDecimal(315), 22,
            new BigDecimal(3.2), 8093475);

    public static final Product GREEN_HILLS_PICTURE = new Product("Picture of green hills in GreenLand", "A calming image of a sunset in " +
            "Greenland.", R.drawable.mayai, new BigDecimal(99), new BigDecimal(50), 79,
            new BigDecimal(4.1), 1485032);

    public static final Product HAVASU_FALLS_PICTURE = new Product("A Very Famous Picture of Havasu Falls", "Check out this famous picture " +
            "of Havasu Falls.", R.drawable.meat, new BigDecimal(76), new BigDecimal(0), 81,
            new BigDecimal(4.9), 8041414);

    public static final Product ICEY_COAST_PICTURE = new Product("An Image of the Icy Coast of Iceland", "Looking at this picture practically " +
            "makes you shiver! But it makes me appreciate warm weather.", R.drawable.pizza, new BigDecimal(120), new BigDecimal(0), 37,
            new BigDecimal(3.3), 1145614);
}

