package kapadokia.nyandoro.foodclient.model;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class ProductViewModel  extends BaseObservable {

    private Product product;
    private int quantity;
    private boolean imageVisibility =false;

    @Bindable
    public Product getProduct() {
        return product;
    }

    @Bindable
    public int getQuantity() {
        return quantity;
    }

    @Bindable
    public boolean getImageVisibility() {
        return imageVisibility;
    }

    public void setProduct(Product product) {
        this.product = product;
        notifyPropertyChanged(kapadokia.nyandoro.foodclient.BR.product);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        notifyPropertyChanged(quantity);
    }

    public void setImageVisible(boolean imageVisibility) {
        this.imageVisibility = imageVisibility;
        notifyPropertyChanged(kapadokia.nyandoro.foodclient.BR.imageVisibility);
    }

    public RequestListener getCustomRequestListener(){

        return new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target, DataSource dataSource, boolean isFirstResource) {
                setImageVisible(true);
                return false;
            }
        };
    }



}
