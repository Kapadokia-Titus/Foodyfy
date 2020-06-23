package kapadokia.nyandoro.foodclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kapadokia.nyandoro.foodclient.adapter.ProductsAdapter;
import kapadokia.nyandoro.foodclient.databinding.FragmentMainBinding;
import kapadokia.nyandoro.foodclient.model.Product;
import kapadokia.nyandoro.foodclient.utils.Products;

public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG ="MainFragment";

    // data binging init
    FragmentMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = FragmentMainBinding.inflate(inflater);
        mBinding.swipeRefreshLayout.setOnRefreshListener(this);
        setUpProductList();
        return mBinding.getRoot(); 
    }

    private void setUpProductList() {
        Products products = new Products();
        List<Product> productList =new ArrayList<>();
        productList.addAll(Arrays.asList(products.PRODUCTS));
        mBinding.setProducts(productList);
    }

    @Override
    public void onRefresh() {

        //facilitating refresh
        Products products = new Products();
        List<Product> productList =new ArrayList<>();
        productList.addAll(Arrays.asList(products.PRODUCTS));
        ((ProductsAdapter)mBinding.foodRecyclerView.getAdapter()).refreshList(productList);
        onItemsLoadComplete();


    }

    void onItemsLoadComplete() {
        (mBinding.foodRecyclerView.getAdapter()).notifyDataSetChanged();
        mBinding.swipeRefreshLayout.setRefreshing(false);
    }
}
