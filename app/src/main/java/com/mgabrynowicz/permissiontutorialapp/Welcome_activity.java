package com.mgabrynowicz.permissiontutorialapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Welcome_activity extends AppCompatActivity {


    FloatingActionButton registerFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_activity);

        registerFloatingActionButton = (FloatingActionButton) findViewById(R.id.registerFloatingActionButton);

        registerFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent startRegisterFormActivityIntent = new Intent(Welcome_activity.this, RegisterForm.class);
                startActivity(startRegisterFormActivityIntent);


            }
        });






    }
}
