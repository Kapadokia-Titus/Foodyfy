package kapadokia.nyandoro.foodclient;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class ConfirmationPopup  {

    // pop up window display method
    public void showPopupWindow(final View view){

        //Create a View object  through inflater
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        final View popupView  =  inflater.inflate(R.layout.activity_confirmation_popup, null);

        //Specify the length and width through constants.
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        //Make Inactive Items Outside Of PopupWindow
        boolean focusable = true;

        //creating a window with this parameters
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        //Set the location of the window on the screen
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);

        //Initialize the elements of our window, install the handler
        TextView popupText = popupView.findViewById(R.id.popup_food_name);
        String text= "Please confirm your order :)";
        popupText.setText(text);

        Button confirm = popupView.findViewById(R.id.confirm_popup_btn);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                //As an example, display the message
                Toast.makeText(view.getContext(), "Wow, popup action button", Toast.LENGTH_SHORT).show();

                }
        });

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

    }

}
