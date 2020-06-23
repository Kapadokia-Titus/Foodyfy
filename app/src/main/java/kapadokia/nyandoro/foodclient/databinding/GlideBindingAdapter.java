package kapadokia.nyandoro.foodclient.databinding;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

import kapadokia.nyandoro.foodclient.R;


public class GlideBindingAdapter {

//    instances where the image is an integer
    @BindingAdapter("imageUrl")
    public static void setImage(ImageView view, int imageUrl){
        //get context
        Context context = view.getContext();

        //create request options for glide
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        // now set image with glide
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageUrl)
                .into(view);
    }



//    in case the image Url is a string
        @BindingAdapter("imageUrl")
        public static void setImage(ImageView view, String imageUrl){
            //get context
            Context context = view.getContext();

            //create request options for glide
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);

            // now set image with glide
            Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(imageUrl)
                    .into(view);
        }

    @BindingAdapter({"requestListener", "imageResource"})
    public static void bindRequestListener(ImageView view, RequestListener requestListener, int imageResource){
        //get context
        Context context = view.getContext();

        //create request options for glide
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        // now set image with glide
        Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(imageResource)
                .listener(requestListener)
                .into(view);
    }
}
