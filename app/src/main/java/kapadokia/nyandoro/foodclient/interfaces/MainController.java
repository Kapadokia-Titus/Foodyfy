package kapadokia.nyandoro.foodclient.interfaces;

import kapadokia.nyandoro.foodclient.model.CartItem;
import kapadokia.nyandoro.foodclient.model.Food;
import kapadokia.nyandoro.foodclient.model.Product;

public interface MainController {

    void inflateViewProductFragment(Food food);

    void showQuantityDialog();

    void setQuantity(int quantity);

    void addToCart(Food food, int quantity);

    void inflateViewCartFragment();

    void setCartVisibility(boolean visibility);

    void updateQuantity(Product food, int quantity);

    void removeCartItem(CartItem cartItem);
}
