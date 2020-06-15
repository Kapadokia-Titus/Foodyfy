package kapadokia.nyandoro.foodclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kapadokia.nyandoro.foodclient.adapter.FoodAdapter;
import kapadokia.nyandoro.foodclient.interfaces.OnItemClickListener;
import kapadokia.nyandoro.foodclient.model.Food;

public class MainActivity extends AppCompatActivity {

    private RecyclerView foodRecycler;
    private FoodAdapter foodAdapter;
    private List<Food> foods;
    private String mUsername;
    private static final int RC_SIGN_IN = 123;
    public static final String ANONYMOUS = "anonymous";

    //firebase declarations
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler init
        foodRecycler =  findViewById(R.id.foodCategory);

        // username init
        mUsername = ANONYMOUS;

        //list init
        foods = new ArrayList<>();

        // firebase inits
        firebaseAuth = FirebaseAuth.getInstance();

        /**
         *  using firebase auth to handle login information
         */

        // use the listener to handle login
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user == null){

                    onSignedOutCleanup();
                    //perform login
                    //user is signed out
                    onSignedOutCleanup();
                    // Choose authentication providers
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.PhoneBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());

                    // Create and launch sign-in intent
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);
                }else{
                     onSignedInInitialised(user.getDisplayName());
                    //the user is logged in
                }

            }
        };

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.food_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout_menu:
                firebaseAuth.signOut();
            case R.id.create_food:
                Intent intent =  new Intent(MainActivity.this, CreateFood.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void onSignedInInitialised(String displayName) {

        mUsername = displayName;
    }

    private void onSignedOutCleanup(){
        mUsername =ANONYMOUS;
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

    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}
