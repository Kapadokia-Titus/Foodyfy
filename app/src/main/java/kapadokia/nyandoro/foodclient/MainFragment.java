package kapadokia.nyandoro.foodclient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import kapadokia.nyandoro.foodclient.databinding.FragmentMainBinding;

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
    }

    @Override
    public void onRefresh() {

    }

    void onItemsLoadComplete() {
        (mBinding.foodRecyclerView.getAdapter()).notifyDataSetChanged();
        mBinding.swipeRefreshLayout.setRefreshing(false);
    }
}
