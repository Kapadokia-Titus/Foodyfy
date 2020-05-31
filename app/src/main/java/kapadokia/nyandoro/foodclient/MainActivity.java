package kapadokia.nyandoro.foodclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView foodRecycler;
    private FoodAdapter foodAdapter;
    private List<Food> foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler init
        foodRecycler =  findViewById(R.id.foodCategory);

        //list init
        foods = new ArrayList<>();


        //adapter init
        foodAdapter   = new FoodAdapter(this, foods);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        foodRecycler.setLayoutManager(manager);
        foodRecycler.setAdapter(foodAdapter);
        addFoodItem();

        foodAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int foodModel) {
                Food food=  foods.get(foodModel);
                Intent intent =  new Intent(MainActivity.this, FoodDetails.class);
                intent.putExtra(FoodDetails.EXTRA_DETAILS, food);
                startActivity(intent);

            }
        });


    }


    public void addFoodItem(){

        Food food = new Food(R.drawable.biriani, "Biriani & Kuku", "200");
        foods.add(food);
        food = new Food(R.drawable.biriani_nyama, "Biriani & Beef", "170");
        foods.add(food);
        food = new Food(R.drawable.burger, "Burger", "250");
        foods.add(food);
        food = new Food(R.drawable.mishikaki, "Mishikaki", "50");
        foods.add(food);
        food = new Food(R.drawable.samaki, "Sima & Samaki", "300");
        foods.add(food);
        food = new Food(R.drawable.nyama, "Sima & Nyama", "310");
        foods.add(food);

    }
}
