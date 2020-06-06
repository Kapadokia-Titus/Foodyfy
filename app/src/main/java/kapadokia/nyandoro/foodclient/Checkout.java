package kapadokia.nyandoro.foodclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Checkout extends AppCompatActivity {

    public static final String EXTRA_CHECKOUT_DETAILS ="package kapadokia.nyandoro.foodclient.EXTRA_CHECKOUT_DETAILS";


    private  List<CheckoutModel> modelList;
    private RecyclerView recyclerView;
    private CheckoutAdapter adapter;

    private ImageView image;
    private TextView name, price ,quantity;
    private CheckoutModel model;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);



       modelList = new ArrayList<>();
       model = getIntent().getParcelableExtra(EXTRA_CHECKOUT_DETAILS);
       view = findViewById(R.id.status_strip);
       modelList.add(model);


        adapter = new CheckoutAdapter(this,modelList);
        recyclerView = findViewById(R.id.checkout_recycler);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);


        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int foodModel) {
                Toast.makeText(Checkout.this, "clicked :)", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
