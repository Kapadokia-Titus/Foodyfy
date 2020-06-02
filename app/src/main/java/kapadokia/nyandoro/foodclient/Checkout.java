package kapadokia.nyandoro.foodclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {

    public static final String EXTRA_CHECKOUT_DETAILS ="package kapadokia.nyandoro.foodclient.EXTRA_CHECKOUT_DETAILS";

    private List<CheckoutModel> checkoutModel;
    private RecyclerView recyclerView;
    private CheckoutAdapter adapter;

    private ImageView image;
    private TextView name, price ,quantity;
    private CheckoutModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

//
//        model = getIntent().getParcelableExtra(EXTRA_CHECKOUT_DETAILS);
//
//
//        image = findViewById(R.id.checkout_image_main);
//        name = findViewById(R.id.food_checkout_name_main);
//        price = findViewById(R.id.food_checkout_price_main);
//        quantity = findViewById(R.id.food_checkout_quantity_main);


//        image.setImageResource(model.getImage());
//        name.setText(model.getName());
//        price.setText(model.getPrice());
//        quantity.setText(model.getQuantity());




    }
}
