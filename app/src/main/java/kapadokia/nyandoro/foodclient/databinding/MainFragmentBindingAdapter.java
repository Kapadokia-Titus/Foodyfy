package kapadokia.nyandoro.foodclient.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kapadokia.nyandoro.foodclient.adapter.ProductsAdapter;
import kapadokia.nyandoro.foodclient.model.Product;

public class MainFragmentBindingAdapter {

    // it will bind to a gridView of two columns
    // so we create a constant to instantiate the number of columns
    private static final int NUM_COLUMNS =2;

    // use @BindingAdapter annotation to mark this method as a binding adapter
    @BindingAdapter("productsList")
    public static void setProductList(RecyclerView view, List<Product> products){


        //check if the list is null
        if (products == null){
            return;
        }

        RecyclerView.LayoutManager layoutManager = view.getLayoutManager();

        //checking if the layout manager is empty so that we can set it to grid layout
        if (layoutManager == null){
            view.setLayoutManager(new GridLayoutManager(view.getContext(), NUM_COLUMNS));
        }

        // instantiate product adapter
        ProductsAdapter adapter = (ProductsAdapter) view.getAdapter();

        //if the adapter is empty,  we create a new one
        if (adapter == null){
            adapter = new ProductsAdapter(view.getContext(), products);
            view.setAdapter(adapter);
        }
    }

}
