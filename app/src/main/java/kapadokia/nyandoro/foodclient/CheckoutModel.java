package kapadokia.nyandoro.foodclient;

import android.os.Parcel;
import android.os.Parcelable;

public class CheckoutModel implements Parcelable {

    private int image;
    private String name;
    private String price;
    private String quantity;
    private String status;
    private int colour;


    public CheckoutModel(){}

    public CheckoutModel(int image, String name, String price, String quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public CheckoutModel(int image, String name, String price, String quantity, String status) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    protected CheckoutModel(Parcel in) {
        image = in.readInt();
        name = in.readString();
        price = in.readString();
        quantity = in.readString();
        status = in.readString();
        colour = in.readInt();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        if (status == String.valueOf(R.string.red)){
            colour = R.color.red;
            this.colour = colour;
        }
        if (status == String.valueOf(R.string.green)){
            colour = R.color.green;
            this.colour =colour;
        }
         if (status == String.valueOf(R.string.delivered)){
            colour = R.color.delivered;
            this.colour = colour;
        }
        else {
            this.colour = colour;
         }
    }

    @Override
    public String toString() {
        return "CheckoutModel{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                ", status='" + status + '\'' +
                ", colour=" + colour +
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
        dest.writeString(status);
        dest.writeInt(colour);
    }
}
