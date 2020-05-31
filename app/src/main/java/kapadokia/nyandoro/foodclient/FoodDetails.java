package kapadokia.nyandoro.foodclient;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FoodDetails extends AppCompatActivity {

    public static final String EXTRA_DETAILS= "package kapadokia.nyandoro.foodclient.EXTRA_DETAILS";

    private ImageView imageView;
    private TextView  name_tv;
    private TextView  price_tv;
    private TextView  description;
    private  TextView number_count;
    private Button sub_btn;
    private int count = 1;
    private Food food;
    private int new_price;
    private  List<CheckoutModel> checkoutModels;
    private  CheckoutAdapter checkoutAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detail);


        food = getIntent().getParcelableExtra(EXTRA_DETAILS);

        imageView = findViewById(R.id.food_detail_image);
        name_tv = findViewById(R.id.food_detail_name);
        price_tv = findViewById(R.id.food_detail_price);
        description = findViewById(R.id.food_detail_description);
        sub_btn = findViewById(R.id.food_detail_checkout);
        number_count = findViewById(R.id.number_count);


        imageView.setImageResource(food.getImage());
        name_tv.setText(food.getFood_name());
        price_tv.setText(food.getPrice());

        checkoutModels = new ArrayList<>();
        checkoutAdapter = new CheckoutAdapter(this, checkoutModels);
        String quantity = String.valueOf(count);
        checkoutModels.add(new CheckoutModel(food.getImage(), food.getFood_name(), food.getPrice(), quantity));

        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckoutModel model = new CheckoutModel();
                model.setImage(food.getImage());
                model.setName(food.getFood_name());
                model.setPrice(String.valueOf(new_price));
                model.setQuantity(String.valueOf(count));

                List<CheckoutModel>  checkoutModels = new ArrayList<>();
                checkoutModels.add(model);
                FoodCart.saveCart(checkoutModels);

                if (FoodCart.getFoodCartSize()>0){
                    Toast.makeText(FoodDetails.this, "order for " +food.getFood_name() + " has been placed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(FoodDetails.this, "Error Making this order", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void subtractMethod(View view) {

        if (count <1){
            sub_btn.setClickable(false);
            Toast.makeText(this, "Order atleast a plate of " + food.getFood_name(), Toast.LENGTH_SHORT).show();
        }
        else {
            count --;
            int food_price  = Integer.parseInt(food.getPrice());
             new_price = food_price * count;


            String price_count = String.valueOf(new_price);
            String string_count = String.valueOf(count);

            number_count.setText(string_count);
            price_tv.setText(price_count);
        }
    }

    public void additionMethod(View view) {


        count++;
        int food_price = Integer.parseInt(food.getPrice());
        new_price = food_price * count;


        String price_count = String.valueOf(new_price);
        String string_count = String.valueOf(count);

        number_count.setText(string_count);
        price_tv.setText(price_count);
    }
}
