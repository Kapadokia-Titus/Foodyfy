package kapadokia.nyandoro.foodclient;

import android.util.Log;

import java.util.List;
import io.paperdb.Paper;

public class FoodCart {

    public static void addItem(CheckoutModel modelItem){

        int quantity;
        List<CheckoutModel> checkoutList = getCart();
        for (int i=0;i<checkoutList.size();i++){
        CheckoutModel targetItem = null;
            targetItem  =  checkoutList.get(i);
            Log.d("FoodCart", "FoodCart name "+targetItem.getName());
        }
        if (modelItem == null) {
            quantity = Integer.parseInt(modelItem.getQuantity())  + 1;
            String quantityString = String.valueOf(quantity);
            modelItem.setQuantity(quantityString);
            checkoutList.add(modelItem);
        } else {
            quantity = Integer.parseInt(modelItem.getQuantity())  + 1;
            String quantityString = String.valueOf(quantity);
            modelItem.setQuantity(quantityString);
            Log.d("FoodCart","Food Cart Quantity: "+modelItem.getQuantity());

        }
        saveCart(checkoutList);


    }



    public static void saveCart(List<CheckoutModel> cart) {
        Paper.book().write("cart", cart);
    }

    public static List<CheckoutModel> getCart() {
        return Paper.book().read("cart");
    }

    public static int getFoodCartSize() {
        Log.d("ShoppingCart","Cart Size: "+getCart().size());
        return getCart().size();
    }
}
