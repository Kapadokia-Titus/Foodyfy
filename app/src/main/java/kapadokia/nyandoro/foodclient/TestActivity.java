package kapadokia.nyandoro.foodclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kapadokia.nyandoro.foodclient.databinding.ActivityTestBinding;
import kapadokia.nyandoro.foodclient.interfaces.MainController;
import kapadokia.nyandoro.foodclient.model.CartItem;
import kapadokia.nyandoro.foodclient.model.CartViewModel;
import kapadokia.nyandoro.foodclient.model.Food;
import kapadokia.nyandoro.foodclient.model.Product;
import kapadokia.nyandoro.foodclient.utils.PreferenceKeys;
import kapadokia.nyandoro.foodclient.utils.Products;

public class TestActivity extends AppCompatActivity implements MainController {

    public  static final String TAG = "TestActivity";

    //data binding
    ActivityTestBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);

        init(); 
    }

    private void init() {

        MainFragment mainFragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, mainFragment, getString(R.string.fragment_main));
        transaction.commit();
    }

    private void getShoppingCart(){
        Log.d(TAG, "getShoppingCart: getting shopping cart.");

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Set<String> serialNumbers =preferences.getStringSet(PreferenceKeys.shopping_cart, new HashSet<String>());

        // Retrieve the quantities of each item from the cart
        Products products = new Products();
        List<CartItem> cartItems = new ArrayList<>();

        for (String serialNumber: serialNumbers){
            int quantity =preferences.getInt(serialNumber, 0);

            cartItems.add(new CartItem(products.PRODUCT_MAP.get(serialNumber),quantity));
        }

        CartViewModel viewModel = new CartViewModel();
    }

    @Override
    public void inflateViewProductFragment(Food food) {

    }

    @Override
    public void showQuantityDialog() {

    }

    @Override
    public void setQuantity(int quantity) {

    }

    @Override
    public void addToCart(Food food, int quantity) {

    }

    @Override
    public void inflateViewCartFragment() {

    }

    @Override
    public void setCartVisibility(boolean visibility) {

    }

    @Override
    public void updateQuantity(Product food, int quantity) {

    }

    @Override
    public void removeCartItem(CartItem cartItem) {

    }
}
