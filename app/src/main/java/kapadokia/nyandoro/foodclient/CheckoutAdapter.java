package kapadokia.nyandoro.foodclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {


    Context context;
    List<CheckoutModel> checkoutList;
    private OnItemClickListener listener;


    public static final String EXTRA_CHECKOUT_DETAILS ="package kapadokia.nyandoro.foodclient.EXTRA_CHECKOUT_DETAILS";




    class CheckoutViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView  name, price, quantity;

       public CheckoutViewHolder(@NonNull View view) {
           super(view);

           imageView = view.findViewById(R.id.checkout_image);
           name = view.findViewById(R.id.food_checkout_name);
           price = view.findViewById(R.id.food_detail_price);
           quantity = view.findViewById(R.id.food_checkout_quantity);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   int position = getAdapterPosition();
                   listener.setOnItemClickListener(position);
               }
           });

       }
   }


    public  CheckoutAdapter(Context context, List<CheckoutModel> checkoutList){

        this.context = context;
        this.checkoutList = checkoutList;
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.checkout_list, parent,false);
        return new CheckoutViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {

        holder.imageView.setImageResource(checkoutList.get(position).getImage());
        holder.name.setText(checkoutList.get(position).getName());
        holder.price.setText(checkoutList.get(position).getPrice());
        holder.quantity.setText(checkoutList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return checkoutList.size();
    }

}
