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
import kapadokia.nyandoro.foodclient.databinding.ProductItemBinding;
import kapadokia.nyandoro.foodclient.model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.BindingHolder> {

    private static final String TAG= "ProductsAdapter";

    private List<Product> mProducts = new ArrayList<>();
    private Context context ;

    public class BindingHolder extends RecyclerView.ViewHolder{

        //        ViewDataBinding binding;
      ProductItemBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public ProductsAdapter (Context context, List<Product> products){

        mProducts = products;
        this.context = context;

    }

    public void refreshList(List<Product> products){
        mProducts.clear();
        mProducts.addAll(products);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductsAdapter.BindingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding =DataBindingUtil.inflate(
                LayoutInflater.from(context), R.layout.product_item, parent, false);

        return new BindingHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.BindingHolder holder, int position) {

        Product product= mProducts.get(position);
        holder.binding.setProduct(product);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

}
