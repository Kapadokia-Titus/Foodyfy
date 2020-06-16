package kapadokia.nyandoro.foodclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kapadokia.nyandoro.foodclient.model.CreatedFood;

public class CreateFood extends AppCompatActivity {

    private TextView name, quantity, price, description;
    private ImageView imageView;
    private Button upload_image_btn;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private CreatedFood createFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_food);





        // other inits
        name = findViewById(R.id.created_food_name);
        quantity = findViewById(R.id.created_food_quantity);
        price = findViewById(R.id.created_food_price);
        description = findViewById(R.id.created_food_description);
        imageView = findViewById(R.id.created_food_image);
        upload_image_btn = findViewById(R.id.upload_image_btn);


        //creating a model objects so that we can pass the values
        //check if food is empty
        Intent intent = getIntent();
        CreatedFood createFood = (CreatedFood) intent.getSerializableExtra("Food");

        if (createFood == null){
            createFood = new CreatedFood();
        }
        this.createFood = createFood;
        name.setText(createFood.getCreatedName());
        price.setText(createFood.getCreatedPrice());
        quantity.setText(createFood.getCreatedQuantity());
        description.setText(createFood.getCreatedDescription());


        // firebase inits
        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference().child("foods");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.created_menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.save_food_item:
                //ProgressDialog dialog = new ProgressDialog(this);
                //dialog.setMessage("saving....");
                saveFood();
                backToMenu();



        }
        return super.onOptionsItemSelected(item);

    }


    public void saveFood(){

        // step 1. read the edit text and convert them to string
        createFood.setCreatedName(name.getText().toString());
        createFood.setCreatedPrice(name.getText().toString());
        createFood.setCreatedQuantity(name.getText().toString());
        createFood.setCreatedDescription(name.getText().toString());

        if (createFood.getId()==null){

            databaseReference.push().setValue(createFood);
        }else {
            databaseReference.child(createFood.getId()).setValue(createFood);
        }
    }



    private void backToMenu(){
        Intent intent = new Intent(this, MyMenu.class);
        startActivity(intent);
    }
}
