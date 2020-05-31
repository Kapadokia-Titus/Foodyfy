package kapadokia.nyandoro.foodclient;

import android.os.Parcel;
import android.os.Parcelable;

public class CheckoutModel implements Parcelable {

    private int image;
    private String name;
    private String price;
    private String quantity;


    public CheckoutModel(){}

    public CheckoutModel(int image, String name, String price, String quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    protected CheckoutModel(Parcel in) {
        image = in.readInt();
        name = in.readString();
        price = in.readString();
        quantity = in.readString();
    }

    public static final Creator<CheckoutModel> CREATOR = new Creator<CheckoutModel>() {
        @Override
        public CheckoutModel createFromParcel(Parcel in) {
            return new CheckoutModel(in);
        }

        @Override
        public CheckoutModel[] newArray(int size) {
            return new CheckoutModel[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CheckoutModel{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(price);
        dest.writeString(quantity);
    }
}
