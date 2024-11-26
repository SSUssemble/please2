package com.example.app1protro;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity
     {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] colors = {Color.RED,Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN};
        // Container LinearLayout
        LinearLayout container = findViewById(R.id.container);

        // Dynamic buttons creation
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < 15; i++) {

            View buttonLayout = inflater.inflate(R.layout.button_layout, container, false);

            ConstraintLayout constraintLayout = buttonLayout.findViewById(R.id.button);
            // Optional: Customize each button (set text, add listeners, etc.)

            constraintLayout.setBackgroundColor(colors[i%5]);

            container.addView(buttonLayout);
        }
        View buttonLayout = inflater.inflate(R.layout.create_room_button, container, false);
        LinearLayout linearLayout = buttonLayout.findViewById(R.id.CRButtonSpace);
        linearLayout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,CreateRoomActivity.class);
                startActivity(intent);
            }
        });
        container.addView(buttonLayout);


    }

//    private void replaceFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        CreateRoomFragment createRoomFragment =new CreateRoomFragment();
//        fragmentTransaction.replace(R.id.fragment_container,createRoomFragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
//    }

}
