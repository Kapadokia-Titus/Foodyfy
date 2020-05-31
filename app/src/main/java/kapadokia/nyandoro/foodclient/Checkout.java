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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        checkoutModel = new ArrayList<>();
        adapter = new CheckoutAdapter(getApplicationContext(), checkoutModel);

        recyclerView = findViewById(R.id.checkout_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);



    }
}
