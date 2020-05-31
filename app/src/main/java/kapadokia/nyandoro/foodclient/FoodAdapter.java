package kapadokia.nyandoro.foodclient;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter< FoodAdapter.FoodViewAdapter>  {

   Context context;
   List<Food> foodsList;
   private OnItemClickListener listener;



    public class FoodViewAdapter extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView  foodName, foodPrice;
        LinearLayout foodLayout;

        public FoodViewAdapter(@NonNull View view) {
            super(view);

            foodImage = view.findViewById(R.id.food_image);
            foodName = view.findViewById(R.id.food_text);
            foodPrice = view.findViewById(R.id.food_price);
           foodLayout = view.findViewById(R.id.foodLayout);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int position = getAdapterPosition();
                   listener.setOnItemClickListener(position);
               }
           });
        }
    }


    public  FoodAdapter(Context context, List<Food> foodsList){
        this.context = context;
        this.foodsList = foodsList;
    }
    @NonNull
    @Override
    public FoodViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.food_list, parent, false);
        return new FoodViewAdapter(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewAdapter holder, int position) {

        //animated recycler
        holder.foodLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));


        holder.foodImage.setImageResource(foodsList.get(position).getImage());
        holder.foodName.setText(foodsList.get(position).getFood_name());
        holder.foodPrice.setText(foodsList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
