package kapadokia.nyandoro.foodclient.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {

    private int image;
    private String food_name;
    private String price;


    private Food(){}

    public Food(int image, String food_name, String price) {
        this.image = image;
        this.food_name = food_name;
        this.price = price;
    }

    protected Food(Parcel in) {
        image = in.readInt();
        food_name = in.readString();
        price = in.readString();
    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(food_name);
        dest.writeString(price);
    }
}
