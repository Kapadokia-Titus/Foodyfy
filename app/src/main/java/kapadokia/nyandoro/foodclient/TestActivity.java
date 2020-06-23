package kapadokia.nyandoro.foodclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import kapadokia.nyandoro.foodclient.databinding.ActivityTestBinding;
import kapadokia.nyandoro.foodclient.interfaces.MainController;
import kapadokia.nyandoro.foodclient.model.CartItem;
import kapadokia.nyandoro.foodclient.model.Food;

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
    public void updateQuantity(Food food, int quantity) {

    }

    @Override
    public void removeCartItem(CartItem cartItem) {

    }
}
