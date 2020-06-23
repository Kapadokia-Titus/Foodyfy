package kapadokia.nyandoro.foodclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kapadokia.nyandoro.foodclient.R;
import kapadokia.nyandoro.foodclient.databinding.CartItemBinding;
import kapadokia.nyandoro.foodclient.model.CartItem;
import kapadokia.nyandoro.foodclient.model.CartItemViewModel;
import kapadokia.nyandoro.foodclient.model.CartViewModel;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.BindingHolder> {

    private static final String TAG = "CartItemAdapter";

    private List<CartItem> cartItems = new ArrayList<>();
    private Context context;

    public  CartItemAdapter(Context context, List<CartItem> cartItems){
        this.cartItems = cartItems;
        this.context = context;
    }

    public class BindingHolder extends RecyclerView.ViewHolder {
        CartItemBinding binding;
        public BindingHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    @NonNull
    @Override
    public CartItemAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CartItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.cart_item, parent,
        false);
        return new CartItemAdapter.BindingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemAdapter.BindingHolder holder, int position) {

        CartItem cartItem = cartItems.get(position);
        CartItemViewModel viewModel = new CartItemViewModel();
        viewModel.setCartItem(cartItem);
        holder.binding.setCartItemView(viewModel);
        holder.binding.executePendingBindings();

    }

    public void updateCartItems(List<CartItem> cartItems){
        cartItems.clear();
        cartItems.addAll(cartItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
