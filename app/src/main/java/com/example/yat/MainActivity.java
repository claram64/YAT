package com.example.yat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Button logInByn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInByn=(Button)findViewById(R.id.logIn_Btn);
        logInByn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToLogIn();
            }
        });

    }
        public void goToLogIn()
        {
            Intent intent=new Intent(this, LogIn.class);
            startActivity(intent);
        }


}